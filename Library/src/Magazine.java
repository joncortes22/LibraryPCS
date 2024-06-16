public class Magazine extends Book {
    private String category;

    public Magazine(String name, Author author, String publishDate, String feature, String genre, Boolean availability, String category) {
        super(name, author, publishDate, feature, genre, availability);
        this.category = category;
    }

    public String getCategory() {
        return category;
    }
}
