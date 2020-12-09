package src;
//import com.twilio.*;

//NOTE: Why HashMaps pf password it's better just to have a collection of Users only

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

/***** MASS TEXT MESSAGE SENDER ******************
 * This program will take message template or a user
 * written message then take the users contacts.txt and
 * send a personalized message to each contact using
 * the selected message.
 ************************************************/


public class Main {

    public static void main(String[] args) throws IOException {
//        final String FILE_PATH = "src\\src\\data\\messages.txt";
//        try (FileWriter writer = new FileWriter("src\\src\\data\\messages.txt")) {
//        }
        MessageManager MessageManager = new MessageManager();
        ContactsManager contactsManager = new ContactsManager();

        Scanner input = new Scanner(System.in);
        //===== getUserName ==============================
        //  THe login will be handled by an unordered
        // collection (hashmap)
        //================================================
        ArrayList<User> users = new ArrayList();
        // Creates and maps Username to User
        HashMap<String, Integer> userIndex = new HashMap();
        HashMap<String, Integer> passwordIndex = new HashMap();
        users.add(new User("u", "p"));
        boolean runLoop = true;
        boolean runLoop2 = true;

        // the first do while run loop starts here for the login
        do {
            // Create index at the end
            for (int i = 0; i < users.size(); i++) {
                userIndex.put(users.get(i).getUsername(), i);
                passwordIndex.put(users.get(i).getPassword(), i);
            }

            System.out.println("Please log in.\n" +
                    "Enter your username:");

            String username = input.nextLine();

            System.out.println("Please enter your password:");

            String password = input.nextLine();
            // if (foundUser == null || password == null) check the username and password
            User foundUser = users.get(userIndex.get(username));
            if (!(userIndex.containsKey(username)) || !(foundUser.equals(password))) {
                System.out.println("Login attempt failed user or password are incorrect");
                //attempt counter here?
                // If the password is correct move onto the User Interface loop.
            } else {
                System.out.println("------Access Granted------\n");
                contactsManager.retrieve("u");
                //If user logged in read all messaged that are saved to file

                do {
                    System.out.println("Hello " + username +
                            ", Welcome to the Mass Text Message Sender!\n" +
                            "What would you like to do? \n" +
                            "1. Add/Remove/Display Contacts\n" +
                            "2. Add/Remove/Display Messages\n" +
                            "3. Send Message\n" +
                            "4. Log out");
                    int userChoice = input.nextInt();

                    if (userChoice == 1) {
                        System.out.println("1. Add contact\n2. Remove contact\n3. Display all contacts.txt\n");
                        userChoice = input.nextInt();
                        if (userChoice == 1) {
                            System.out.println("Enter name:\n");
                            input.nextLine();
                            String name = input.nextLine();
                            System.out.println("Enter phone number:\n");
                            Integer number = input.nextInt();
                            contactsManager.add(name, number);

                        } else if (userChoice == 2) {
                            System.out.println("Enter name of contact to be removed");
                            String name = input.nextLine();
                            contactsManager.remove(name);
                            return;

                        } else if (userChoice == 3) {
                            contactsManager.displayContacts();
                            System.out.println("Return to main ");

                        } else {
                            System.out.println("Invalid option");
                            runLoop = true;
                        }

                    } else if (userChoice == 2) {

                        System.out.println("1. Add message\n2. Remove message\n3. Display all message\n");
                        userChoice = input.nextInt();
                        if (userChoice == 1) {
                            if (userChoice == 1) {
                                String userInput;
                                input.nextLine();
                                System.out.println("Message Name:\n");
                                //get user input
                                System.out.println("Enter your message here and place an \"`\" for the name placement.\n");
                                //get user msg
                            }


                        } else if (userChoice == 2) {
                            // delete a message from the messageManager
                            System.out.println("What message would you like to delete?\n");


                        } else if (userChoice == 3) {
                            //display all the current messages
                            System.out.println("Here is your saved messages.\n");

                        } else {
                            System.out.println("Invalid option");
                            return;
                        }
                    } else if (userChoice == 3) {
                        //run the message builder

                    } else if (userChoice == 4) {
                         contactsManager.logOut();
                        runLoop2 = false;
                        input.nextLine();
                    }
                } while (runLoop2 == true);

            }

        } while (runLoop == true);
    }
}


