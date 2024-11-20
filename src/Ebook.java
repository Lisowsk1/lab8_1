class Ebook extends Book {
    private double fileSizeMB;


    public Ebook(String title, String author, String isbn, double fileSizeMB) {
        super(title, author, isbn);
        this.fileSizeMB = fileSizeMB;

    }

    public double getFileSizeMB() {
        return fileSizeMB;
    }

    public void setFileSizeMB(double fileSizeMB) {
        this.fileSizeMB = fileSizeMB;
    }

    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println(getFileSizeMB());
    }
}
