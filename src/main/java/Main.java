import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    BufferedReader buff;
    InputStreamReader isr;
    String selectOperation,selectField;
    String BookName, BookAuthor, BookISBN, BookPrice;
    Stock stock;

    public Main() {
        if(isr == null) isr = new InputStreamReader(System.in);
        if(buff == null) buff = new BufferedReader(isr);
    }

    public static void main(String[] args) {
        Main obj = new Main();
        System.out.println("Welcome to Book Store\nPlease enter the type of the operation: \n1. Add Book\n2. Search Book\n3. Update Book Details\n4. Delete a Book");
        obj.selectOperation = obj.takeStringInput(obj.selectOperation);
        switch(obj.selectOperation) {
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
//        if(obj.selectOperation.equals("1")) {
//            obj.addBookToRecordsMain();
//        }
//        else if(obj.selectOperation.equals("2")) {
//            System.out.println("Please select the field by which you want to search the book:\n1. Author\n2. ISBN\n3. Genre\n4. Price");
//            obj.selectField = obj.takeStringInput(obj.selectField);
//            switch (obj.selectField) {
//                case "1":
//                    obj.searchByAuthorMain();
//                    break;
//                case "2":
//                    obj.searchByISBNMain();
//                    break;
//                case "3":
//                    obj.searchByGenreMain();
//                    break;
//                case "4":
//                    obj.searchByPriceMain();
//                    break;
//            }
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

    public Book addBookToRecordsMain() {
        System.out.println("Please enter the Name of the Book:");
        BookName=takeStringInput(BookName);
        System.out.println("Please enter the Author of the Book:");
        BookAuthor=takeStringInput(BookAuthor);
        System.out.println("Please enter the ISBN of the Book:");
        BookISBN=takeStringInput(BookISBN);
        System.out.println("Please enter the Price of the Book:");
        BookPrice=takeStringInput(BookPrice);
        return new Book(BookName,BookAuthor,BookISBN,BookPrice,BookGenre);
    }
    public void searchByAuthorMain() {
        String author = "";
        System.out.println("Please enter the name of the Author:");
        author = takeStringInput(author);

    }
    public void searchByISBNMain() {
        String ISBN="";
        System.out.println("Please enter the name of the ISBN:");
        ISBN = takeStringInput(ISBN);
    }
    public void searchByGenreMain() {
        String Genre="";
        System.out.println("Please enter the name of the Genre");
        Genre = takeStringInput(Genre);
    }
    public void searchByPriceMain() {
        float upperLimit,lowerLimit;
        System.out.println("Please enter the price range");
        try {
            upperLimit = Float.parseFloat(buff.readLine());
            lowerLimit = Float.parseFloat(buff.readLine());
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
}