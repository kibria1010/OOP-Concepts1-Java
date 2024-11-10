package oop;

import java.util.*;

// Comparable_to_define_how_a_class_is_to_be_sorted.
public class Comparable_isToDefine {

    public static void main(String[] args) {

        Employeee[] a = new Employeee[5];
        a[0] = new Employeee("Kirk", "Douglas");
        a[1] = new Employeee("Mel", "Brooks");
        a[2] = new Employeee("Jane", "Fonda");
        a[3] = new Employeee("Henry", "Fonda");
        a[4] = new Employeee("Michael", "Douglas");

        // The .sort() method uses the Comparable interface.
        Arrays.sort(a);

        // Print out the sorted Employees
        for (int i = 0; i < a.length; i++) {
            System.out.println(a[i]);
        }
    }
}

class Employeee implements Comparable<Employeee> {

    String firstName;
    String lastName;

    // Constructor sets firstName and lastName
    public Employeee(String first, String last) {
        this.firstName = first;
        this.lastName = last;
    }

    // User-friendly output when printed.
    public String toString() {
        return "( " + lastName + ", " + firstName + " )";
    }

    // Implement the Comparable interface
    @Override
    public int compareTo(Employeee value) {
        if (this.lastName.compareTo(value.lastName) != 0) {
            // If lastNames are different, compare lastName
            return this.lastName.compareTo(value.lastName);
        } else {
            // If lastNames are the same, compare firstName
            return this.firstName.compareTo(value.firstName);
        }
    }
}
