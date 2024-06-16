public class Comic extends Book {
    private String heroe;

    public Comic(String name, Author author, String publishDate, String feature, String genre, Boolean availability, String heroe) {
        super(name, author, publishDate, feature, genre, availability);
        this.heroe = heroe;
    }

    public String getHeroe() {
        return heroe;
    }
}
