package vehicle;

public class Truck extends Vehicle 
{
    public String country = "Egypt"; // our main country for trucks
    public int payload;
    public Truck(String country, String model)
    {
        super(country, model);
        // this.model;  //gives error as model is private
    }

    public void run()
    {
        System.out.println("child: Prrr Ths");
    }

    public void headquarters()
    {
        System.out.println("Main Headquater: " + super.country);
        System.out.println("Main Trucks Headquater: " + country);
    }


}
