public interface LibraryItem {
    public void displayInfo();

    public boolean isAvailable();

    public void borrow();

    public void returnBook();

    public String getTitle();

    public String getAuthor();
}
