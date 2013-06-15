package ModMatias.Mobs.Matias;

import java.awt.List;
import java.util.ArrayList;

import ModMatias.Configuracion.Datos;

import net.minecraft.block.Block;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EnumCreatureAttribute;
import net.minecraft.entity.ai.*;
import net.minecraft.entity.boss.EntityDragon;
import net.minecraft.entity.boss.EntityWither;
import net.minecraft.entity.boss.IBossDisplayData;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.DamageSource;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;

public class EntityMatias extends EntityMob 
{
	boolean invul;

	long time=0;
	int estado=0;
    int[] tmp={Datos.t0,Datos.t1,Datos.t2,Datos.t3};
    EntityLiving[] mobs2={new Dragon(worldObj)
    ,new Wither(worldObj)};
		

	public void setEstado(int n){
		estado=n;
	}
	public int getEstado(){
		return estado;
	}


	
	public EnumCreatureAttribute getCreatureAttribute()
    {
        return EnumCreatureAttribute.UNDEAD;
    }
    public EntityMatias(World par1World)
    {	
    	super(par1World);
    	
    	this.invul=false;
    	this.texture = "/ModMatias/Texturas/Mobs/matias.png";
    	
    	this.moveSpeed = 0.5f;
    	this.isImmuneToFire = true;
        this.experienceValue = 500;
    	this.setSize(0.9F, 3.3F);
    	
    	this.tasks.addTask(0, new EntityAISwimming(this));
    	this.tasks.addTask(1, new EntityAIMatias(this, this.moveSpeed, false));
       	this.attackTime=5;
    	this.tasks.addTask(2, new EntityAIMoveTwardsRestriction(this, this.moveSpeed));
    	this.tasks.addTask(3, new EntityAIWander(this, this.moveSpeed));
    	this.tasks.addTask(4, new EntityAILookIdle(this));
    	this.targetTasks.addTask(0, new EntityAIHurtByTarget(this, false));
    	this.targetTasks.addTask(1, new EntityAINearestAttackableTarget(this, EntityPlayer.class, 25.0F, 0, true));
    	}
    

    	public void onLivingUpdate()
    		{
	    	
    		time++;
    		if(invul){
                particles(posX,posY,posZ);
                particles(posX,posY+1,posZ);
                particles(posX,posY+2,posZ);
                particles(posX,posY+3,posZ);

    		}
    		if(time==tmp[0]){
	    		this.setInvul(false);
	    		setEstado(1);
		    	
	    		if(!this.worldObj.isRemote){
		    		invoca(0);}
	    		//invoca(0);
	    		setInvul(true);
	    		setmoveSpeed(0f);
	    	}
	    	if(time==tmp[1]){
	    		setEstado(1);

	    		
	    		this.setInvul(true);
			    	
	    		if(!this.worldObj.isRemote){
	    		invoca(1);
	    		}
	    		setInvul(true);
	    		setmoveSpeed(0f);
	    	}
	    	if(time==tmp[2]){
	    		setEstado(0);

	    		this.setInvul(false);
	    		
	    	}
	    	if(time==tmp[3]){
	    		setEstado(0);
	    		time=0;
	    	
           }
	    	super.onLivingUpdate();
    		}

  
    	public int getMaxHealth() // Mob health
    	{
    	return Datos.MatiasHealt;
    	}

    	protected String getLivingSound()
    	{
    	return "mob.pig.say";
    	
    	}

    	protected String getHurtSound()
    	{
    	return "mob.pig.say";
    	}

    	protected String getDeathSound()
    	{
    	return "mob.pig.death";
    	}

    	protected int getDropItemId()
    	{
    		this.dropItem(Item.redstone.itemID, 5);
    		this.dropItem(Block.blockLapis.blockID, 5);
    		this.dropItem(Block.blockDiamond.blockID, 5);
    		return 0;
    	}
    	protected boolean canDespawn()
    	{
    	return true;
    	}

    	public float getBrightness(float par1)
        {
            return 4.0F;
        }
    	public int getBrightnessForRender(float par1)
        {
            return 15728880;
        }
    	public boolean isEntityInvulnerable(){

			return invul;
    	}
    	public void setInvul(boolean inv){
    		invul=inv;
    	}

    		public void setmoveSpeed(float s){
    		
    		this.moveSpeed=s;
    	}
	
    		public void writeEntityToNBT(NBTTagCompound par1NBTTagCompound)
    	    {
    	        super.writeEntityToNBT(par1NBTTagCompound);
    	        par1NBTTagCompound.setLong("time", time);
    	        par1NBTTagCompound.setBoolean("inv", this.invul);    	       
    	        par1NBTTagCompound.setInteger("estado", estado);  	       
    	    }
    	    public void readEntityFromNBT(NBTTagCompound par1NBTTagCompound)
    	    {
    	        super.readEntityFromNBT(par1NBTTagCompound);
    	        time=par1NBTTagCompound.getLong("time");
    	        invul=par1NBTTagCompound.getBoolean("inv");
    	        estado=par1NBTTagCompound.getInteger("estado");

    	    }
    	    
    	   public void invoca(int i){
    	    	mobs2[0]=new Dragon(worldObj,(long)(tmp[1]-tmp[0]));
    	    	mobs2[1]=new Wither(worldObj,(long)(tmp[2]-tmp[1]));
    	    	
    			
    			   invocaMob(mobs2[i],1,0,0,10);

    		   }
    	public void invocaMob(EntityLiving mob,int v,int x,int y, int z){
    	   		
    			   if(!this.worldObj.isRemote){
    			   mob.setPositionAndRotation(posX+x, 
    	   				posY+y, posZ+z,0,0);

    				worldObj.spawnEntityInWorld(mob);
    	   		
    	   		}
    	   		
    	   		
    			}
    	
    	public void particles(double varX,double varY, double varZ){
    		this.worldObj.spawnParticle(
    				"portal", varX -0.3+ this.rand.nextGaussian() * 
            		0.30000001192092896D, varY + this.rand.nextGaussian()
            		* 0.30000001192092896D, varZ-0.3 + this.rand.nextGaussian() 
            		* 0.30000001192092896D, 0.699999988079071D,
            		0.699999988079071D, 0.5D);
    	}
    	

}

