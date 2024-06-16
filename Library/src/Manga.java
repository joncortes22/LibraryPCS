public class Manga extends Book {
    private String language;

    public Manga(String name, Author author, String publishDate, String feature, String genre, Boolean availability, String language) {
        super(name, author, publishDate, feature, genre, availability);
        this.language = language;
    }

    public String getLanguage() {
        return language;
    }
}
