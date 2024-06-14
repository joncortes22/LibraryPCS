public class Comic extends Book {
    private String heroe;

    public Comic(String name, Author author, String publishDate, Boolean availability, String heroe) {
        super(name, author, publishDate, availability);
        this.heroe = heroe;
    }
}
