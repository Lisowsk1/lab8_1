import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class Gui extends JFrame {

    private JComboBox<String> userComboBox;
    private JPanel booksPanel;
    private JCheckBox showBorrowedOnlyCheckBox;
    private JTextField searchField;
    private JButton searchButton;
    private ArrayList<LibraryItem> searchedItems;

    public Gui() {
        setTitle("Librosoft");
        setSize(800, 600);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        JPanel topPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        userComboBox = new JComboBox<>(Main.getUserNames(Main.users));
        userComboBox.addActionListener(e -> updateBookList());
        topPanel.add(userComboBox);

        showBorrowedOnlyCheckBox = new JCheckBox("Show Borrowed Books Only");
        showBorrowedOnlyCheckBox.addActionListener(e -> updateBookList());
        topPanel.add(showBorrowedOnlyCheckBox);
        add(topPanel, BorderLayout.NORTH);

        JPanel searchPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        searchField = new JTextField(20);
        searchButton = new JButton("Search");
        searchButton.addActionListener(e -> Search());
        searchPanel.add(searchField);
        searchPanel.add(searchButton);
        add(searchPanel, BorderLayout.SOUTH);

        booksPanel = new JPanel();
        booksPanel.setLayout(new BoxLayout(booksPanel, BoxLayout.Y_AXIS));
        add(new JScrollPane(booksPanel), BorderLayout.CENTER);

        searchedItems = new ArrayList<>();
        for (LibraryItem item : Main.items) {
            searchedItems.add(item);
        }

        updateBookList();
        setVisible(true);
    }

    public void updateBookList() {
        booksPanel.removeAll();

        int selectedUserIndex = userComboBox.getSelectedIndex();
        LibraryUser selectedUser = Main.users[selectedUserIndex];

        boolean showBorrowedOnly = showBorrowedOnlyCheckBox.isSelected();

        for (LibraryItem item : searchedItems) {
            if (showBorrowedOnly && !selectedUser.hasBorrowed(item)) {
                continue;
            }

            JPanel bookPanel = new JPanel(new BorderLayout());
            bookPanel.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));

            JLabel bookLabel = new JLabel(item.getTitle() + " by " + item.getAuthor());
            bookPanel.add(bookLabel, BorderLayout.WEST);

            JButton borrowButton = new JButton("Borrow");
            JButton returnButton = new JButton("Return");

            borrowButton.setEnabled(item.isAvailable() && !selectedUser.hasBorrowed(item));
            borrowButton.addActionListener(e -> {
                selectedUser.borrowBook(item);
                updateBookList();
            });

            returnButton.setEnabled(selectedUser.hasBorrowed(item));
            returnButton.addActionListener(e -> {
                selectedUser.returnBook(item);
                updateBookList();
            });

            JPanel buttonPanel = new JPanel();
            buttonPanel.setLayout(new FlowLayout(FlowLayout.RIGHT));
            buttonPanel.add(borrowButton);
            buttonPanel.add(returnButton);

            bookPanel.add(buttonPanel, BorderLayout.EAST);
            booksPanel.add(bookPanel);
        }

        booksPanel.revalidate();
        booksPanel.repaint();
    }

    private void Search() {
        String search = searchField.getText().toLowerCase().trim();
        searchedItems.clear();

        for (LibraryItem item : Main.items) {
            if (item.getTitle().toLowerCase().contains(search) || item.getAuthor().toLowerCase().contains(search)) {
                if (!searchedItems.contains(item))
                    searchedItems.add(item);
            }
        }

        updateBookList();
    }
}
