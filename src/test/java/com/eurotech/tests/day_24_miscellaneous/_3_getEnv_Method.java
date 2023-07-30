package com.eurotech.tests.day_24_miscellaneous;

import org.testng.annotations.Test;

public class _3_getEnv_Method {
    /**
     * environment variables'da bulunan değişkenlere erişmek için kullanılır.
     */

    @Test
    public void test1(){
        String password= System.getenv("password");
        System.out.println("password= " + password);
    }

}
