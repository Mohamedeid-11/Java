package medical;

public class Doctor 
{
    final String name;
    String working_day;
    static int counter;

    public Doctor(String name, String working_day) {
        this.name = name;
        this.working_day = working_day;
        counter++;
    }

    // Constructors can call each other
    public Doctor(String name) {
        this(name, "Saturday");
    }

    public static int getCounter() {
        return counter;
    }
}
