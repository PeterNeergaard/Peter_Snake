package GUI;

/**
 * Created by Peter on 23/11/15.
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;


public class ConfirmationPanel extends JPanel
{
    private JLabel lblHeader;
    private JLabel lblTitle;
    private JLabel lblFirst;
    private JLabel lblSecond;
    private JLabel lblOk;
    private JButton btnOk;

    public ConfirmationPanel () {
        setLayout(null);
        setBounds(100, 100, 530, 350);
        setBackground(new Color(247, 247, 243));

        lblHeader = new JLabel("");
        lblHeader.setFont(new Font("Lucida Grande", Font.PLAIN, 25));
        lblHeader.setForeground(new Color(73, 103, 170));
        add(lblHeader);

        lblTitle = new JLabel();
        lblTitle.setText("Success!");
        lblTitle.setFont(new Font("Lucida Grande", Font.BOLD, 20));
        lblTitle.setBounds(215, 99, 99, 22);
        add(lblTitle);

        lblFirst = new JLabel();
        lblFirst.setText("");
        lblFirst.setBounds(135, 126, 311, 22);
        add(lblFirst);

        lblSecond = new JLabel();
        lblSecond.setText("");
        lblSecond.setBounds(135, 148, 311, 22);
        add(lblSecond);

        btnOk = new JButton("OK");
        add(btnOk);

        lblOk = new JLabel("Press \"OK\" to return to the main menu");
        lblOk.setFont(new Font("Lucida Grande", Font.PLAIN, 9));
        add(lblOk);

    }

    public void showPlay(String Moves)
    {
        lblHeader.setBounds(230, 56, 186, 31);
        lblHeader.setText("Play");
        lblTitle.setText("Success!");
        lblFirst.setText("You played with the moves: "+Moves);
        lblFirst.setBounds(31, 126, 468, 22);
        lblSecond.setText("Wait until someone challenges you to see if you win");
        lblSecond.setBounds(31, 148, 338, 22);
        btnOk.setBounds(206, 182, 117, 29);
        lblOk.setBounds(162, 210, 205, 16);
    }

    public void showDelete(String gameID)
    {
        lblHeader.setBounds(200, 56, 186, 31);
        lblHeader.setText("Delete Game");
        lblTitle.setText("Success!");
        lblFirst.setText("You deleted the game with the gameID: "+gameID);
        lblFirst.setBounds(135, 126, 468, 22);
        lblSecond.setText("");
        lblSecond.setBounds(31, 148, 338, 22);
        btnOk.setBounds(206, 182, 117, 29);
        lblOk.setBounds(162, 210, 205, 16);
    }

    public JButton getBtnOk()
    {
        return btnOk;
    }

    public void addActionListener(ActionListener l) {
        btnOk.addActionListener(l);
    }
}
