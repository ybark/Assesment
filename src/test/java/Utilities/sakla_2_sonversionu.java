package Utilities;

import com.opencsv.CSVWriter;

import static Utilities.Methods.*;

public class sakla_2_sonversionu {

    // CSV_FILE_PATH variable's value is coming from Configuration.properties file
    // this variable is holding the name of the variable and path of the variable
    private static final
    String CSV_FILE_PATH = ConfigurationReader.getProperty("secondFile");

    public static void main(String[] args) {

        //CreateCSV methos is accepting 1 argument
        // that argument is specifying what will be the CSV file's name
        // and where it will be created.
        CSVWriter writer = CreateCSV(CSV_FILE_PATH);



        // readData_WriteInSecondCSVFile metod is accepting 1 argument
        // this argument is related in which place output wi be stored.
        readData_WriteInSecondCSVFile(writer);


        String messageBody =" file  copied !!!! ";
        message(messageBody);






    }




}
