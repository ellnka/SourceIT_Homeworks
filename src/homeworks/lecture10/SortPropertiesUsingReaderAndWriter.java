package homeworks.lecture10;

import com.sun.deploy.util.StringUtils;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Created by ElenaY on 10/04/2017.
 */
public class SortPropertiesUsingReaderAndWriter {
    private static final String PATH             = "D:\\js_projects\\java\\SourceIT_Homeworks\\resources\\";
    private static final String INPUT_FILE_NAME  = "creditBureau.properties";
    private static final String OUTPUT_FILE_NAME = "creditBureau_sorted.properties";

    public static void main(String[] args) {
        List<String> listOfLines = readListOfLines(PATH + INPUT_FILE_NAME);
        Collections.sort(listOfLines);
        writeListOfLines(PATH + OUTPUT_FILE_NAME, listOfLines);
    }

    public static List<String> readListOfLines(String pathToFile) {
        List<String> listOfLines = new ArrayList<>();
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(new File(pathToFile)));
            String line;
            try {
                while ((line = bufferedReader.readLine()) != null) {
                    if (line.length() > 1 && !line.startsWith("#")) {
                        listOfLines.add(line);
                    }
                }
            } finally {
                bufferedReader.close();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return listOfLines;
    }


    public static void writeListOfLines(String pathToFile, List<String> listOfLines) {
        try {
            PrintWriter printWriter = new PrintWriter(new File(pathToFile));
            try {
                for(String line: listOfLines) {
                    printWriter.println(line);
                }
            } finally {
                printWriter.close();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

}
