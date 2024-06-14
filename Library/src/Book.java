public abstract class Book {
    private String name;
    private Author author;
    private String publishDate;
    private Boolean availability;

    public Book(String name, Author author, String publishDate, Boolean availability) {
        this.name = name;
        this.author = author;
        this.publishDate = publishDate;
        this.availability = availability;
    }
}
