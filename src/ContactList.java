/**
 * A class that stores subclasses of Person as a contact list.
 * The user is presented with a menu of options and may add, sort,
 * search, or list the contacts.
 *
 * Created for Menlo School CS2
 *
 * @author: Ms. Namasivayam & Mr. Blick
 * @version: 2022-2023
 */

import java.util.Collections;
import java.util.ArrayList;
import java.util.Scanner;

public class ContactList
{
    // TODO: Create your array contacts
    private ArrayList<Person> list;

    // TODO: Write a Constructor
    // all that's needed in constructor is to initialize Array List of Persons
    public ContactList()
    {
        list = new ArrayList<Person>();
    }

    public void printMenuOptions() {
        System.out.println("Menu: ");
        System.out.println("1. Add Contact");
        System.out.println("2. List All Contacts By First Name");
        System.out.println("3. List All Contacts By Last Name");
        System.out.println("4. List All Contacts By Phone Number");
        System.out.println("5. List All Students");
        System.out.println("6. Search By First Name");
        System.out.println("7. Search By Last Name");
        System.out.println("8. Search by Phone Number");
        System.out.println("0. Exit");
    }

    /**
     * Asks user for input to create and add a new Person
     * to the contact list
     */
    public void addContact()
    {
        // TODO: Complete the addContact method
        Scanner input = new Scanner(System.in);
        int choice;
        // to make sure that the user either inputs a one or a two so that they either select to
        // input a student(1) or worker(2)
        do
        {
            System.out.println("Select a type of contact to add:\n1. Student\n2. Worker");
            choice = input.nextInt();
            input.nextLine();
        }
        while (choice != 1 && choice != 2);

        // creates and adds a student with user input
        if (choice == 1)
        {
            System.out.println("Please fill in the following information:");
            System.out.println("First Name:");
            String firstName = input.nextLine();
            System.out.println("Last Name:");
            String lastName = input.nextLine();
            System.out.println("Phone Number:");
            String phoneNum = input.nextLine();
            System.out.println("Grade:");
            int grade = input.nextInt();
            Student x = new Student(firstName, lastName, phoneNum, grade);
            list.add(x);
        }
        // creates and adds a worker with user input
        if (choice == 2)
        {
            System.out.println("Please fill in the following information:");
            System.out.println("First Name:");
            String firstName = input.nextLine();
            System.out.println("Last Name:");
            String lastName = input.nextLine();
            System.out.println("Phone Number:");
            String phoneNum = input.nextLine();
            System.out.println("Job:");
            String job = input.nextLine();
            Worker x = new Worker(firstName, lastName, phoneNum, job);
            list.add(x);
        }
    }

    /**
     * Loops through and prints all contacts
     */
    public void printContacts()
    {
        // TODO: Complete the printContacts method
        // goes through each person and prints its toString
        for (int i = 0; i < list.size(); i++)
        {
            System.out.println(list.get(i));
        }
    }

    /**
     * Bubble sorts the contacts in the list by firstName,
     * lastName, or phoneNumber
     * @param sortBy: 0=firstName, 1=lastName, 2=phoneNumber
     */
    public void sort(int sortBy)
    {
        // TODO: Complete the sort method
        // Bubble sort code from class slides, edited so that it complies with this arraylist's name and vars
        // Also I use compare to when checking the difference between adjacent people in the list
        // the if (sortBy == x) is just to know how to sort the list (fName, lName, etc...)
        int n = list.size();
        for (int pass = 1; pass < n; pass++)
        {
            for (int comp = 0; comp < n - pass; comp++)
            {
                if (sortBy == 0)
                {
                    if (list.get(comp).getFirstName().compareTo(list.get(comp + 1).getFirstName()) > 0)
                    {
                        Collections.swap(list, comp, comp + 1);
                    }
                }
                if (sortBy == 1)
                {
                    if (list.get(comp).getLastName().compareTo(list.get(comp + 1).getLastName()) > 0)
                    {
                        Collections.swap(list, comp, comp + 1);
                    }
                }
                if (sortBy == 2)
                {
                    if (list.get(comp).getPhoneNumber().compareTo(list.get(comp + 1).getPhoneNumber()) > 0)
                    {
                        Collections.swap(list, comp, comp + 1);
                    }
                }
            }
        }



    }

    // TODO: Write searchByFirstName
    // for these search methods, I just have a for loop and check whether an instance of a person in the list has
    // the same: fName, lName, or number as the parameter, and return what person does match
    // if there isn't a match, null is returned
    public Person searchByFirstName(String firstName)
    {
        for (int i = 0; i < list.size(); i++)
        {
            if (list.get(i).getFirstName().equals(firstName))
            {
                return list.get(i);
            }
        }
        return null;
    }

    // TODO: Write searchByLastName
    public Person searchByLastName(String lastName)
    {
        for (int i = 0; i < list.size(); i++)
        {
            if (list.get(i).getLastName().equals(lastName))
            {
                return list.get(i);
            }
        }
        return null;
    }

    // TODO: Write searchByPhoneNumber
    public Person searchByPhoneNumber(String phoneNumber)
    {
        for (int i = 0; i < list.size(); i++)
        {
            if (list.get(i).getPhoneNumber().equals(phoneNumber))
            {
                return list.get(i);
            }
        }
        return null;
    }

    /**
     * Lists just the Student objects in the Contact List
     */
    // another for loop going through list, checking whether a person is a student using the
    // instanceof keyword. Then I print depending on whether the person is a student.
    public void listStudents()
    {
        // TODO: Complete the listStudents method
        for (int i = 0; i < list.size(); i++)
        {
            if(list.get(i) instanceof Student)
            {
                System.out.println(list.get(i));
            }
        }
    }

    /**
     * Loops providing menu options to the user
     * until the user exits
     */
    // in run() I just have a do while to keep looping until the user inputs 0
    // other than that, if statements are just what happens when a user selects an option from the menu
    public void run()
    {
        System.out.println("Welcome to your Contacts List");
        System.out.println("Please pick from the following menu options");
        Scanner input = new Scanner(System.in);
        int choice;
        do
        {
            printMenuOptions();
            choice = input.nextInt();
            input.nextLine();

            if (choice == 1)
            {
                addContact();
            }
            if (choice == 2)
            {
                sort(0);
                printContacts();
            }
            if (choice == 3)
            {
                sort(1);
                printContacts();
            }
            if (choice == 4)
            {
                sort(2);
                printContacts();
            }
            if (choice == 5)
            {
                listStudents();
            }
            // for the search options in the menu I have an if statement to first check whether it is actually
            // null before printing whether there is a matching person
            if (choice == 6)
            {
                System.out.println("Enter a name:");
                String firstName = input.nextLine();
                if (searchByFirstName(firstName) == null)
                {
                    System.out.println(firstName + " is not on the list.");
                }
                else
                {
                    System.out.println(searchByFirstName(firstName));
                }
            }
            if (choice == 7)
            {
                System.out.println("Enter a name:");
                String lastName = input.nextLine();
                if (searchByLastName(lastName) == null)
                {
                    System.out.println(lastName + " is not on the list.");
                }
                else
                {
                    System.out.println(searchByLastName(lastName));
                }
            }
            if (choice == 8)
            {
                System.out.println("Enter a phone number:");
                String phoneNumber = input.nextLine();
                if (searchByPhoneNumber(phoneNumber) == null)
                {
                    System.out.println(phoneNumber + " is not on the list.");
                }
                else
                {
                    System.out.println(searchByPhoneNumber(phoneNumber));
                }
            }

        }
        while (choice != 0);
    }


    public static void main(String[] args)
    {
        ContactList cl = new ContactList();
        cl.run();
    }
}
