package Utilities;
// Java program to illustrate
// for Writing Data in CSV file

import com.github.javafaker.Faker;
import com.opencsv.CSVWriter;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static Utilities.Methods.createRandomDate;
import static Utilities.Methods.message;

public class sakla1 {


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



    public static void addDataToCSV(String output) {


        File file = new File(output);
        Scanner sc = new Scanner(System.in);

        try {
            // create FileWriter object using  'file' object as parameter
            FileWriter outputfile = new FileWriter(file);

            // create CSVWriter with ',' as separator
            CSVWriter writer = new CSVWriter(outputfile, ',',
                    CSVWriter.NO_QUOTE_CHARACTER,
                    CSVWriter.DEFAULT_ESCAPE_CHARACTER,
                    CSVWriter.DEFAULT_LINE_END);

            // variables   defined here
            int id=0;
            String firstName = "";
            String lastName = "";
            String gender = "";
            LocalDate date;
            String row ="";


            // created a List which contains our row Data
            List<String[]> data = new ArrayList<String[]>();


            // created first row and stored into a first row of the ArrayList
            row = "ID" + "," + "Last Name" + "," +
                    "First Name "+ ","+"Gender" + "," + "Date";



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

                date = createRandomDate(1950,2010); // created sub-method


                // random Gender can not work properly according to the Name
                // because faker class can not understand
                // which name is male's name which name is female's name
                if(Math.random() > 0.5)
                { gender  = "M"; } else {gender = "F";}


                row = id + "," + lastName + "," +
                        firstName +"," + gender + "," + date;
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




    // This method is creating random date with the year-month-date format //

//    public static LocalDate createRandomDate(int startYear, int endYear) {
//
//
//    // createRandomIntBetween method is also stored in Methods class
//
//        int year = createRandomIntBetween(startYear, endYear);
//        int month = createRandomIntBetween(1, 12);
//        int day = createRandomIntBetween(1, 30);
//        if(month==2 && day>=29){
//            day=28;
//        }
//
//        return LocalDate.of(year, month, day);
//    }



    // This method is creating random number between 2 integer parameters ///


//    public static int createRandomIntBetween(int start, int end) {
//        return start + (int) Math.round(Math.random() * (end - start));
//    }

}