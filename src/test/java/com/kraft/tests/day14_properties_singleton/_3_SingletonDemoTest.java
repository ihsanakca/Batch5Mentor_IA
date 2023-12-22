package com.kraft.tests.day14_properties_singleton;

import org.testng.annotations.Test;

public class _3_SingletonDemoTest {

    @Test
    public void test1(){
        String s = _2_SingletonDemo.getDriver();
        System.out.println("s = " + s);

        String s1 = _2_SingletonDemo.getDriver();
        System.out.println("s1 = " + s1);
    }
}
