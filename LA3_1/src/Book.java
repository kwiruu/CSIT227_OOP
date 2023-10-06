public class Book {

        String title;
        String author;
        String publisher;
        boolean isAvailable;
    public Book(String testTitle, String testAuthor, String testPublisher) {
            this.title = testTitle;
            this.author = testAuthor;
            this.publisher = testPublisher;
            this.isAvailable = true;
    }

    public void displayInfo(){
        System.out.println("Title: "+ title);
        System.out.println("Author: "+ author);
        System.out.println("Publisher: "+ publisher);
    }

    public void borrow(){
        isAvailable = false;
    }
    public void returnBook(){
        isAvailable = true;
    }


}
