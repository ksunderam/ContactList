// subclass of Person
public class Worker extends Person
{
    private String job;

    public Worker(String fName, String lName, String mobileNum, String title)
    {
        // calling person constructor
        super(fName, lName, mobileNum);
        job = title;
    }

    public String getJob()
    {
        return job;
    }

    @Override
    public String toString()
    {
        return super.toString() + " Job: " + job;
    }
}
