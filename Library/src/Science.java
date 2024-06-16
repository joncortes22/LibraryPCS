public class Science extends Book {
    private String field;

    public Science(String name, Author author, String publishDate, String feature, String genre, Boolean availability, String field) {
        super(name, author, publishDate, feature, genre, availability);
        this.field = field;
    }

    public String getField() {
        return field;
    }
}
