package oop;

/*
    In Java, lambda expressions are a way to write concise, functional-style code, primarily used to implement functional interfaces (interfaces with a single abstract method). 
 */

import java.util.*;

public class LambdaExpression {

    public static void main(String[] args) {

        Calculator add = (a, b) -> a + b;
        Calculator multiply = (a, b) -> a * b;
        System.out.println(add.calculate(5, 3));        // Output: 8
        System.out.println(multiply.calculate(5, 3));   // Output: 15
        //--------------------
         Calculator multiplyAndLog = (a, b) -> {
            System.out.println("Multiplying " + a + " and " + b);
            int result = a * b;
            System.out.println("Result: " + result);
            return result;  // Returns the product
        };

        // Using the lambda expression
        int product = multiplyAndLog.calculate(5, 3);
        System.out.println("Product: " + product);  // Output: 15

        //--------------------
        List<String> names = new ArrayList<>();
        names.add("ok");
        names.add("done");
        names.add("well");
        
        names.forEach(name -> System.out.print(name + " "));
        System.out.println("");
        names.stream().forEach(System.out::println);
        names.forEach((t) -> {
            System.out.println(t + " ");
            
        });
        System.out.println("");
    }
}

@FunctionalInterface
interface Calculator {

    int calculate(int x, int y);
}

/*
When to Use Lambda Expressions
When you need a quick, one-line implementation of a functional interface.
To write more readable and concise code, especially when passing behavior as a parameter.
To work efficiently with functional programming constructs in Java's Stream API and collection operations.

Benefits of Lambda Expressions
More concise and readable code.
Reduces boilerplate code, especially for anonymous inner classes.
Enables functional programming patterns, which are powerful for collections and Stream processing.
*/