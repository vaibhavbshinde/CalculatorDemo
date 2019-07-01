# CalculatorDemo
CalculatorDemo
Demo Calculator automation framework

    This repo is used as the Calculator Demo automation framework using winium driver.

    Page Object Model design pattern has been used in this project.

Getting Started the framework

In order to get a copy of the project, clone the project from the respective git repository at your desired local path.

git clone https://github.com/vaibhavbshinde/CalculatorDemo.git

Prerequisites

This project should be running on local environments after fulfilling the following Prerequisites

1. JDK 7 or lastest JDK is installed in your machine. [JDK 7]
2. Latest version of maven. [maven] (https://maven.apache.org/download.cgi)
3. IDE of your choice. [Intellij] 

Note: maven pom.xml should take care of required version of the following:

1. Winium WebDriver
2. TestNG
3. Maven

Installing

    After having all Prerequisites then cloning the project, everything should work smoothly.
    Make sure to include unnecessary files to .gitignore file

How To Run (Using Maven Command)

from command line Use following command to run test:
mvn clean test -DcalcNum1=36 -DcalNum2=72 

Here calcNum1 and calNum2 are 2 parameters which used for Addition, Subtraction and Division. For square root "calcNum1" parameter is get used


How To Run (In IDE)

From IDE: Right click POM.xml file and run from Maven lifecyle "test" (i.e. maven test)
