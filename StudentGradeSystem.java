//Studet Grade System Version 01

import java.util.ArrayList;
import java.util.Scanner;

public class StudentGradeSystem {

    public static void main(String[] args) {

        ArrayList<Student> students = new ArrayList<>();
        Scanner sc = new Scanner(System.in);

        int choice = 0;

        while (choice != 5) {

            System.out.println("\n== Student Grade Management System ==");
            System.out.println("1. Add Student");
            System.out.println("2. Display All Students");
            System.out.println("3. Search Student by ID");
            System.out.println("4. Calculate Average Marks");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");

            choice = sc.nextInt();
            sc.nextLine();

            if (choice == 1) {

                System.out.print("Enter Student ID: ");
                String id = sc.nextLine();

                System.out.print("Enter Student Name: ");
                String name = sc.nextLine();

                System.out.print("Enter Marks: ");
                double marks = sc.nextDouble();

                Student student = new Student(id, name, marks);
                students.add(student);

                System.out.println("Student added successfully!");

            } else if (choice == 2) {

                if (students.isEmpty()) {
                    System.out.println("No students found.");
                } else {
                    for (Student s : students) {
                        System.out.println(s);
                    }
                }

            } else if (choice == 3) {

                System.out.print("Enter Student ID: ");
                String searchId = sc.nextLine();

                boolean found = false;

                for (Student s : students) {
                    if (s.getStudentId().equals(searchId)) {
                        System.out.println("Student Found:");
                        System.out.println(s);
                        found = true;
                    }
                }

                if (!found) {
                    System.out.println("Student not found.");
                }

            } else if (choice == 4) {

                if (students.isEmpty()) {
                    System.out.println("No students available.");
                } else {

                    double total = 0;

                    for (Student s : students) {
                        total += s.getMarks();
                    }

                    double average = total / students.size();

                    System.out.println("Average Marks: " + average);
                }

            } else if (choice == 5) {

                System.out.println("Thank you!");

            } else {

                System.out.println("Invalid choice!");
            }
        }

        sc.close();
    }
}