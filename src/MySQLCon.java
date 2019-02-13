import java.sql.*;

class MySQLCon {
    public static void main(String args[]) {
        try {
            //Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "root","");
            //here the big URL-ish thing after the // is the database name, then username and password
            Connection con = DriverManager.getConnection("jdbc:mysql://db773397590.hosting-data.io:3306/db773397590", "dbo773397590","HCIMMMm!0");

            //Creates a statement
            Statement stmt = con.createStatement();
            //Executes statement
            stmt.executeUpdate("insert into users (first,last) VALUES ('Jack','McBride')");
            //New statement
            Statement stmt1 = con.createStatement();
            //New Result
            ResultSet rs1 = stmt1.executeQuery("select * from users");

            while (rs1.next())
                System.out.println(rs1.getString(1) + "  " + rs1.getString(2));

            con.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}