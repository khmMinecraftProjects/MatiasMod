package ModMatias.Mobs.Matias;

import net.minecraft.entity.boss.EntityDragon;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.World;

public class Dragon extends EntityDragon {

	public Dragon(World par1World) {
		super(par1World);
		// TODO Auto-generated constructor stub
	}
	public Dragon(World par1World,long max) {
		super(par1World);
		maximo=max;
		// TODO Auto-generated constructor stub
	}
	
	Long maximo=(long)500;
	double tiempo=0;
		public void writeEntityToNBT(NBTTagCompound par1NBTTagCompound)
	    {
	        super.writeEntityToNBT(par1NBTTagCompound);
	        par1NBTTagCompound.setDouble("tiempo",tiempo);
	        par1NBTTagCompound.setLong("maximo",maximo);

	    }
	    public void readEntityFromNBT(NBTTagCompound par1NBTTagCompound)
	    {
	        super.readEntityFromNBT(par1NBTTagCompound);
	        tiempo=par1NBTTagCompound.getDouble("tiempo");
	        maximo=par1NBTTagCompound.getLong("maximo");
	    }
	   
	    public void onLivingUpdate()
	    {
	    	tiempo+=200/maximo;
	    	while(tiempo>=1){
	    		tiempo--;
				super.health=super.getHealth()-1;
	    	}

	        super.onLivingUpdate();

	    }
	    protected void onDeathUpdate()
	    {
            this.setDead();
	    }
}
