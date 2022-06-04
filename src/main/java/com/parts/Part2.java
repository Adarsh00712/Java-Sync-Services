package com.parts;

//We are importing respective classes from java.util.concurrent package for using classes while making their objects
import java.sql.*;
import java.io.*;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

class MyThreadRunnable implements Runnable {   //Using Runnable Interface
    public void run() {
                //Connecting with Database
                String jdbcUrl = "jdbc:mysql://localhost:3306/assignment";
                String username = "root";
                String password = "root";

                // filepath is variable to store file path of csv file
                String filepath = "C:\\Users\\adars\\OneDrive\\Desktop\\assignment sheet.CSV";

                int batchSize = 20; //batchSize sent to the database instead of individual queries

                //Creating the Connnection which is initially null
                Connection connection = null;

                try {
                    // Getting a connection to MYSQL by getting DriverManager
                    connection = DriverManager.getConnection(jdbcUrl, username, password);  //providing parameters
                    connection.setAutoCommit(false); //It will autocommit our SQL

                    //First we TRUNCATE the element of excisting datatable by creating statement
                    Statement stmt = connection.createStatement();
                    stmt.executeUpdate("TRUNCATE assignment_sheet");

                    //Providing the SQL query                                                                                                                                                 providing values from CSV file
                    String sql = "INSERT INTO assignment_sheet(timestamp,ver,product_family,country,device_type,os,checkout_failure_count,payment_api_failure_count,purchase_count,revenue) values(?,?,?,?,?,?,?,?,?,?) ";

                    //Giving the Prepared statement (its a interface to execute parameterised Query
                    PreparedStatement statement = connection.prepareStatement(sql); //providing SQL Query inside PreparedStatement

                    //BufferedReader for reading the file (from CSV file)
                    BufferedReader lineReader = new BufferedReader(new FileReader(filepath)); //Providing our file path to BufferedReader

                    //Declaring String linetext with null
                    String lineText = null;
                    int count = 0;      //Creating another variable and initialise with 0

                    lineReader.readLine();    //We Skiping the headline of the table column we only need data inside the CSV file

                    //Unless it null we going to read our data and store into our data array
                    while ((lineText = lineReader.readLine()) != null) {
                        String[] data = lineText.split(",");   //Creating String data for storing our data array

                        //storing data with their respective indexes
                        String timestamp = data[0];
                        String ver = data[1];
                        String product_family = data[2];
                        String country = data[3];
                        String device_type = data[4];
                        String os = data[5];
                        String checkout_failure_count = data[6];
                        String payment_api_failure_count = data[7];
                        String purchase_count = data[8];
                        String revenue = data[9];

                         /*he valueOf() method of the java,sql.Timestamp class accepts a String value representing a time stamp
                          in JDBC escape format and converts the givenString value into Timestamp */
                         Timestamp sqlTimestamp = Timestamp.valueOf(timestamp);

                        // to save the value we need to provide statement with the data from our array
                        statement.setTimestamp(1, sqlTimestamp);

                        statement.setString(2, ver);
                        statement.setString(3, product_family);
                        statement.setString(4, country);
                        statement.setString(5, device_type);
                        statement.setString(6, os);

                        //For DOuble format we use ParseDouble method
                        Double cfc = Double.parseDouble(checkout_failure_count);
                        statement.setDouble(7, cfc);

                        Double pafc = Double.parseDouble(payment_api_failure_count);
                        statement.setDouble(8, pafc);

                        Double pc = Double.parseDouble(purchase_count);
                        statement.setDouble(9, pc);

                        Double rev = Double.parseDouble(revenue);
                        statement.setDouble(10, rev);

                        statement.addBatch();

                        if (count % batchSize == 0) {
                            statement.executeBatch();   //we are executing our batch here
                        }
                    }

                    connection.commit();//commit() method of Connectionface interface will save all the modifications made since the last commit
                    lineReader.close();      //closing the lineReader
                    statement.executeBatch();

                    System.out.println("Data has been inserted successfully.");  //Message


                } catch (IOException ex) {    //Input/Output exception if input or output operation is failed or interpreted
                    System.err.println(ex);
                } catch (SQLException ex) {    //Provides information on database access error
                    ex.printStackTrace();
                }
                    if (connection != null) {
                        try {
                            connection.close();  //closing our Connection
                        } catch (SQLException e) {
                            throw new RuntimeException(e);
                        }

                    }
                }

            }
     public class Part2{
         public static void main(String[] args) {

     

             //  ScheduledExecutorService extends to ExecutorService that will run after given delay

             //We use newScheduledThreadPool() method of Executors class for Schedule command to run after 2 minutes

             ScheduledExecutorService scheduledExecutorService= Executors.newScheduledThreadPool(1);
             MyThreadRunnable myThreadRunnable =new MyThreadRunnable();


             //scheduleAtFixedRate() method of timer class is used to schedule the given task again and again
             scheduledExecutorService.scheduleAtFixedRate(myThreadRunnable,0,2,TimeUnit.Minutes);

             System.out.println("Our program will keep updating after every 2 Minutes"); //message
         }
     }

