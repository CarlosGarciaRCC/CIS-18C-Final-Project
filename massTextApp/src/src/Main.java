package src;
//import com.twilio.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        ArrayList<User> users = new ArrayList();
        // Maps Username to User
        HashMap<String, Integer> userIndex = new HashMap();
        HashMap<String, Integer> passwordIndex = new HashMap();
        users.add(new User("user", "password"));

        // Create index at the end

        for (int i = 0; i < users.size(); i++) {
            userIndex.put(users.get(i).getUsername(), i);
            passwordIndex.put(users.get(i).getPassword(), i);
        }

        System.out.println("Please log in.\nEnter your username:");
        String username = input.nextLine();
        // if (foundUser == null) {
        if (!(userIndex.containsKey(username))) {
            System.out.println("Username not found");
            return;
        } else {
            // Check the password
            User foundUser = users.get(userIndex.get(username));

            //System.out.println(foundUser);

            System.out.println("Please enter your password:");

            String password = input.nextLine();
            if (foundUser.getPassword().equals(password)) {
                System.out.println("Access Granted");
                int userChoice = 0;

                System.out.println("Hello " + username + ",\nWhat would you like to do? \n1. Add/Remove/Display Contacts\n" +
                        "2. Add/Remove/Display Messages\n3. Send Message");
                if (userChoice == 1) {
                    System.out.println("1. Add contact\n2. Remove contact\n3. Display contacts\n");
                    if (userChoice == 1) {

                    } else if (userChoice == 2) {

                    } else if (userChoice == 3) {

                    } else {
                        System.out.println("Invalid option");
                        return;
                    }

                } else if (userChoice == 2) {
                    if (userChoice == 1) {
                        System.out.println("1. Add message\n2. Remove message\n3. Display message\n");
                        if (userChoice == 1) {

                        } else if (userChoice == 2) {

                        } else if (userChoice == 3) {

                        } else {
                            System.out.println("Invalid option");
                            return;
                        }


                    } else if (userChoice == 3) {

                    }

                } else {
                    System.out.println("Access Denied");
                }
            }
        }
    }
}
