package com.kraft.tests.day07_testNG_Intro;

import org.testng.Assert;
import org.testng.annotations.Test;

public class _2_TestNGAssertions {

    @Test
    public void test1(){
        String str=null;
        String str1="Ahmet";
        Assert.assertEquals("Ali","Ali");
        Assert.assertNotEquals("Ahmet","Ali");
        Assert.assertTrue(0<1);
        Assert.assertFalse(0>1);
        Assert.assertNull(str);
        Assert.assertNotNull(str1);

    }
}
