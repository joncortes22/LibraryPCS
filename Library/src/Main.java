import java.util.ArrayList;

public class Main {

    public static ArrayList<Book> bookList = new ArrayList<Book>();
    public static ArrayList<Author> authorList = new ArrayList<Author>();
    public static ArrayList<User> userList = new ArrayList<User>();
    public static ArrayList<Loan> loanList = new ArrayList<Loan>();

    public static void main(String[] args) {
        MyFrame mainWin = new MyFrame("Library", 655, 390, "main");
    }
}