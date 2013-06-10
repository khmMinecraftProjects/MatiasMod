package net.minecraft.src;

public class ItemMatiasFire extends Item {
	boolean p=false;
	 public ItemMatiasFire (int par1)
	    {
	        super(par1);
	        this.maxStackSize = 1;
	        this.setMaxDamage(64);
	        this.setCreativeTab(CreativeTabs.tabTools);
	        
	    }

	    /**
	     * Callback for item usage. If the item does something special on right clicking, he will have one of those. Return
	     * True if something happen and false if it don't. This is for ITEMS, not BLOCKS
	     */
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
	          
	            
	            if(Esta(par3World, par4, par5, par6)){
	            	
						try {
							Invoca(par2EntityPlayer,par3World, par4, par5, par6);
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					
	            	
	            }
	            
	         
	            par1ItemStack.damageItem(1, par2EntityPlayer);
	            return true;
	        }
	    }
	    public void Invoca (EntityPlayer entityplayer,World par3World,int par4,int par5,int par6) throws InterruptedException {
	    	if(!p){p=true;}else{
	    	
	    	
	    	p=false;
	    	
	    	Sleep sleep=new Sleep(5,entityplayer
					,par4,par5,par6,par3World);
	    	entityplayer.addChatMessage("Matias is coming");
	    	sleep.start();
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
}
