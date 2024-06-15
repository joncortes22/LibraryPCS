public class Author {
    private String name;
    private String lastName;
    private String nationality;
    private String birth;

    public Author(String name, String lastName, String nationality, String birth) {
        this.name = name;
        this.lastName = lastName;
        this.nationality = nationality;
        this.birth = birth;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public String getBirth() {
        return birth;
    }

    public void setBirth(String birth) {
        this.birth = birth;
    }
}
