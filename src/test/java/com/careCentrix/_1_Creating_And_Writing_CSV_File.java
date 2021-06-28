package com.careCentrix;
// Java program to illustrate
// for Writing Data in CSV file
import java.io.*;
import java.time.LocalDate;
import java.util.*;

import Utilities.ConfigurationReader;
import static Utilities.Methods.*;

import Utilities.Methods;
import com.github.javafaker.Faker;
import com.opencsv.CSVWriter;
import org.testng.annotations.Test;

public class _1_Creating_And_Writing_CSV_File {

    // file path never change out of the class
    // because of that declared private and final
    // code is reading CSV file's path and name from 'configuration.properties' file
    // in the future if it is needed to be change the file name and path
    // we will only make changes in one place in 'configuration.properties'

    private static final String CSV_FILE_PATH =
                    ConfigurationReader.getProperty("firstFile");



    public static void main(String[] args)
    {
        addDataToCSV(CSV_FILE_PATH);

        // message method is coming from 'Methods' class
        // where is located in Utilities package.

        message("File is created !!!!! ");



    }


    // this method is accepting 1 argument
    // this argument is holding the name and the path the csv file.

    public static void addDataToCSV(String output) {


        File file = new File(output);
        Scanner sc = new Scanner(System.in);

        try {
            // create FileWriter object using  'file' object as parameter
            FileWriter outputfile = new FileWriter(file);

            // create CSVWriter with '|' as separator
            CSVWriter writer = new CSVWriter(outputfile, '|',
                    CSVWriter.NO_QUOTE_CHARACTER,
                    CSVWriter.DEFAULT_ESCAPE_CHARACTER,
                    CSVWriter.DEFAULT_LINE_END);

            // variables   defined here
            int     id=0;
            String  firstName = "";
            String  lastName = "";
            String  gender = "";
            LocalDate dob;
            String  row ="";
            String  address="";


            // created a List which contains our row Data
            List<String[]> data = new ArrayList<String[]>();


            // created first row and stored into a first row of the ArrayList
            row = "ID" + "," + "Last Name" + "," +
                            "First Name "+ ","+"Gender" + "," + "Date of Birth" + "," + "address";



            String[] rowdata = row.split(",");
            data.add(rowdata);

            System.out.println("Enter no of rows");
            int noOfRow = Integer.parseInt(sc.nextLine());



            // here we are starting the generate random data
            // according to user input


            System.out.println(row); // first row appeared on the screen.

            for (int i = 1; i <= noOfRow; i++) {

                // this is the random data generator part
                Faker faker = new Faker();

                id = faker.number().numberBetween(1000,2000);

                firstName = faker.name().firstName();

                lastName = faker.name().lastName();


                // createRandomDate Method is coming from Methods Class which is
                //stored in Utiliies package

                dob = createRandomDate(1950,2010); // created sub-method

                address = faker.address().fullAddress();


                // random Gender can not work properly according to the Name
                // because faker class can not understand
                // which name is male's name which name is female's name
                if(Math.random() > 0.5)
                { gender  = "M"; } else {gender = "F";}


                row = id + "," + lastName + "," +
                        firstName +"," + gender + "," + dob + "," + address;
                rowdata = row.split(",");
                data.add(rowdata);
                System.out.println(row);
            }

            writer.writeAll(data);

            // closing writer connection
            writer.close();
        }
        catch (IOException e) {
            e.printStackTrace();
        }



    }





}