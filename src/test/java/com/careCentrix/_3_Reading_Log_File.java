package com.careCentrix;

import Utilities.ConfigurationReader;
import com.opencsv.CSVWriter;
import org.testng.annotations.Test;


import java.io.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import static Utilities.Methods.*;

public class _3_Reading_Log_File {


    public static void main(String[] args) {
        // creating List for storing all data from CSV file
        List<String> content = new ArrayList<>();
        content = readLogFile();
        List<String> group = new ArrayList<>();

        String allErrorsNumber = "200 201 202 204 300 400 401 403 404 405 500 501 502 503";
        String errorType ="";
        Boolean errorEntry = true;


        while (errorEntry) {
            // asking the errorCode for checking
            Scanner sc = new Scanner(System.in);
            System.out.println("Which Error Message you want to check  < <Q> for exit>");
            errorType = sc.next();
            if (errorType.equalsIgnoreCase("Q")) {
                System.exit(0);
            }
            if (errorType.length()==3 && allErrorsNumber.contains(errorType)) {

                errorEntry= false;

            } else
            System.out.println("invalid entry please try again ");

        }





        System.out.println("----------");
        System.out.println("Error  Type you want to check is " + errorType);

        String errorDefinition = ConfigurationReader.getProperty(errorType);


        System.out.println("Error Definition is ==> " + errorDefinition);
        System.out.println();
        System.out.println("----------");



        int innerCount = 0;
        int errorCount = 0;
        int totalCount = 0;

        for (int i = 0; i < content.size(); i++) {
            if (content.get(i).contains(errorType)) {
                group.add(content.get(i));
                errorCount++;
                innerCount++;
                totalCount++;


            } else {innerCount = 0;}

            if (innerCount == 0 && errorCount >= 5 ) {
                readErrorArrayList(group);
//                for(int a=0; a< group.size(); a++) {
//                    System.out.println(group.get(a));
//                }
                System.out.println("--------------");
                System.out.println("errorCount = " + errorCount);
                System.out.println("--------------");
                group.clear();
                errorCount = 0;

            } else

            if (innerCount == 0 && errorCount < 5 ){

                group.clear();
                errorCount = 0;
            }


        }

        if (group.size()>=5){
            readErrorArrayList(group);

            System.out.println("--------------");
            System.out.println("errorCount = " + errorCount);
            System.out.println("--------------");
        }

            System.out.println("total number of occurrences of <" + errorType + " " +
                    errorDefinition + "> in the log file is ==> " + totalCount
                    + " times");

        }

        public static void writeError ( int groupCount, int loopCount,
        List<String> content  ){

            System.out.println("Related Error records are ");
            System.out.println("--------------------------");
            for (int a = (loopCount - groupCount); a < loopCount; a++) {
                System.out.println(content.get(a));
            }
        }


        public static List<String> readLogFile () {

            // first file's name which will be read,
            // and its path is coming from configuration.property file
            String firstFile = ConfigurationReader.getProperty("logFile");

            List<String> content = new ArrayList<>();

            try (BufferedReader br = new BufferedReader(new FileReader(firstFile))) {
                String line = "";
                while ((line = br.readLine()) != null) {
                    content.add(line);
//                System.out.println(line);
                }

            } catch (Exception e) {
                System.out.println
                        ("File could not read and written please check the path");
            }
            return content;
        }

        public static void readErrorArrayList( List<String> group) {
            for (String error:group) {
                System.out.println(error);

            }

        }


    }





