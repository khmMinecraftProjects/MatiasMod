package ModMatias.proxies;

import java.io.File;

import ModMatias.Mobs.Matias.EntityMatias;
import ModMatias.Mobs.Matias.ModelMatias;
import ModMatias.Mobs.Matias.RenderMatias;
import cpw.mods.fml.client.registry.RenderingRegistry;

import net.minecraftforge.client.MinecraftForgeClient;


public class MatiasClientProxy extends MatiasCommonProxy {
	@Override
	public void registerRenderThings(){
		RenderingRegistry.registerEntityRenderingHandler(
			 	EntityMatias.class, 
			 	new RenderMatias(new ModelMatias(),0.3F));
	}
	
	
}
