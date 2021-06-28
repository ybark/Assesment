package Utilities;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class sakla_3_ilk_version {


    public static void main(String[] args) {
        // creating List for storing all data from CSV file
        List<String> content = new ArrayList<>();
        content = readLogFile();
        List<String> group = new ArrayList<>();


        //System.out.println(Arrays.toString(group.toArray()));


        System.out.println(Arrays.toString(content.toArray()));
        System.out.println("content.size() = " + content.size());


        // asking the errorCode for checking
        Scanner sc = new Scanner(System.in);
        System.out.println("Which Error Message you want to check ");
        String errorType = sc.next();


        System.out.println("----------");
        System.out.println("Error Type is ==>" + errorType);


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
                for(int a=0; a< group.size(); a++) {
                    System.out.println(group.get(a));
                }
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
            for(int a=0; a< group.size(); a++) {
                System.out.println(group.get(a));
            }
            System.out.println("--------------");
            System.out.println("errorCount = " + errorCount);
            System.out.println("--------------");
        }

        System.out.println("Total " + errorType + " error occured " + totalCount
                + " times");


        // Message method is accepting 1 argument
        // this argument is holding the message text
        //String messageBody = " file  copied !!!! ";
        //message(messageBody);
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

}
