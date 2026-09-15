/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.prog5121poe;

public class Prog5121Poe {

    public static void main(String[] args) {
        java.util.Scanner input = new java.util.Scanner(System.in);
        
        // Initializing placeholder data outside the loop so it persists!
        Registration myReg = new Registration("default", "default", "default", "default", "+27000000000");
        Login myLoginSystem = new Login(myReg);
        
        boolean running = true;

        while (running) {
            System.out.println("\n--- WELCOME SYSTEM ---");
            System.out.println("1. Register a new account");
            System.out.println("2. Login to existing account");
            System.out.println("3. Exit");
            System.out.print("Choose an option (1, 2, or 3): ");
            int choice = input.nextInt();
            input.nextLine(); // Clear the buffer line

            if (choice == 1) {
                System.out.println("\n--- REGISTRATION ---");
                System.out.print("Enter First Name: ");
                String fName = input.nextLine();
                
                System.out.print("Enter Last Name: ");
                String lName = input.nextLine();
                
                System.out.print("Enter Username: ");
                String uName = input.nextLine();
                
                System.out.print("Enter Password: ");
                String pWord = input.nextLine();
                
                System.out.print("Enter Cellphone Number: ");
                String cell = input.nextLine();

                // Override with user input
                myReg = new Registration(fName, lName, uName, pWord, cell);
                myLoginSystem = new Login(myReg);
                
                // Execute validation checks and show result
                String regStatus = myReg.registerUser();
                System.out.println("\n" + regStatus);
                
            } else if (choice == 2) {
                System.out.println("\n--- LOGIN ---");
                System.out.print("Enter Username: ");
                String user = input.nextLine();
                
                System.out.print("Enter Password: ");
                String pass = input.nextLine();

                // Check if credentials match
                boolean success = myLoginSystem.loginUser(user, pass);
                System.out.println("Login Successful Status: " + success);
                
                // Fetch and display the exact text required by the rubric
                String statusMessage = myLoginSystem.returnLoginStatus(success);
                System.out.println("System Notification: " + statusMessage);
                
            } else if (choice == 3) {
                System.out.println("Exiting application...");
                running = false;
            } else {
                System.out.println("Invalid option selected.");
            }
        }
    }
}
