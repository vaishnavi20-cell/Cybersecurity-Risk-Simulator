package com.cybersecurity.simulator;

public class PasswordAnalysisResult {

    // Password Details
    public String password;
    public int length;

    // Character Checks
    public boolean hasUpper;
    public boolean hasLower;
    public boolean hasDigit;
    public boolean hasSpecial;

    // Analysis Results
    public String strength;
    public int score;
    public double entropy;
    public String riskLevel;

    // Dictionary Attack Check
    public boolean dictionaryPassword;

}