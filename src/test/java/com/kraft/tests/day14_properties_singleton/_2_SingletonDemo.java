package com.kraft.tests.day14_properties_singleton;

import com.kraft.utilities.ConfigurationReader;

public class _2_SingletonDemo {

    private  _2_SingletonDemo(){}

   private static String driver;

    public static String getDriver(){
        if (driver==null){
            System.out.println("driver boştur, lütfen değer atayınız");
            driver= ConfigurationReader.get("browser");
        }else{
            System.out.println("driver doludur, değerini isteseniz return ile alınız");
        }
        return driver;
    }
}
