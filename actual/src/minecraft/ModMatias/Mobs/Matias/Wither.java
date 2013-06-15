package ModMatias.Mobs.Matias;

import net.minecraft.entity.Entity;
import net.minecraft.entity.boss.EntityWither;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;

public class Wither extends EntityWither {

	public Wither(World par1World) {
		super(par1World);
		
		// TODO Auto-generated constructor stub
	}
	public Wither(World par1World,long max) {
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
	    	tiempo+=500/maximo;
	    	while(tiempo>=1){
	    		tiempo--;
				super.health=super.getHealth()-1;
	    	}

	        super.onLivingUpdate();

	    }
	    protected void dropFewItems(boolean par1, int par2)
	    {
	    	super.experienceValue=0;
	    }
	    

}
