public class BookStoreImpl {
    public static void main(String[] args) {
        BookStore bookStore = new BookStore();
        Book book = new Book(3121,"Mocking Bird","Fiction","JL Baird",300);

        //book.acceptBookDetails();
        book.displayBookDetails();
        float discount = 25;
        System.out.println("The discounted price on "+book.bookName+" is"+bookStore.calculateDiscount(book, discount));
    }
}
