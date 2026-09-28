package com.mystore.utilities;

import java.io.FileInputStream;
import java.util.Properties;

public class ReadConfig {
	Properties prop;
	String path="C:\\Amol\\Total Project\\SeleniumWorkspace\\NewMavenProject\\SeleniumMavenProject\\Configuration\\config.properties";
	
	public  ReadConfig() {
    
    try {
    	prop=new Properties();
    	FileInputStream fis=new  FileInputStream(path);
    	prop.load(fis);
    }catch(Exception e) {
    	e.printStackTrace();
    }
    }
      public String getBaseUrl() {
    	String value=  prop.getProperty("baseUrl");
    	if(value != null) { 
    		return value;}
    	else  throw new RuntimeException("url not specified in configbfile");
      }
      
      public String getBrowser() {
      	String value=  prop.getProperty("browser");
      	if(value != null) { 
      		return value;}
      	else  throw new RuntimeException("url not specified in configbfile");
        }

}
