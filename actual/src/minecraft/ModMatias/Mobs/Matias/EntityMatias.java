package ModMatias.Mobs.Matias;

import java.awt.List;
import java.util.ArrayList;

import net.minecraft.block.Block;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EnumCreatureAttribute;
import net.minecraft.entity.ai.*;
import net.minecraft.entity.boss.EntityDragon;
import net.minecraft.entity.boss.EntityWither;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.DamageSource;
import net.minecraft.world.World;

public class EntityMatias extends EntityMob
{
    private int conversionTime = 0;
	boolean invul;
	int idDragon=-1;
	int idWhither=-1;
	int idMob=-1;
	long time=0;
	int estado=0;
	String boss="";
	boolean pendiente=false;
    EntityLiving[] mobs2={
			new EntityDragon(worldObj),
			new EntityWither(worldObj)
		};
    int[] tmp={300,500,700,1000};

	public void setEstado(int n){
		estado=n;
	}
	public int getEstado(){
		return estado;
	}
	public void setPendiente(boolean n){
		pendiente=n;
	}
	public boolean getPendiente(){
		return pendiente;
	}
	public void setID(int id){
		idMob=id;
	}
	
	public EnumCreatureAttribute getCreatureAttribute()
    {
        return EnumCreatureAttribute.UNDEAD;
    }
    public EntityMatias(World par1World)
    {	
    	super(par1World);
    	this.invul=false;
    	this.texture = "/ModMatias/Texturas/Mobs/matias.png";//Set Mob texture
    	//this.texture = "/mob/mati.png";
    	
    	this.moveSpeed = 0.5f;//sets how fast this mob moves
    	this.isImmuneToFire = true;
        this.experienceValue = 500;
    	 this.setSize(0.9F, 3.3F);
   
         //this.stepHeight = 1.0F;
    	//below this is all the ai tasks that specify how the mob will behave mess around with it to see what happens
    	
    	this.tasks.addTask(0, new EntityAISwimming(this));
    	this.tasks.addTask(1, new EntityAIMatias(this, EntityPlayer.class, this.moveSpeed, false));
    	//this.tasks.addTask(1, new EntityAIAttackOnCollide(this, EntityPlayer.class, this.moveSpeed, false));
    	
    	this.tasks.addTask(2, new EntityAIMoveTwardsRestriction(this, this.moveSpeed));
    	this.tasks.addTask(3, new EntityAIWander(this, this.moveSpeed));
    	this.tasks.addTask(4, new EntityAILookIdle(this));
    	this.targetTasks.addTask(0, new EntityAIHurtByTarget(this, false));
    	this.targetTasks.addTask(1, new EntityAINearestAttackableTarget(this, EntityPlayer.class, 25.0F, 0, true));
    	}
    	
    	public void onLivingUpdate()
    		{
    		this.updateArmSwingProgress();
           if(!this.worldObj.isRemote){
        	   
    		time++;
    		if(time==tmp[0]){
		    	pendiente=true;
		    	
	    	}
	    	if(time==tmp[1]){
	    		pendiente=true;
	    		eliminar(0);
	    	}
	    	if(time==tmp[2]){
	    		eliminar(1);
	    	}}
	    	super.onLivingUpdate();
    		}

    	public void setBoss(String s){
    		boss=s;
    	}
    	public int func_82193_c(Entity par1Entity) //the amount of damage
    	{
    	return 34;
    	}

    	protected void fall(float par1) {}
    	public int getMaxHealth() // Mob health
    	{
    	return 500;
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
    		this.dropItem(Block.blockRedstone.blockID, 5);
    		this.dropItem(Block.blockLapis.blockID, 5);
    		return Block.blockDiamond.blockID;
    	}
    	protected boolean canDespawn()
    	{
    	return true;
    	}
   
    	protected boolean isAIEnabled()//Allow your AI task to work?
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
    	protected void attackEntity(Entity par1Entity, float par2)
        {
        
        }
    	
    	@Override
    	 public boolean attackEntityFrom(DamageSource par1DamageSource, int par2)
        {

            if (this.isEntityInvulnerable())
            {
                return false;
            }
            else if (super.attackEntityFrom(par1DamageSource, par2))
            {
                Entity var3 = par1DamageSource.getEntity();

                if (this.riddenByEntity != var3 && this.ridingEntity != var3)
                {
                    if (var3 != this)
                    {
                        this.entityToAttack = var3;
                    }

                    return true;
                }
                else
                {
                    return true;
                }
            }
            else
            {
                return false;
            }
        }
    	public void setmoveSpeed(float s){
    		
    		this.moveSpeed=s;
    	}
	
    	
    	 public void writeEntityToNBT(NBTTagCompound par1NBTTagCompound)
    	    {
    	        super.writeEntityToNBT(par1NBTTagCompound);
    	        idMob=-1;
    	        par1NBTTagCompound.setString("boss", boss);
    	        par1NBTTagCompound.setLong("Mob", idMob);
    	        par1NBTTagCompound.setBoolean("inv", this.invul);    	       
    	        par1NBTTagCompound.setInteger("estado", estado);  	       
    	        par1NBTTagCompound.setBoolean("pendiente", pendiente);  	       
    	    }
    
    	    /**
    	     * (abstract) Protected helper method to read subclass entity data from NBT.
    	     */
    	 	public long getTime(){
    	 		return time;
    	 	}
    	 	public void setTime(long s){
    	 		time=s;
    	 	}
    	    public void readEntityFromNBT(NBTTagCompound par1NBTTagCompound)
    	    {
    	        super.readEntityFromNBT(par1NBTTagCompound);
    	        time=par1NBTTagCompound.getLong("time");
    	        boss=par1NBTTagCompound.getString("boss");
    	        invul=par1NBTTagCompound.getBoolean("inv");
    	        estado=par1NBTTagCompound.getInteger("estado");
    	        pendiente=par1NBTTagCompound.getBoolean("pendiente");

    	    }
    	    
    	    public void invoca(int i){
    			   
    			   invocaMob(mobs2[i],1,0,0,10);

    		   }
    		   public void invocaMob(EntityLiving mob,int v,int x,int y, int z){
    	   		mob.setPositionAndRotation(posX+x, 
    	   				posY+y, posZ+z,0,0);

    				worldObj.spawnEntityInWorld(mob);
    	   		
    	   		setBoss(mob.toString().substring(0, 15));
    	   		
    	   		
    			}
    		   public void eliminar(int i){
    			   eliminarBoss(
    			   mobs2[i].toString().substring(0, 15));
    		   }
    		   public void eliminarBoss(String enemigo){
    			   boolean t=false;
    		    	int id=-1;
    		    	ArrayList<Entity> list = new ArrayList<Entity>();
    		    	
    		        for(int i=0;!t&&i<this.worldObj.getLoadedEntityList().size();i++){

    		        	if(
    		        			
    		        	this.worldObj.getLoadedEntityList()
    		        	.get(i).toString().contains(enemigo)
    		        	
    		        			){
    		        		list.add((Entity) this.worldObj.getLoadedEntityList().get(i));
    		        	}
    		        }
    		        for(int i=0;!t&&i<list.size();i++){
    		        	this.worldObj.removeEntity(
    		        				list.get(i)
    		        				);
    		        }
    		   }

}

