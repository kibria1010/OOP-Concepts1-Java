package oop;

import java.io.*;

public class ExceptionHandling {
    
    // Throws IOException if the file cannot be read
    public static void readFile(String fileName) throws IOException {
        FileReader fileReader = new FileReader(fileName);
        BufferedReader in = new BufferedReader(fileReader);

        String line;
        while ((line = in.readLine()) != null) {
            System.out.println(line);
        }

        in.close();
    }
    
    public static void checkAge(int age) {
        if (age < 18) {
            throw new IllegalArgumentException("Age must be 18 or older.");
        }
    }
    
    public static void main(String[] args) {
        try {
            readFile("example.txt");
        } catch (IOException e) {
            System.out.println("File not found or could not be read.");
        } finally {
            System.out.println("Closing file operations.");
        }
        
        try {
            checkAge(15);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        
        try {
            CheckAge(15);
        } catch (InvalidAgeException e) {
            System.out.println(e.getMessage());
        }
    }
    
    public static void CheckAge(int age) throws InvalidAgeException {
        if (age < 18) {
            throw new InvalidAgeException("Age must be 18 or older.");
        }
    }
}


class InvalidAgeException extends Exception {
    public InvalidAgeException(String message) {
        super(message);
    }
}


/**
 * In Java, an exception is an event that disrupts the normal flow of a program
 * during runtime. Exceptions are used to handle errors and unexpected
 * situations in a controlled manner, allowing the program to respond to
 * problems instead of crashing. Java provides a robust exception-handling
 * mechanism through the use of try, catch, throw, throws, and finally keywords,
 * enabling developers to manage errors gracefully.
 *
 * Types of Exceptions Exceptions in Java are divided into three main
 * categories:
 *
 * Checked Exceptions:
 *
 * Checked at compile-time and must be either caught or declared in the method
 * using throws. These exceptions typically represent issues that the program
 * can reasonably expect, like file access errors, network errors, etc. Examples
 * include IOException, SQLException, and FileNotFoundException. Unchecked
 * Exceptions (Runtime Exceptions):
 *
 * Occur at runtime and are not checked by the compiler, so the programmer
 * doesn’t have to handle them explicitly. These exceptions often occur due to
 * programming errors, such as incorrect casting, accessing an out-of-bounds
 * array index, etc. Examples include NullPointerException,
 * ArrayIndexOutOfBoundsException, and ArithmeticException. Errors:
 *
 * Represent severe issues outside the program’s control, usually related to the
 * system or JVM, and are not intended to be caught or handled.
 *
Throwable
├── Exception
│   ├── IOException       (checked exception)
│   ├── SQLException      (checked exception)
│   └── RuntimeException  (unchecked exception)
│       ├── NullPointerException
│       ├── ArithmeticException
│       └── ArrayIndexOutOfBoundsException
└── Error
    ├── OutOfMemoryError
    └── StackOverflowError

 */

    /**
     * try and catch The try block contains code that might throw an exception,
     * and the catch block catches and handles the exception. If an exception
     * occurs in the try block, control is transferred to the appropriate catch
     * block.
     * 
     * The finally block contains code that is always executed, regardless of whether an exception was thrown or not. 
     * It’s often used to release resources like files or database connections.
     * 
     * throw: Used to explicitly throw an exception in the program. 
     * The throw keyword is followed by an instance of Throwable, usually created using new.
     * 
     * throws: Used in method signatures to declare that a method might throw an exception. 
     * It’s commonly used with checked exceptions.
     */