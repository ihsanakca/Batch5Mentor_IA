package com.kraft.tests.day07_testNG_Intro;

import org.testng.annotations.*;

public class _1_Before_After {
    @BeforeMethod
    public void setUp(){
        System.out.println("before method");
    }

    @AfterMethod
    public void tearDown(){
        System.out.println("after method");
    }

    @Test (priority = 1)
    public void test1(){
        System.out.println("test1");
    }

    @Test    //(enabled = false)
 //   @Ignore
    public void test2() {
        System.out.println("test2");
    }

    @Test (priority = 2)
    public void test3() {
        System.out.println("test3");
    }

    @BeforeClass
    public void beforeClass(){
        System.out.println("before class");
    }

    @AfterClass
    public void afterClass(){
        System.out.println("after class");
    }

    @BeforeTest
    public void beforeTest(){
        System.out.println("before test");
    }

    @AfterTest
    public void afterTest(){
        System.out.println("after test");
    }

    @BeforeSuite
    public void beforeSuite(){
        System.out.println("before suite");
    }

    @AfterSuite
    public void afterSuite(){
        System.out.println("after suite");
    }
}
