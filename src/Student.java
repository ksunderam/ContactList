/**
 * A subclass of Person that represents a Student
 *
 * Created for Menlo School CS2
 *
 * @author: Ms. Namasivayam & Mr. Blick
 * @version: 2022-2023
 */
// keyword "extends" cause it's a subclass of Person
public class Student extends Person
{
    // TODO: Modify and complete this class

    private int grade;
    public Student(String fName, String lName, String mobileNum, int standard)
    {
        // calling the Person constructor
        super(fName, lName, mobileNum);
        grade = standard;

    }
    public int getGrade()
    {
        return grade;
    }

    @Override
    public String toString()
    {
        return super.toString() + " Grade: " + grade;
    }
}
