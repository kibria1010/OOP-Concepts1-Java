package oop;

/**
 * The Comparator interface is used to order objects of an arbitrary class. 
 * It is not to be confused with the Comparable interface, 
 * which is implemented by the class to be sorted. 
 * The Comparator interface is implemented in a separate class.
 */

import java.util.*;

public class Comparator_isUsedTo {

    public static void main(String[] args) {
        Employe a[] = new Employe[5];
        a[0] = new Employe("Kirk", "Douglas");
        a[1] = new Employe("Mel", "Brooks");
        a[2] = new Employe("Jane", "Fonda");
        a[3] = new Employe("Henry", "Fonda");
        a[4] = new Employe("Michael", "Douglas");

        // Use .sort() method with Comparable class.
        Arrays.sort(a, new EmployeSort());

        // Print out the sorted Employees
        for (int i = 0; i < a.length; i++) {
            System.out.println(a[i]);
        }
    }
}

// EmployeeSort.java
class EmployeSort implements Comparator<Employe> {

    // Implement the Comparator interface
    @Override
    public int compare(Employe valueA, Employe valueB) {
        if (valueA.lastName.compareTo(valueB.lastName) != 0) {
            // If lastNames are different, compare lastName
            return valueA.lastName.compareTo(valueB.lastName);
        } else {
            // If lastNames are the same, compare firstName
            return valueA.firstName.compareTo(valueB.firstName);
        }
    }
}


class Employe {

    String firstName;
    String lastName;

    // Constructor sets firstName and lastName
    public Employe(String first, String last) {
        this.firstName = first;
        this.lastName = last;
    }

    // User-friendly output when printed.
    public String toString() {
        return "( " + lastName + ", " + firstName + " )";
    }
}
