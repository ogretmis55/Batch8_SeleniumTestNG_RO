package com.eurotech.tests.day_09_testNG_intro;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.sql.SQLOutput;

public class _3_TestNGAssertionsDemo {

    @BeforeMethod
    public void setUp() {
        System.out.println("**********OPEN BROWSER************");
    }

    @AfterMethod
    public void tearDown() {
        System.out.println("**********CLOSE BROWSER***********");
    }

    @Test
    public void test1() {
        System.out.println("First Assertion");
        Assert.assertEquals("Ayse3", "Ayse");

        System.out.println("Second Assertion");
        Assert.assertEquals("Ali3", "Ali");
    }

    @Test
    public void test2() {
        System.out.println("Third Assertion");
        Assert.assertEquals("url", "url", "verify that both urls are equal");
        //int i=8/0;
    }

    @Test
    public void test3() {
        String str = "euroTech";
        String str1 = "euro";
        String mail = "aaaaa@aaa.com";

        Assert.assertTrue(str.startsWith(str1));
        Assert.assertTrue(mail.contains("@"), "verify that mail contains @");
        Assert.assertTrue(mail.contains("@") && mail.contains("com"), "verify that mail contains @");
    }

    @Test
    public void test4() {
        String str = "euroTech";
        Assert.assertFalse(str.contains("@"));
        Assert.assertNotEquals("Ali","Ayse");
    }
    @Test
    public void test5(){
        String str="Ahmet";
        String str1=null;
        Assert.assertNotNull(str);
        Assert.assertNull(str1);
    }
}

