import storepopulate.Product;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DBConnector {

    static final String JDBC_DRIVER = "org.h2.Driver";
    static final String url = "jdbc:h2:~/test";
    static final String user = "sa";
    static final String passwd = "kira300815!";
    static Connection con=null;
    static Statement st= null;

    public static void connection()  {

        try {
           Class.forName(JDBC_DRIVER);
            con = DriverManager.getConnection(url, user, passwd);
            st = con.createStatement();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public static void insertProductTable(int id,Product product) throws SQLException, ClassNotFoundException {
        String query = "INSERT INTO PRODUCT VALUES ("+ id + ", '" + product.getName() + "', " + product.getPrice() + "," + product.getRate() + ");";
        st.executeUpdate(query);


    }
    public static void insertCategoryTable(int id,String categoryName) throws SQLException, ClassNotFoundException {
        String query = "INSERT INTO CATEGORY VALUES ("+ id + ", '"+categoryName+ "');";
        st.executeUpdate(query);


    }
    public static void deleteCategoryTable() throws SQLException, ClassNotFoundException {
        String query = "DELETE FROM CATEGORY";
        st.executeUpdate(query);


    }
    public static void deleteProductTable() throws SQLException, ClassNotFoundException {
        String query = "DELETE FROM PRODUCT";
        st.executeUpdate(query);


    }

    public static void closeConnection()  {
        try {
            con.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
