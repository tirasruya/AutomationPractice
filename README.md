# 🚀 AutomationPractice

![Java](https://img.shields.io/badge/Java-17-blue?logo=java&logoColor=white)
![Selenium](https://img.shields.io/badge/Selenium-WebDriver-green?logo=selenium&logoColor=white)
![Maven](https://img.shields.io/badge/Maven-Build-orange?logo=apachemaven&logoColor=white)
![License: MIT](https://img.shields.io/badge/License-MIT-yellow.svg)

## 🧪 Overview

This repository contains automated UI test scripts for **[AutomationExercise](https://automationexercise.com/)**, implemented in **Java + Selenium WebDriver**.  
The tests are based on the official [AutomationExercise Test Cases](https://automationexercise.com/test_cases) and aim to validate common e-commerce features such as user registration, login, product search, cart, and checkout flows.

The project is structured with **Page Object Model (POM)** for maintainability and scalability.

---

## 📋 Test Cases

Currently included / planned test scenarios:

✅ Test Case 1: Register User  
✅ Test Case 2: Login User with correct email and password
- 🔜 More cases will be added soon  

> 📌 Full reference: [AutomationExercise Test Cases](https://automationexercise.com/test_cases)

---

## 🧱 Tech Stack

- **Java 17**  
- **Selenium WebDriver**  
- **TestNG**  
- **Maven**  

---

## 📂 Project Structure

Here’s a suggested directory structure:

```
AutomationPractice/
│
├── src
│   └── main
│       └── java
│       │   └── pojo         #
│       │   |   └── User     #
│   └── test
│       └── java
│       │   └── testCases    #
│       │   |   └── TestCase1_RegisterUser
│       │   |   └── TestCase2_LoginUserWithCorrectEmailAndPassword
│       │   └── utility      # Helpers (driver manager, waits, etc.)
│       │   |   └── BaseDriver
│       │   |   └── JSONHelper
│       │   └── data         # Test data
│       └── resources        # Config files (e.g. properties)
│       │   └── testData
│       │   |   └── user1.json 
│
├── pom.xml                  # Maven dependencies
├── README.md
└── reports/                 # Reports & screenshots (after run)
```

---

## ⚙️ Setup & Installation

1. **Clone repository**

   ```bash
   git clone https://github.com/tirasruya/AutomationPractice.git
   cd AutomationPractice
   ```

2. **Install dependencies**

   ```bash
   mvn clean install
   ```

3. **Configuration**
   - Define `baseUrl`, browser type, and timeouts in `config.properties`
   - Ensure WebDriver binaries (e.g. `chromedriver`) are installed and in PATH

---

## ▶️ Running Tests

- **Run all tests**

  ```bash
  mvn test
  ```

- **Run specific test class**

  ```bash
  mvn -Dtest=LoginTests test
  ```

- **Generate reports**
  - Reports and screenshots are stored under the `reports/` folder  
  - If using Allure:  

    ```bash
    mvn allure:serve
    ```

---

## 📊 CI/CD Integration (Optional)

You can integrate this suite with **GitHub Actions**, **Jenkins**, or any CI/CD tool for continuous validation.  
Example: run `mvn test` on every pull request.

---

## 🤝 Contributing

Contributions are welcome! 🚀

1. Fork this repo  
2. Create a feature branch:  
   ```bash
   git checkout -b feature/new-test
   ```
3. Add your changes (tests, pages, utils)  
4. Commit and push:  
   ```bash
   git commit -m "Add test for XYZ functionality"
   git push origin feature/new-test
   ```
5. Open a Pull Request  

---

## 📄 License

This project is licensed under the [MIT License](LICENSE).  
You are free to use, modify, and distribute for educational and professional purposes.

---

✍️ Author: [@tirasruya](https://github.com/tirasruya)
