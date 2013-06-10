package ModMatias.proxies;

import java.io.File;

import net.minecraftforge.client.MinecraftForgeClient;


public class MatiasClientProxy extends MatiasCommonProxy {
	String fire="/ModMatias/Texturas/Items/fire.png";
	@Override
	public void registerRenderThings(){
		

	}
	
	public void use(){
		File dir = new File ("/");
		String[] list=dir.list();
		for(int i=0;i<list.length;i++){
		System.out.println("ss "+dir.listFiles()[i]);
		}
	}
}
