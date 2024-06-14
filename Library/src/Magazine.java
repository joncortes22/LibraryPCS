public class Magazine extends Book {
    private String category;

    public Magazine(String name, Author author, String publishDate, Boolean availability, String category) {
        super(name, author, publishDate, availability);
        this.category = category;
    }
}
