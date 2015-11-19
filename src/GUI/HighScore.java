package GUI;

/**
 * Created by Peter on 19/11/15.
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

// klassen oprettes
public class HighScore extends JPanel
{
    // deklarerer variabler for klassen
    //private JTable table;
    private JButton btnBack;
    private JLabel lblHeader;

    // konstruktør der instantierer variablene
    public HighScore()
    {
        setLayout(null);
        setBounds(100, 100, 530, 350);
        setBackground(new Color(247, 247, 243));

        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(78, 56, 373, 207);
        add(scrollPane);
        lblHeader  = new JLabel("Highscores");
        lblHeader.setFont(new Font("Lucida Grande", Font.PLAIN, 25));
        lblHeader.setForeground(new Color(73, 103, 170));
        lblHeader.setBounds(192, 15, 146, 29);
        add(lblHeader);

        btnBack = new JButton("Back");
        btnBack.setFont(new Font("Lucida Grande", Font.PLAIN, 9));
        btnBack.setBounds(6, 277, 76, 29);
        add(btnBack);
    }

    public JButton getBtnBack()
    {
        return btnBack;
    }

    public void addActionListener(ActionListener l)
    {
        btnBack.addActionListener(l);

    }
}

