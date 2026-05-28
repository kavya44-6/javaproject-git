import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
class Bank {
    void details(int accNo) {
        try {
            Connection con = DBConnection.getConnection();
            String query =  "SELECT * FROM accounts WHERE acc_no = ?";
            PreparedStatement ps = con.prepareStatement(query);
            ps.setInt(1, accNo);
            ResultSet rs =  ps.executeQuery();
            if(rs.next()) {
                System.out.println(  "\nName: " + rs.getString("name")  );
                System.out.println(  "Account No: " +rs.getInt("acc_no"));
                System.out.println("Balance: " +rs.getDouble("balance"));
            } else {
                System.out.println("Account Not Found");
            }
            con.close();
        } catch(Exception e) {
            System.out.println(e);
        }
    }
}