package net.minecraft.src;

public class EntityMatias extends EntityMob
{
	boolean invul;

    public EntityMatias(World par1World)
    {	
    	super(par1World);
    	this.invul=false;
    	this.texture = "/mob/matias.png";
    	this.moveSpeed = 0.5f;
    	this.isImmuneToFire = true;
        this.experienceValue = 500;
    	 this.setSize(0.9F, 3.3F);
   
         //this.stepHeight = 1.0F;

    	this.tasks.addTask(0, new EntityAISwimming(this));
    	this.tasks.addTask(1, new EntityAIMatias(this, EntityPlayer.class, this.moveSpeed, false));
    	//this.tasks.addTask(1, new EntityAIAttackOnCollide(this, EntityPlayer.class, this.moveSpeed, false));//Ataque normal
    	
    	this.tasks.addTask(2, new EntityAIMoveTwardsRestriction(this, this.moveSpeed));
    	this.tasks.addTask(3, new EntityAIWander(this, this.moveSpeed));
    	this.tasks.addTask(4, new EntityAILookIdle(this));
    	this.targetTasks.addTask(0, new EntityAIHurtByTarget(this, false));
    	this.targetTasks.addTask(1, new EntityAINearestAttackableTarget(this, EntityPlayer.class, 25.0F, 0, true));
    	 
    	}

    	public int func_82193_c(Entity par1Entity) //Daño
    	{
    	return 34;
    	}

    	protected void fall(float par1) {}
    	public int getMaxHealth() // Vida
    	{
    	return 500;
    	}

    	protected String getLivingSound() //sonido mientras vive
    	{
    	return "mob.pig.say";
    	
    	}

    	protected String getHurtSound()//sonido al ser atacado
    	{
    	return "mob.pig.say";
    	}

    	protected String getDeathSound()//sonido al morir
    	{
    	return "mob.pig.death";
    	}

    	protected int getDropItemId()//drops
    	{
    		this.dropItem(Block.blockRedstone.blockID, 5);
    		this.dropItem(Block.blockLapis.blockID, 5);
    	return Block.blockDiamond.blockID;
    	}
    	
    	protected boolean canDespawn()
    	{
    	return false;
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
    		System.out.println(par1DamageSource.damageType+" --ataque");

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

}
