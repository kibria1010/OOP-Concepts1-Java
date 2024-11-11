package oop;

import java.io.*;
import java.nio.file.*;
import java.util.*;

/**
 *
 * @author Md Golam Kibria
 */
public class File {

    public static void main(String[] args) {
        readingFromFile();
        writingToFile();
        readingFromFileUtil();
        appendToFileWithoutBuildingFunction();
        findSumAndShowFromAFile();
    }

    public static void readingFromFile() {
        try (BufferedReader reader = new BufferedReader(new FileReader("example.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
            reader.close();
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
    
    public static void writingToFile() {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Append to the file and write 'exit' to exit.");
        try (PrintWriter writer = new PrintWriter(new FileWriter("example.txt", true))) { // 'true' enables appending
            String line;
            while (!(line = in.readLine()).equals("exit")) {
                writer.println(line);
            }
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
    
    public static void appendToFileWithoutBuildingFunction() {
        BufferedReader reader = null;
        PrintWriter writer = null;
        List<String> lines = new ArrayList<>();
        
        try {
            reader = new BufferedReader(new FileReader("example.txt"));
            String line;
            while ((line = reader.readLine()) != null) {
                lines.add(line);
            }
            reader.close();
            
            writer = new PrintWriter(new FileWriter("example.txt"));
            for (String s : lines) {
                writer.println();
            }
            reader = new BufferedReader(new InputStreamReader(System.in));
            System.out.println("Append to the file and write 'exit' to exit.");
            while (!(line = reader.readLine()).equals("exit")) {
                writer.println(line);
            }
            reader.close();
            writer.close();
            
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
        
    }
    
    public static void readingFromFileUtil() {
        try {
            List<String> lines = Files.readAllLines(Paths.get("example.txt"));
            for (String line : lines) {
                System.out.println(line);
            }
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    private static void findSumAndShowFromAFile() {
        int sum=0;
        try (BufferedReader reader = new BufferedReader(new FileReader("input.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] sp = line.split(" ");
                for (String word : sp) {
                    sum += Integer.parseInt(word);
                }
            }
            reader.close();
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
        System.out.println("sum: " + sum);
    }
}
