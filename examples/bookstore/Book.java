import java.util.Scanner;

public class Book
{
    int ISBNNo;
    String bookName;
    String genre;
    String authorName;
    float price;
    Book()
    {
        // initial values to my variables
        
    }
    public Book(int ISBNNo, String bookName, String genre, String authorName, float price) {
        this.ISBNNo = ISBNNo;
        this.bookName = bookName;
        this.genre = genre;
        this.authorName = authorName;
        this.price = price;
    }
    
    void acceptBookDetails()
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Book ISBNNO : ");
        ISBNNo = sc.nextInt();
        System.out.println("Enter Book Name : ");
        bookName = sc.next();
        System.out.println("Enter Genre : ");
        genre = sc.next();
        System.out.println("Enter Author Name : ");
        authorName = sc.next();
        System.out.println("Enter Price : ");
        price = sc.nextFloat();
    }

    void displayBookDetails()
    {
        System.out.println(ISBNNo+" "+bookName+" "+genre+" "+authorName+" "+price);
    }

    float getPrice()
    {
        return price;
    }

    
}