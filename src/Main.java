import java.io.*;
import java.util.Scanner;

public class Main {
    Book book1;
    static Book book2 = new Book("Bible", "Moses", "87456788");
    static Book book3 = new Book("Witcher Blood of Elves", "Andrzej Sapkowski", "986547765");
    Ebook ebook1;
    Audiobook audiobook1;
    LibraryUser user1;

    public static Book readBookFile(String fileName) {
        try {
            File book = new File(fileName);
            Scanner reader = new Scanner(book);

                String title = reader.nextLine();
                String author = reader.nextLine();
                String isbn = reader.nextLine();

               return new Book(title,author,isbn);


        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
    public static Ebook readEbookFile(String fileName) {
        try {
            File book = new File(fileName);
            Scanner reader = new Scanner(book);

            String title = reader.nextLine();
            String author = reader.nextLine();
            String isbn = reader.nextLine();
            double fileSizeMB = Double.parseDouble(reader.nextLine());

            return new Ebook(title,author,isbn,fileSizeMB);


        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
    public static Audiobook readAudiobookFile(String fileName) {
        try {
            File book = new File(fileName);
            Scanner reader = new Scanner(book);

            String title = reader.nextLine();
            String author = reader.nextLine();
            String isbn = reader.nextLine();
            double fileSizeMB = Double.parseDouble(reader.nextLine());
            double duration = Double.parseDouble(reader.nextLine());

            return new Audiobook(title,author,isbn,fileSizeMB,duration);


        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public static LibraryUser readUserFile(String fileName) {
        try {
            File book = new File(fileName);
            Scanner reader = new Scanner(book);

            String name = reader.nextLine();
            String userId = reader.nextLine();

            return new LibraryUser(name,userId);


        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }


    public static void main(String[] args) {

        LibraryUser user1 = readUserFile("userFile1.txt");
        Book book1 = readBookFile("bookFile1.txt");
        Ebook ebook1 = readEbookFile("ebookFile1.txt");
        Audiobook audiobook1 = readAudiobookFile("audiobookFile1.txt");

        user1.borrowBook(book1);
        user1.borrowBook(book2);
        user1.saveBorrowedBooks();
        user1.returnBook(book2);
        user1.borrowBook(book3);
        user1.saveHistoricalBorrowedBooks();

    }
}