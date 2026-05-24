import java.util.Scanner;

class LibraryView{

Scanner sc=new Scanner(System.in);

void showMenu(){

System.out.println("\n---Library Menu---");

System.out.println("1.Display Books");

System.out.println("2.Search Book");

System.out.println("3.Issue Book");

System.out.println("4.Return Book");

System.out.println("5.Exit");

}

int getChoice(){

System.out.print("Enter choice:");

return sc.nextInt();

}

String getTitle(String msg){

sc.nextLine();

System.out.print(msg);

return sc.nextLine();

}

void displayBooks(Book books[],int count){

for(int i=0;i<count;i++){

System.out.println(

books[i].id+

" - "+

books[i].title+

" - "+

(books[i].issued?

"Issued":"Available")

);

}

}

void showMessage(String msg){

System.out.println(msg);

}

}