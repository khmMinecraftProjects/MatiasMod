package ModMatias.Mobs.Matias;

import java.util.ArrayList;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.ai.EntityAIAttackOnCollide;
import net.minecraft.entity.ai.EntityAIBase;
import net.minecraft.entity.boss.EntityDragon;
import net.minecraft.entity.boss.EntityWither;
import net.minecraft.pathfinding.PathEntity;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;


public class EntityAIMatias extends EntityAIAttackOnCollide{
    EntityLiving attacker;

    public EntityAIMatias(EntityLiving par1EntityLiving, float par2,
			boolean par3) {
		super(par1EntityLiving, par2, par3);
    	attacker=par1EntityLiving;
	}
	    public void updateTask()
	    {   	
	    	switch(((EntityMatias)attacker).getEstado()){
	    	case 0:
	    		super.updateTask();
	 	        break;
	    	case 1:
	    		break;
	    	}
	    	
	       
	    }
	   
	
}

