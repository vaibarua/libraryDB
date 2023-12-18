import java.sql.SQLException;
import java.util.HashMap;

public interface Stock {
    public void addBookToRecords(Book newBook);
    public void searchByAuthor(String Author);
    public void searchByISBN(String ISBN);
    public void searchByGenre(String Genre);
    public void searchByPrice(float upperLimit, float lowerLimit);
    public void searchByName(String name);
    public void updateBookDetails(String ISBN);
    public void deleteBook(String ISBN);
    public void cheapestAndCostliestBook();
    public void deleteOldBooks();
}
