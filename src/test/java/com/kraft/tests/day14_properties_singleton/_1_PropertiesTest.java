package com.kraft.tests.day14_properties_singleton;

import com.kraft.utilities.ConfigurationReader;
import org.testng.annotations.Test;

public class _1_PropertiesTest {

    @Test
    public void test1(){
        String browser = ConfigurationReader.get("browser");
        System.out.println("browser = " + browser);

    }
}
