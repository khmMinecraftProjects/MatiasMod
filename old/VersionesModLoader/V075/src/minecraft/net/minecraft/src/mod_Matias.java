package net.minecraft.src;

import java.awt.Color;
import java.util.Map;

import net.minecraft.client.Minecraft;


public class mod_Matias extends BaseMod {
    public static final Item Fire;

	public String getVersion()
    {
            return "Version 0.75";
    }
	static {
		

		Fire = new ItemMatiasFire(302);
		Fire.setUnlocalizedName("fire");
		
		ModLoader.addName(Fire, "flint and Steel of Matias");

		ModLoader.addRecipe(new ItemStack(Fire, 1), new Object[] { 
		    "RRR", "RYB", "BBB",  Character.valueOf('R'), Block.blockRedstone
		    ,Character.valueOf('B'), Block.blockLapis
		    ,Character.valueOf('Y'), Item.flintAndSteel}); 
		
		
		
		
		
		//////////////////////////
		
		ModLoader.registerEntityID(EntityMatias.class, "Matias", 52);
		ModLoader.addSpawn("Matias", 15, -5, 1, EnumCreatureType.monster);
		ModLoader.addLocalization("Matias", "Matias");
		EntityList.entityEggs.put(Integer.valueOf(52), new EntityEggInfo
		(52, 894731, (new Color(236, 36, 0)).getRGB()));
		
		//////////////////////////
		
		
	}
	public void addRenderer(Map var1)
	{
		var1.put(EntityMatias.class, new RenderLiving(new ModelMatias(),.5f));

	}
	public void load() {

	}
	
}
