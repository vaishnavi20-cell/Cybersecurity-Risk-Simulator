package com.cybersecurity.simulator;

import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class ReportGenerator {

    public void generateReport(PasswordAnalysisResult result) {

        try {

            FileWriter writer = new FileWriter("SecurityReport.txt");

            LocalDateTime now = LocalDateTime.now();

            DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
            DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("hh:mm a");

            String maskedPassword = "*".repeat(result.length);

            writer.write("=====================================================\n");
            writer.write("        CYBERSECURITY PASSWORD SECURITY REPORT\n");
            writer.write("=====================================================\n\n");

            writer.write("Generated Date      : " + now.format(dateFormatter) + "\n");
            writer.write("Generated Time      : " + now.format(timeFormatter) + "\n\n");

            writer.write("PASSWORD INFORMATION\n");
            writer.write("-----------------------------------------------------\n");
            writer.write("Password            : " + maskedPassword + "\n");
            writer.write("Password Length     : " + result.length + "\n");
            writer.write("Password Strength   : " + result.strength + "\n");
            writer.write("Password Score      : " + result.score + "/10\n");
            writer.write(String.format("Password Entropy    : %.2f bits%n", result.entropy));
            writer.write("Risk Level          : " + result.riskLevel + "\n");
            writer.write("Dictionary Password : " +
                    (result.dictionaryPassword ? "YES" : "NO") + "\n\n");

            writer.write("PASSWORD COMPOSITION\n");
            writer.write("-----------------------------------------------------\n");
            writer.write("Uppercase Letters   : " +
                    (result.hasUpper ? "Yes" : "No") + "\n");
            writer.write("Lowercase Letters   : " +
                    (result.hasLower ? "Yes" : "No") + "\n");
            writer.write("Digits              : " +
                    (result.hasDigit ? "Yes" : "No") + "\n");
            writer.write("Special Characters  : " +
                    (result.hasSpecial ? "Yes" : "No") + "\n\n");

            writer.write("SECURITY RECOMMENDATIONS\n");
            writer.write("-----------------------------------------------------\n");

            if(result.length < 12)
                writer.write("• Increase password length to at least 12 characters.\n");

            if(!result.hasUpper)
                writer.write("• Add uppercase letters.\n");

            if(!result.hasLower)
                writer.write("• Add lowercase letters.\n");

            if(!result.hasDigit)
                writer.write("• Add numeric digits.\n");

            if(!result.hasSpecial)
                writer.write("• Add special characters.\n");

            if(result.dictionaryPassword)
                writer.write("• Avoid common dictionary words in passwords.\n");

            writer.write("• Enable Multi-Factor Authentication (MFA).\n");
            writer.write("• Never reuse passwords across multiple accounts.\n");
            writer.write("• Change passwords periodically.\n");

            if(result.score == 10) {
                writer.write("\nExcellent! Your password follows strong security practices.\n");
            }

            writer.write("\n=====================================================\n");
            writer.write("Report Status : Successfully Generated\n");
            writer.write("End of Report\n");
            writer.write("=====================================================\n");

            writer.close();

            System.out.println("\n=================================================");
            System.out.println("   Security Report Generated Successfully!");
            System.out.println("   File Name : SecurityReport.txt");
            System.out.println("=================================================");

        } catch (IOException e) {

            System.out.println("Error generating security report.");

        }

    }

}