import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Main {
    static Book book1 = new Book("Intelligent Investor", "Benjamin Graham", "38763362653");
    static Book book2 = new Book("Bible", "Moses", "87456788");
    static Book book3 = new Book("Witcher Blood of Elves", "Andrzej Sapkowski", "986547765");
    static Book book4 = new Book("1984", "George Orwell", "123456789");
    static Book book5 = new Book("To Kill a Mockingbird", "Harper Lee", "987654321");
    static Book book6 = new Book("Dune", "Frank Herbert", "456789123");
    static Book book7 = new Book("The Hobbit", "J.R.R. Tolkien", "789123456");
    static Book book8 = new Book("The Catcher in the Rye", "J.D. Salinger", "654321987");
    static Book book9 = new Book("Pride and Prejudice", "Jane Austen", "321987654");
    static Ebook ebook1 = new Ebook("Cyberpunk2076", "John Mnemonic", "5896432345", 1.57);
    static Ebook ebook2 = new Ebook("1984", "George Orwell", "8753973453", 21.54);
    static Audiobook audiobook1 = new Audiobook("Waterfall", "Joanne Deare", "1234765433", 7.24, 4.5);
    static Audiobook audiobook2 = new Audiobook("Stargazing", "Travis Stock", "8765445678", 6.95, 4.2);

    static LibraryUser user0 = new LibraryUser("Select User", "");
    static LibraryUser user1 = new LibraryUser("Mariusz Kowalczyk", " 6574");
    static LibraryUser user2 = new LibraryUser("Anna Piechocka", " 3475");
    static LibraryUser user3 = new LibraryUser("Robert Makrewicz", " 9811");

    static LibraryUser[] users = {user1, user2, user3};
    static LibraryItem[] items = {
            book1, book2, book3, book4, book5, book6, book7, book8, book9,
            ebook1, ebook2, audiobook1, audiobook2
    };

    public static String[] getUserNames(LibraryUser[] users) {
        String[] userNames = new String[users.length];
        for (int i = 0; i < users.length; i++) {
            userNames[i] = users[i].getName();
        }
        return userNames;
    }


    public static Book readBookFile(String fileName) {
        try {
            File book = new File(fileName); //initializing File book
            Scanner reader = new Scanner(book);

            String title = reader.nextLine(); //using scanner to getline
            String author = reader.nextLine();
            String isbn = reader.nextLine();

            return new Book(title, author, isbn); //we return an Book object


        } catch (IOException e) { //if any error occurs, we get a message
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
            double fileSizeMB = Double.parseDouble(reader.nextLine()); // the txt file contains a string, so we need to parse it to double to be useful

            return new Ebook(title, author, isbn, fileSizeMB);


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

            return new Audiobook(title, author, isbn, fileSizeMB, duration);


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

            return new LibraryUser(name, userId);


        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }


    public static void main(String[] args) {
        new Gui();
    }
}