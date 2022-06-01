
# Java Sync Service
***
## TASK
Create a Java service that syncs data from CSV to MySQL. It consists of two parts.

Part 1: You will be given a CSV file that should keep updating over the time. You have to right a Java program that adds few rows of data in the CSV File.

Part 2: You have to populate the MySQL table with the data present in CSV. Your service should run in every 2 mins and check for any new data in CSV.

## Skills
***
Java,DBMS on MYSQL,MS Office..

## Technologies
***
* [IntelliJ Idea Community Edition](https://www.jetbrains.com/idea/download/?fromIDE=#section=windows): Version 2022.1.1
* [JDK](https://download.oracle.com/java/18/latest/jdk-18_windows-x64_bin.msi): Version  18.0.1.1
* [MYSQL](https://dev.mysql.com/downloads/mysql/) Version 8.0.29
* [Github](https://github.com/) Version 5.10.3

## Installation
***


Steps to install Intellij IDEA plugin from IDE:

* Open the Settings dialog.

* In the left-hand pane, select Plugins.

* On the Plugins page that opens in the right-hand part of the dialog, click the Install MAVEN and Githuib Plugins.

### Creating a java Project
***
* File -> New Project.
* Choose 'Java'.
* Choose the project location and java sdk
* Finish

### Maven project using maven-plugin
***
* File -> New Project

* Choose Maven
* Choose the  java sdk then Enter project Name, location.
* Finish
### Dependecies
***
* Adding dependecies of mysql-connector and opencsv in POM.XML file

```bash
 <!-- https://mvnrepository.com/artifact/mysql/mysql-connector-java -->

        <dependency>
            <groupId>mysql</groupId>
            <artifactId>mysql-connector-java</artifactId>
            <version>8.0.29</version>

        </dependency>
                <dependency>
            <groupId>com.opencsv</groupId>
            <artifactId>opencsv</artifactId>
            <version>5.6</version>
        </dependency>
```
### Execution
***
* After Creating project named CSVtoDatabase and adding dependecies to POM.XML I have created a two java package which are csvtodatabase and parts.
* In csvtodatabase package I have created a java class named CSVConsume.java and Write a java code to Sync data from given CSV file to database and run the code Successfully.
* For part 1 I have created java class Part1.java in package named parts and Write code  that adds few rows of data in the CSV File and run the code by adding 3 rows data to CSV file Successfully.
* For part 2 I have created a java class Part2.java in package named parts and Write a code which run the service in every 2 minutes and check for new data.


### Support
***
For Support email adarshdwivedi2@gmail.com

### License
***
Apache License 2.0



