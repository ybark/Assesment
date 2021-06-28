package Utilities;

import com.opencsv.CSVWriter;
import org.testng.annotations.Test;

import java.io.File;
import java.io.FileWriter;

import static Utilities.Methods.message;
import static Utilities.Methods.readData_WriteInSecondCSVFile;

public class sakla_2 {
    private static final
    // String CSV_FILE_PATH = "./src/test/java/com/careCentrix/second.csv";
    String CSV_FILE_PATH = ConfigurationReader.getProperty("secondFile");

    public static void main(String[] args)
    {
        CreateCSV(CSV_FILE_PATH);
    }




    public  static void CreateCSV(String CSV_FILE_PATH){

        File file = new File(CSV_FILE_PATH);

        FileWriter outputfile = null;
        try {
            outputfile = new FileWriter(file);
        } catch (Exception e) {
            e.printStackTrace();
        }


        CSVWriter writer = new CSVWriter(outputfile, ',',
                CSVWriter.NO_QUOTE_CHARACTER,
                CSVWriter.DEFAULT_ESCAPE_CHARACTER,
                CSVWriter.DEFAULT_LINE_END);


        readData_WriteInSecondCSVFile(writer);


        String messageBody =" file  copied !!!! ";
        message(messageBody);






    }


//    public static void readData_WriteInSecondCSVFile(CSVWriter writer)   {
//        String firstFile = ConfigurationReader.getProperty("firstFile");
//
//        List<String[]> content = new ArrayList<>();
//
//        try(BufferedReader br = new BufferedReader(new FileReader(firstFile))) {
//            String line = "";
//            while ((line = br.readLine()) != null) {
//                content.add(line.split(","));
//                System.out.println(line);
//            }
//
//            writer.writeAll(content);
//            writer.close();
//
//        }
//        catch (Exception e) {
//            System.out.println("File could not read and written please check the code");
//        }
//
//        String messageBody =" file  copied !!!! ";
//        message(messageBody);
//
//    }

//
//
//    private static void message(String s){
//        JOptionPane.showMessageDialog(null, s);
//
//    }
}
