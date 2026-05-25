/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.registration1;

import java.util.Scanner;

/**
 *
 * @author Student
 */
import java.util.Scanner;

public class Registration1 {

    public static void main(String[] args) {
        Login1 login = new Login1();
        Scanner input = new Scanner(System.in);

        // Registration Process
        System.out.println("Register..........");
        System.out.print("Enter First Name: ");
        login.firstName = input.next();
        System.out.print("Enter Last Name: ");
        login.surname = input.next();
        System.out.print("Enter Username: ");
        login.userName = input.next();
        System.out.print("Enter Password: ");
        login.password = input.next();
        System.out.println("Enter cellphone number: ");
        login.cellPhone = input.next();
        System.out.println(login.registerUser());

        // Ensure valid username and password complexity
        while (!login.checkUsername() || !login.checkPasswordComplexity()) {
            System.out.println("Try to register again!!!!!");
            System.out.print("Enter Username: ");
            login.userName = input.next();
            System.out.print("Enter Password: ");
            login.password = input.next();
            System.out.println("Enter cellphone number: ");
            login.cellPhone = input.next();
            System.out.println(login.registerUser());
        }

        // Login Process
        System.out.println("Login..........");
        System.out.print("Enter Username: ");
        login.enteredUserName = input.next();
        System.out.print("Enter Password: ");
        login.enteredPassword = input.next();
        System.out.println("Enter cellphone number: ");
        login.enteredCell = input.next();
        System.out.println(login.returnLoginStatus());

        while (!login.loginUser()) {
            System.out.println("Try to Login again ..........");
            System.out.print("Enter Username: ");
            login.enteredUserName = input.next();
            System.out.print("Enter Password: ");
            login.enteredPassword = input.next();
            System.out.println("Enter cellphone number: ");
            login.enteredCell = input.next();
            System.out.println(login.returnLoginStatus());
        }

        input.close();
    }
}

    

