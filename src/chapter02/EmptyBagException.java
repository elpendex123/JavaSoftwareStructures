package chapter02;

public class EmptyBagException extends Exception {
    public EmptyBagException()
    {
        super("The bag is empty");
    }

    public EmptyBagException (String message)
    {
        super (message);
    }
}
