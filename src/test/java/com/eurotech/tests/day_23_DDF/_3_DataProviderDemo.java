package com.eurotech.tests.day_23_DDF;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class _3_DataProviderDemo {

    @DataProvider
    public Object [][] testData_1(){
        String [][] notes={
                {"Hasan Sari", "70","100"},
                {"Veysel Candan","80","98"},
                {"Hanife Kara","90","95"},
                {"Burhan Eratli","87","98"},
                {"Sule Aylin Atmaca", "100", "93"},
                {"Eylem Sönmez","89","97"}
        };
        return notes;
    }


    @Test(dataProvider = "testData_1" )
    public void testNotes(String fullName,String visaNote,String finalNote){
        System.out.println(fullName+" "+visaNote+" "+finalNote);

    }
    @DataProvider(name = "StudentNotes")
    public Object [][] testData_2(){
       Object [][] notes={
                {"Hasan Sari", 70,100},
                {"Veysel Candan",80,98},
                {"Hanife Kara",90,95},
                {"Burhan Eratli",87,98},
                {"Sule Aylin Atmaca", 100, 93},
                {"Eylem Sönmez",89,97}
        };
        return notes;
    }


    @Test(dataProvider = "StudentNotes")
    public void testNotes_2(String fullName,int visaNote,int finalNote){
        System.out.println(fullName+" "+visaNote+" "+finalNote+ " Yil sonu notu ="+(visaNote*0.4+finalNote*0.6));

    }
}
