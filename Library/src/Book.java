public abstract class Book {
    private String name;
    private Author author;
    private String publishDate;
    private String feature;

    private String genre;
    private Boolean availability;

    public Book(String name, Author author, String publishDate, String feature, String genre, Boolean availability) {
        this.name = name;
        this.author = author;
        this.publishDate = publishDate;
        this.feature = feature;
        this.genre = genre;
        this.availability = availability;
    }

    public String getName() {
        return name;
    }

    public Author getAuthor() {
        return author;
    }

    public String getPublishDate() {
        return publishDate;
    }

    public Boolean getAvailability() {
        return availability;
    }

    public String getFeature() {
        return feature;
    }

    public String getGenre() {
        return genre;
    }
}
