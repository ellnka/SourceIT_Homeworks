package homeworks.lecture10;

import java.io.*;
import java.net.URL;
import java.util.zip.GZIPOutputStream;

/**
 * Created by Elena Y on 4/6/2017.
 *
 * Task:
 * Read content from google.com.
 * Write it to two files(txt and zip) in the same loop
 * If one of the files is broken by exception, delete it,
 * however the second file should be completed.
 *
 */
public class WriteGoogleToTxtAndZip
{
    private static final String PATH           = "D:\\Java\\SourceIT\\homeworks\\resources\\";
  //  private static final String WRONG_PATH     = "E:\\Java\\SourceIT\\homeworks\\resources\\";
    private static final String URL            = "https://google.com";
    private static final String TXT_FILE_NAME  = "google.txt";
    private static final String ZIP_FILE_NAME  = "google.zip";
    private static final int    BUFFER_SIZE    = 1024 * 2;

    public static void main(String[] args) {
        InputStream inputStream = null;
        File txtFile = new File(PATH + TXT_FILE_NAME);
        File zipFile = new File(PATH + ZIP_FILE_NAME);

        OutputStream txtOutputStream = null;
        OutputStream zipOutputStream = null;

        try {
            byte[] buffer = new byte[BUFFER_SIZE];
            int count;
            inputStream = new URL(URL).openStream();
            try {
                txtOutputStream = new FileOutputStream(txtFile);
            } catch (IOException e) {
                System.out.println("path to txt file is incorrect");
            }
            try {
                zipOutputStream = new GZIPOutputStream(new FileOutputStream(zipFile));
            }  catch (IOException e) {
                System.out.println("path to zip file is incorrect");
            }

            while ((count = inputStream.read(buffer)) != -1) {
                if (txtFile.exists()) {
                    writeByteArrayToFile(buffer, count, txtFile, txtOutputStream);
                }
                if (zipFile.exists()) {
                    writeByteArrayToFile(buffer, count, zipFile, zipOutputStream);
                }
            }

        } catch (IOException e) {
           e.printStackTrace();

        }
        finally {
            closeInputStream(inputStream);
            closeOutputStream(txtOutputStream);
            closeOutputStream(zipOutputStream);
        }
    }


    public static void writeByteArrayToFile(byte[] buffer, int count, File file, OutputStream outputStream) {
        try {
            outputStream.write(buffer, 0, count);
            //throw new IOException();
        } catch (IOException e) {
            if(file != null) {
                String fileName = file.getName();
                if (file.exists() && file.delete()) {
                    System.out.println("File " + fileName + " deleted!");
                }
            }
            closeOutputStream(outputStream);
        }
    }



    private static void closeInputStream(InputStream inputStream) {
        if (inputStream != null) {
            try {
                inputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private static void closeOutputStream(OutputStream outputStream) {
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
