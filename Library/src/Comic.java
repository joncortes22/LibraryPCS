public class Comic extends Book {
    private String hero;

    public Comic(String name, Author author, String publishDate, String feature, String genre, Boolean availability, String heroe) {
        super(name, author, publishDate, feature, genre, availability);
        this.hero = heroe;
    }

    public String getHero() {
        return hero;
    }
}
