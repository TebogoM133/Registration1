/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.registration1;
   import java.util.Scanner;
import java.util.Random;
/**
 *
 * @author Student
 */
public class QuickChatp2 {


    public static void main(String[] args) {

        // --- All declarations at the top ---
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        String username = "";
        String password = "";
        String recipient = "";
        String message = "";
        String messageIDStr = "";
        String messageHash = "";
        String first2 = "";
        String firstWord = "";
        String lastWord = "";
        String[] words = new String[0]; // <-- fixed here

        long messageID = 0;

        int maxMessages = 0;
        int messageCount = 0;
        int totalSent = 0;
        int choice = 0;
        int sendChoice = 0;

        boolean loggedIn = false;
        boolean running = true;
        boolean validRecipient = false;
        boolean validMessage = false;

        // --- Requirement 1: Login ---
        System.out.print("Enter username: ");
        username = scanner.nextLine();
        System.out.print("Enter password: ");
        password = scanner.nextLine();

        if (username.equals("user") && password.equals("pass")) {
            loggedIn = true;
        }

        if (!loggedIn) {
            System.out.println("Login failed. Goodbye.");
            return;
        }

        // --- Requirement 2: Welcome message ---
        System.out.println("Welcome to QuickChat.");

        // --- Requirement 5: How many messages? ---
        System.out.print("How many messages do you want to send? ");
        maxMessages = scanner.nextInt();
        scanner.nextLine();

        // --- Requirement 4: Run until user quits ---
        while (running) {

            System.out.println("\n1) Send Messages");
            System.out.println("2) Show recently sent messages");
            System.out.println("3) Quit");
            System.out.print("Choose an option: ");

            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {

                case 1:
                    if (messageCount >= maxMessages) {
                        System.out.println("You have reached your message limit.");
                        break;
                    }

                    // Auto-generate 10-digit Message ID
                    messageID = (long)(random.nextDouble() * 9000000000L) + 1000000000L;
                    messageIDStr = String.valueOf(messageID);

                    messageCount++;

                    // Recipient validation
                    recipient = "";
                    validRecipient = false;
                    while (!validRecipient) {
                        System.out.print("Enter recipient cell number (with international code, max 10 chars): ");
                        recipient = scanner.nextLine();
                        if (recipient.length() <= 10 && recipient.startsWith("+")) {
                            validRecipient = true;
                        } else {
                            System.out.println("Invalid number. Must start with + and be max 10 characters.");
                        }
                    }

                    // Message validation
                    message = "";
                    validMessage = false;
                    while (!validMessage) {
                        System.out.print("Enter your message (max 250 characters): ");
                        message = scanner.nextLine();
                        if (message.length() <= 250) {
                            validMessage = true;
                        } else {
                            System.out.println("Please enter a message of less than 250 characters.");
                        }
                    }

                    // Build Message Hash
                    first2 = messageIDStr.substring(0, 2);
                    words = message.split(" ");
                    firstWord = words[0];
                    lastWord = words[words.length - 1];
                    messageHash = (first2 + ":" + messageCount + ":" + firstWord + lastWord).toUpperCase();

                    // Send / Disregard / Store menu
                    System.out.println("\nWhat do you want to do with this message?");
                    System.out.println("1) Send Message");
                    System.out.println("2) Disregard Message");
                    System.out.println("3) Store Message to send later");
                    System.out.print("Choose: ");
                    sendChoice = scanner.nextInt();
                    scanner.nextLine();

                    switch (sendChoice) {
                        case 1:
                            System.out.println("Message successfully sent");
                            totalSent++;
                            System.out.println("\n--- Message Details ---");
                            System.out.println("Message ID: " + messageIDStr);
                            System.out.println("Message Hash: " + messageHash);
                            System.out.println("Recipient: " + recipient);
                            System.out.println("Message: " + message);
                            System.out.println("-----------------------");
                            break;

                        case 2:
                            System.out.println("Press 0 to delete the message");
                            messageCount--;
                            break;

                        case 3:
                            System.out.println("Message successfully stored");
                            break;

                        default:
                            System.out.println("Invalid option.");
                            break;
                    }
                    break;

                case 2:
                    System.out.println("Coming Soon.");
                    break;

                case 3:
                    running = false;
                    break;

                default:
                    System.out.println("Invalid option. Please choose 1, 2, or 3.");
                    break;
            }
        }

        // --- Requirement 6: Total messages sent ---
        System.out.println("\nTotal messages sent: " + totalSent);
        System.out.println("Goodbye!");

        scanner.close();
    }
}

