#  Cybersecurity Risk Simulator

A Java-based cybersecurity project that analyzes password strength, estimates resistance against brute-force attacks, detects common dictionary passwords, and generates a detailed security report.

---

##  Project Overview

The Cybersecurity Risk Simulator is a console-based Java application developed to demonstrate fundamental cybersecurity concepts related to password security.

The application evaluates a user's password based on multiple security parameters, estimates the time required for brute-force attacks, checks against commonly used dictionary passwords, and generates a detailed security report.

This project was built to strengthen Java programming skills while applying practical cybersecurity concepts.

---

##  Features

-  Password Strength Analysis
-  Password Length Validation
-  Uppercase & Lowercase Detection
-  Number Detection
-  Special Character Detection
-  Dictionary Password Detection
-  Password Entropy Calculation
-  Brute Force Attack Simulation
-  Automatic Security Report Generation
-  Risk Level Assessment
-  Security Recommendations

---

##  Technologies Used

- Java
- Eclipse IDE
- Object-Oriented Programming (OOP)
- File Handling
- Exception Handling
- Java Collections
- Java Time API

---

##  Project Structure

```
Cybersecurity-Risk-Simulator
│
├── src
│   └── com.cybersecurity.simulator
│       ├── Main.java
│       ├── PasswordAnalyzer.java
│       ├── PasswordAnalysisResult.java
│       ├── BruteForceSimulator.java
│       └── ReportGenerator.java
│
├── Screenshots 1
├── SecurityReport.txt
└── README.md
```

---

##  How to Run

1. Clone the repository

```
git clone https://github.com/vaishnavi20-cell/Cybersecurity-Risk-Simulator.git
```

2. Open the project in Eclipse IDE.

3. Run `Main.java`.

4. Enter a password.

5. Choose one of the available options:

- Analyze Password
- Brute Force Simulation
- Generate Security Report
- Exit

---

##  Test Cases

###  Test Case 1 – Weak Password

Password:

```
password
```

Result:

- Weak Password
- High Risk
- Dictionary Password Detected
- Vulnerable to Brute Force Attack

---

###  Test Case 2 – Strong Password

Password:

```
Hello@123World
```

Result:

- Strong Password
- Low Risk
- High Entropy
- Resistant to Brute Force Attack

---

###  Test Case 3 – Medium Password

Password:

```
Admin123
```

Result:

- Medium Password
- Medium Risk
- Dictionary Password Detected
- Security Improvements Suggested

---

##  Output Screenshots

Project screenshots are available inside the **Screenshots 1** folder.

They include:

- Password Analysis
- Brute Force Simulation
- Security Report Generation
- Weak Password Test
- Medium Password Test
- Strong Password Test

---

##  Future Enhancements

- GUI using JavaFX or Swing
- Password Generator
- Password History Check
- SHA-256 Password Hashing
- CSV/PDF Report Export
- Database Integration
- Multi-language Support

---

##  Learning Outcomes

Through this project, I gained practical experience with:

- Java Programming
- Object-Oriented Design
- File Handling
- Exception Handling
- Password Security Principles
- Cybersecurity Fundamentals
- Brute Force Attack Simulation
- Git & GitHub

---

##  Author

**Vaishnavi Maradi**

Aspiring Cybersecurity Analyst

GitHub:
https://github.com/vaishnavi20-cell

---

 If you found this project useful, consider giving it a Star!