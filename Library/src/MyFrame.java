import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;

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
            case "newAuthor":
                newAuthor();
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
        addMainListeners(btnShowBooks, "showBooks");

        // Authors
        JLabel lblAuthors = new JLabel("Authors");
        lblAuthors.setBounds(220, 75, 200, 50);

        JButton btnNewAuthor = new JButton("New Author");
        btnNewAuthor.setBounds(190, 130, 120, 50);
        addMainListeners(btnNewAuthor, "winNewAuthor");

        JButton btnShowAuthors = new JButton("Show Authors");
        btnShowAuthors.setBounds(190, 200, 120, 50);
        addMainListeners(btnShowAuthors, "showAuthors");

        // Authors
        JLabel lblUsers = new JLabel("Users");
        lblUsers.setBounds(360, 75, 200, 50);

        JButton btnNewUser = new JButton("New User");
        btnNewUser.setBounds(330, 130, 120, 50);
        addMainListeners(btnNewUser, "newUser");

        JButton btnShowUser = new JButton("Show Users");
        btnShowUser.setBounds(330, 200, 120, 50);
        addMainListeners(btnShowUser, "showUsers");

        // Loans
        JLabel lblLoans = new JLabel("Loans");
        lblLoans.setBounds(500, 75, 200, 50);

        JButton btnNewLoan = new JButton("New Loan");
        btnNewLoan.setBounds(470, 130, 120, 50);
        addMainListeners(btnNewLoan, "newLoan");

        JButton btnShowLoans = new JButton("Show Loans");
        btnShowLoans.setBounds(470, 200, 120, 50);
        addMainListeners(btnShowLoans, "showLoans");

        // Add the button to the JFrame
        add(lblBook);add(btnNewBook);add(btnShowBooks);
        add(lblAuthors);add(btnNewAuthor);add(btnShowAuthors);
        add(lblUsers);add(btnNewUser);add(btnShowUser);
        add(lblLoans);add(btnNewLoan);add(btnShowLoans);
    }

    private void newBook() {
        String[] days = new String[31]; String[] months = new String[12]; String[] years = new String[125];
        for (int n = 1; n <= 31; n++){days[n-1] = Integer.toString(n);}
        for (int n = 1; n <= 12; n++){months[n-1] = Integer.toString(n);}
        int counter = 0;
        for (int n = 2024; n >= 1900; n--){years[counter] = Integer.toString(n);counter++;}


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

        JComboBox<String> cmbAuthor;
        cmbAuthor = new JComboBox<>(new String[] { "Option 1", "Option 2", "Option 3" });
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
                        specific = "Heroe: ";
                        break;
                    case "Literature":
                        specific = "Genre: ";
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
        btnNewBook.setBounds(50, 130, 120, 50);
        addBookListeres(btnNewBook, "newBook");



        // Add the button to the JFrame
        add(lblTitle);
        add(lblName);add(txtTitle);
        add(lblAuthor);add(cmbAuthor);
        add(lblDate);add(cmbDays);add(cmbMonths);add(cmbYears);
        add(lblGenre);add(cmbGenre);
        add(lblSpecifics);add(txtSpecifics);
        add(lblAvailability);add(cmbAvailability);
    }

    private void addMainListeners(JButton button, String section) {
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Call the method when the button is pressed
                setVisible(false);
                switch (section){
                    case "winNewBook":
                        MyFrame fNewBook = new MyFrame("New Book", 450, 420, "newBook");
                        /*if (Main.authorList.isEmpty()){
                            JOptionPane.showMessageDialog(null,
                                    "No Authores Registered",
                                    "Error",
                                    JOptionPane.ERROR_MESSAGE);
                            setVisible(true);
                        } else{
                            MyFrame fNewBook = new MyFrame("New Book", 450, 420, "newBook");
                        }*/
                        break;
                    case "winNewAuthor":
                        MyFrame fNewAuthor = new MyFrame("New Author", 450, 420, "newAuthor");
                }
            }
        });
    }

    private void addBookListeres(JButton button, String section) {
        // Create a new JButton


        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Call the method when the button is pressed
                setVisible(false);
                switch (section){
                    case "newBook":
                        MyFrame fNewBook = new MyFrame("New Book", 450, 420, "newBook");
                        /*if (Main.authorList.isEmpty()){
                            JOptionPane.showMessageDialog(null,
                                    "No Authores Registered",
                                    "Error",
                                    JOptionPane.ERROR_MESSAGE);
                            setVisible(true);
                        } else{
                            MyFrame fNewBook = new MyFrame("New Book", 450, 420, "newBook");
                        }*/
                        break;
                }
            }
        });
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
        btnCreateAuthor.setBounds(50, 280, 120, 50);
        addNewAuthorListeners(btnCreateAuthor, txtName, txtLastName, txtNationality, cmbDays, cmbMonths, cmbYears);

        // Add the button to the JFrame
        add(lblTitle);
        add(lblName);add(txtName);
        add(lblLastName);add(txtLastName);
        add(lblDate);add(cmbDays);add(cmbMonths);add(cmbYears);
        add(lblNationality);add(txtNationality);
        add(btnCreateAuthor);
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
                    System.out.println("hola");
                    String birth = day + "/" + month + "/" + year;
                    Author author = new Author(firstName, lastName, nationality, birth);
                    Main.authorList.add(author);
                }
            }
        });
    }


}