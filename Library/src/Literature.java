public class Literature extends Book {
    private String subGenre;

    public Literature(String name, Author author, String publishDate, String feature, String genre, Boolean availability, String subGenre) {
        super(name, author, publishDate, feature, genre, availability);
        this.subGenre = subGenre;
    }

    public String getSubGenre() {
        return subGenre;
    }
}
