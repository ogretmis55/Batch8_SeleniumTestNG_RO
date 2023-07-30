package com.eurotech.tests.day_09_testNG_intro;

import org.testng.annotations.*;

public class _2_BeforeAfterMethod {

    @Test(priority = 2)
    public void test1() {
        System.out.println("Test 1");


    }

    @Test(priority = 1)
    //@Ignore
    public void test2() {
        System.out.println("Test 2");
    }

    @Test(priority = 4)
    public void test3() {
        System.out.println("Test 3");
    }

    @Test(priority = 3)
    public void test4() {
        System.out.println("Test 4");
    }

    @BeforeMethod
    public void setUp() {
        System.out.println("Before Method");
    }

    @AfterMethod
    public void tearDown() {
        System.out.println("After Method");

    }

    @BeforeClass
    public void beforeClass() {
        System.out.println("Before Class");
    }

    @AfterClass
    public void afterClass() {
        System.out.println("After Class");

    }

    @BeforeTest
    public void beforeTest() {
        System.out.println("Before Test");
    }

    @AfterTest
    public void afterTest() {
        System.out.println("After Test");
    }
    @BeforeSuite
    public void beforeSuit(){
        System.out.println("Before Suit");
    }
    @AfterSuite
    public void afterSuite(){
        System.out.println("After Suite");
    }
}
