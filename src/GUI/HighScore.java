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
    //private JTable table;
    private JButton btnBack;
    private JLabel lblHeader;
    private JTable highScoreTable;

    // konstruktør der instantierer variablene
    public HighScore()
    {
        setLayout(null);
        setBounds(100, 100, 530, 350);
        setBackground(new Color(247, 247, 243));

        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(78, 56, 373, 207);
        add(scrollPane);

        highScoreTable = new JTable(new DefaultTableModel(new Object[]{"Username", "GameId", "Score"}, 0));
        scrollPane.setViewportView(highScoreTable);


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
    public void HighScoreTable(Score[] scores) {
        DefaultTableModel model = (DefaultTableModel) highScoreTable.getModel();

        for(Score score : scores) {
            model.addRow(new Object[]{score.getUser().getUsername(), score.getGame().getGameId(), score.getScore()});
        }
    }

    public void clearTable() {
        DefaultTableModel model = (DefaultTableModel) highScoreTable.getModel();
        model.setRowCount(0);
    }

}

