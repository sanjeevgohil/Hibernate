package com.example.hibernatecrud.com.example.hibernatecrud;

import com.example.hibernatecrud.com.example.hibernatecrud.StudentDAO;
import com.example.hibernatecrud.com.example.hibernatecrud.Student;

import java.util.Scanner;

public class App 
{
    public static void main( String[] args )
    {
    	 StudentDAO studentDAO = new StudentDAO();
         Scanner scanner = new Scanner(System.in);
         boolean exit = false;

         while (!exit) {
             System.out.println("Choose an option:");
             System.out.println("1. Add Student");
             System.out.println("2. View Students");
             System.out.println("3. Update Student");
             System.out.println("4. Delete Student");
             System.out.println("5. Exit");
             int choice = scanner.nextInt();

             switch (choice) {
                 case 1:
                     // Add Student
                     System.out.println("Enter First Name:");
                     String firstName = scanner.next();
                     System.out.println("Enter Last Name:");
                     String lastName = scanner.next();
                     System.out.println("Enter Email:");
                     String email = scanner.next();
                     Student newStudent = new Student(firstName, lastName, email);
                     studentDAO.saveStudent(newStudent);
                     System.out.println("Student added successfully!");
                     break;

                 case 2:
                     // View Students
                     System.out.println("Student List:");
                     for (Student student : studentDAO.getStudents()) {
                         System.out.println(student);
                     }
                     break;

                 case 3:
                     // Update Student
                     System.out.println("Enter Student ID to Update:");
                     int idToUpdate = scanner.nextInt();
                     Student studentToUpdate = studentDAO.getStudents().stream()
                         .filter(s -> s.getId() == idToUpdate)
                         .findFirst()
                         .orElse(null);

                     if (studentToUpdate != null) {
                         System.out.println("Enter New First Name:");
                         String newFirstName = scanner.next();
                         System.out.println("Enter New Last Name:");
                         String newLastName = scanner.next();
                         System.out.println("Enter New Email:");
                         String newEmail = scanner.next();

                         studentToUpdate.setFirstName(newFirstName);
                         studentToUpdate.setLastName(newLastName);
                         studentToUpdate.setEmail(newEmail);
                         studentDAO.updateStudent(studentToUpdate);

                         System.out.println("Student updated successfully!");
                     } else {
                         System.out.println("Student with ID " + idToUpdate + " not found.");
                     }
                     break;

                 case 4:
                     // Delete Student
                     System.out.println("Enter Student ID to Delete:");
                     int idToDelete = scanner.nextInt();
                     studentDAO.deleteStudent(idToDelete);
                     System.out.println("Student deleted successfully!");
                     break;

                 case 5:
                     // Exit
                     exit = true;
                     System.out.println("Exiting...");
                     break;

                 default:
                     System.out.println("Invalid choice! Please choose again.");
                     break;
             }
         }

         scanner.close();
    }
}
