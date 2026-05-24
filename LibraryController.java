class LibraryController{

Book books[];
int count;

LibraryController(int size){

books=new Book[size];
count=0;

}

void addBook(int id,String title){

books[count]=new Book(id,title);

count++;

}

Book[] getBooks(){

return books;

}

int getCount(){

return count;

}

Book findBook(String title){

for(int i=0;i<count;i++){

if(books[i].title.equalsIgnoreCase(title))

return books[i];

}

return null;

}

String issueBook(String title){

Book b=findBook(title);

if(b==null)

return "Book Not Found";

if(!b.issued){

b.issued=true;

return "Book Issued Successfully";

}

return "Book Already Issued";

}

String returnBook(String title){

Book b=findBook(title);

if(b==null)

return "Book Not Found";

if(b.issued){

b.issued=false;

return "Book Returned Successfully";

}

return "Book was not issued";

}

}