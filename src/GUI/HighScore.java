package GUI;

/**
 * Created by Peter on 19/11/15.
 */

import sdk.Score;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionListener;

// klassen oprettes
public class HighScore extends JPanel
{
    // deklarerer variabler for klassen
    private JButton btnBack;
    private JLabel lblHeader;
    private JTable highScoreTable;

    // konstruktør der instantierer variablene
    public HighScore()
    {
        setLayout(null);
        setBounds(100, 100, 530, 350);
        setBackground(new Color(247, 247, 243));

        // JScrollPane til at indeholde JTable når highscores skal vises
        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(78, 56, 373, 207);
        add(scrollPane);

        // tabellen der fyldes ind i ScrollPane
        highScoreTable = new JTable(new DefaultTableModel(new Object[]{"User Name", "Game name", "Score", "Winner"}, 0));
        scrollPane.setViewportView(highScoreTable);

        // label til overskriften
        lblHeader  = new JLabel("Highscores");
        lblHeader.setFont(new Font("Lucida Grande", Font.PLAIN, 25));
        lblHeader.setForeground(new Color(73, 103, 170));
        lblHeader.setBounds(192, 15, 146, 29);
        add(lblHeader);

        // knap til at returnere til hovedmenuen
        btnBack = new JButton("Back");
        btnBack.setFont(new Font("Lucida Grande", Font.PLAIN, 9));
        btnBack.setBounds(6, 277, 76, 29);
        add(btnBack);
    }

    // getter til "back" knappen
    public JButton getBtnBack()
    {
        return btnBack;
    }

    // actionlistener til tilbage kanppen
    public void addActionListener(ActionListener l)
    {
        btnBack.addActionListener(l);

    }

    // Metode til at fylde tabellen med data fra Arraylisten Score
    public void HighScoreTable(Score[] scores) {
        DefaultTableModel model = (DefaultTableModel) highScoreTable.getModel();

        for(Score score : scores) {
            model.addRow(new Object[]{score.getUser().getUsername(), score.getGame().getName(), score.getScore(), score.getGame().getWinner()});
        }
    }

    // Metode der rydder table så man ikke ser dobbelt hvis man vil se highscores flere gange
    public void clearTable() {
        DefaultTableModel model = (DefaultTableModel) highScoreTable.getModel();
        model.setRowCount(0);
    }

}

