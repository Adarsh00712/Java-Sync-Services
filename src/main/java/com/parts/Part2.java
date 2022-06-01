package com.parts;

//We are importing respective classes from java.util.concurrent package for using classes while making their objects
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import com.csvtodatabase.CSVConsume;  //for importing the CSVConsume java class from csvtodatabase package

     public class Part2{
         public static void main(String[] args) {

             //  ScheduledExecutorService extends to ExecutorService that will run after given delay

             //We use newScheduledThreadPool() method of Executors class for Schedule command to run after 10 minutes

             ScheduledExecutorService scheduledExecutorService= Executors.newScheduledThreadPool(100);

             CSVConsume csvConsume =new CSVConsume(); //making object of CSVConsume class for using it here

             //scheduleAtFixedRate() method of timer class is used to schedule the given task again and again
             scheduledExecutorService.scheduleAtFixedRate((Runnable) csvConsume,0,2,TimeUnit.MINUTES);

             System.out.println("Our program will keep updating after every 10 minutes"); //message
         }
     }
