package GUI;

/**
 * Created by Peter on 19/11/15.
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class UserMenu extends JPanel {

    private JLabel lblHeader;
    private JLabel lblPeterClient;
    private JSeparator separator;
    private JButton btnPlay;
    private JButton btnHighscore;
    private JButton btnDelete;
    private JButton btnLogOut;

    public UserMenu()
    {
        setLayout(null);
        setBounds(100, 100, 530, 305);
        setBackground(new Color(247, 247, 243));

        lblHeader = new JLabel("Menu");
        lblHeader.setFont(new Font("Lucida Grande", Font.PLAIN, 25));
        lblHeader.setForeground(new Color(73, 103, 170));
        lblHeader.setBounds(228, 28, 73, 38);
        add(lblHeader);

        lblPeterClient = new JLabel("Welcome to Peters client");
        lblPeterClient.setBounds(184, 78, 162, 16);
        add(lblPeterClient);

        separator = new JSeparator();
        separator.setBounds(6, 106, 524, 16);
        add(separator);

        btnPlay = new JButton("Play");
        btnPlay.setBounds(164, 157, 196, 38);
        add(btnPlay);

        btnHighscore = new JButton("Highscore");
        btnHighscore.setBounds(164, 195, 196, 38);
        add(btnHighscore);

        btnDelete = new JButton("Delete Game");
        btnDelete.setBounds(164, 235, 196, 38);
        add(btnDelete);

        btnLogOut = new JButton("Log out");
        btnLogOut.setFont(new Font("Lucida Grande", Font.PLAIN, 9));
        btnLogOut.setBounds(6, 265, 76, 29);
        add(btnLogOut);
    }

    public JLabel getPeterClient()
    {
        return lblPeterClient;
    }

    public JButton getBtnPlay()
    {
        return btnPlay;
    }

    public JButton getBtnHighscore()
    {
        return btnHighscore;
    }

    public JButton getBtnDelete()
    {
        return btnDelete;
    }

    public JButton getBtnLogOut()
    {
        return btnLogOut;
    }

    public void addActionListener(ActionListener l)
    {
        btnPlay.addActionListener(l);
        btnHighscore.addActionListener(l);
        btnDelete.addActionListener(l);
        btnLogOut.addActionListener(l);
    }

}