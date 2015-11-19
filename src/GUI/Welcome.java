package GUI;

/**
 * Created by Peter on 19/11/15.
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;

public class Welcome extends JPanel {

    private static final long serialVersionUID = 1L;
    private JLabel lblTitle;
    private JLabel lblUserName;
    private JTextField txtUserName;
    private JLabel lblPassword;
    private JButton btnLogin;
    private JButton btnQuit;
    private JPasswordField passwordField;
    private JLabel wrongUser;

    private String userName;
    private String password;

    public Welcome() {
        setLayout(null);
        setBackground(new Color(247, 247, 243));
        setBounds(100, 100, 530, 306);
        lblTitle = new JLabel("Welcome to snake");
        lblTitle.setForeground(new Color(73, 103, 170));
        lblTitle.setFont(new Font("Lucida Grande", Font.PLAIN, 25));
        lblTitle.setBounds(151, 40, 228, 31);
        add(lblTitle);

        lblUserName = new JLabel("Username:");
        lblUserName.setBounds(128, 106, 79, 16);
        add(lblUserName);

        txtUserName = new JTextField();
        txtUserName.setBounds(207, 100, 168, 28);
        add(txtUserName);
        txtUserName.setColumns(10);

        lblPassword = new JLabel("Password:");
        lblPassword.setBounds(128, 140, 67, 16);
        add(lblPassword);

        btnLogin = new JButton("Login");
        btnLogin.setBounds(206, 168, 117, 29);
        add(btnLogin);

        btnQuit = new JButton("Exit");
        btnQuit.setBounds(6, 265, 79, 29);
        add(btnQuit);

        passwordField = new JPasswordField();
        passwordField.setBounds(207, 134, 168, 28);
        add(passwordField);

        wrongUser = new JLabel("Wrong username or password, try again");
        wrongUser.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
        wrongUser.setForeground(Color.RED);
        wrongUser.setBounds(117, 197, 295, 31);
        wrongUser.setVisible(false);
        add(wrongUser);
    }

    // Get Brugernavn
    public String getUserName()
    {
        userName = txtUserName.getText();
        return userName;
    }

    public void setUsername(String userName)
    {
        this.userName = userName;
    }

    public void clearUserName() {
        txtUserName.setText("");
    }

    // Get password
    @SuppressWarnings("deprecation")
    public String getPassword()
    {
        password = passwordField.getText();
        return password;
    }
    public void setPassword(String password)
    {
        this.password = password;
    }
    public void clearPassword()
    {
        passwordField.setText("");
    }

    public JButton getBtnLogin()
    {
        return btnLogin;
    }

    public JButton getBtnQuit()
    {
        return btnQuit;
    }

    public void addActionListener(ActionListener l)
    {
        btnLogin.addActionListener(l);
        btnQuit.addActionListener(l);
    }
    public void addKeyListener(KeyAdapter l)
    {
        passwordField.addKeyListener(l);
        txtUserName.addKeyListener(l);
        btnLogin.addKeyListener(l);
        btnQuit.addKeyListener(l);
    }


}
