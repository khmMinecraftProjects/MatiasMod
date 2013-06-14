package ModMatias;


import java.awt.Color;
import java.io.BufferedReader;


import net.minecraft.block.Block;
import net.minecraft.client.model.ModelBase;
import net.minecraft.entity.EntityEggInfo;
import net.minecraft.entity.EntityList;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.src.ModLoader;
import net.minecraft.util.StringTranslate;
import cpw.mods.fml.client.registry.RenderingRegistry;
import cpw.mods.fml.common.FMLLog;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.Init;
import cpw.mods.fml.common.Mod.PostInit;
import cpw.mods.fml.common.Mod.PreInit;
import cpw.mods.fml.common.ModMetadata;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkMod;
import cpw.mods.fml.common.registry.EntityRegistry;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;
import cpw.mods.fml.common.registry.VillagerRegistry;
import cpw.mods.fml.relauncher.SideOnly;
import ModMatias.Items.ItemMatiasFire;
import ModMatias.Mobs.Matias.EntityMatias;
import ModMatias.Mobs.Matias.ModelMatias;
import ModMatias.Mobs.Matias.RenderMatias;
import ModMatias.proxies.MatiasClientProxy;
import ModMatias.proxies.MatiasCommonProxy;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.Mod;

@Mod(modid= "ModMatias",useMetadata=true)



@NetworkMod(clientSideRequired = true, serverSideRequired = false)

public class Base {
	String fir="flint and Steel of Matias";
	@SidedProxy(clientSide="ModMatias.proxies.MatiasClientProxy", serverSide="ModMatias.proxies.MatiasCommonProxy")
	public static MatiasCommonProxy proxy;
    public static Item Fire;

    @PreInit
	public void preInit(FMLPreInitializationEvent event) 
	{
	}

	@Init
	public void init(FMLInitializationEvent event)
	{
		  proxy.registerRenderThings();
		String lan=StringTranslate.getInstance().currentLanguage;
		if(lan=="es_ES"){
			fir="Mechero de Matias";
		}
		Fire = new ItemMatiasFire(558).setIconCoord(0, 0).setItemName("fire");
		 LanguageRegistry.addName(Fire, fir);

		GameRegistry.addRecipe(new ItemStack(Fire, 1), new Object[] { 
		    "RRR", "RYB", "BBB",  Character.valueOf('R'), Item.redstone
		    ,Character.valueOf('B'), Block.blockLapis
		    ,Character.valueOf('Y'), Item.flintAndSteel});
		
		
		 
		 EntityRegistry.registerModEntity(EntityMatias.class,
				 	"Matias",1, this, 80, 3, true);
		 
		 EntityList.IDtoClassMapping.put(559, EntityMatias.class);
		 EntityList.entityEggs.put(559, new EntityEggInfo(559,
				 	new Color(236, 36, 0).getRGB(),
				 	new Color(0,0,205).getRGB()));
		 LanguageRegistry.instance().addStringLocalization("entity.ModMatias.Matias.name", "Matias");
		 
	}

	@PostInit
	public static void postInit(FMLPostInitializationEvent event)
	{
	}

	
	
	
	
	
}
