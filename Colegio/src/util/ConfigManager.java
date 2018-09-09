/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

/**
 *
 * @author cbustamante
 */
public class ConfigManager {
    private static Properties properties;
    private static boolean config;
    public  static  String database;
    public static  String schema;
    
    
    private static void init ()    
   
    {
        try
        {
            
//            String configPath= System.getProperty("user.dir") +  "config.properties";
            String configPath= "config.properties";
            System.out.println("Init ConfigManager from:" + configPath);
            FileInputStream fileInput = new FileInputStream(new File(configPath));
            properties = new Properties();
            properties.load(fileInput);
        }
        catch(Exception ex)
        {
            System.out.println("No se encuentra el archivo de configuracion");
            
        }
                
        
        config = true;
    }
    public static String getConfig (String conf)
    {
        System.out.println("ConfigManager.get(" + conf + ")");
        if (!config)
        {
            init ();
        }
        try
        {
            return properties.get(conf).toString().trim();
        }
        catch(Exception ex)
        {
            System.out.println("Error al retornar la propiedad:" + conf);
        }
        return "";
    }
    
}
