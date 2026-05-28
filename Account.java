class Account {

    String name;
    int accNo;
    double balance;

    Account(String n, int a, double b) {

        name = n;
        accNo = a;
        balance = b;
    }

    void show() {

        System.out.println("\nName: " + name);
        System.out.println("Account No: " + accNo);
        System.out.println("Balance: " + balance);
    }
}