package com.eurotech.tests.day_01_automation_intro;

import com.github.javafaker.CreditCardType;
import com.github.javafaker.Faker;

public class _3_JavaFakerDemo {
    public static void main(String[] args) {

        //mock Data üretmek icin kullanilir....(sahte data)
        Faker faker=new Faker();

        //sahte isim uretelim

       String fullname=  faker.name().fullName();
        System.out.println("fullname = " + fullname);

        //sahte bir sehir uretelim
        String city= faker.address().city();
        System.out.println("city = " + city);

        //credit card uretelim
        String creditCard= faker.finance().creditCard();
        System.out.println("creditCard = " + creditCard);

        //american express
        String creditCard1= faker.finance().creditCard(CreditCardType.AMERICAN_EXPRESS);
        System.out.println("American Express = " + creditCard1);

        //sifre uretelim
        String password= faker.internet().password();
        System.out.println("password = " + password);

        //rakam harf ozel isaret iceren password
        String password1= faker.internet().password(8,16,true,true,true);
        System.out.println("password1 = " + password1);

        //belli bir degerle baslayan sifre
        String password2= "AB123*" + faker.internet().password();
        System.out.println("password2 = " + password2);


    }
}
