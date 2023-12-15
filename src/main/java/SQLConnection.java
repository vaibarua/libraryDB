import java.sql.*;

public class SQLConnection {
    Connection con;
    Statement stmt;
    PreparedStatement pStmt;
    private void connectionMain(){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/librarydb","root","@Travisscott1");
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
    public Connection getConnectionObj() {
        if(con == null)
        {
            connectionMain();
        }
        return con;
    }

    public Statement getStatement() {
        if(con == null) connectionMain();
        try {
            stmt = con.createStatement();
        }
        catch(SQLException e) {
            e.printStackTrace();
        }
        return stmt;
    }
    public PreparedStatement getPreparedStatement(String query) {
        if(con == null) connectionMain();
        try {
            pStmt = con.prepareStatement(query);
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        return pStmt;
    }

}
