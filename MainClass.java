import java.util.Scanner;
import java.lang.Integer;
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
        
        clinic.display_doctors("Saturday");
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
        // Notice the difference between (static) and normal fields
        Car c1 = new Car("Egypt", "1977");
        Car c2 = new Car("Japan", "2019");
        Car c3 = new Car("Germany", "2006");
        System.out.printf("c1: localId: %d  -  globalId: %d", c1.getLocalId(), c1.getGlobalId());
        System.out.printf("\nc2: localId: %d  -  globalId: %d", c2.getLocalId(), c2.getGlobalId());
        System.out.printf("\nc3: localId: %d  -  globalId: %d", c3.getLocalId(), c3.getGlobalId());
        System.out.println('\n');
        
        // Notice using super.color in method headquarters()
        Vehicle v;
        Truck t = new Truck("Germany", "2006");
        t.headquarters();
        System.out.println();
        
        // upcasting
        v = t;
        System.out.println(v.getCountry());     // still "Germany" and didn't use child attribute
        v.run();                                // used child method --> even when vehicle implemented run()
        //v.payload;                            // error as (v) can only see vehicle's members
        if (v instanceof Vehicle) System.out.println("v is Vehicle");
        if (v instanceof Truck) System.out.println("v is Truck");
        if ( !(v instanceof Car) ) System.out.println("v is not a Car");
        System.out.println();

        //downcasting
        t = (Truck)v;                             // cast truck into it's original form
        //t = v;                                  // compile time error: 
        //Car c = (Car) v;                        // gives a run time ClassCastException
        if (t instanceof Vehicle) System.out.println("t is Vehicle");
        if (t instanceof Truck) System.out.println("t is Truck");
    }
    
    public static void exceptions()
    {
        int n = 0;
        
        try {
            n = 3/0;
            System.out.println("rest of try " + n); // code here doesn't execute after exception throw
        } 
        catch (ArithmeticException ae) {
            System.out.println("catch 1");
        }
        catch(Exception e) {
            System.out.println("catch 2: general");
        }
        finally {
            System.out.println("always gets excuted"); // solves the issue in the previous comment
        }

        System.out.println("after try-catch n: " + n);
    }
    // handliling checked exceptions, and exceptions passing
    public static void show() throws Exception
    {
        System.out.println("show is called and throws a checked exception");
        throw new Exception("My Exception"); // if not handeled it gores to the caller method
        // here is unreachable code

    }
    public static void show2() throws Exception
    {
        System.out.println("show2 is called");
        try {
            show();
        } catch (Exception rte) {
            System.out.println("# Handeled in show2");
        }
        System.out.println("end of show2");
    }
    public static void show3() throws Exception
    {
        System.out.println("show3 is called");
        try {
            show2();
        } catch (Exception rte) {
            System.out.println("# Handeled in show3");
        }
        System.out.println("end of show3");
    }

    public static void main(String[] args) throws Exception
    // we have to use (throws) here as we'd called show3 that (throws) a checked exception, and we didn't handle it here in main
    {
        // input_output();
        // arrays();
        // medical();
        // library();
        vehicles(); 
        // exceptions();
        
        // Application on Exceptions
        System.out.println("main is called");
        show3();
        System.out.println("end of main");

    }
}

/*                                                   Study
to run:
1. Compile (using javac --> into bytecode .class):   javac general.java
2. run (usign JVM --> into machine code):            java general


Notes:
    - Each file must have EXACTLY on public class, and that class must be of the same name
    - class access modifiers  -->  public | default
    - (Modifiers) come before datatype or return type
    - child inherits all (non-private) members
    - reference type: class (like String, Scanner), array, interface
    - (Object) is the super classes of all classes in java
    - Avoid compiler errors:
        - Usage of uninitialized Local Variables(in methods)
        - Unreacheable code: E.g. code after return, Unreachable catch block, while(false) ...
        - All Checked Exceptions Must Be Handled or passed by (throws)
/


Concepts:
    (OOP)
    In the real world, everything around us is an Object that has some properties and functionality.
    we can define OOP as a Programming paradigm where the software is represented by a collection of objects
    interacting with each other.

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
    1. Encapsulation:   combine data and methods into (class). use (access modifiers) to isolate data from outer interference.
    2. Inheritance:     create hierarchy of related classes     -->     inherits all non-private members
    3. Abstraction:     hide complexity (black box)
    4. Polymorphism:    methods have general meaning but different forms [ overload, override ] 
    
    Overload: compile time polymorphism (static or early binding) -->  same name, different parameter list
    Override: run time polymorphism (dynamic or late binding)     -->  when child implement parent method


    (Constructor)
    - Has the (same exact name) as the class 
    - doesn't have (return type)
    - Can't be inhereted (subclasses must call super())
    - Types:
        1. Default          --> if you didn't implement any constructor
        2. Parametrized
        3. Copy constructor --> public Car(Car c) {brand = c.brand;}
    - can call each other through [ this() ]   --> like in medical\Doctor.java
/


(KeyWords)
Access Modifiers:
    public    (+):  Allows access from anywhere
    protected (~):  Allows access within the package and by subclasses (even if within different).
    private   (-):  Restricts access to within the class.
        - writing none of the above will be default:
    default:    Allows access within the package        
        - top level classes can only be (public) or (default)

Non Access Modifiers:
    class:      Declares a class.
    extends:    Indicates inheritance (a class extending another class).
    interface:  Declares an interface.
    implements: Indicates that a class implements an interface.
    default:    to define a default interface method
    enum:       Declares an enumerated type.

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
        - Cannot refer to (this) or (super)
        - Cannot interact with non-static members

    final: 
        - defines Constant
        - prevents method override (final)
        - prevent class inheritance
/


(Package)
- Group of related classes.
- Standard Packages: 
java.*
javax.*
- use (import) to access (public) classes in other packages


Interface:
    - An interface is a pure (Abstract) class.      so the implementer class HAS TO OVERRIDE ALL of the interface methods
    - A class can implement (many interfaces).
    - An interface can extend (many interfaces).
    - All data members are (public static final),     and there is no need to define them explicitly
    - All methods are (public abstract).
    - default methods provide a default implementation that you can override if you want providing (backward compatibility)
    - static methods in interfaces are not inherited.
    - we can use (upcasting) with interfaces and classes that implement it

    - Abstract classes should be used primarily for objects that are closely related, 
    whereas interfaces are best suited for providing a common functionality to unrelated classes. 
    
    - Comparable Interface:    -->   int compareTo(Object o)
        -ve : if the current object is smaller than the passed object
        0   : if both objects are equal
        +ve : if the current object is larger than the passed object
    
        public class Student implements Comparable {
            private int id;
            private String name;
            private float marks;
            public Student(int id, String name, float marks){
                this.id = id;
                this.name = name;
                this.marks = marks;
            }
            public int compareTo(Object obj) {
                Student otherStudent = (Student) obj;
                if(this.id < otherStudent.id)
                    return -1;
                else if(this.id > otherStudent.id)
                    return 1;
                else return 0;
            }
        }

    - implementing compareTo defines the (natural ordering)  -->  what Arrays.sort() or Collections.sort() use
        public static void main(String[] args) {
            Student[] arr = new Student[3];

            arr[0] = new Student(7, "Ahmed”, 30.0F);
            arr[1] = new Student(1, "Mona", 50.0F);
            arr[2] = new Student(5, "Ashraf”, 70.0F);

            Arrays.sort(arr);     // NOTE //
        }
    - Comparator Interface:   -->   int compare(Object o1, Object o2) returns:
        -ve : if the first object is smaller than the second object
        0   : if both objects are equal
        +ve : if the first object is larger than the second object

      - we can use Comparator interface to override natural ordering (compareTo):
        public class StudentComparator implements Comparator {
            @Override
            public int compare(Object obj1, Object obj2) {
                Student student1 = (Student) obj1;
                Student student2 = (Student) obj2;
                if(student1.marks < student2.marks)
                    return -1;
                else if(student1.marks > student2.marks)
                    return 1;
                else return 0;
            }
        }
        public static void main(String[] args) {
            StudentComparator comparator = new StudentComparator();
            Student[] arr = new Student[3];

            arr[0] = new Student(7, "Ahmed”, 30.0F);
            arr[1] = new Student(1, "Mona", 50.0F);
            arr[2] = new Student(5, "Ashraf”, 70.0F);

            Arrays.sort(arr, comparator);  // NOTE //
        }

Exceptions:
    - All exceptions                            (extends throwable)
    - Unchecked exceptions: riase at run time   (extends RunTimeException)
    - Checked exceptions: riase at compile time (extends Exception directly) 
        --> if not handeled through (try catch) the method must (throws) the exception to it's caller

    - Code after the line that throwed exception is (unrechable)
    /


Upcasting and Downcasting: 
    - upcasting: converting an object of a subclass to it superclass → Done implicitly
    - Downcasting: converting an object of a superclass to one of its subclasses → Must be done explicitly

    ---> ### See vehicles() ###

        Vehicle v = new Truck();        (upcasting)
        Truck t = (Truck) v;            (explicit downcasting)
        Car c = (Car) v;                (wrong downcasting --> throws an exception)

    if(t instanceOf Truck) {}           (true when comparing the instance to its class or suprtclass)
/


Casting
    1. Widening Casting (automatic):    smaller type to larger  (byte --> int)
    2. Narrwing Casting (manual):       larger type to smaller one (long --> int)

    int num = 5;
    float num2 = num;           (Widening Casting)
    byte num3 = (byte) num;     (Narrwing Casting)

    // Using Methods
    String s = "200";
    int i = Integer.parseInt(s);
    float a = (Float.valueOf("10.5")).floatValue(); 
    String s1 = String.valueOf(i);  
/


String
    Definition:
        String str = "Hello";          (uses stringBuffer)
        char[] chars = { 'H', 'i' };
        String s1 = new String(str);   (normal reference)
        String s2 = new String(chars); (now we can print chars)

    Comparison --> s1.equals(s2) || s1.compareTo(s2)   '==' Operator CANNOT be used(it compares object references)

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
    Arrays are classes (Reference type)
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
/

*/