import java.util.HashMap;

public interface Stock {
    public void addBookToRecords(String ISBN, Book newBook);
    public void searchByAuthor(String Author);
    public void searchByISBN(String ISBN);
    public void searchByGenre(String Genre);
    public void searchByPrice(float upperLimit, float lowerLimit);
    public Book updateBookDetails(String ISBN);
    public void deleteBook(String ISBN);
}
