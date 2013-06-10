package net.minecraft.src;
import java.util.concurrent.Semaphore;

import net.minecraft.client.Minecraft;


public class Sleep extends Thread {
		int tiempo;
		Semaphore semaphore;
		boolean ok=false;
		EntityPlayer entityplayer;
		int par4, par5, par6;
		World par3World;
		EntityLiving matias;
		int accion=0,estado=1;
		EntityLiving Mob,target;
		EntityLiving[] mobs;
		public Sleep(EntityLiving mob,EntityLiving attacker,int tip
				,int t){
			Mob=mob;
			matias=attacker;
			accion=tip;
			tiempo=t;
		}
		public Sleep(EntityLiving attacker,int tip){
			matias=attacker;
			accion=tip;
		}
		public Sleep(int tiemp,EntityPlayer entityplayer1
				,int par41,int par51,int par61,World par3World1) {
		tiempo=tiemp;
		
		entityplayer=entityplayer1;
		par4=par41;
		par5=par51;
		par6=par61;
		par3World=par3World1;
		
		semaphore = new Semaphore (0);
		}
		public boolean okey() {
			return ok;
		}
		public void IA(){
    		((EntityMatias)matias).setInvul(true);
    		matias.moveSpeed=0f;

		    PotionEffect[] potions={
		    		new PotionEffect(1,3,10000),//SPEED
		    		new PotionEffect(5,3,10000),//STRENGTH
		    		new PotionEffect(10,3,10000),//REGENERATION
		    		new PotionEffect(11,3,10000),//RESISTANCE
		    	};
		   
		    EntityLiving[] mobs2={
					new EntityDragon(matias.worldObj),
					new EntityWither(matias.worldObj)
				};
		    mobs=mobs2;
		    
			int [] [] pos={
					{10,5,0},
					{5,5,0},
					{0,0,0}
				};
			int[] V={1,1,5};
			int[] tiempos={5000,5000,1000,5000,5000};
			//matias.setPosition(target.posX+5, target.posY, target.posZ);
			for(int i=0;i<mobs.length;i++){
				invocaMob(mobs[i],V[i],pos[i][0],pos[i][1],pos[i][2],
						tiempos[i]);
				//matias.setPosition(target.posX+5, target.posY, target.posZ);
			}
			comprobar();
			System.out.println("aqui");
			setEstado(0);
    		((EntityMatias)matias).setInvul(false);
			try {
				Thread.sleep(10000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			setEstado(1);
		}
		public void espera() throws InterruptedException{
			tiempo=5000;
			Mob=new EntityDragon(matias.worldObj);
			
			try {
				Thread.sleep(tiempo);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
    		matias.moveSpeed=0.5f;

		}
		public void invocaMob(EntityLiving mob,int v,int x,int y, int z,int t){
			
			
    		mob.setPositionAndRotation(target.posX+x, 
    				target.posY+y, target.posZ+z,0,0);
    		matias.worldObj.spawnEntityInWorld(mob);
    		try {
				Thread.sleep(t);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
    		
    		matias.worldObj.removeEntity(mob);
    		
		}
		public void setTarget(EntityLiving p){
			target=p;
		}
		public void invoca(){
			ok=true;
			
			
			for(int i=0;i<tiempo;i++){
				
	    		try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		    	entityplayer.addChatMessage("Faltan "+(5-i)+" segundos");
				}
				
				entityplayer.addChatMessage("Matias esta aqui");
				
				for(int s=0;s<3;s++){
		           	par3World.setBlock(par4, par5-s-1, par6,0);
		          	par3World.setBlock(par4+1, par5-s-1, par6,0);
		          	par3World.setBlock(par4, par5-s-1, par6+1,0);
		          	par3World.setBlock(par4-1, par5-s-1, par6,0);
		          	par3World.setBlock(par4, par5-s-1, par6-1,0);
		          }
		    	 EntityLightningBolt entitybolt = new EntityLightningBolt(par3World
		    			 , 0D, 0D, 0D);
		    	 
		        entitybolt.setLocationAndAngles(par4, par5-3, par6, 0, 0.0F);
		        par3World.spawnEntityInWorld(entitybolt); 
		        
		    	EntityMatias eggmatias=new EntityMatias(par3World);
				eggmatias.setPosition(par4, par5-3, par6);
				par3World.spawnEntityInWorld(eggmatias);
		}
		public synchronized int getEstado(){
			return estado;
		}
		public synchronized void setEstado(int i){
			estado=i;
		}
		public void run() {
			/*
		try { 
		Thread.sleep(1000);
		semaphore.release();
		} catch (InterruptedException e) {System.out.println(e); }
		*/
			System.out.println(accion);
		switch(accion){
		case 0:
			invoca();
			break;
		case 1:
			invocaMob(Mob,1,0,10,0,tiempo);
			break;
		case 2:
			IA();
		default:break;
		}
		
		
		
		
		}
		public void comprobar() {
			for(int i=0;mobs!=null&&i<mobs.length;i++){
	    		matias.worldObj.removeEntity(mobs[i]);
			}
			
		}
}
