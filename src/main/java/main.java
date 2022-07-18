import java.util.UUID;
import java.sql.*;

public class main {
    public static void main(String[] args)
    {

        Connection con = null;
        PreparedStatement stm = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://127.0.0.1/dbtest", "root", "root");
            con.setAutoCommit(false);
            String query = "INSERT INTO reservations(id,check_in_date,check_out_date,status) values(?,?,?,?)";
            stm = con.prepareStatement(query);
            String uuid = UUID.randomUUID().toString();
            stm.setString(1,uuid);
            stm.setString(2,"2022-12-12");
            stm.setString(3,"2022-12-11");
            stm.setString(4,"holdd");
            stm.execute();
            String query1 = "INSERT INTO guests(id,reservation_id,first_name,last_name) values(?,?,?,?)";


            stm = con.prepareStatement(query1);
            stm.setString(1,"122");
            stm.setString(2,uuid);
            stm.setString(3,"hussain");
            stm.setString(4,"attique");
            stm.execute();
            con.commit();
        }   catch (Exception throwables) {
            throwables.printStackTrace();
        }


    }
}
