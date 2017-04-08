package homeworks.lecture10;

/**
 * Created by Elena Y on 4/6/2017.
 *
 * Task:
 * Read all properties from a file, sort them.
 * Write sorted properties to a separate file line by line.
 * Omit comments, started with "#", and empty lines.
 * Use only InputStream and OutputStream classes
 *
 */

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SortProperties {

    private static final String PATH             = "D:\\Java\\SourceIT\\homeworks\\resources\\";
    private static final String INPUT_FILE_NAME  = "creditBureau.properties";
    private static final String OUTPUT_FILE_NAME = "creditBureau_sorted.properties";
    private static final char   NEW_LINE         = '\n';


    public static void main(String[] args) {
        InputStream inputStream = null;
        OutputStream outputStream = null;

        try {
            inputStream = new FileInputStream(new File(PATH + INPUT_FILE_NAME));
            List<String> list = readLinesFromFileToList(inputStream);
            Collections.sort(list);

            outputStream = new FileOutputStream(new File(PATH + OUTPUT_FILE_NAME));
            writeListToFile(list, outputStream);

        } catch (IOException e) {
             e.printStackTrace();
        } finally {
            closeIOStreams(inputStream, outputStream);
        }
    }

    private static List<String> readLinesFromFileToList(InputStream inputStream) throws IOException {
        List<String> list = new ArrayList<>();
        int    oneByte;
        String line = "";

        do {
            oneByte = inputStream.read();
            if ((char)oneByte == NEW_LINE || oneByte == -1) {
                if (!line.startsWith("#") && line.length() > 1) {
                    list.add(line);
                }
                line = "";
            } else {
                line += (char) oneByte;
            }
        } while (oneByte != -1);

        return list;
    }

    public static void writeListToFile(List<String> list, OutputStream outputStream) throws IOException {
        for (String line: list) {
            System.out.println(line);
            outputStream.write((line + NEW_LINE).getBytes());
        }
    }

    private static void closeIOStreams(InputStream inputStream, OutputStream outputStream) {
        if (inputStream != null) {
            try {
                inputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        if (outputStream != null) {
            try {
                outputStream.flush();
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                try {
                    outputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
