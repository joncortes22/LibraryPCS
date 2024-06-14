public class Science extends Book {
    private String field;

    public Science(String name, Author author, String publishDate, Boolean availability, String field) {
        super(name, author, publishDate, availability);
        this.field = field;
    }
}
