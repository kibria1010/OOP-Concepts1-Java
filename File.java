package oop;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

/**
 *
 * @author Md Golam Kibria
 */
public class File {

    public static void main(String[] args) {
        readingFromFile();
        readingFromFileUtil();
        writingToFile();
    }

    public static void readingFromFile() {
        try (BufferedReader reader = new BufferedReader(new FileReader("example.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
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
    
    public static void writingToFile() {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        try (PrintWriter writer = new PrintWriter(new FileWriter("example.txt", true))) { // 'true' enables appending
            String line;
            while (!(line = in.readLine()).equals("0")) {
                writer.println(line);
            }
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        } finally {
            
        }
    }
}
