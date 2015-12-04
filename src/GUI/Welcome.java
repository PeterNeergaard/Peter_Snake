package GUI;

/**
 * Created by Peter on 19/11/15.
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

// klassen oprettes
public class Welcome extends JPanel {

    // deklarerer variabler for klassen
    private static final long serialVersionUID = 1L;
    private JLabel lblTitle;
    private JLabel lblUserName;
    private JTextField txtUserName;
    private JLabel lblPassword;
    private JButton btnLogin;
    private JButton btnQuit;
    private JPasswordField passwordField;
    private JLabel wrongUser;
    private JLabel error;

    private String userName;
    private String password;

    // konstruktør der instantierer variablene
    public Welcome() {

        setLayout(null);
        setBackground(new Color(247, 247, 243));
        setBounds(100, 100, 530, 306);

        // label til overskriften
        lblTitle = new JLabel("Welcome to Snake");
        lblTitle.setForeground(new Color(73, 103, 170));
        lblTitle.setFont(new Font("Lucida Grande", Font.PLAIN, 25));
        lblTitle.setBounds(151, 40, 228, 31);
        add(lblTitle);

        // label til tekstfeltet Username
        lblUserName = new JLabel("Username:");
        lblUserName.setBounds(128, 106, 79, 16);
        add(lblUserName);

        // tekstfelt til at modtage et brugernavn
        txtUserName = new JTextField();
        txtUserName.setBounds(207, 100, 168, 28);
        add(txtUserName);

        // label til tekstfeltet password
        lblPassword = new JLabel("Password:");
        lblPassword.setBounds(128, 140, 67, 16);
        add(lblPassword);

        // knap til at logge ind
        btnLogin = new JButton("Login");
        btnLogin.setBounds(206, 168, 117, 29);
        add(btnLogin);

        // knap til at lukke programmet
        btnQuit = new JButton("Exit");
        btnQuit.setBounds(6, 265, 79, 29);
        add(btnQuit);

        // tekstfelt til at taste password
        passwordField = new JPasswordField();
        passwordField.setBounds(207, 134, 168, 28);
        add(passwordField);

        // label som bliver vist hvis du prøver at logge ind med en forkert bruger
        wrongUser = new JLabel("Wrong username or password, try again");
        wrongUser.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
        wrongUser.setForeground(Color.RED);
        wrongUser.setBounds(117, 197, 295, 31);
        wrongUser.setVisible(false);
        add(wrongUser);

        // label der bliver vist hvis der sker en fejl (ud over forkert bruger)
        error = new JLabel("Error, please try again");
        error.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
        error.setForeground(Color.RED);
        error.setBounds(200, 197, 295, 31);
        error.setVisible(false);
        add(error);
    }

    // metode til at rydde password feltet
    public void clearPassword()
    {
        passwordField.setText("");
    }

    // metode ti lat rydde username feltet
    public void clearUserName() {
        txtUserName.setText("");
    }

    //getters til knapperne og tekstfelterne
    public JLabel getWrongUser()
    {
        return wrongUser;
    }

    public JLabel getError() {
        return error;
    }

    public String getUserName()
    {
        userName = txtUserName.getText();
        return userName;
    }

    public String getPassword()
    {
        password = passwordField.getText();
        return password;
    }

    public JButton getBtnLogin()
    {
        return btnLogin;
    }

    public JButton getBtnQuit()
    {
        return btnQuit;
    }

    // action listeners til knapperne
    public void addActionListener(ActionListener l)
    {
        btnLogin.addActionListener(l);
        btnQuit.addActionListener(l);
    }


}
