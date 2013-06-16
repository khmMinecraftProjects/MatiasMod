package ModMatias.Items;

import ModMatias.Mobs.Matias.EntityMatias;
import net.minecraft.block.Block;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.entity.effect.EntityLightningBolt;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemFlintAndSteel;
import net.minecraft.item.ItemStack;
import net.minecraft.src.ModLoader;
import net.minecraft.util.StringTranslate;
import net.minecraft.world.World;


public class ItemMatiasFire extends ItemFlintAndSteel {

	boolean p=false;
	EntityPlayer player=null;
	int temp=0,v=0,x=0,y=0,z=0;
	boolean ready=false;
	boolean a=false;

	public ItemMatiasFire(int par1) {
		super(par1);
		// TODO Auto-generated constructor stub
	}
	public String getTextureFile()
	{
		return "/ModMatias/fire.png";
	}

    public boolean onItemUse(ItemStack par1ItemStack, EntityPlayer par2EntityPlayer, World par3World, int par4, int par5, int par6, int par7, float par8, float par9, float par10)
    {
    	
        if (par7 == 0)
        {
            --par5;
        }

        if (par7 == 1)
        {
            ++par5;
        }

        if (par7 == 2)
        {
            --par6;
        }

        if (par7 == 3)
        {
            ++par6;
        }

        if (par7 == 4)
        {
            --par4;
        }

        if (par7 == 5)
        {
            ++par4;
        }

        if (!par2EntityPlayer.canPlayerEdit(par4, par5, par6, par7, par1ItemStack))
        {
            return false;
        }
        else
        {
            int var11 = par3World.getBlockId(par4, par5, par6);

            if (var11 == 0)
            {
                par3World.playSoundEffect((double)par4 + 0.5D, (double)par5 + 0.5D, (double)par6 + 0.5D, "fire.ignite", 1.0F, itemRand.nextFloat() * 0.4F + 0.8F);
                par3World.setBlock(par4, par5, par6, Block.fire.blockID);
            }
          
            
            if(Esta(par3World, par4, par5, par6)&&!ready){
            	player=par2EntityPlayer;
    	    	x=par4;
    	    	y=par5;
    	    	z=par6;
    	    	ready=true;
				
            	
            }
            
         
            par1ItemStack.damageItem(1, par2EntityPlayer);
            return true;
        }
    }

	public boolean Esta (World par3World,int par4,int par5,int par6){


		int[][] okey={{87,69,144,69,0},{17,127,127,127,127}
		,{17,127,76,127,127}};

		int[] aux={0,0,0,0};
		boolean ok=true,fin=false;
		int[][] pos=new int [3][5];

		for(int s=0;s<3;s++){

			pos[s][0]=par3World.getBlockId(par4, par5-s-1, par6);
			pos[s][1]=par3World.getBlockId(par4+1, par5-s-1, par6);
			pos[s][2]=par3World.getBlockId(par4, par5-s-1, par6+1);
			pos[s][3]=par3World.getBlockId(par4-1, par5-s-1, par6);
			pos[s][4]=par3World.getBlockId(par4, par5-s-1, par6-1);
		}
		int c=0;
		while(!fin){
			ok=true;
			for(int i=0;i<3;i++){
				for(int s=0;s<5;s++){
					if(pos[i][s]!=okey[i][s]){ok=false;}
				}	
			}
			if(c==4){fin=true;}

			if(!ok){
				if(!fin){
					for(int s=0;s<3;s=s+2){


						aux[0]=okey[s][1];
						aux[1]=okey[s][2];
						aux[2]=okey[s][3];
						aux[3]=okey[s][4];

						okey[s][1]=aux[1];
						okey[s][2]=aux[2];
						okey[s][3]=aux[3];
						okey[s][4]=aux[0];
					}
					c++;}

			}else{fin=true;}

		}

		return ok;
	}

	public void onUpdate(ItemStack par1ItemStack, World world, Entity par3Entity, int par4, boolean par5){
		if(true){
			if(ready){
				if(!p){p=true;
				if(world.isRemote){
					player.addChatMessage("Matias is coming");
				}
				}
				temp++;
				if(temp>40){
					temp=0;
					if(world.isRemote){
						player.addChatMessage("Faltan "+(5-v)+" segundos");
					}
					v++;
				}
				if(v==6){
					if(world.isRemote){
						player.addChatMessage("Matias esta aqui");
					}
					for(int s=0;s<3;s++){
						world.setBlock(x, y-s-1, z,0);
						world.setBlock(x+1, y-s-1, z,0);
						world.setBlock(x, y-s-1, z+1,0);
						world.setBlock(x-1, y-s-1, z,0);
						world.setBlock(x, y-s-1, z-1,0);
					}

					if(!world.isRemote){
						EntityMatias eggmatias=new EntityMatias(world);
						eggmatias.setPosition(x, y-3, z);

						world.spawnEntityInWorld(eggmatias);}
					p=false;
					ready=false;
					temp=0;v=0;x=0;y=0;z=0;
				}

			}

			super.onUpdate(par1ItemStack, world, par3Entity, par4, par5);
		}
	}
}
