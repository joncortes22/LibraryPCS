import java.util.ArrayList;

public class Main {

    public static ArrayList<Book> bookList = new ArrayList<Book>();
    public static ArrayList<Author> authorList = new ArrayList<Author>();
    public static ArrayList<User> userList = new ArrayList<User>();
    public static ArrayList<Loan> loanList = new ArrayList<Loan>();

    public static void main(String[] args) {
        Author author = new Author("Jonathan", "Cortes", "Costarican", "22/11/2003");
        authorList.add(author);
        Manga book = new Manga("Test", author, "22/22", "Language", "Manga", true, "Chinese");
        bookList.add(book);
        MyFrame mainWin = new MyFrame("Library", 655, 420, "main");

        // Make the frame visible

    }
}