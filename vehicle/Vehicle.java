package vehicle;

// abstract class has to be inherited (extended)
public abstract class Vehicle 
{
    private String make;
    private String model;

    // abstract class may have constructor but you can't call it
    public Vehicle(String make, String model) {
        this.make = make;
        this.model = model;
    }

    public String getMake() {
        return make;
    }

    public String getModel() {
        return model;
    }

    public abstract void run();     // abstract function has to be overriden
}
