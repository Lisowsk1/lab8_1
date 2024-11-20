public class Book {
    private String title;
    private String author;
    private String isbn;
    private Boolean isAvailable = true;

    public Book(String title, String author, String isbn) {
        this.title = title;
        this.author = author;
        this.isbn = isbn;
    }


    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public Boolean getAvailable() {
        return isAvailable;
    }

    public void setAvailable(Boolean available) {
        isAvailable = available;
    }


    public void borrow() {
        if (!isAvailable)
            System.out.println("The " + title + " book is already borrowed");
        else
            setAvailable(false);//book has been borrowed
    }

    public void returnBook() {
        if (isAvailable)
            System.out.println("The " + getTitle() + "book is already available");
        else
            setAvailable(true);//book has been returned
    }

    public void displayInfo() {
        System.out.println(getTitle());
        System.out.println(getAuthor());
        System.out.println(getIsbn());
        System.out.println(getAvailable());
    }
}
