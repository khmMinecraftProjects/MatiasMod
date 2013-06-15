package ModMatias.Mobs.Matias;

import ModMatias.Mobs.Matias.EntityMatias;
import ModMatias.Mobs.Matias.ModelMatias;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.monster.EntityMob;

public class RenderMatias extends RenderLiving
{
	 protected ModelMatias modelo;

	 public RenderMatias (ModelMatias model, float f)
	 {
	  super(model, f);
	  modelo = ((ModelMatias)mainModel);
	 }
	 
	 public void render(EntityMatias entity, double par2, double par4, double par6, float par8, float par9)
	    {
	        super.doRenderLiving(entity, par2, par4, par6, par8, par9);
	    }
	 
	 public void doRenderLiving(EntityLiving par1EntityLiving, double par2, double par4, double par6, float par8, float par9)
	    {
	        render((EntityMatias)par1EntityLiving, par2, par4, par6, par8, par9);
	    }
	 
	 public void doRender(Entity par1Entity, double par2, double par4, double par6, float par8, float par9)
	    {
	        render((EntityMatias)par1Entity, par2, par4, par6, par8, par9);
	    }
	}