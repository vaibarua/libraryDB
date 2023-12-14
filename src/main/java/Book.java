public class Book {
    String BookName, BookAuthor, BookISBN, BookPrice,BookGenre;
    public Book(String BookName, String BookAuthor, String BookISBN, String BookPrice,String BookGenre) {
        this.BookName = BookName;
        this.BookAuthor = BookAuthor;
        this.BookISBN = BookISBN;
        this.BookPrice = BookPrice;
        this.BookGenre = BookGenre;
    }
    public String getBookAuthor() {return BookName;}

    public void setBookPrice(String BookPrice) {this.BookPrice = BookPrice;}
    public void setBookAuthor(String BookAuthor) {this.BookAuthor = BookAuthor;}
    public void setBookISBN(String BookISBN) {this.BookISBN = BookISBN;}
    public void setBookName(String BookName) {this.BookName = BookName;}

}
