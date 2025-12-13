public interface calculator 
{
    int Min_Num = 0;                        // public static private buy default

    int add(int n1, int n2);               // public abstract by default
    int subtreact(int n1, int n2);

    static int multiply(int n1, int n2) {   // can't be inherited
        return n1*n2;
    }

    default int devide(int n1, int n2) {
        return n1*n2;
    }
}

abstract class c implements calculator
{
    public int add(int n1, int n2) {
        return n1 + n2;
    }

    // it didn't have to implement subtract as it's an astract class
}