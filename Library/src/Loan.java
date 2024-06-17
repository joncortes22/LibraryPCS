public class Loan {
    private User user;
    private Book book;
    private String loanDate;
    private String returnDate;

    public Loan(User user, Book book, String loanDate, String returnDate) {
        this.user = user;
        this.book = book;
        this.loanDate = loanDate;
        this.returnDate = returnDate;
    }

    public User getUser() {
        return user;
    }

    public Book getBook() {
        return book;
    }

    public String getLoanDate() {
        return loanDate;
    }

    public String getReturnDate() {
        return returnDate;
    }
}
