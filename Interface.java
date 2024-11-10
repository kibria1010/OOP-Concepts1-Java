package oop;

/**
 * An interface in Java is a blueprint of a behavior. 
 * A Java interface contains static constants and abstract methods.
 */

public class Interface {
    public static void main(String[] args) {
        Duck duck = new Duck();
        duck.fly();   // Output: Duck flies.
        duck.swim();  // Output: Duck swims.
        
        Dog2 dog = new Dog2();
        dog.eat();      // Output: Dog eats bones.
        dog.sleep();    // Output: This animal sleeps. (default method)
        Animal2.info();  // Output: Animals have various behaviors. (static method)
    }
}

interface Flyable {
    void fly();
}

interface Swimmable {
    void swim();
}

class Duck implements Flyable, Swimmable {
    public void fly() {
        System.out.println("Duck flies.");
    }

    public void swim() {
        System.out.println("Duck swims.");
    }
}

interface Animal2 {
    String x = "var is static and final by default"; //
    // Abstract method (no body)
    void eat();

    // Default method (provides a default implementation)
    default void sleep() {
        System.out.println("This animal sleeps.");
    }

    // Static method
    static void info() {
        System.out.println("Animals have various behaviors.");
    }
}

class Dog2 implements Animal2 {
    // Providing implementation for the eat method
    public void eat() {
        System.out.println("Dog eats bones.");
        System.out.println(x);
    }
}

