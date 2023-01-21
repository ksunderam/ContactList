/**
 * A class that represents a Person
 *
 * Created for Menlo School CS2
 *
 * @author: Ms. Namasivayam & Mr. Blick
 * @version: 2022-2023
 */

public class Person
{
    // TODO: Complete the Person class

    // instance variables
    private String firstName;
    private String lastName;
    private String phoneNumber;
    // constrcutor
    public Person(String fName, String lName, String mobileNum)
    {
        firstName = fName;
        lastName = lName;
        phoneNumber = mobileNum;
    }

    // getter methods
    public String getFirstName()
    {
        return firstName;
    }

    public String getLastName()
    {
        return lastName;
    }

    public String getPhoneNumber()
    {
        return phoneNumber;
    }

    // toString
    @Override
    public String toString()
    {
        return firstName + " " + lastName + " - #" + phoneNumber;
    }
}
