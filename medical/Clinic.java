package medical;

public class Clinic 
{
    private Doctor[] doctors = new Doctor[3];

    public void insert_doctor(Doctor doc, int idx) 
    {
        doctors[idx] = doc;
        System.out.println("counter: " + Doctor.getCounter());
    }

    public void display_doctors(String day) 
    {
        System.out.printf("Doctors working on %s: ", day);
        for(Doctor doc : doctors)
        {
            if(doc.working_day.equals(day))
                System.out.print(doc.name + " ");
        }
    }
}
