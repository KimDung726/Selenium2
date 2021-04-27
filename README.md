[![author][author-shield]][author-url]
[![selenium2][selenium2-shield]][selenium2-url]
[![ratting][ratting-shield]][ratting-url]

<!-- PROJECT LOGO -->
<br />
<p align="center">
  <a href="https://github.com/KimDung726/Selenium2">
    <img src="doc/image/logo.png" alt="Logo" width="120" height="120">
  </a>

<h3 align="center">Test Automation Framework</h3>

  <p align="center">
    This is an example of using Selenium test framework.
    <br />
    <a href="https://github.com/KimDung726/Selenium2">🖼 View Demo</a>
    ·
    <a href="https://github.com/KimDung726/Selenium2">📊 Report Bug</a>
    ·
    <a href="https://github.com/KimDung726/Selenium2">🛂 Request Feature</a>
  </p>

<!-- TABLE OF CONTENTS -->

## Table of Contents

1. [About The Project](#about-the-project)
    * [Built With](#built-with)
2. [Getting Started](#getting-started)
    * [Prerequisites](#prerequisites)
    * [Set up environment](#set-up-environment)
        - [Install Java 8](#install-java-8)
        - [Install dependencies](#install-dependencies)
3. [Usage](#usage)
4. [Contact](#contact)
5. [Helpful Docs](#helpful-docs)

<!-- ABOUT THE PROJECT -->

## About The Project

[![Website need testing][product-screenshot]](http://www.railway.somee.com/Page/HomePage.cshtml)

🌏 A Maven framework in which to build Selenium tests written in Java with Allure reports of test results.

📸 Take Screenshots: 
On test failures screenshots will automatically be taken. The screenshot files will be named with a combination of the class name and the test method name.

📟 Parallel Test Execution: 
The Project is preconfigured to run the tests in parallel. The number of test that will be executed at the same time is configurable (defaults to 4) or can be deactivated if required.

📊 Allure Test Result Report
Allure provides a good representation of test execution output and is designed to create reports that are clear to everyone by creating graphs regarding test execution time, overall test result overviews, test result history, etc.

### Built With

* [Java](https://en.wikipedia.org/wiki/Java_(programming_language)) - Language
* [TestNG](https://github.com/cbeust/testng) - Testing framework
* [Selenium](https://github.com/SeleniumHQ/selenium) - Automation framework
* [Allure](https://github.com/allure-framework) - Reporting framework
* [Maven](https://maven.apache.org/) - Dependency management
* [WebDriverManager](https://github.com/bonigarcia/webdrivermanager) - Local driver binary management

<!-- GETTING STARTED -->

## Getting Started

📖 This is an example of how you may give instructions on setting up your project locally. To get a local copy up and
running follow these simple example steps.


### Prerequisites

* [OS](https://www.microsoft.com/en-us/software-download/windows10) : Windows, recommended Windows 10
* [Browsers](https://www.jetbrains.com/idea/download/#section=windows) : Chrome latest or older, Firefox 46.0.1 or older


### Set up environment

1. Install Java 8

2. Install dependencies
- CD to the project folder
- Open CMD/terminal then type :

   ```bash
   mvnw install
   ```

<!-- USAGE -->

## Usage

🖥 Copy the repo into your local machine : 

   ```bash
   git clone https://github.com/KimDung726/Selenium2
   ```

### Run the test

1. Run test script on IntelliJ

- Under Railway project, go to 'src/test/resources'
- Select the test suite file (runFullRegression.xml for example), right click on this file, select Run.

2. Run test script via Maven

- CD to the project folder
- Open CMD/terminal then type :

   ```bash
   mvnw clean test
   ```
  📍 It will run the default file: `runFullRegression.xml`. 
  
  📍 If you want to run another file, add the param: `-DxmlFile=NameFile.xml`
  
### Generate report

- CD to the project folder
- Open CMD/terminal then type :

   ```bash
   allure serve allure-results
   ```

🗂 The test result locates in the allure-results folder

<!-- CONTACT -->

## Contact

📱 Created by [Dang Thi Kim Dung](kimdung726@gmail.com) - feel free to contact me!

<!-- HELPFUL DOCS -->

## Helpful Docs

📑 [Xpath Cheatsheet](https://devhints.io/xpath)

📑 [Selenium: Locating Elements](https://selenium-python.readthedocs.io/locating-elements.html)

📑 [Selenium: Waits](https://selenium-python.readthedocs.io/waits.html)

[author-shield]: https://img.shields.io/badge/Author-Dung-blue

[author-url]: https://github.com/KimDung726

[ratting-shield]: https://img.shields.io/redmine/plugin/stars/redmine_xlsx_format_issue_exporter?color=orange

[ratting-url]: https://github.com/KimDung726

[selenium2-shield]: https://img.shields.io/badge/Selenium2-PASS-brightgreen

[selenium2-url]: https://github.com/KimDung726/Selenium2/graphs/stargazers

[product-screenshot]: doc/image/screenshot.png