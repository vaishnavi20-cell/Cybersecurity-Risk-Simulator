package com.cybersecurity.simulator;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        boolean running = true;

        while (running) {

            System.out.println("\n==================================================");
            System.out.println("     CYBERSECURITY RISK SIMULATOR v2.0");
            System.out.println("==================================================");

            System.out.print("Enter Password : ");
            String password = sc.nextLine();

            System.out.println("\n==================== MENU ====================");

            System.out.println("1. Analyze Password");
            System.out.println("2. Brute Force Simulation");
            System.out.println("3. Generate Security Report");
            System.out.println("4. Exit");

            System.out.println("==============================================");

            System.out.print("Enter Choice : ");

            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {

            case 1:

                PasswordAnalyzer analyzer = new PasswordAnalyzer();

                PasswordAnalysisResult result = analyzer.analyze(password);

                analyzer.checkDictionaryPassword(result);

                break;

            case 2:

                BruteForceSimulator simulator = new BruteForceSimulator();

                simulator.simulate(password);

                break;

            case 3:

                PasswordAnalyzer analyzer2 = new PasswordAnalyzer();

                PasswordAnalysisResult result2 = analyzer2.analyze(password);

                analyzer2.checkDictionaryPassword(result2);

                ReportGenerator report = new ReportGenerator();

                report.generateReport(result2);

                break;

            case 4:

                System.out.println("\nThank you for using Cybersecurity Risk Simulator!");
                running = false;
                break;

            default:

                System.out.println("\nInvalid choice. Please try again.");
            }

            if (running) {
                System.out.println("\n----------------------------------------------");
                System.out.println("Press ENTER to continue...");
                sc.nextLine();
            }

        }

        sc.close();

    }

}