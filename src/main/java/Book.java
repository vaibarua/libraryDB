public class Book {
    String BookName, BookAuthor, BookISBN, BookGenre, BookDate;
    float BookPrice;
    public Book(String BookName, String BookAuthor, String BookISBN, float BookPrice,String BookGenre,String BookDate) {
        this.BookName = BookName;
        this.BookAuthor = BookAuthor;
        this.BookISBN = BookISBN;
        this.BookPrice = BookPrice;
        this.BookGenre = BookGenre;
        this.BookDate = BookDate;
    }
    public String getBookAuthor() {return BookAuthor;}
    public String getBookName() {return BookName;}
    public String getBookISBN() {return BookISBN;}
    public float getBookPrice() {return BookPrice;}
    public String getBookGenre() {return BookGenre;}
    public String getBookDate() {return BookDate;}

    public void setBookPrice(float BookPrice) {this.BookPrice = BookPrice;}
    public void setBookAuthor(String BookAuthor) {this.BookAuthor = BookAuthor;}
    public void setBookISBN(String BookISBN) {this.BookISBN = BookISBN;}
    public void setBookName(String BookName) {this.BookName = BookName;}
    public void setBookDate(String BookDate) {this.BookDate = BookDate;}
}
