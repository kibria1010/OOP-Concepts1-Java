package oop;

/**
 *
 * @author Md Golam Kibria
 */
public class Nested_Classes {

    public static void main(String[] args) {

        //-------------Creating object of Inner Class
        OuterClass outer = new OuterClass();
        OuterClass.InnerClass inner = outer.new InnerClass();
        inner.display();  // Output: Accessing from inner class: Outer field
        
        //-------------Creating object of Nested Class
        OuterClass.StaticNestedClass nested = new OuterClass.StaticNestedClass();
        nested.display();  // Output: Accessing from static nested class: Outer static field
        
        //-------------Calling Method Inner Class
        outer.methodWithInnerClass();
        
        //-------------Creating an anonymous inner class that implements Runnable
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                System.out.println("Running in an anonymous inner class.");
            }
        };

        //-----
        Thread thread = new Thread(runnable);
        thread.start();  // Output: Running in an anonymous inner class.
        //-----
        CustomRunnable r = new CustomRunnable() {
            @Override
            public void run() {
                System.out.println("Running in an anonymous inner class.");
            }
        };
        r.run();
        ////
        Th t = new Th() {
            @Override
            public void run() {
                System.out.println("Running in an anonymous inner class.");
            }
        };
        t.run();

    }
}

class OuterClass {

    private String name = "Outer field";
    private String outer = "Outer field";

    // Non-static Inner Class
    public class InnerClass {

        private String name = "Inner field";

        public void display() {
            System.out.println("Accessing from inner class: " + outer);
            System.out.println("Local var first if name conflict: " + name);
            System.out.println("Accessing from inner class: " + OuterClass.this.name);
            System.out.println("-----");
        }
    }

    private static String outerStaticField = "Outer static field";

    // Static Nested Class
    public static class StaticNestedClass {

        public void display() {
            System.out.println("Accessing from static nested class: " + outerStaticField);
            System.out.println("-----");
        }
    }

    public void methodWithInnerClass() {
        final int localVar = 10;

        // Local Inner Class
        class LocalInnerClass {

            public void display() {
                System.out.println("Accessing from local inner class: " + localVar);
                System.out.println("-----");
            }
        }

        LocalInnerClass localInner = new LocalInnerClass();
        localInner.display();  // Output: Accessing from local inner class: 10
    }
}

//------------------------
interface CustomRunnable {

    public void run();
}

abstract class Th {

    abstract public void run();
}

/*
A regular inner class is an instance-level class declared within another class. 
It has access to all members of the outer class, including private fields and methods.
To create an instance of a non-static inner class, you must first create an instance of the outer class.
-
A static nested class is like a static member of the outer class. 
Unlike non-static inner classes, static nested classes cannot directly access instance members of the outer class. They can only access static members of the outer class. Static nested classes are used when the inner class does not need access to the outer class’s instance members.
-
A local inner class is defined within a method, constructor, or block and is only accessible within that scope. 
Local inner classes can access local variables, but only if those variables are declared final or are effectively final (not modified after initialization). 
They are primarily used for specific operations within a particular method.
-
An anonymous inner class is an inner class without a name. 
It is used to provide an immediate implementation of an interface or an abstract class. 
Anonymous inner classes are often used in event handling or to provide short-lived implementations of interfaces.
 */
