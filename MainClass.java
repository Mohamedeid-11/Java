import java.util.Scanner;
import vehicle.*;           // import all classes in vehicle
import medical.*;
import library.*;

public class MainClass 
{
    // Topics:
    public static void input_output()
    {
        Scanner input = new Scanner(System.in);

        System.out.print("Name: ");
        String name = input.next();
        System.out.print("Age: ");
        int age = input.nextInt();
        System.out.print("Weight: ");
        // notice the (f suffix)
        float weight = 65.734f; 
        weight = input.nextFloat();
        System.out.println();
        
        System.out.printf("Hello %s. \nYou're %d years old, and %.2f Kg!", name, age, weight);
        input.close();
    }
    public static void arrays()
    {
        // Define array:
        int[][] arr = {
            {1, 2, 3},                 // 1. Arry initializer(array constant) 
            new int[]{4, 5, 6, 7},     // 2. Full form (explicit creation)
            new int[3]                 // Assign later
        };
        arr[2][0] = 8;

        for(int[] a : arr)
        {
            for(int element : a)
            {
                System.out.printf("%d ", element);
            }
            System.out.println();
        }
        System.err.println();

        arr[0] = arr[1];
        arr[2] = new int[]{8};
        // arr[0] = {1, 2, 3};  Gives an error as this is assignment not intialization

        for(int[] a : arr)
        {
            for(int element : a)
            {
                System.out.printf("%d ", element);
            }
            System.out.println();
        }
    }
    public static void medical()
    {
        Clinic clinic = new Clinic();
        
        Doctor d1 = new Doctor("A", "Saturday");
        clinic.insert_doctor(d1, 0);
        Doctor d2 = new Doctor("B", "Sunday");
        clinic.insert_doctor(d2, 1);
        Doctor d3 = new Doctor("C", "Saturday");
        clinic.insert_doctor(d3, 2);
        
        clinic.display_doctor("Saturday");
    }
    public static void library()
    {
        // Association Relationship (Aggregation)
        Author author = new Author("Mohamed");
        Book b1 = new Book(100); b1.setName("Book1"); b1.setPrice(65.0f);
        Book b2 = new Book("Book2", 200); b2.setPrice(153.99f);
        Book b3 = new Book("Book3", 300, 234.5f);
        
        author.addBook(b1, 0);
        author.addBook(b2, 1);
        author.addBook(b3, 2);
        
        System.out.println("Search for 'Book2': ");
        Book b = author.searchBook("Book2");
        if(b != null) {
            System.err.println("Name: " + b.getName());
            System.err.println("Number of books: " + b.getNumberOfPages());
            System.out.println("Price: " + b.getPrice());
        }
        else{
            System.out.println("none");
        }
        System.out.println();

        author.displayBooksData();
    }
    public static void vehicles()
    {
        Car c1 = new Car("Egypt", "1977");
        Car c2 = new Car("Japan", "2019");
        Car c3 = new Car("Germany", "2006");
        // Notice the difference between (static) and normal fields
        System.out.printf("c1: localId: %d  -  globalId: %d", c1.getLocalId(), c1.getGlobalId());
        System.out.printf("\nc2: localId: %d  -  globalId: %d", c2.getLocalId(), c2.getGlobalId());
        System.out.printf("\nc3: localId: %d  -  globalId: %d", c3.getLocalId(), c3.getGlobalId());
        System.out.println();
        
        // upcasting & downcasting
        Vehicle v;
        Truck t = new Truck("Germany", "2006");

        v = t;          // upcasting
        v.run();        // truck method
        // v.payload;   // gives error as it can only see vehicle not truck members
        if (v instanceof Vehicle) System.out.println("v is Vehicle");
        if (v instanceof Truck) System.out.println("v is Truck");
        if ( !(v instanceof Car) ) System.out.println("v is not a Car");

        v = new Truck("","");
        t = (Truck)v;   //downcasting
        if (t instanceof Vehicle) System.out.println("t is Vehicle");
        if (t instanceof Truck) System.out.println("t is Truck");
    }
    public static void main(String[] args) 
    {
        // input_output();
        // arrays();
        // medical();
        // library();
        // vehicles(); 
    }
}

/*                                                   Study
to run:
1. Compile (using javac --> into bytecode .class):   javac general.java
2. run (usign JVM --> into machine code):            java general

(Modifiers come before data or return type)

Concepts:
    (OOP)
    In the real world, everything around us is an Object that has some properties and functionality.
    we can define OOP as a Programming paradigm where the software is represented by a collection of objects
    nteracting with each other.

    Relationships:
        1. generalization(is kind of): A generalization connects a derived class to its base class. 
            generalized (student) will be a "persion"  --> (student) is kind of (person)

        2. Association: a relation between two separate classes which establishes through their Objects. 
            - Aggregation(has/own-a) جمع --> unidirectional association i.e. a one-way relationship. 
                (Both entries can survive individually) 
                (school) has a (teacher and a student) 
            - Composition (part-of) تكوين --> the composed object cannot exist without the other entity.
                (engine) is part of (car)

    OOP Principles:
    1. Encapsulation:   isolate data throuh (access modifiers)
    2. Inheritance:     create hierarchy of relates classes     --> inherits all non-private members
    3. Abstraction:     hide complexity (black box)
    4. Polymorphism:    methods have general meaning but different forms [ overload(change parameter list), override ] 
        dynamic binding mechanism: determines which method definition will be called in case of overriding
    
    (Constructor)
    - Has the (same exact name) as the class 
    - doesn't have (return type)
    - Can't be inhereted (subclasses must call super())

    - Types:
    1. Default          --> if you didn't implement any constructor
    2. Parametrized
    3. Copy constructor --> public Car(Car c) {brand = c.brand;}
    - can call each other through [ this() ]   --> like in medical\Doctor.java
    

    (Package)
    - Group of related classes.
    - Standard Packages: 
    java.*
    javax.*
    - use (import) to access (public) classes in other packages
    

    Non Primitave / reference types: class (like String, Scanner), array, interface
    

    (KeyWords)
    Access Modifiers:
    public:     Allows access from anywhere
    protected:  Allows access within the package and by subclasses (even if within different).
    private:    Restricts access to within the class.
        - writing none of the above will be default:
    default:    Allows access within the package        
        - top level classes can only be (public) or (default)
    
    Non Access Modifiers:
    class:      Declares a class.
    enum:       Declares an enumerated type.
    extends:    Indicates inheritance (a class extending another class).
    interface:  Declares an interface.
    implements: Indicates that a class implements an interface.
    
    abstract:                            Example: vehicle/Vehicle.java
        - class: you can't create objects of an abstract class(inherit from it only)
            it can have constructor but only for subclasses to call it through super()
        - method(only in abstract classes): declared without an implementation (body),  subclasses must provide their own implementation.
    
    Field Modifiers:
    static: 
      Variables and methods that belong to the class itself not individual instances.
        - Class-level ownership: There is only one copy shared across all instances and (sublasses)
        - Direct access: accessed directly using the class name
        - Can't be (overriden), hence can't be (abstract)
        - Cannot interact with non-static members as it's object specific
        - can't call (this) or (super)

    final: 
        - defines Constant
        - prevent class inheritance
        - prevents method override
        /

    Casting
    1. Widening Casting (Implicit):    smaller type to larger  (byte --> int)
    2. Narrwing Casting (Explicit):       larger type to smaller one (long --> int)
    
    int num = 5;
    float num2 = num;           (Widening Casting)
    byte num3 = (byte) num;     (Narrwing Casting)

    // Using Methods
    String s = "200";
    int i = Integer.parseInt(s);
    float a = (Float.valueOf("10.5")).floatValue(); 
    String s1 = String.valueOf(i);  

/

Upcasting and Downcasting: 
    - upcasting: converting an object of a subclass to it superclass → Done implicitly
    - Downcasting: converting an object of a superclass to one of its subclasses → Must be done explicitly

        Vehicle v = new Truck();        (upcasting)
        Truck t = (Truck) v;            (explicit downcasting)
        Car c = (Car) v;                (wrong downcasting --> throws an exception)

    if(t instanceOf Truck) {}           (true when comparing the instance to its class or suprtclass)
/

String
    Definition:
        String str = "Hello";          (uses stringBuffer)
        char[] chars = { 'H', 'i' };
        String s1 = new String(str);   (normal reference)
        String s2 = new String(chars); (now we can print chars)

    Comparison --> s1.equals(s2) || s1.compareTo(s2)   '==' Operator compares object references

    - When we define (literal) string : String str = "Hello"; 
      the compiler searches the (stringBuffer)
      if found it will return its reference
      if not it will create an instance for it then return the reference

    Format string 
        System.out.printf("%.2f", weight);

        parameters:
        c   char  
        s   string
        d   integer (byte,... ,long)
        f   float (float, double)
        b   bool

        (%.2f)    round for nearest 2 decimals 
/   


Array
    Arrays are classes
    Define array:
        int[][] arr = {
            {1, 2, 3},                 // 1. Arry initializer(array constant)  --> cannot be used for later assignment
            new int[]{4, 5, 6, 7},     // 2. Full form (explicit creation)
            new int[3]                 // Assign later
        };

    Assinment:
        arr[0] = arr[1];
        arr[2] = new int[]{1, 2, 3};
        (X)  arr[2] = {1, 2, 3};  // error
        

*/
