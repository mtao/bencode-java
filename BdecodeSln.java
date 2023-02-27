import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileInputStream;
import java.util.Arrays;
import java.util.Scanner;

public class BdecodeSln {

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
    public static byte[] data;
    public static int position = 0;
    public static int indentation = 0;


    public static void printPads() {
        for(int j = 0; j < indentation; ++j) {
            System.out.print("    ");
        }
        System.out.print(">");
    }
    public static String readString(int start, int end) {
        return new String( Arrays.copyOfRange(data,start,end));

    }
    public static String readString() {

        int colonPos = findColonPosition(position+1);
        int length = (int) readLong(position,colonPos);

        int start = colonPos + 1;
        int end = colonPos + 1 + length;
        String str = readString(start,end);

        position = end;

        return str;
    }

    public static long readLong(int start, int end) {
        String str = readString(start,end);
        return Long.parseLong(str);
    }

    public static int findColonPosition(int position) {
        return findCharPosition(position,':');
    }
    public static int findEPosition(int position) {
        return findCharPosition(position,'e');
    }
    public static int findCharPosition(int position, char character) {
        int j;
        for(j = position; j < data.length; ++j) {
            if( data[j] == character ) {
                break;
            }
        }
        return j;
    }

    public static void parseDict() {
        position += 1;

        while(data[position] != 'e') {
            String key = readString();
            printPads();
            System.out.println(key + ":");
            indentation = indentation + 1;
            parse();
            indentation-=1;
        }

    }

    public static void parseInt() {
        position = position + 1;
        int end = findEPosition(position);
        long value = readLong(position,end);
        printPads();
        System.out.println("Int: " + value);
        position = end+1;
    }
    public static void parseList() {
        position += 1;
        indentation+=1;
        while(data[position] != 'e') {

            parse();
        }
            indentation-=1;
        position += 1;
    }
    public static void parseString() {
        String str = readString();
        printPads();
        System.out.println("String: " + str);



    }
    public static void parse() {
        byte value = data[position];
        switch(value) {
            case 'd':
                parseDict();
                break;
            case 'i':
                parseInt();
                break;
            case 'l':
                parseList();
                break;
            default:
                parseString();

        }
    }

    public static void main(String args[]) {
        String filename = args[0];
        System.out.println("Filename: " + filename);
        data = readFile(filename);
        position = 0;
        parse();

    }
}
