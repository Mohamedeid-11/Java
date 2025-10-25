package library;

public class Author {
    private final String name;
    private Book[] books = new Book[3];

    public Author(String name)
    {
        this.name = name;
    }
    public String getName()
    {
        return name;
    }

    public void addBook(Book book, int idx)
    {
        books[idx] = book;
    }
    public Book searchBook(String name)
    {
        for (Book book : books) {
            if(book.getName().equals(name)) 
                return book;
        }
        return null;
    }
    public void displayBooksData()
    {
        System.out.println(name + " Books data:");
        int idx = 1;
        for(Book book : books)
        {
            System.out.printf("\t%d. %s:" + '\n', idx++, book.getName());
            System.out.println("\t\tNumber of pages: " + book.getNumberOfPages());
            System.out.println("\t\tPrice: " + book.getPrice());
        }
    }
}
