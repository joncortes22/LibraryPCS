import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.Objects;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
public class MyFrame extends JFrame {

    public MyFrame(String name, int width, int height, String winCall) {
        setTitle(name);

        setSize(width, height);

        setResizable(false);

        setLayout(null);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        switch (winCall){
            case "main":
                addMainComponents();
                break;
            case "newBook":
                newBook();
                break;
            case "showBook":
                showBook();
                break;
            case "newAuthor":
                newAuthor();
                break;
            case "showAuthor":
                showAuthor();
                break;
            case "newUser":
                newUser();
                break;
            case "showUser":
                showUser();
                break;
            case "newLoan":
                newLoan();
                break;
            case "showLoan":
                showLoan();
                break;
        }
        setVisible(true);
    }

    private void addMainComponents() {

        // Books
        JLabel lblBook = new JLabel("Books");
        lblBook.setBounds(80, 75, 200, 50);

        JButton btnNewBook = new JButton("New Book");
        btnNewBook.setBounds(50, 130, 120, 50);
        addMainListeners(btnNewBook, "winNewBook");

        JButton btnShowBooks = new JButton("Show Books");
        btnShowBooks.setBounds(50, 200, 120, 50);
        addMainListeners(btnShowBooks, "winShowBook");

        // Authors
        JLabel lblAuthors = new JLabel("Authors");
        lblAuthors.setBounds(220, 75, 200, 50);

        JButton btnNewAuthor = new JButton("New Author");
        btnNewAuthor.setBounds(190, 130, 120, 50);
        addMainListeners(btnNewAuthor, "winNewAuthor");

        JButton btnShowAuthors = new JButton("Show Authors");
        btnShowAuthors.setBounds(190, 200, 120, 50);
        addMainListeners(btnShowAuthors, "winShowAuthor");

        // Authors
        JLabel lblUsers = new JLabel("Users");
        lblUsers.setBounds(360, 75, 200, 50);

        JButton btnNewUser = new JButton("New User");
        btnNewUser.setBounds(330, 130, 120, 50);
        addMainListeners(btnNewUser, "winNewUser");

        JButton btnShowUser = new JButton("Show Users");
        btnShowUser.setBounds(330, 200, 120, 50);
        addMainListeners(btnShowUser, "winShowUser");

        // Loans
        JLabel lblLoans = new JLabel("Loans");
        lblLoans.setBounds(500, 75, 200, 50);

        JButton btnNewLoan = new JButton("New Loan");
        btnNewLoan.setBounds(470, 130, 120, 50);
        addMainListeners(btnNewLoan, "winNewLoan");

        JButton btnShowLoans = new JButton("Show Loans");
        btnShowLoans.setBounds(470, 200, 120, 50);
        addMainListeners(btnShowLoans, "winShowLoan");

        // Add the button to the JFrame
        add(lblBook);add(btnNewBook);add(btnShowBooks);
        add(lblAuthors);add(btnNewAuthor);add(btnShowAuthors);
        add(lblUsers);add(btnNewUser);add(btnShowUser);
        add(lblLoans);add(btnNewLoan);add(btnShowLoans);
    }
    private void addMainListeners(JButton button, String section) {
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Call the method when the button is pressed
                setVisible(false);
                switch (section){
                    case "winNewBook":
                        if (Main.authorList.isEmpty()){
                            JOptionPane.showMessageDialog(null,
                                    "No Authores Registered",
                                    "Error",
                                    JOptionPane.ERROR_MESSAGE);
                            setVisible(true);
                        } else{
                            MyFrame fNewBook = new MyFrame("New Book", 450, 500, "newBook");
                        }
                        break;
                    case "winShowBook":
                        if (Main.bookList.isEmpty()){
                            JOptionPane.showMessageDialog(null,
                                    "No Books Registered",
                                    "Error",
                                    JOptionPane.ERROR_MESSAGE);
                            setVisible(true);
                        } else{
                            MyFrame fShowBook = new MyFrame("Books Registered", 450, 520, "showBook");
                        }
                        break;
                    case "winNewAuthor":
                        MyFrame fNewAuthor = new MyFrame("New Author", 450, 420, "newAuthor");
                        break;
                    case "winShowAuthor":
                        if (Main.authorList.isEmpty()){
                            JOptionPane.showMessageDialog(null,
                                    "No Authores Registered",
                                    "Error",
                                    JOptionPane.ERROR_MESSAGE);
                            setVisible(true);
                        } else {
                            MyFrame fShowAuthor = new MyFrame("Show Author", 450, 420, "showAuthor");
                        }
                        break;
                    case "winNewUser":
                        MyFrame fNewUser = new MyFrame("New User", 450, 420, "newUser");
                        break;
                    case "winShowUser":
                        if (Main.userList.isEmpty()){
                            JOptionPane.showMessageDialog(null,
                                    "No Users Registered",
                                    "Error",
                                    JOptionPane.ERROR_MESSAGE);
                            setVisible(true);
                        } else{
                            MyFrame fShowUser = new MyFrame("Show Author", 450, 420, "showUser");
                        }
                        break;
                    case "winNewLoan":
                        if (Main.userList.isEmpty()){
                            JOptionPane.showMessageDialog(null,
                                    "No Users Registered to Loan",
                                    "Error",
                                    JOptionPane.ERROR_MESSAGE);
                            setVisible(true);
                        } else{
                            boolean booksAvailable = false;
                            for (Book book : Main.bookList){
                                if (book.getAvailability()){
                                    booksAvailable = true;
                                    break;
                                }
                            }
                            if (booksAvailable){
                                MyFrame fNewLoan = new MyFrame("New Loan", 450, 400, "newLoan");
                            } else {
                                JOptionPane.showMessageDialog(null,
                                        "No Books Available to Loan",
                                        "Error",
                                        JOptionPane.ERROR_MESSAGE);
                                setVisible(true);
                            }
                        }
                        break;
                    case "winShowLoan":
                        if (Main.loanList.isEmpty()){
                            JOptionPane.showMessageDialog(null,
                                    "No Loans Registered",
                                    "Error",
                                    JOptionPane.ERROR_MESSAGE);
                            setVisible(true);
                        } else{
                            MyFrame fShowLoan = new MyFrame("Show Loan", 450, 420, "showLoan");
                        }
                        break;
                }
            }
        });
    }

    private void newBook() {
        String[] days = new String[31]; String[] months = new String[12]; String[] years = new String[125];
        for (int n = 1; n <= 31; n++){days[n-1] = Integer.toString(n);}
        for (int n = 1; n <= 12; n++){months[n-1] = Integer.toString(n);}
        int counter = 0;
        for (int n = 2024; n >= 1900; n--){years[counter] = Integer.toString(n);counter++;}

        String[] arrAuthors = new String[Main.authorList.size()];

        // Books
        JLabel lblTitle = new JLabel("New Book");
        lblTitle.setBounds(150, 20, 200, 50);

        //Title
        JLabel lblName = new JLabel("Title:");
        lblName.setBounds(60, 70, 200, 50);

        JTextField txtTitle = new JTextField();
        txtTitle.setBounds(150, 80, 200, 30); // (x, y, width, height)

        //Author
        JLabel lblAuthor = new JLabel("Author:");
        lblAuthor.setBounds(60, 120, 200, 50);

        int pos = 0;
        for (Author author : Main.authorList) {
            arrAuthors[pos] = author.getLastName() + ", " + author.getName();
            pos++;
        }
        JComboBox<String> cmbAuthor;
        cmbAuthor = new JComboBox<>(arrAuthors);
        cmbAuthor.setBounds(150, 130, 200, 30);

        //PublishDate
        JLabel lblDate = new JLabel("Publish Date:");
        lblDate.setBounds(60, 170, 200, 50);

        JComboBox<String> cmbDays;
        cmbDays = new JComboBox<>(days);
        cmbDays.setBounds(150, 180, 50, 30);

        JComboBox<String> cmbMonths;
        cmbMonths = new JComboBox<>(months);
        cmbMonths.setBounds(210, 180, 50, 30);

        JComboBox<String> cmbYears;
        cmbYears = new JComboBox<>(years);
        cmbYears.setBounds(270, 180, 80, 30);


        //Specifics
        JLabel lblSpecifics = new JLabel("");
        lblSpecifics.setBounds(60, 270, 200, 50);

        JTextField txtSpecifics = new JTextField();
        txtSpecifics.setBounds(150, 280, 200, 30); // (x, y, width, height)

        //Genre
        JLabel lblGenre = new JLabel("Genre:");
        lblGenre.setBounds(60, 220, 200, 50);

        JComboBox<String> cmbGenre;
        cmbGenre = new JComboBox<>(new String[] { "Magazine", "Manga", "Literature", "Science", "Comic" });
        cmbGenre.setBounds(150, 230, 200, 30);

        cmbGenre.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Method to handle item selection
                String selectedOption = (String) cmbGenre.getSelectedItem();
                String specific = "";
                switch (selectedOption){
                    case "Comic":
                        specific = "Hero: ";
                        break;
                    case "Literature":
                        specific = "Subgenre: ";
                        break;
                    case "Magazine":
                        specific = "Category: ";
                        break;
                    case "Manga":
                        specific = "Language: ";
                        break;
                    case "Science":
                        specific = "Field: ";
                }
                lblSpecifics.setText(specific);
            }
        });

        //Availability
        JLabel lblAvailability = new JLabel("Availability:");
        lblAvailability.setBounds(60, 320, 200, 50);

        JComboBox<String> cmbAvailability;
        cmbAvailability = new JComboBox<>(new String[] { "Yes", "No"});
        cmbAvailability.setBounds(150, 330, 200, 30);

        JButton btnNewBook = new JButton("Create");
        btnNewBook.setBounds(150, 380, 80, 40);
        btnNewBook.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String date = cmbDays.getSelectedItem() + "/" + cmbMonths.getSelectedItem() + "/" + cmbYears.getSelectedItem();
                String genre = (String) cmbGenre.getSelectedItem();
                boolean availability = cmbAvailability.getSelectedItem() != "No";

                if (txtTitle.getText().isEmpty() || txtSpecifics.getText().isEmpty()) {
                    JOptionPane.showMessageDialog(null,
                            "Every field is required",
                            "Error",
                            JOptionPane.ERROR_MESSAGE);
                } else{
                    for (Author author : Main.authorList) {
                        String formattedAuthor = author.getLastName() + ", " + author.getName();
                        if (formattedAuthor.equals((String) cmbAuthor.getSelectedItem())){
                            switch (genre){
                                case "Comic":
                                    Comic comic = new Comic(txtTitle.getText(), author, date, lblSpecifics.getText(), genre, availability, txtSpecifics.getText());
                                    Main.bookList.add(comic);
                                    break;
                                case "Literature":
                                    Literature literature = new Literature(txtTitle.getText(), author, date, lblSpecifics.getText(), genre, availability, txtSpecifics.getText());
                                    Main.bookList.add(literature);
                                    break;
                                case "Magazine":
                                    Magazine magazine = new Magazine(txtTitle.getText(), author, date, lblSpecifics.getText(), genre, availability, txtSpecifics.getText());
                                    Main.bookList.add(magazine);
                                    break;
                                case "Manga":
                                    Manga manga = new Manga(txtTitle.getText(), author, date, lblSpecifics.getText(), genre, availability, txtSpecifics.getText());
                                    Main.bookList.add(manga);
                                    break;
                                case "Science":
                                    Science science = new Science(txtTitle.getText(), author, date, lblSpecifics.getText(), genre, availability, txtSpecifics.getText());
                                    Main.bookList.add(science);
                                    break;
                            }
                            JOptionPane.showMessageDialog(null,
                                    "Book Has been Registered",
                                    "Success",
                                    JOptionPane.INFORMATION_MESSAGE);
                            txtTitle.setText("");
                            lblSpecifics.setText("");
                            txtSpecifics.setText("");
                            cmbGenre.setSelectedIndex(0);
                            cmbAuthor.setSelectedIndex(0);
                            cmbDays.setSelectedIndex(0);
                            cmbMonths.setSelectedIndex(0);
                            cmbYears.setSelectedIndex(0);
                            cmbAvailability.setSelectedIndex(0);
                        }
                    }
                }
            }
        });

        JButton btnBack = new JButton("Cancel");
        btnBack.setBounds(250, 380, 80, 40);

        btnBack.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                MyFrame mainWin = new MyFrame("Library", 655, 420, "main");
            }
        });



        // Add the button to the JFrame
        add(lblTitle);
        add(lblName);add(txtTitle);
        add(lblAuthor);add(cmbAuthor);
        add(lblDate);add(cmbDays);add(cmbMonths);add(cmbYears);
        add(lblGenre);add(cmbGenre);
        add(lblSpecifics);add(txtSpecifics);
        add(lblAvailability);add(cmbAvailability);
        add(btnNewBook);add(btnBack);
    }

    private void showBook() {
        String[] arrBooks = new String[Main.bookList.size()];
        int pos = 0;
        for (Book book : Main.bookList) {
            arrBooks[pos] = book.getName();
            pos++;
        }

        // Title
        JLabel lblTitle = new JLabel("Book Information");
        lblTitle.setBounds(150, 20, 200, 50);

        // First Name
        JLabel lblName = new JLabel("Title:");
        lblName.setBounds(60, 120, 200, 50);

        JLabel lblNameDet = new JLabel("");
        lblNameDet.setBounds(150, 120, 200, 50);

        // Last Name
        JLabel lblAuthor = new JLabel("Author:");
        lblAuthor.setBounds(60, 170, 200, 50);

        JLabel lblAuthorDet = new JLabel("");
        lblAuthorDet.setBounds(150, 170, 200, 50);

        // Nationality
        JLabel lblDate = new JLabel("Publish Date:");
        lblDate.setBounds(60, 220, 200, 50);

        JLabel lblDateDet = new JLabel("");
        lblDateDet.setBounds(150, 220, 200, 50);

        // Date of Birth
        JLabel lblGenre = new JLabel("Genre:");
        lblGenre.setBounds(60, 270, 270, 50);

        JLabel lblGenreDet = new JLabel("");
        lblGenreDet.setBounds(150, 270, 270, 50);

        // Characteristic
        JLabel lblSpec = new JLabel("");
        lblSpec.setBounds(60, 320, 270, 50);

        JLabel lblSpecDet = new JLabel("");
        lblSpecDet.setBounds(150, 320, 270, 50);

        // Author
        JLabel lblAvailable = new JLabel("Available:");
        lblAvailable.setBounds(60, 370, 200, 50);

        JLabel lblAvailableDet = new JLabel("");
        lblAvailableDet.setBounds(150, 370, 200, 50);

        JLabel lblBook = new JLabel("Book:");
        lblBook.setBounds(60, 70, 200, 50);

        JComboBox<String> cmbBook;
        cmbBook = new JComboBox<>(arrBooks);
        cmbBook.setBounds(150, 80, 200, 30);

        cmbBook.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Method to handle item selection
                String selectedOption = (String) cmbBook.getSelectedItem();
                for (Book book : Main.bookList) {
                    String bookSelected = book.getName();
                    if (Objects.equals(selectedOption, bookSelected)){
                        lblNameDet.setText(book.getName());
                        String formatedAuthor = book.getAuthor().getLastName() + ", " + book.getAuthor().getName();
                        lblAuthorDet.setText(formatedAuthor);
                        lblDateDet.setText(book.getPublishDate());
                        lblGenreDet.setText(book.getGenre());
                        lblSpec.setText(book.getFeature());

                        if (book instanceof Manga){
                            Manga manga = (Manga) book;
                            lblSpecDet.setText(manga.getLanguage());
                        } else if (book instanceof Comic) {
                            Comic comic = (Comic) book;
                            lblSpecDet.setText(comic.getHero());
                        } else if (book instanceof Literature) {
                            Literature literature = (Literature) book;
                            lblSpecDet.setText(literature.getSubGenre());
                        } else if (book instanceof Magazine) {
                            Magazine magazine = (Magazine) book;
                            lblSpecDet.setText(magazine.getCategory());
                        } else if (book instanceof Science) {
                            Science science = (Science) book;
                            lblSpecDet.setText(science.getField());
                        }


                        if (book.getAvailability()){
                            lblAvailableDet.setText("Yes");
                        } else {
                            lblAvailableDet.setText("No");
                        }
                    }
                }
            }
        });

        JButton btnBack = new JButton("Cancel");
        btnBack.setBounds(150, 420, 80, 40);
        btnBack.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                MyFrame mainWin = new MyFrame("Library", 655, 420, "main");
            }
        });

        // Add the button to the JFrame
        add(lblTitle);
        add(lblName);add(lblNameDet);
        add(lblAuthor);add(lblAuthorDet);
        add(lblDate);add(lblDateDet);
        add(lblSpec);add(lblSpecDet);
        add(lblGenre);add(lblGenreDet);
        add(lblAvailable);add(lblAvailableDet);
        add(lblBook);add(cmbBook);
        add(btnBack);
    }

    private void newAuthor() {
        String[] days = new String[31]; String[] months = new String[12]; String[] years = new String[125];
        for (int n = 1; n <= 31; n++){days[n-1] = Integer.toString(n);}
        for (int n = 1; n <= 12; n++){months[n-1] = Integer.toString(n);}
        int counter = 0;
        for (int n = 2024; n >= 1900; n--){years[counter] = Integer.toString(n);counter++;}


        // Books
        JLabel lblTitle = new JLabel("New Author");
        lblTitle.setBounds(150, 20, 200, 50);

        // Name
        JLabel lblName = new JLabel("Name:");
        lblName.setBounds(60, 70, 200, 50);

        JTextField txtName = new JTextField();
        txtName.setBounds(150, 80, 200, 30);

        //Author
        JLabel lblLastName = new JLabel("Last Name:");
        lblLastName.setBounds(60, 120, 200, 50);

        JTextField txtLastName = new JTextField();
        txtLastName.setBounds(150, 130, 200, 30);

        //PublishDate
        JLabel lblDate = new JLabel("Date of Birth:");
        lblDate.setBounds(60, 170, 200, 50);

        JComboBox<String> cmbDays;
        cmbDays = new JComboBox<>(days);
        cmbDays.setBounds(150, 180, 50, 30);

        JComboBox<String> cmbMonths;
        cmbMonths = new JComboBox<>(months);
        cmbMonths.setBounds(210, 180, 50, 30);

        JComboBox<String> cmbYears;
        cmbYears = new JComboBox<>(years);
        cmbYears.setBounds(270, 180, 80, 30);

        //Specifics
        JLabel lblNationality = new JLabel("Nationality:");
        lblNationality.setBounds(60, 220, 200, 50);

        JTextField txtNationality = new JTextField();
        txtNationality.setBounds(150, 230, 200, 30);

        JButton btnCreateAuthor = new JButton("Create");
        btnCreateAuthor.setBounds(50, 280, 80, 40);
        addNewAuthorListeners(btnCreateAuthor, txtName, txtLastName, txtNationality, cmbDays, cmbMonths, cmbYears);

        JButton btnBack = new JButton("Cancel");
        btnBack.setBounds(150, 280, 80, 40);
        btnBack.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                MyFrame mainWin = new MyFrame("Library", 655, 420, "main");
            }
        });

        // Add the button to the JFrame
        add(lblTitle);
        add(lblName);add(txtName);
        add(lblLastName);add(txtLastName);
        add(lblDate);add(cmbDays);add(cmbMonths);add(cmbYears);
        add(lblNationality);add(txtNationality);
        add(btnCreateAuthor);
        add(btnBack);
    }

    private void addNewAuthorListeners(JButton button,
                                       JTextField jName,
                                       JTextField jLastName,
                                       JTextField jNationality,
                                       JComboBox jDay,
                                       JComboBox jMonth,
                                       JComboBox jYear) {

        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String firstName = jName.getText().trim();
                String lastName = jLastName.getText().trim();
                String nationality = jNationality.getText().trim();
                String day = jDay.getSelectedItem().toString();
                String month = jMonth.getSelectedItem().toString();
                String year = jYear.getSelectedItem().toString();

                if (firstName.isEmpty() || lastName.isEmpty() || nationality.isEmpty()) {
                    JOptionPane.showMessageDialog(null,
                            "Every field is required",
                            "Error",
                            JOptionPane.ERROR_MESSAGE);
                } else {
                    // Call the method when the button is pressed
                    String birth = day + "/" + month + "/" + year;
                    Author author = new Author(firstName, lastName, nationality, birth);
                    Main.authorList.add(author);
                    JOptionPane.showMessageDialog(null,
                            "Author Has been Registered",
                            "Success",
                            JOptionPane.INFORMATION_MESSAGE);
                    jName.setText("");
                    jLastName.setText("");
                    jNationality.setText("");
                    jDay.setSelectedIndex(0);
                    jMonth.setSelectedIndex(0);
                    jYear.setSelectedIndex(0);
                }
            }
        });
    }
    private void showAuthor() {
        String[] arrAuthors = new String[Main.authorList.size()];
        int pos = 0;
        for (Author author : Main.authorList) {
            arrAuthors[pos] = author.getLastName() + ", " + author.getName();
            pos++;
        }

        // Title
        JLabel lblTitle = new JLabel("Author Information");
        lblTitle.setBounds(150, 20, 200, 50);

        // First Name
        JLabel lblName = new JLabel("Name:");
        lblName.setBounds(60, 120, 200, 50);

        JLabel lblNameDet = new JLabel("");
        lblNameDet.setBounds(150, 120, 200, 50);

        // Last Name
        JLabel lblLastName = new JLabel("Last Name:");
        lblLastName.setBounds(60, 170, 200, 50);

        JLabel lblLastNameDet = new JLabel("");
        lblLastNameDet.setBounds(150, 170, 200, 50);

        // Nationality
        JLabel lblNationality = new JLabel("Nationality");
        lblNationality.setBounds(60, 220, 200, 50);

        JLabel lblNationalityDet = new JLabel("");
        lblNationalityDet.setBounds(150, 220, 200, 50);

        // Date of Birth
        JLabel lblBirth = new JLabel("Date of Birth: ");
        lblBirth.setBounds(60, 270, 270, 50);

        JLabel lblBirthDet = new JLabel("");
        lblBirthDet.setBounds(150, 270, 270, 50);

        // Author
        JLabel lblAuthor = new JLabel("Author:");
        lblAuthor.setBounds(60, 70, 200, 50);

        JComboBox<String> cmbAuthor;
        cmbAuthor = new JComboBox<>(arrAuthors);
        cmbAuthor.setBounds(150, 80, 200, 30);

        cmbAuthor.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Method to handle item selection
                String selectedOption = (String) cmbAuthor.getSelectedItem();
                for (Author author : Main.authorList) {
                    String formatedName = author.getLastName() + ", " + author.getName();
                    if (Objects.equals(selectedOption, formatedName)){
                        lblNameDet.setText(author.getName());
                        lblLastNameDet.setText(author.getLastName());
                        lblNationalityDet.setText(author.getNationality());
                        lblBirthDet.setText(author.getBirth());
                    }
                }
            }
        });

        JButton btnBack = new JButton("Back");
        btnBack.setBounds(150, 320, 80, 40);
        btnBack.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                MyFrame mainWin = new MyFrame("Library", 655, 420, "main");
            }
        });



        // Add the button to the JFrame
        add(lblTitle);
        add(lblName);add(lblNameDet);
        add(lblLastName);add(lblLastNameDet);
        add(lblNationality);add(lblNationalityDet);
        add(lblBirth);add(lblBirthDet);
        add(lblAuthor);add(cmbAuthor);
        add(btnBack);
    }

    private void newUser() {
        // Books
        JLabel lblTitle = new JLabel("New User");
        lblTitle.setBounds(150, 20, 200, 50);

        // Name
        JLabel lblId = new JLabel("ID:");
        lblId.setBounds(60, 70, 200, 50);

        JTextField txtId = new JTextField();
        txtId.setBounds(170, 80, 200, 30);

        txtId.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                char c = e.getKeyChar();
                if (!Character.isDigit(c) && c != KeyEvent.VK_BACK_SPACE) {
                    e.consume();  // Ignore the key event
                }
            }
        });

        //Author
        JLabel lblName = new JLabel("First Name:");
        lblName.setBounds(60, 120, 200, 50);

        JTextField txtName = new JTextField();
        txtName.setBounds(170, 130, 200, 30);

        //PublishDate
        JLabel lblLastName = new JLabel("Last Name:");
        lblLastName.setBounds(60, 170, 200, 50);

        JTextField txtLastName = new JTextField();
        txtLastName.setBounds(170, 180, 200, 30);

        //Specifics
        JLabel lblAddress = new JLabel("Address:");
        lblAddress.setBounds(60, 220, 200, 50);

        JTextField txtAddress = new JTextField();
        txtAddress.setBounds(170, 230, 200, 30);

        //Specifics
        JLabel lblPhone = new JLabel("Phone Number:");
        lblPhone.setBounds(60, 270, 200, 50);

        JTextField txtPhone = new JTextField();
        txtPhone.setBounds(170, 280, 200, 30);

        txtPhone.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                char c = e.getKeyChar();
                if (!Character.isDigit(c) && c != KeyEvent.VK_BACK_SPACE) {
                    e.consume();  // Ignore the key event
                }
            }
        });

        JButton btnCreateAuthor = new JButton("Create");
        btnCreateAuthor.setBounds(170, 320, 80, 40);
        addNewUserListeners(btnCreateAuthor, txtName, txtLastName, txtAddress, txtPhone, txtId);

        JButton btnBack = new JButton("Cancel");
        btnBack.setBounds(270, 320, 80, 40);
        btnBack.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                MyFrame mainWin = new MyFrame("Library", 655, 420, "main");
            }
        });

        add(lblTitle);
        add(lblName);add(txtName);
        add(lblLastName);add(txtLastName);
        add(lblAddress);add(txtAddress);
        add(lblPhone);add(txtPhone);
        add(lblId);add(txtId);
        add(btnCreateAuthor);add(btnBack);
    }

    private void addNewUserListeners(JButton button,
                                       JTextField jName,
                                       JTextField jLastName,
                                       JTextField jAddress,
                                       JTextField jPhoneNumber,
                                       JTextField jId) {

        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String firstName = jName.getText().trim();
                String lastName = jLastName.getText().trim();
                String address = jAddress.getText().trim();
                String phone = jPhoneNumber.getText().trim();
                String id = jId.getText().trim();

                if (firstName.isEmpty() || lastName.isEmpty() || address.isEmpty() || phone.isEmpty() || id.isEmpty()) {
                    JOptionPane.showMessageDialog(null,
                            "Every field is required",
                            "Error",
                            JOptionPane.ERROR_MESSAGE);
                } else {
                    User user = new User(firstName, lastName, address, phone, id);
                    Main.userList.add(user);
                    JOptionPane.showMessageDialog(null,
                            "Author Has been Registered",
                            "Success",
                            JOptionPane.INFORMATION_MESSAGE);
                    jName.setText("");
                    jLastName.setText("");
                    jAddress.setText("");
                    jPhoneNumber.setText("");
                    jId.setText("");
                }
            }
        });
    }

    private void showUser() {
        // Title
        JLabel lblTitle = new JLabel("User Information");
        lblTitle.setBounds(150, 20, 200, 50);

        // First Name
        JLabel lblId = new JLabel("Enter ID:");
        lblId.setBounds(60, 70, 200, 50);

        JTextField txtId = new JTextField();
        txtId.setBounds(160, 80, 200, 30);

        txtId.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                char c = e.getKeyChar();
                if (!Character.isDigit(c) && c != KeyEvent.VK_BACK_SPACE) {
                    e.consume();  // Ignore the key event
                }
            }
        });

        // First Name
        JLabel lblName = new JLabel("First Name:");
        lblName.setBounds(60, 120, 200, 50);

        JLabel lblNameDet = new JLabel("");
        lblNameDet.setBounds(160, 120, 200, 50);

        // Last Name
        JLabel lblLastName = new JLabel("Last Name:");
        lblLastName.setBounds(60, 170, 200, 50);

        JLabel lblLastNameDet = new JLabel("");
        lblLastNameDet.setBounds(160, 170, 200, 50);

        // Nationality
        JLabel lblAddress = new JLabel("Address:");
        lblAddress.setBounds(60, 220, 200, 50);

        JLabel lblAddressDet = new JLabel("");
        lblAddressDet.setBounds(160, 220, 200, 50);

        // Date of Birth
        JLabel lblPhone = new JLabel("Phone Number:");
        lblPhone.setBounds(60, 270, 270, 50);

        JLabel lblPhoneDet = new JLabel("");
        lblPhoneDet.setBounds(160, 270, 270, 50);

        JButton btnBack = new JButton("Back");
        btnBack.setBounds(250, 320, 80, 40);
        btnBack.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                MyFrame mainWin = new MyFrame("Library", 655, 420, "main");
            }
        });

        JButton btnSearch = new JButton("Search");
        btnSearch.setBounds(160, 320, 80, 40);
        btnSearch.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                boolean found = false;
                for (User user : Main.userList) {
                    if (Objects.equals(user.getId(), txtId.getText())){
                        lblNameDet.setText(user.getName());
                        lblLastNameDet.setText(user.getLastName());
                        lblAddressDet.setText(user.getAddress());
                        lblPhoneDet.setText(user.getPhone());
                        found = true;
                    }
                }
                if (!found){
                    lblNameDet.setText("");
                    lblLastNameDet.setText("");
                    lblAddressDet.setText("");
                    lblPhoneDet.setText("");
                    JOptionPane.showMessageDialog(null,
                            "User not found",
                            "Error",
                            JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        // Add the button to the JFrame
        add(lblTitle);
        add(lblId);add(txtId);
        add(lblName);add(lblNameDet);
        add(lblLastName);add(lblLastNameDet);
        add(lblAddress);add(lblAddressDet);
        add(lblPhone);add(lblPhoneDet);
        add(btnSearch);add(btnBack);
    }

    private void newLoan() {
        String[] days = new String[31]; String[] months = new String[12]; String[] years = {"2024", "2025", "2026"};
        for (int n = 1; n <= 31; n++){days[n-1] = Integer.toString(n);}
        for (int n = 1; n <= 12; n++){months[n-1] = Integer.toString(n);}

        String[] arrBooks = new String[Main.bookList.size()];

        // Books
        JLabel lblTitle = new JLabel("Loan a Book");
        lblTitle.setBounds(150, 20, 200, 50);

        //Title
        JLabel lblUser = new JLabel("User ID:");
        lblUser.setBounds(60, 70, 200, 50);

        JTextField txtId = new JTextField();
        txtId.setBounds(150, 80, 200, 30);

        txtId.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                char c = e.getKeyChar();
                if (!Character.isDigit(c) && c != KeyEvent.VK_BACK_SPACE) {
                    e.consume();  // Ignore the key event
                }
            }
        });

        //Author
        JLabel lblBook = new JLabel("Book:");
        lblBook.setBounds(60, 120, 200, 50);

        int pos = 0;
        for (Book book : Main.bookList) {
            if (book.getAvailability()){
                arrBooks[pos] = book.getName();
                pos++;
            }
        }
        JComboBox<String> cmbBook;
        cmbBook = new JComboBox<>(arrBooks);
        cmbBook.setBounds(150, 130, 200, 30);

        // Loan Date
        JLabel lblLoanDate = new JLabel("Loan Date:");
        lblLoanDate.setBounds(60, 170, 200, 50);

        JComboBox<String> cmbLoanDays;
        cmbLoanDays = new JComboBox<>(days);
        cmbLoanDays.setBounds(150, 180, 50, 30);

        JComboBox<String> cmbLoanMonths;
        cmbLoanMonths = new JComboBox<>(months);
        cmbLoanMonths.setBounds(210, 180, 50, 30);

        JComboBox<String> cmbLoanYears;
        cmbLoanYears = new JComboBox<>(years);
        cmbLoanYears.setBounds(270, 180, 80, 30);

        // Return Date
        JLabel lblReturnDate = new JLabel("Return Date:");
        lblReturnDate.setBounds(60, 220, 200, 50);

        JComboBox<String> cmbReturnDays;
        cmbReturnDays = new JComboBox<>(days);
        cmbReturnDays.setBounds(150, 230, 50, 30);

        JComboBox<String> cmbReturnMonths;
        cmbReturnMonths = new JComboBox<>(months);
        cmbReturnMonths.setBounds(210, 230, 50, 30);

        JComboBox<String> cmbReturnYears;
        cmbReturnYears = new JComboBox<>(years);
        cmbReturnYears.setBounds(270, 230, 80, 30);


        JButton btnNewBook = new JButton("Create");
        btnNewBook.setBounds(150, 280, 80, 40);
        btnNewBook.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                boolean userFound = false;
                for (User user : Main.userList) {
                    if (Objects.equals(user.getId(), txtId.getText())){
                        userFound = true;
                        for (Book book : Main.bookList){
                            if (Objects.equals(book.getName(), cmbBook.getSelectedItem())){
                                String loanDate = cmbLoanDays.getSelectedItem() + "/" + cmbLoanMonths.getSelectedItem() + "/" + cmbLoanYears.getSelectedItem();
                                String returnDate = cmbReturnDays.getSelectedItem() + "/" + cmbReturnMonths.getSelectedItem() + "/" + cmbReturnYears.getSelectedItem();
                                Loan loan = new Loan(user, book, loanDate, returnDate);
                                Main.loanList.add(loan);
                                book.setAvailability(false);
                                JOptionPane.showMessageDialog(null,
                                        "Loan Has been Registered",
                                        "Success",
                                        JOptionPane.INFORMATION_MESSAGE);
                                txtId.setText("");
                                cmbBook.setSelectedIndex(0);
                                cmbLoanDays.setSelectedIndex(0);
                                cmbLoanMonths.setSelectedIndex(0);
                                cmbLoanYears.setSelectedIndex(0);
                                cmbReturnDays.setSelectedIndex(0);
                                cmbReturnMonths.setSelectedIndex(0);
                                cmbReturnYears.setSelectedIndex(0);
                                boolean furtherAction = false;
                                for (Book book1 : Main.bookList) {
                                    if (book1.getAvailability()) {
                                        furtherAction = true;
                                        break;
                                    }
                                }
                                if (!furtherAction){
                                    dispose();
                                    MyFrame mainWin = new MyFrame("Library", 655, 420, "main");
                                }
                            }
                        }
                    }
                }
                if (!userFound){
                    JOptionPane.showMessageDialog(null,
                            "User not found",
                            "Error",
                            JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        JButton btnBack = new JButton("Cancel");
        btnBack.setBounds(250, 280, 80, 40);

        btnBack.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                MyFrame mainWin = new MyFrame("Library", 655, 420, "main");
            }
        });



        // Add the button to the JFrame
        add(lblTitle);
        add(lblUser);add(txtId);
        add(lblBook);add(cmbBook);
        add(lblLoanDate);add(lblReturnDate);
        add(cmbLoanDays);add(cmbLoanMonths);add(cmbLoanYears);
        add(cmbReturnDays);add(cmbReturnMonths);add(cmbReturnYears);
        add(btnNewBook);add(btnBack);
    }

    private void showLoan() {
        String[] arrLoans = new String[Main.loanList.size()];
        int pos = 0;
        for (Loan loan : Main.loanList) {
            arrLoans[pos] = loan.getBook().getName();
            pos++;
        }

        // Title
        JLabel lblTitle = new JLabel("Loan Information");
        lblTitle.setBounds(150, 20, 200, 50);

        JLabel lblBook = new JLabel("Book:");
        lblBook.setBounds(60, 70, 200, 50);

        // First Name
        JLabel lblUser = new JLabel("User ID:");
        lblUser.setBounds(60, 120, 200, 50);

        JLabel lblUserIdDet = new JLabel("");
        lblUserIdDet.setBounds(150, 120, 200, 50);

        // Last Name
        JLabel lblLoanDate = new JLabel("Loan Date:");
        lblLoanDate.setBounds(60, 170, 200, 50);

        JLabel lblLoanDateDet = new JLabel("");
        lblLoanDateDet.setBounds(150, 170, 200, 50);

        // Nationality
        JLabel lblReturnDate = new JLabel("Return Date:");
        lblReturnDate.setBounds(60, 220, 200, 50);

        JLabel lblReturnDateDet = new JLabel("");
        lblReturnDateDet.setBounds(150, 220, 200, 50);

        JComboBox<String> cmbBook;
        cmbBook = new JComboBox<>(arrLoans);
        cmbBook.setBounds(150, 80, 200, 30);

        cmbBook.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Method to handle item selection
                String selectedOption = (String) cmbBook.getSelectedItem();
                for (Loan loan : Main.loanList) {
                    String bookSelected = loan.getBook().getName();
                    if (Objects.equals(selectedOption, bookSelected)){
                        lblUserIdDet.setText(loan.getUser().getId());
                        lblLoanDateDet.setText(loan.getLoanDate());
                        lblReturnDateDet.setText(loan.getReturnDate());
                    }
                }
            }
        });


        JButton btnReturned = new JButton("Return");
        btnReturned.setBounds(150, 270, 80, 40);
        btnReturned.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String selectedOption = (String) cmbBook.getSelectedItem();
                int index = 0;
                for (Loan loan : Main.loanList) {
                    String bookSelected = loan.getBook().getName();
                    if (Objects.equals(selectedOption, bookSelected)){
                        loan.getBook().setAvailability(true);
                        JOptionPane.showMessageDialog(null,
                                "Book has been returned",
                                "Success",
                                JOptionPane.INFORMATION_MESSAGE);
                        lblUserIdDet.setText("");
                        lblLoanDateDet.setText("");
                        lblReturnDateDet.setText("");
                        Main.loanList.remove(index);
                        if (Main.loanList.size() == 0){
                            dispose();
                            MyFrame mainWin = new MyFrame("Library", 655, 420, "main");
                            break;
                        }
                    }
                    index++;
                }
            }
        });

        JButton btnBack = new JButton("Back");
        btnBack.setBounds(250, 270, 80, 40);
        btnBack.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                MyFrame mainWin = new MyFrame("Library", 655, 420, "main");
            }
        });



        // Add the button to the JFrame
        add(lblTitle);
        add(lblBook);
        add(cmbBook);
        add(lblUser);add(lblUserIdDet);
        add(lblLoanDate);add(lblLoanDateDet);
        add(lblReturnDate);add(lblReturnDateDet);
        add(btnReturned);add(btnBack);
    }

}