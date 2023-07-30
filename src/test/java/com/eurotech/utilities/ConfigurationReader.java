package com.eurotech.utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigurationReader {

    private static Properties properties;

    static {
        try {
            //path of file which is wanted to read
            String path= "configuration.properties";

            FileInputStream input = new FileInputStream(path);
            //properties --> class that can store data (properties) in key/value format
            properties=new Properties();
            //the values (data) from input is loaded to the properties object
            properties.load(input);
            input.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static String get(String keyName){
       return properties.getProperty(keyName);
    }
}
