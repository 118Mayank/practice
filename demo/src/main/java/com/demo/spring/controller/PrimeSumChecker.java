package com.demo.spring.controller;
import java.util.Scanner;
//Write a java program to check if any number given as input is the sum of 2 prime numbers.
public class PrimeSumChecker {

    // Method to check if a number is prime
    private static boolean isPrime(int num) {
        if (num <= 1) return false;
        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) return false;
        }
        return true;
    }

    // Method to check if the number is the sum of two primes
    private static boolean isSumOfTwoPrimes(int number) {
        for (int i = 2; i <= number / 2; i++) {
            if (isPrime(i) && isPrime(number - i)) {
                System.out.println(number + " = " + i + " + " + (number - i));
                return true;
            }
        }
        return false;
    }

    public static void main2(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a number: ");
        int number = scanner.nextInt();

        if (isSumOfTwoPrimes(number)) {
            System.out.println(number + " can be expressed as the sum of two prime numbers.");
        } else {
            System.out.println(number + " cannot be expressed as the sum of two prime numbers.");
        }

        scanner.close();
    }
}
