import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Connection;

public class Main {
    BufferedReader buff;
    InputStreamReader isr;
    String selectOperation,selectField;
    String BookName, BookAuthor, BookISBN,BookGenre;
    float  BookPrice,upperLimit,lowerLimit;
    Stock stock;
    Connection con;
    SQLConnection SQLconnect;

    public Main() {
        if(isr == null) isr = new InputStreamReader(System.in);
        if(buff == null) buff = new BufferedReader(isr);
        SQLconnect = new SQLConnection();
    }

    public static void main(String[] args) {
        Main obj = new Main();
        obj.stock = new Library();
        obj.con = obj.SQLconnect.getConnectionObj();
        if(obj.con==null) {
            System.out.println("Connection Unsuccessful");
        }
        System.out.println("Welcome to Book Store\nPlease enter the type of the operation: \n1. Add Book\n2. Search Book\n3. Update Book Details\n4. Delete a Book");
        obj.selectOperation = obj.takeStringInput(obj.selectOperation);
        switch (obj.selectOperation) {
            case "1":
                obj.addBookToRecordsMain();
                break;
            case "2":
                obj.searchBookMain();
                break;
            case "3":
                obj.updateBookMain();
                break;
            case "4":
                obj.deleteBookMain();
                break;
        }
    }
    public String takeStringInput(String input) {
        try {
            input = buff.readLine();
        }
        catch(IOException e) {
            e.printStackTrace();
        }
        return input;
    }

    public void addBookToRecordsMain() {
        System.out.println("Please enter the Name of the Book:");
        BookName=takeStringInput(BookName);
        System.out.println("Please enter the Author of the Book:");
        BookAuthor=takeStringInput(BookAuthor);
        System.out.println("Please enter the ISBN of the Book:");
        BookISBN=takeStringInput(BookISBN);
        System.out.println("Please enter the Price of the Book:");
        try {
            BookPrice = Float.parseFloat(buff.readLine());
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("Please enter the Genre of the Book:");
        BookGenre=takeStringInput(BookGenre);
        Book newBook = new Book(BookName,BookAuthor,BookISBN,BookPrice,BookGenre);
        stock.addBookToRecords(newBook);
    }

    public void searchBookMain() {
        System.out.println("Please select the field by which you want to search the book:\n1. Author\n2. ISBN\n3. Genre\n4. Price\n5. Name");
            selectField = takeStringInput(selectField);
            switch (selectField) {
                case "1":
                    searchByAuthorMain();
                    break;
                case "2":
                    searchByISBNMain();
                    break;
                case "3":
                    searchByGenreMain();
                    break;
                case "4":
                    searchByPriceMain();
                    break;
                case "5":
                    searchByNameMain();
            }
    }

    public void updateBookMain() {
        String updISBN = null;
        System.out.println("Please enter the ISBN of the book you want to update");
        updISBN = takeStringInput(updISBN);
        stock.updateBookDetails(updISBN);
    }
    public void deleteBookMain() {
        String delISBN = null;
        System.out.println("Please enter the ISBN of the book you want to delete");
        delISBN = takeStringInput(delISBN);
        stock.deleteBook(delISBN);
    }
    public void searchByNameMain() {
        String name="";
        System.out.println("Please enter the name of the Book:");
        name=takeStringInput(name);
        stock.searchByName(name);
    }
    public void searchByAuthorMain() {
        String author = "";
        System.out.println("Please enter the name of the Author:");
        author = takeStringInput(author);
        stock.searchByAuthor(author);

    }
    public void searchByISBNMain() {
        String ISBN="";
        System.out.println("Please enter the name of the ISBN:");
        ISBN = takeStringInput(ISBN);
        stock.searchByISBN(ISBN);
    }
    public void searchByGenreMain() {
        String Genre="";
        System.out.println("Please enter the name of the Genre");
        Genre = takeStringInput(Genre);
        stock.searchByGenre(Genre);
    }
    public void searchByPriceMain() {
        System.out.println("Please enter the price range (Upper Limit/Lower Limit)");
        try {
            upperLimit = Float.parseFloat(buff.readLine());
            lowerLimit = Float.parseFloat(buff.readLine());
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        stock.searchByPrice(upperLimit,lowerLimit);
    }
}