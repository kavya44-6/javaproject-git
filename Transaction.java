import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

class Transaction {

    void deposit(int accNo, double amt) {

        try {

            Connection con =
                DBConnection.getConnection();

            String query =
                "UPDATE accounts " +
                "SET balance = balance + ? " +
                "WHERE acc_no = ?";

            PreparedStatement ps =
                con.prepareStatement(query);

            ps.setDouble(1, amt);
            ps.setInt(2, accNo);

            int rows = ps.executeUpdate();

            if(rows > 0)
                System.out.println("Amount Deposited");
            else
                System.out.println("Account Not Found");

            con.close();

        } catch(Exception e) {

            System.out.println(e);
        }
    }

    void withdraw(int accNo, double amt) {

        try {

            Connection con =
                DBConnection.getConnection();

            String checkQuery =
                "SELECT balance FROM accounts " +
                "WHERE acc_no = ?";

            PreparedStatement checkPs =
                con.prepareStatement(checkQuery);

            checkPs.setInt(1, accNo);

            ResultSet rs =
                checkPs.executeQuery();

            if(rs.next()) {

                double balance =
                    rs.getDouble("balance");

                if(amt <= balance) {

                    String updateQuery =
                        "UPDATE accounts " +
                        "SET balance = balance - ? " +
                        "WHERE acc_no = ?";

                    PreparedStatement updatePs =
                        con.prepareStatement(updateQuery);

                    updatePs.setDouble(1, amt);
                    updatePs.setInt(2, accNo);

                    updatePs.executeUpdate();

                    System.out.println(
                        "Amount Withdrawn"
                    );

                } else {

                    System.out.println(
                        "Insufficient Balance"
                    );
                }

            } else {

                System.out.println(
                    "Account Not Found"
                );
            }

            con.close();

        } catch(Exception e) {

            System.out.println(e);
        }
    }
}