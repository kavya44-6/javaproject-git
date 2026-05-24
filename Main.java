class Main{

public static void main(String args[]){

LibraryController controller=
new LibraryController(10);

LibraryView view=
new LibraryView();

controller.addBook(1,"Java");

controller.addBook(2,"Python");

controller.addBook(3,"C Programming");

while(true){

view.showMenu();

int choice=
view.getChoice();

switch(choice){

case 1:

view.displayBooks(

controller.getBooks(),

controller.getCount()

);

break;

case 2:

String search=

view.getTitle(

"Enter title:"

);

if(

controller.findBook(search)

!=null

)

view.showMessage(

"Book Found"

);

else

view.showMessage(

"Book Not Found"

);

break;

case 3:

String issue=

view.getTitle(

"Enter title:"

);

view.showMessage(

controller.issueBook(issue)

);

break;

case 4:

String ret=

view.getTitle(

"Enter title:"

);

view.showMessage(

controller.returnBook(ret)

);

break;

case 5:

System.out.println(

"Exiting..."

);

return;

default:

System.out.println(

"Invalid Choice"

);

}

}

}

}