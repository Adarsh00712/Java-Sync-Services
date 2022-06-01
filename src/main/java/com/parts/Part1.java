package com.parts;
                                //We are importing respective classes from java.io package for using classes while making their objects
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;

import au.com.bytecode.opencsv.CSVWriter;  //importing opencsv from au.com.bytecode which is a  CSV parser library for using CSVWriter class
                                     //we already add opencsv to our project by way of pom.xml dependency

public class Part1 {

    public static void main(String[] args) throws Exception   //will declare the Exceptions that occur during the execution of a program
    {
        // filepath is a variable to store file path of csv file
        String filepath = "C:\\Users\\adars\\OneDrive\\Desktop\\Assignment Sheet.CSV";

        //BufferedReader class is used to read the text from character based input stream here it's a filepath
        BufferedReader lineReader = new BufferedReader(new FileReader(filepath));

        //Start data writing to filepath using FileWriter class in character form with a boolean to append the data writing
        CSVWriter writer =new CSVWriter(new FileWriter(filepath,true));

        //Creating a String data array which we want to send to CSV file and adding some rows
        String [] record1 ="2021-05-20 06:30:00,ECOM_200,sunglasses,Ukraine,Mobile,iOS,7564.452,5698.125,5485.245,5698.125".split(",");
        String [] record2 ="2019-06-12 09:30:00,ECOM_200,cloths,Russia,Mobile,iOS,5568.255,5698.369,7485.582,9698.596".split(",");
        String [] record3 ="2019-09-26 11:25:00,ECOM_200,shoes,India,Mobile,iOS,7564.452,5698.125,5485.245,5698.125".split(",");
        //inserting the records
        writer.writeNext(record1);
        writer.writeNext(record2);
        writer.writeNext(record3);


        writer.close(); //close mtehod to close the writer

        System.out.println("Record save successfully");  //message
    }

    }