package oop;

import java.util.*;
/**
 *
 * @author Md Golam Kibria
 */
public class Iterable_Iterator {
    public static void main(String[] args) {
        List<String> names = new ArrayList<>();
        names.add("Alice");
        names.add("Bob");

        // Using Iterable with enhanced for-loop
        for (String name : names) {
            System.out.println(name);
        }
        // Using Iterator 
        Iterator<String> iterator = names.iterator();
        while (iterator.hasNext()) {
            String name = iterator.next();
            System.out.println(name);
    
            // Removing elements while iterating
          if (name.equals("Alice")) {
              iterator.remove();
          }
        }
        System.out.println(names);
    }
}

/*
Iterable Interface:

    The Iterable interface represents a collection that can be iterated over.

    It’s part of the java.lang package and is a superinterface for all collection classes, like List, Set, etc.

    The Iterable interface contains only one abstract method:
        Iterator<T> iterator();
    This method returns an Iterator for the elements of the collection, 
    allowing it to be used with the enhanced for-each loop.
*/

/*
Iterator interface:
The Iterator interface is a way to access elements sequentially from a collection.

    It’s part of the java.util package and has three main methods:
        boolean hasNext();  // Returns true if there are more elements
        T next();           // Returns the next element
        void remove();      // Removes the last element returned by next()
    The Iterator is useful when you need to traverse a collection and possibly remove elements while iterating.
*/


/*
Key Differences:

-Iterable is a broader concept that represents anything that can be iterated, while Iterator is a tool for actually performing the iteration.
-Iterable allows the use of the enhanced for-each loop, making the code more readable and concise.
-Iterator provides more control over the iteration process, including the ability to remove elements while iterating.
*/