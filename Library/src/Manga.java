public class Manga extends Book {
    private String language;

    public Manga(String name, Author author, String publishDate, Boolean availability, String language) {
        super(name, author, publishDate, availability);
        this.language = language;
    }
}
