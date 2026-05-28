import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        try {

            System.out.print("Enter Name: ");
            String name = sc.nextLine();

            System.out.print("Enter Account No: ");
            int no = sc.nextInt();

            System.out.print("Enter Balance: ");
            double bal = sc.nextDouble();

            Connection con =
                DBConnection.getConnection();

            String insertQuery =
                "INSERT INTO accounts VALUES (?, ?, ?)";

            PreparedStatement ps =
                con.prepareStatement(insertQuery);

            ps.setInt(1, no);
            ps.setString(2, name);
            ps.setDouble(3, bal);

            ps.executeUpdate();

            System.out.println(
                "Account Created Successfully"
            );

            Transaction t = new Transaction();
            Bank b = new Bank();

            int ch;

            do {

                System.out.println("\n1.Deposit");
                System.out.println("2.Withdraw");
                System.out.println("3.Check Balance");
                System.out.println("4.Exit");

                System.out.print("Enter Choice: ");

                ch = sc.nextInt();

                switch(ch) {

                    case 1:

                        System.out.print(
                            "Enter Amount: "
                        );

                        double d = sc.nextDouble();

                        t.deposit(no, d);

                        break;

                    case 2:

                        System.out.print(
                            "Enter Amount: "
                        );

                        double w = sc.nextDouble();

                        t.withdraw(no, w);

                        break;

                    case 3:

                        b.details(no);

                        break;

                    case 4:

                        System.out.println(
                            "Thank You"
                        );

                        break;

                    default:

                        System.out.println(
                            "Invalid Choice"
                        );
                }

            } while(ch != 4);

            con.close();

        } catch(Exception e) {

            System.out.println(e);
        }

        sc.close();
    }
}