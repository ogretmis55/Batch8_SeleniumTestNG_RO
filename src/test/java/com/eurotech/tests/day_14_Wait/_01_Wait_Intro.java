package com.eurotech.tests.day_14_Wait;

import java.util.Scanner;

public class _01_Wait_Intro {

    public static void main(String[] args) throws InterruptedException {

        Scanner sc= new Scanner(System.in);
        System.out.println("Please enter a number of minutes");
        int minutes= sc.nextInt();

        sc.close();

        for (int i = minutes; i >0 ; i--) {
            for (int j = 59; j >=0 ; j--) {
                System.out.println("\r" + (i - 1) + " minutes and " + j + " Seconds left");
                Thread.sleep(1000);

            }

        }

    }
}
