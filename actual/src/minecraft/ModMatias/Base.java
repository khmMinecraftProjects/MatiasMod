package ModMatias;


import java.awt.Color;
import java.io.BufferedReader;
import java.io.File;



import net.minecraft.block.Block;
import net.minecraft.client.model.ModelBase;
import net.minecraft.entity.Entity;
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
import ModMatias.Configuracion.CargarConfiguracion;
import ModMatias.Configuracion.Datos;
import ModMatias.Configuracion.Values;
import ModMatias.Items.ItemMatiasFire;
import ModMatias.Mobs.Matias.Dragon;
import ModMatias.Mobs.Matias.EntityMatias;
import ModMatias.Mobs.Matias.ModelMatias;
import ModMatias.Mobs.Matias.RenderMatias;
import ModMatias.Mobs.Matias.Wither;
import ModMatias.proxies.MatiasClientProxy;
import ModMatias.proxies.MatiasCommonProxy;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.Mod;
@Mod(modid= "ModMatias",useMetadata=true)



@NetworkMod(clientSideRequired = true, serverSideRequired = false)

public class Base {

	String fir;
	@SidedProxy(clientSide="ModMatias.proxies.MatiasClientProxy", serverSide="ModMatias.proxies.MatiasCommonProxy")
	public static MatiasCommonProxy proxy;
	public static Item Fire;


	@PreInit
	public void preInit(FMLPreInitializationEvent event) 
	{
		CargarConfiguracion.load(
				new File(event.getModConfigurationDirectory().getAbsolutePath()+File.separator+"ModMatias"+File.separator+"ModMatias.cfg"));
		if(Datos.Idioma=="ES"){
			fir=Values.Fire_ES;
		}
		else{
			fir=Values.Fire_UK;
		}
	}

	@Init
	public void init(FMLInitializationEvent event)
	{
		int idFire=Datos.idMechero,
				idMatias=Datos.MatiasID,
				idDragon=Datos.DragonID,
				idWither=Datos.WitherID;
		
		proxy.registerRenderThings();

		Fire = new ItemMatiasFire(idFire).setUnlocalizedName("fire");
		LanguageRegistry.addName(Fire, fir);
		
		GameRegistry.addRecipe(new ItemStack(Fire, 1), new Object[] { 
			"RRR", "RYB", "BBB",  Character.valueOf('R'), Item.redstone
			,Character.valueOf('B'), Block.blockLapis
			,Character.valueOf('Y'), Item.flintAndSteel});

		creaMob(EntityMatias.class,"Matias",1,559,
				new Color(236, 36, 0),new Color(0,0,205));
		creaMob(Dragon.class,"Dragon Invocado",2,600,
				new Color(236, 36, 0),new Color(0,0,205));
		creaMob(Wither.class,"Wither Invocado",3,601,
				new Color(236, 36, 0),new Color(0,0,205));
	}

	@PostInit
	public static void postInit(FMLPostInitializationEvent event)
	{
	}
	public void creaMob(Class<?extends Entity> mob,String name
			,int id,int idM,Color a,Color b){
		EntityRegistry.registerModEntity(mob,
				name,idM, this, 80, 3, true);
		if(id!=0){
		EntityList.IDtoClassMapping.put(id, mob);
		EntityList.entityEggs.put(id, new EntityEggInfo(id,
				a.getRGB(),
				b.getRGB()));}
		LanguageRegistry.instance().addStringLocalization("entity.ModMatias."
					+name+".name", name);

	}






}
