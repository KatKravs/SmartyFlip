In our Git repository we present the SmartyFlip project

![smartyFlip_train_your_brain!](https://github.com/VitalKo7/SmartyFlip_QA_POM/assets/151151151/0cf95564-14e2-41dd-bcb0-1f1ec9957e23)

Description

📖The project was created for beginner programmers or programmers with experience to test their knowledge. Checking takes place using cards. There are also separate functions for the guest and for the user. The user can also create his own modules.

Technologies


🧿 Java Programming Language

🧿 Gradle Build System

🧿 TestNG Test Automation Framework

🧿 Selenium Web Testing Library

🧿 Logback Logging Library

🧿 OpenCSV CSV Handling Library

🧿 Gradle Task Task Management System

🧿 RestAssured for API testing

🧿 Gson for working with JSON

🧿 Java Collections Framework for working with data sets

🧿 Java IO and Java NIO for input-output operations

🧿 Java Exceptions for error handling

Installation
🖥️ You can install and run my project locally. For example:

⚙️ Clone the repository us https://github.com/VitalKo7/SmartyFlip\_QA\_POM

⚙️ Install the required dependencies using Gradle install.

⚙️ Start the project with a gentle run.

Before executing tests, ensure the installation of the following dependencies: Java, Gradle, Selenium (version 4.20.0), TestNG (version 7.9.0), Logback (version 1.4.14), OpenCSV (version 5.9).

Сreate new branch


💾 Use feature/new-branch

💾 Use git status to list all new or modified files that haven't yet been committed.

`                                                                         `Tasks
Development of Test Scenarios The primary objective was to formulate a comprehensive set of test scenarios encompassing key functionalities on the site. This spans user registration, data input, and validation processes.

Test Automation A test automation framework was crafted utilizing Selenium, Cucumber and TestNG. The suite covers a spectrum of basic and edge use cases to ensure robust testing.

Integration with Continuous Integration System (Jenkins) To ensure seamless execution of integration tests, integration with the continuous integration system (Jenkins) was established. This ensures automatic test runs with each code change.

Report Generation Detailed report generation was implemented post each test run to enhance result comprehension and facilitate problem identification.

Testing
📝 You can run tests in my project. For example:

Run tests with gradle test.

Project structure
✅ SmartyFlip

├── pages───────────────────────── tests
├── aboutUs                                                      ├── aboutUs
│        └── AboutUsPage.java                           │           └── AboutUsTests.java
├── footer                                                          ├── footer
│        └── FooterPage.java                               │           └── FooterTests.java
├── donate page                                                   ├── donate page  
│        └── DonatPage.java                                │           └── DonatePageTests.java
├── login                                                            ├── login
│        └── LoginPage.java                                │           └── LoginPositiveTests.java, LoginNegativeTests.java
├──   cabinet                                                       ├── cabinet
│           ├── CabinetPage.java                                         ├── CabinetPageTests.java
├── forgotPasswordPage                                    ├── forgotPasswordPage 
│        └── ForgotPasswordPage.java                 │           └── forgotPasswordTests.java
└── registration                                                   └── registration
└── RegistrationPage.java                                    ── RegisterPagePositiveTests.java
`                                                                                `└── RegisterPageNegativeTests.java
Experience in software testing, including web application testing.
🎨 Knowledge and experience in testing automated systems, particularly in the context of web technologies.

Automated Testing:
📈 Proficiency with automated testing tools such as Selenium, Appium, JUnit, etc. Ability to develop and maintain automated test scripts for web applications, covering functional, regression, and performance testing.

Understanding of Business Processes:
💼 In-depth understanding of the business processes of the auction site, including sales, purchases, lot management, and interaction with the platform.

Security Testing:
🔐 Knowledge of web application security testing methods, including vulnerability scanning, authentication, authorization, and data encryption.

Compatibility Testing:
⚔️ Experience in compatibility testing across various browsers, devices, and operating systems.

Performance Testing:
⚙️ Ability to conduct performance testing to ensure the stable operation of the website under high loads.

Reporting and Communication:
🤝 Proficient in detailed documentation of test results, identified defects, and suggestions for improvement. Effective collaboration with developers and other project stakeholders to address identified issues.

Analytical Skills:
: basecamp: Ability to analyze requirements and specifications to identify potential issues and risks.

Leadership:
:bowtie: Experience working as a testing team leader or as a team member, with the ability to organize and coordinate testing processes.

Adaptability and Continuous Learning:
:neckbeard: Willingness to learn new testing methodologies and technologies. Commitment to continuous improvement of skills and knowledge.

Problems and Challenges
Data Validation Instability Issues arose during testing, revealing that certain tests associated with data validation exhibit instability due to fluctuations in the interface.

Asynchronous Operations Challenge Tests linked to asynchronous operations, such as updating registration status, necessitate additional configurations for stable execution.

Expansion of Test Coverage While the existing suite covers a substantial portion of the functionality, there's a need to extend testing scenarios for comprehensive project coverage.

Test Summary

![testSummaryBig](https://github.com/VitalKo7/SmartyFlip_QA_POM/assets/151151151/80261f72-594f-4b0d-9c95-f746e981645a)

Jenkins test results

![testResult](https://github.com/VitalKo7/SmartyFlip_QA_POM/assets/151151151/5bbde947-7c78-4b14-89c9-078613ee9991)
