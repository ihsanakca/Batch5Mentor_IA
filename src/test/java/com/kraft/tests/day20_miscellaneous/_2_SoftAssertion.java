package com.kraft.tests.day20_miscellaneous;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class _2_SoftAssertion {
    SoftAssert softAssert=new SoftAssert();
    @Test
    public void test1(){
        softAssert.assertTrue(11>3);
        softAssert.assertTrue(1>3);
        softAssert.assertEquals("A","A");
        softAssert.assertEquals("A","N");
        softAssert.assertAll("demo assertion");

        /**
         * Soft assertion: Normal assertte hata aldıktan sonraki assertleri test edemeyiz, ancak etmek istediğimiz
         * durumlarda soft assertion kullanabiliriz. Bu assertion tipinde bütün assertler biriktirilir, hatalı assertion olsa da kod
         * exception fırlatmaz ve execution devam eder. En son assertAll() metodunda geriye dönük olarak bütün assertionlar
         * değerlendirilir ve varsa hatalar, bu satır çalıştıktan sonra log kayıtlarında görünür ve hata fırlatılır.
         */

    }
}
