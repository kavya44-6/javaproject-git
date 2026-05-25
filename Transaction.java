class Transaction{
void deposit(Account a,double amt){
a.balance+=amt;
System.out.println("Amount Deposited");
}
void withdraw(Account a,double amt){
if(amt<=a.balance){
a.balance-=amt;
System.out.println("Amount Withdrawn");
}
else{
System.out.println("Insufficient Balance");
}
}
}