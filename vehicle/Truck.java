package vehicle;

public class Truck extends Vehicle {
    public int payload;
    public Truck(String make, String model)
    {
        super(make, model);
    }

    public void run()
    {
        System.out.println("Prrr Ths");
    }
}
