package com.kraft.tests.day20_miscellaneous;

import org.testng.annotations.Test;

public class _3_getEnv_Method {

    @Test
    public void test1() {
        /**
         * environment variables'da bulunan değişkenlere erişmek için kullanılır.
         */

        String password = System.getenv("Password");
        System.out.println("password = " + password);
    }
}
