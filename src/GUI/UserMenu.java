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
    private JButton btnJoinGame;

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
        lblPeterClient.setBounds(183, 62, 162, 16);
        add(lblPeterClient);

        separator = new JSeparator();
        separator.setBounds(6, 90, 524, 16);
        add(separator);

        btnPlay = new JButton("Play");
        btnPlay.setBounds(164, 104, 196, 38);
        add(btnPlay);

        btnHighscore = new JButton("Highscore");
        btnHighscore.setBounds(164, 184, 196, 38);
        add(btnHighscore);

        btnDelete = new JButton("Delete Game");
        btnDelete.setBounds(164, 225, 196, 38);
        add(btnDelete);

        btnLogOut = new JButton("Log out");
        btnLogOut.setFont(new Font("Lucida Grande", Font.PLAIN, 9));
        btnLogOut.setBounds(6, 265, 79, 29);
        add(btnLogOut);

        btnJoinGame = new JButton("Join Game");
        btnJoinGame.setBounds(164, 145, 196, 38);
        add(btnJoinGame);
    }

    public JLabel getPeterClient()
    {
        return lblPeterClient;
    }

    public JButton getBtnPlay()
    {
        return btnPlay;
    }

    public JButton getBtnJoinGame()
    {
        return btnJoinGame;
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
        btnJoinGame.addActionListener(l);
    }

}