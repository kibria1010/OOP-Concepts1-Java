package oop;

import java.io.*;
import java.util.Arrays;



import java.io.*;

public class Array_Of_Object {

    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String name;
        int price;
        // -------------------------------- ArrayOfObject1D
        Book[] a1 = new Book[2];
        for (int i = 0; i < a1.length; i++) {
            name = in.readLine();
            price = Integer.parseInt(in.readLine());
            a1[i] = new Book(name, price);
        }
        for (Book book : a1) {
            System.out.println(book.name + " " + book.price);
        }
        
        
        // -------------------------------- ArrayOfObject2D
        Book[][] a2 = new Book[2][];
        for (int i = 0; i < a2.length; i++) {
            a2[i] = new Book[2];
            for (int j = 0; j < a2[i].length; j++) {
                name = in.readLine();
                price = Integer.parseInt(in.readLine());
                a2[i][j] = new Book(name, price);
            }
        }
        // print array 
        for (Book[] array : a2) {
            for (Book book : array) {
                System.out.println(book.name + " " + book.price);
            }
            System.out.println("");
        }
    }
}

class Book {

    String name;
    int price;

    public Book(String name, int price) {
        this.name = name;
        this.price = price;
    }
}












//----------------------------------------------primitive array
class A {
    
    public void inputArray1D(int[] a1) {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        
        System.out.println("input " + a1.length + " integers: ");
        for (int i = 0; i < a1.length; i++) {
            try {
                a1[i] = Integer.parseInt(in.readLine());
            } catch (Exception e) {
            }
        }
    }

    public static void printArray1D(int[] a1) {
        for (int instance : a1) {
            System.out.print(instance + " ");
        }
        
        System.out.println("");
    }

    public void inputArray2D(int[][] a2) {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        for (int i = 0; i < a2.length; i++) {
            for (int j = 0; j < a2.length; j++) {

                try {
                    a2[i][j] = Integer.parseInt(in.readLine());;

                } catch (Exception e) {
                }
            }
        }
    }

    public void printArray2d(int[][] a2) {
        for (int[] a1 : a2) {
            for (int instance : a1) {
                System.out.print(instance + " ");
            }
            System.out.println("");
        }
    }

}