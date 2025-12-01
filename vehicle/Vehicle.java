package vehicle;

// abstract class has to be inherited (extended)
public abstract class Vehicle 
{
    String country = "Germany";     // the main headquarter
    private String model;

    // abstract class may have constructor but you can't call it
    public Vehicle(String country, String model) {
        this.country = country;
        this.model = model;
    }

    public String getCountry() {
        return country;
    }

    public String getModel() {
        return model;
    }

    public void run()
    {
        System.out.println("Parent");
    }

    // can have abstract methods
}
