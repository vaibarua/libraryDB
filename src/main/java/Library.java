import java.util.HashMap;

public class Library implements Stock {

    private HashMap<String,Book> records;

    @Override
    public void addBookToRecords(String ISBN, Book newBook) {
        records.put(ISBN,newBook);
    }

    @Override
    public void searchByAuthor(String Author) {

    }

    @Override
    public void searchByISBN(String ISBN) {

    }

    @Override
    public void searchByGenre(String Genre) {

    }

    @Override
    public void searchByPrice(float upperLimit, float lowerLimit) {

    }

    @Override
    public Book updateBookDetails(String ISBN) {
        return null;
    }

    @Override
    public void deleteBook(String ISBN) {

    }


}
