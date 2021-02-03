public class BookStore {
   String bookStoreName;
   Book [] books;
   
   float calculateDiscount(Book book,float discountPercentage)
   {
       float cost = book.getPrice();
       return cost-(cost*discountPercentage/100);
   }
}
