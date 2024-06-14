public class Literature extends Book {
    private String genre;

    public Literature(String name, Author author, String publishDate, Boolean availability, String genre) {
        super(name, author, publishDate, availability);
        this.genre = genre;
    }
}
