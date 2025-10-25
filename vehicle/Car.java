package vehicle;

public class Car extends Vehicle
{
    private static int globalId;
    private int localId;

    public Car(String make, String model){
        super(make, model);
        localId = ++globalId;
    }

    public static int getGlobalId() {
        return globalId;
    }
    public int getLocalId() {
        return localId;
    }

    public void run() {
        System.out.println("Vrom Vrom");
    }
}
