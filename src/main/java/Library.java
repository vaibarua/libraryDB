import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;

public class Library implements Stock {
    Statement stmt;
    Connection con;
    PreparedStatement pStmt;
    SQLConnection SQLconnect;
    public Library() {
        SQLconnect = new SQLConnection();
    }

    @Override
    public void addBookToRecords(Book newBook) {
        if(newBook==null) System.out.println("Object not passed");
        else System.out.println("Book Name:"+newBook.BookName);
        pStmt = SQLconnect.getPreparedStatement("insert into books values(?,?,?,?,?,?)");
        try {
            pStmt.setString(1,newBook.BookName);
            pStmt.setString(2,newBook.BookAuthor);
            pStmt.setString(3,newBook.BookISBN);
            pStmt.setString(4,newBook.BookGenre);
            pStmt.setFloat(5,newBook.BookPrice);
            pStmt.setString(6,newBook.BookDate);
            pStmt.executeUpdate();
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void searchByAuthor(String Author) {
        ArrayList <String> resBooks = new ArrayList<>();
        pStmt = SQLconnect.getPreparedStatement("select * from books where BookAuthor like ?;");
        try {
            pStmt.setString(1,"%"+Author+"%");
            ResultSet rs = pStmt.executeQuery();
            while(rs.next()) {
                resBooks.add(rs.getString(1));
            }
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println("Results:");
        for(String Book:resBooks) {
            System.out.println(Book);
        }
    }

    @Override
    public void searchByISBN(String ISBN) {
        ArrayList <String> resBooks = new ArrayList<>();
        pStmt = SQLconnect.getPreparedStatement("select * from books where BookISBN = ?;");
        try {
            pStmt.setString(1,ISBN);
            ResultSet rs = pStmt.executeQuery();
            while(rs.next()) {
                resBooks.add(rs.getString(1));
            }
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println("Results:");
        for(String Book:resBooks) {
            System.out.println(Book);
        }
    }

    @Override
    public void searchByGenre(String Genre) {
        ArrayList <String> resBooks = new ArrayList();
        pStmt = SQLconnect.getPreparedStatement("select * from books where BookGenre = ?;");
        try {
            pStmt.setString(1,Genre);
            ResultSet rs = pStmt.executeQuery();
            while(rs.next()) {
                resBooks.add(rs.getString(1));
            }
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println("Results:");
        for(String Book:resBooks) {
            System.out.println(Book);
        }
    }

    @Override
    public void searchByPrice(float upperLimit, float lowerLimit) {
        ArrayList <String> resBooks = new ArrayList();
        pStmt = SQLconnect.getPreparedStatement("select * from books where BookPrice >= ? and BookPrice <= ?;");
        try {
            pStmt.setFloat(1,lowerLimit);
            pStmt.setFloat(2,upperLimit);
            ResultSet rs = pStmt.executeQuery();
            while (rs.next()) {
                resBooks.add(rs.getString(1));
            }
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println("Results:");
        for(String Book:resBooks) {
            System.out.println(Book);
        }
    }

    @Override
    public void searchByName(String name) {
        ArrayList <String> resBooks = new ArrayList<>();
        pStmt = SQLconnect.getPreparedStatement("select * from books where BookName like ?;");
        try {
            pStmt.setString(1,"%"+name+"%");
            ResultSet rs = pStmt.executeQuery();
            while(rs.next()) {
                resBooks.add(rs.getString(1));
            }
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println("Results:");
        for(String Book:resBooks) {
            System.out.println(Book);
        }
    }

    @Override
    public void updateBookDetails(String ISBN) {
        String newName=null,newAuthor=null,newGenre=null;
        float newPrice=0.0F;
        Main obj = new Main();
        System.out.println("Enter the updated Book Name");
        newName = obj.takeStringInput(newName);
        System.out.println("Enter the updated Book Author");
        newAuthor = obj.takeStringInput(newAuthor);
        System.out.println("Enter the updated Book Price");
        try {
            newPrice = Float.parseFloat(obj.buff.readLine());
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("Enter the updated Book Genre");
        newGenre = obj.takeStringInput(newGenre);
        pStmt = SQLconnect.getPreparedStatement("update books " +
                "set "+
                "BookName = coalesce(?,BookName)," +
                "BookAuthor = coalesce(?,BookAuthor)," +
                "BookPrice = coalesce(?,BookPrice)," +
                "BookGenre = coalesce(?,BookGenre) " +
                "where BookISBN = ?");
        try {
            pStmt.setString(1,newName);
            pStmt.setString(2,newAuthor);
            pStmt.setFloat(3,newPrice);
            pStmt.setString(4,newGenre);
            pStmt.setString(5,ISBN);
            pStmt.executeUpdate();
        }
        catch(SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteBook(String ISBN) {
        pStmt = SQLconnect.getPreparedStatement("delete from books where BookISBN = ?");
        try {
            pStmt.setString(1,ISBN);
            pStmt.executeUpdate();
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void cheapestAndCostliestBook() {
        pStmt = SQLconnect.getPreparedStatement("select BookName,\n" +
                "       BookPrice,\n" +
                "       case\n" +
                "           when BookPrice = (select MAX(BookPrice) FROM books) then 'Costliest'\n" +
                "           when BookPrice = (select MIN(BookPrice) FROM books) then 'Cheapest'\n" +
                "           else 'Unknown'\n" +
                "       end AS PriceCategory\n" +
                "from books\n" +
                "where BookPrice = (select MAX(BookPrice) from books)\n" +
                "   or BookPrice = (select MIN(BookPrice) from books);\n");
        try {
            ResultSet rs = pStmt.executeQuery();
            while(rs.next()) {
                String bookTitle = rs.getString("BookName");
                double bookPrice = rs.getDouble("BookPrice");
                String priceCategory = rs.getString("PriceCategory");

                System.out.println(priceCategory + " Book");
                System.out.println("BookTitle: " + bookTitle);
                System.out.println("BookPrice: " + bookPrice);
                System.out.println("------------------------");
            }
        }
        catch (SQLException e){
            e.printStackTrace();
        }

    }

    @Override
    public void deleteOldBooks() {
        ArrayList <String> resBooks = new ArrayList<>();
        stmt = SQLconnect.getStatement();
        try{
            ResultSet rs = stmt.executeQuery("select * from books where (CURDATE()-BookDate)>=730");
            while (rs.next()) {
                resBooks.add(rs.getString(1));
            }
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println("Books whose Published Dates are over 2 years old:");
        for(String Book:resBooks) {
            System.out.println(Book);
        }
        stmt = SQLconnect.getStatement();
        try {
            stmt.executeUpdate("delete from books where (CURDATE()-BookDate)>=730");
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println("Successfully Deleted.");
    }


}
