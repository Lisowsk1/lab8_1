import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class LibraryUser  {
    private String name;
    private String userId;
    private ArrayList<LibraryItem> borrowedBooks = new ArrayList<>();
    private ArrayList<LibraryItem> historicalBorrowedBooks = new ArrayList<>();


    public LibraryUser(String name, String userId) {
        this.name = name;
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public ArrayList<LibraryItem> getBorrowedBook() {
        return borrowedBooks;
    }

    public void addBorrowedBook(LibraryItem book) {
        borrowedBooks.addFirst(book);
    }

    public void removeBorrowedBook(LibraryItem book) {
        borrowedBooks.remove(book);
    }

    public void borrowBook(LibraryItem book) {
        if (book.isAvailable()) {
            borrowedBooks.add(book);
            historicalBorrowedBooks.add(book);
        }
        book.borrow();
    }


    public void returnBook(LibraryItem book) {
        if (!book.isAvailable())
            borrowedBooks.remove(book);
        book.returnBook();
    }
    public boolean isAvailable(Book book){
        return book.isAvailable();
    }

    public boolean hasBorrowed(LibraryItem book) {
        return borrowedBooks.contains(book);
    }

    public void displayBorrowedBooks() {
        System.out.println("Borrowed books:");
        for (LibraryItem borrowedbook : borrowedBooks) {
            System.out.println(borrowedbook.getTitle());
        }
    }

    public ArrayList<LibraryItem> getHistoricalBorrowedBooks() {
        return historicalBorrowedBooks;
    }

    public void setHistoricalBorrowedBooks(ArrayList<LibraryItem> historicalBorrowedBooks) {
        this.historicalBorrowedBooks = historicalBorrowedBooks;
    }

    public void displayHistoricallyBorrowedBooks() {
        System.out.println("Historically borrowed books:");
        for (LibraryItem historicalBorrowedBook : historicalBorrowedBooks) {
            System.out.println(historicalBorrowedBook.getTitle());
        }
    }

    public boolean isAudiobook(Object book) {
        if (book instanceof Audiobook)
            return true;
        return false;
    }

    public void displayOnlyAudiobooks() {
        System.out.println("Borrowed audiobooks:");
        for (LibraryItem borrowedBook : borrowedBooks) {
            if (isAudiobook(borrowedBook))
                System.out.println(borrowedBook.getTitle());
        }
    }
    public boolean isEbook(Object book) {
        if (book instanceof Ebook)
            return true;
        return false;
    }

    public void displayOnlyEbooks() {
        System.out.println("Borrowed ebooks:");
        for (LibraryItem borrowedBook : borrowedBooks) {
            if (isEbook(borrowedBook))
                System.out.println(borrowedBook.getTitle());
        }
    }

    public void saveBorrowedBooks(){
          try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(getName()+"borrowedBooks.txt")); //title
              writer.write(getName()+" "+getUserId()+"\n"); //header
            for(int i=0;i<borrowedBooks.size();i++)
            {
                writer.write(borrowedBooks.get(i).getTitle()+"\n"); //we go by every book and save the title into the file
            }
            writer.close(); //closing write to not waste memory we dont use anymore
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public void saveHistoricalBorrowedBooks(){
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(getName()+"historicalBorrowedBooks.txt"));
            writer.write(getName()+" "+getUserId()+"\n");
            for(int i=0;i<historicalBorrowedBooks.size();i++)
            {
                writer.write(historicalBorrowedBooks.get(i).getTitle()+"\n");
            }
            writer.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
