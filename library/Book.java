package library;

public class Book 
{
    private String name;
    private final int numberOfPages;
    private float price;
    
    public Book(int pages)
    {
        numberOfPages = pages;
    }
    public Book(String name, int pages)
    {
        this.name = name;
        this.numberOfPages = pages;
    }
    public Book(String name, int pages, float price)
    {
        this.name = name;
        this.numberOfPages = pages;
        this.price = price;
    }

    public int getNumberOfPages() 
    {
        return numberOfPages;
    }
    public void setName(String name)
    {
        this.name = name;
    }
    public String getName()
    {
        return name;
    }
    public void setPrice(float price)
    {
        this.price = price;
    }
    public float getPrice()
    {
        return price;
    }
}
