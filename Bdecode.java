import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileInputStream;
import java.util.Arrays;
import java.util.Scanner;

public class Bdecode {

    public static byte[] readFile(String filename) {
        try {
        File file = new File(filename);
        byte[] data = new byte[(int) file.length()];
        FileInputStream inputStream = new FileInputStream(file);
        int bytesRead = inputStream.read(data);
        return data;
        } catch(Exception e) {
            e.printStackTrace();
        }
        return null;

    }
    public static void printPads() {
        for(int j = 0; j < indentation; ++j) {
            System.out.print(' ');
        }
        System.out.print(">");
    }




    public static byte[] data;
    public static int position = 0;
    public static int indentation = 0;


    public static String readString(int start, int end) {

    }
    public static String readString() {
    }

    public static long readLong(int start, int end) {
    }

    public static int findColonPosition(int position) {
    }
    public static int findEPosition(int position) {
    }
    public static int findCharPosition(int position, char character) {
    }

    public static void parseDict() {

    }

    public static void parseInt() {
    }
    public static void parseList() {
    }
    public static void parseString() {
    }

    public static void parse() {
    }

    public static void main(String args[]) {
        String filename = args[0];
        System.out.println("Filename: " + filename);
        data = readFile(filename);
        parse();

    }
}
