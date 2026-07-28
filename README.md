# 🏦 SecureBank Test Automation Framework

[![CI Pipeline](https://github.com/sergarciap-dev/securebank-test-framework/actions/workflows/ci.yml/badge.svg)](https://github.com/sergarciap-dev/securebank-test-framework/actions/workflows/ci.yml)

> Framework de automatización de pruebas funcional, API y seguridad para una aplicación bancaria.

![Java](https://img.shields.io/badge/Java-17-orange)
![Selenium](https://img.shields.io/badge/Selenium-4.18-green)
![Cucumber](https://img.shields.io/badge/Cucumber-7.15-brightgreen)
![REST Assured](https://img.shields.io/badge/REST_Assured-5.4-blue)
![Jenkins](https://img.shields.io/badge/Jenkins-Pipeline-red)
![Docker](https://img.shields.io/badge/Docker-Ready-2496ED)

## 🎯 Objetivo
Demostrar un framework enterprise-grade que cubre:
- ✅ **UI Testing** con Selenium + Cucumber (BDD en español)
- ✅ **API Testing** con REST Assured
- ✅ **Security Testing** (SQL Injection, XSS, headers)
- ✅ **CI/CD** con Jenkins + Docker
- ✅ **Reportes visuales** con Allure

## 🛠️ Stack Técnico
| Categoría | Herramientas |
|-----------|-------------|
| Lenguaje | Java 17 |
| UI Automation | Selenium WebDriver 4.18 |
| BDD | Cucumber 7.15 (Gherkin en español) |
| API Testing | REST ASSURED 5.4 |
| Build | Maven |
| CI/CD | Jenkins / GitHub Actions |
| Contenedores | Docker + Docker Compose |
| Reportes | Allure Reports, Cucumber HTML |
| Logging | Logback |

## 📂 Estructura
```
securebank-test-framework/
├── src/
│   ├── main/
│   │   ├── java/securebank/
│   │   │   ├── config/             → ConfigManager
│   │   │   ├── utils/              → DriverManager
│   │   │   └── pages/              → LoginPage, InventoryPage, BasePage
│   │   └── resources/
│   │       └── app/                → App mock (opcional)
│   └── test/
│       ├── java/securebank/
│       │   ├── hooks/              → Setup/Teardown (Hooks.java)
│       │   ├── runners/            → TestRunner.java
│       │   └── stepdefinitions/    → LoginSteps.java
│       └── resources/
│           ├── features/           → login.feature (Gherkin)
│           ├── config.properties   → Configuración
│           └── logback.xml         → Logging
├── .github/
│   └── workflows/
│       └── ci.yml                  → GitHub Actions CI/CD
├── docker-compose.yml              → Selenium Grid + PostgreSQL
├── Jenkinsfile                     → Pipeline alternativo
├── pom.xml                         → Dependencias Maven
├── README.md
└── .gitignore
```
## 🚀 Quick Start

### Prerrequisitos
- Java 17+
- Maven 3.9+
- Chrome/Firefox/Edge

### Clonar y ejecutar
```bash
git clone https://github.com/sergarciap-dev/securebank-test-framework.git
cd securebank-test-framework
mvn clean test
```

### Ejecutar por tag
```bash
mvn test -Dcucumber.filter.tags="@smoke"
mvn test -Dcucumber.filter.tags="@security"
mvn test -Dcucumber.filter.tags="@regression"
```

### Ver reportes
Abre `target/cucumber-reports/report.html` en tu navegador

## 👤 Autor
**Sergio García Puente**
- 🎓 Ingeniero en Informática - Duoc UC
- 🔍 Ex QA Tester & Automatizador - Accenture (Banco BCI)
- 🛡️ Diplomado en Ciberseguridad y Ciberdefensa
- 🔗 [LinkedIn](https://linkedin.com/in/sergio-garc%C3%ADa-puente)
- 📧 sergiogpuente88@gmail.com

