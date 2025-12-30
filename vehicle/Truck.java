package vehicle;

public class Truck extends Vehicle 
{
    public String country; // where this truck was manufactured
    public int payload;
    public Truck(String country, String model)
    {
        super(model);
        this.country = country;
        // this.model;  //gives error as model is private
    }

    public void run()
    {
        System.out.println("child: Prrr Ths");
    }

    public void headquarters()
    {
        System.out.println("Main Headquater: " + super.country);
        System.out.println("Truck's Manufacturer: " + country);
    }
}
