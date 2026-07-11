package com.cybersecurity.simulator;

public class PasswordAnalyzer {

    public PasswordAnalysisResult analyze(String password) {

        PasswordAnalysisResult result = new PasswordAnalysisResult();

        result.password = password;
        result.length = password.length();

        for (int i = 0; i < password.length(); i++) {

            char ch = password.charAt(i);

            if (Character.isUpperCase(ch))
                result.hasUpper = true;

            else if (Character.isLowerCase(ch))
                result.hasLower = true;

            else if (Character.isDigit(ch))
                result.hasDigit = true;

            else
                result.hasSpecial = true;
        }

        int score = 0;

        if (result.length >= 8)
            score++;

        if (result.hasUpper)
            score++;

        if (result.hasLower)
            score++;

        if (result.hasDigit)
            score++;

        if (result.hasSpecial)
            score++;

        if (score <= 2)
            result.strength = "Weak";

        else if (score == 3 || score == 4)
            result.strength = "Medium";

        else
            result.strength = "Strong";
        result.score = score * 2;
        
        int characterSet = 0;

        if (result.hasLower)
            characterSet += 26;

        if (result.hasUpper)
            characterSet += 26;

        if (result.hasDigit)
            characterSet += 10;

        if (result.hasSpecial)
            characterSet += 32;

        result.entropy = result.length * (Math.log(characterSet) / Math.log(2));
        if(result.strength.equals("Weak"))
            result.riskLevel = "HIGH";

        else if(result.strength.equals("Medium"))
            result.riskLevel = "MEDIUM";

        else
            result.riskLevel = "LOW";
        System.out.println("\n========== Password Analysis ==========");

        System.out.println("Length             : " + result.length);
        System.out.println("Uppercase          : " + (result.hasUpper ? "Yes" : "No"));
        System.out.println("Lowercase          : " + (result.hasLower ? "Yes" : "No"));
        System.out.println("Digits             : " + (result.hasDigit ? "Yes" : "No"));
        System.out.println("Special Characters : " + (result.hasSpecial ? "Yes" : "No"));
        System.out.println("\nPassword Strength : " + result.strength);
        System.out.println("Password Score    : " + result.score + "/10");
        System.out.printf("Entropy           : %.2f bits%n", result.entropy);
        System.out.println("Risk Level        : " + result.riskLevel);
        System.out.println("\nSuggestions:");

        if (result.length < 12)
            System.out.println("- Increase password length to at least 12 characters.");

        if (!result.hasUpper)
            System.out.println("- Add uppercase letters.");

        if (!result.hasLower)
            System.out.println("- Add lowercase letters.");

        if (!result.hasDigit)
            System.out.println("- Add numbers.");

        if (!result.hasSpecial)
            System.out.println("- Add special characters like @, #, $, %.");

        if (score == 5 && result.length >= 12)
            System.out.println("- Excellent! Your password follows good security practices.");

        return result;
    }

    public void checkDictionaryPassword(PasswordAnalysisResult result) {

        String[] commonPasswords = {
                "password",
                "123456",
                "admin",
                "qwerty",
                "welcome",
                "letmein",
                "abc123",
                "iloveyou"
        };

        String lowerPassword = result.password.toLowerCase();

        result.dictionaryPassword = false;

        for (String common : commonPasswords) {

            if (lowerPassword.contains(common)) {
                result.dictionaryPassword = true;
                break;
            }
        }

        System.out.println("\n========== Dictionary Password Check ==========");

        if (result.dictionaryPassword) {

            System.out.println("WARNING!");
            System.out.println("This password contains a commonly used password.");
            System.out.println("Risk Level : HIGH");
            System.out.println("This password may be vulnerable to dictionary attacks.");

        } else {

            System.out.println("Good!");
            System.out.println("No common dictionary passwords detected.");
        }
    }
}