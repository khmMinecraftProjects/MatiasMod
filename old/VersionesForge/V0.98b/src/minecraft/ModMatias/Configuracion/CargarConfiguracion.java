package ModMatias.Configuracion;

import java.io.File;
import static net.minecraftforge.common.Configuration.CATEGORY_GENERAL;

import net.minecraft.util.StringTranslate;
import net.minecraftforge.common.Configuration;


public class CargarConfiguracion {
    public static Configuration config;
	public static void load(File fil){
		config=new Configuration(fil);
		try{
			config.load();
            Datos.idMechero = config.get(CATEGORY_GENERAL,Datos.RidMechero,Datos.FidMechero).getInt();
            Datos.MatiasID = config.get(CATEGORY_GENERAL,Datos.RMatiasID,Datos.FMatiasID).getInt();
            Datos.DragonID = config.get(CATEGORY_GENERAL,Datos.RDragonID,Datos.FDragonID).getInt();
            Datos.WitherID = config.get(CATEGORY_GENERAL,Datos.RWitherID,Datos.FWitherID).getInt();
            Datos.t0 = config.get(CATEGORY_GENERAL,Datos.Rt0,Datos.Ft0).getInt();
            Datos.t1 = config.get(CATEGORY_GENERAL,Datos.Rt1,Datos.Ft1).getInt();
            Datos.t2 = config.get(CATEGORY_GENERAL,Datos.Rt2,Datos.Ft2).getInt();
            Datos.t3 = config.get(CATEGORY_GENERAL,Datos.Rt3,Datos.Ft3).getInt();
            Datos.MatiasHealt = config.get(CATEGORY_GENERAL,Datos.RMatiasHealt,Datos.FMatiasHealt).getInt();
            Datos.Idioma = config.get(CATEGORY_GENERAL,Datos.RIdioma,Datos.FIdioma).getName();
            Datos.MatiasEgg = config.get(CATEGORY_GENERAL,Datos.RMatiasEgg,Datos.FMatiasEgg).getBoolean(true);
            Datos.WitherEgg = config.get(CATEGORY_GENERAL,Datos.RWitherEgg,Datos.FWitherEgg).getBoolean(true);
            Datos.DragonEgg = config.get(CATEGORY_GENERAL,Datos.RDragonEgg,Datos.FDragonEgg).getBoolean(true);

         
		}catch(Exception e){
			
		}
		finally {
			config.save();
		}
	}


}
