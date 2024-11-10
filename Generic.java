package oop;

/**
 * Generics refer to the ability to use a type as a parameter to methods and classes. 
 * This provides the ability to define a set of related classes or methods that can operate on many 
 * different types with a single declaration. 
 * This also allows type safety at compile-time allowing invalid types to be caught during compilation.

Note: Java type parameters can only be reference types, not primitive types (like int, double, or char).
 * @author Md Golam Kibria
 */

public class Generic {

    public static <T> void arrayPrint(T[] a) {
        for (T item : a) {
            System.out.print(item + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {

        Integer[] array1 = {0, 1, 2, 3};
        String[] array2 = {"Hello", "World"};
        arrayPrint(array1);
        arrayPrint(array2);

        Bucket<String> bucket1 = new Bucket<>();
        Bucket<Integer> bucket2 = new Bucket<>();

        bucket1.putInBucket("Hello World!");
        bucket2.putInBucket(12345);

        System.out.println(bucket1.fetchFromBucket());
        System.out.println(bucket2.fetchFromBucket());
        
        Bucket<Integer>[] bucket3 = (Bucket<Integer>[]) new Bucket[3];
        for (int i = 0; i < 3; i++) {
            bucket3[i] = new Bucket<>();
            bucket3[i].putInBucket(i);
        }
        for (Bucket<Integer> bucket : bucket3) {
            System.out.println(bucket.fetchFromBucket());
        }
        
    }
}

// Bucket.java
class Bucket<T> {

    private T item;

    public void putInBucket(T item) {
        this.item = item;
    }

    public T fetchFromBucket() {
        return item;
    }
}

///
class K<T> {
    T name;

    public K(T name) {
        this.name = name;
    }
    
    static class I<T1> {
        int data;
        I<T1> next;
    }
    
    public static <T> void arrayPrint(T[] a) {
        for (T item : a) {
            System.out.print(item + " ");
        }
        System.out.println();
    }
    
}