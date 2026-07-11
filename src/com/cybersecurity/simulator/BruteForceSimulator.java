package com.cybersecurity.simulator;

import java.text.DecimalFormat;

public class BruteForceSimulator {

    public void simulate(String password) {

        int length = password.length();

        boolean hasUpper = false;
        boolean hasLower = false;
        boolean hasDigit = false;
        boolean hasSpecial = false;

        for (char ch : password.toCharArray()) {

            if (Character.isUpperCase(ch))
                hasUpper = true;

            else if (Character.isLowerCase(ch))
                hasLower = true;

            else if (Character.isDigit(ch))
                hasDigit = true;

            else
                hasSpecial = true;
        }

        int characterSet = 0;

        if (hasLower)
            characterSet += 26;

        if (hasUpper)
            characterSet += 26;

        if (hasDigit)
            characterSet += 10;

        if (hasSpecial)
            characterSet += 32;

        double combinations = Math.pow(characterSet, length);

        DecimalFormat df = new DecimalFormat("#,###");

        System.out.println("\n==========================================");
        System.out.println("      BRUTE FORCE ATTACK SIMULATION");
        System.out.println("==========================================");

        System.out.println("Password Length      : " + length);
        System.out.println("Character Set Size   : " + characterSet);
        System.out.println("Possible Combinations: " + df.format(combinations));

        System.out.println("\nEstimated Cracking Time");

        printTime("1000 guesses/sec", combinations / 1000);
        printTime("1 Million guesses/sec", combinations / 1_000_000);
        printTime("1 Billion guesses/sec", combinations / 1_000_000_000);

        System.out.println();

        if (length >= 12 && characterSet >= 94) {

            System.out.println("Security Rating : EXCELLENT");
            System.out.println("Risk Level      : LOW");
            System.out.println("Recommendation  : Password is highly resistant to brute-force attacks.");

        } else if (length >= 8) {

            System.out.println("Security Rating : GOOD");
            System.out.println("Risk Level      : MEDIUM");
            System.out.println("Recommendation  : Increase password length for stronger security.");

        } else {

            System.out.println("Security Rating : WEAK");
            System.out.println("Risk Level      : HIGH");
            System.out.println("Recommendation  : Use a longer password with uppercase, lowercase, numbers, and special characters.");

        }

        System.out.println("==========================================");

    }

    private void printTime(String speed, double seconds) {

        double minutes = seconds / 60;
        double hours = minutes / 60;
        double days = hours / 24;
        double years = days / 365;

        System.out.print(speed + " : ");

        if (years >= 1)
            System.out.printf("%.2f years%n", years);

        else if (days >= 1)
            System.out.printf("%.2f days%n", days);

        else if (hours >= 1)
            System.out.printf("%.2f hours%n", hours);

        else if (minutes >= 1)
            System.out.printf("%.2f minutes%n", minutes);

        else
            System.out.printf("%.2f seconds%n", seconds);
    }
}