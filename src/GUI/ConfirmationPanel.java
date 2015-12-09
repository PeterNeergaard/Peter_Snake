package GUI;

/**
 * Created by Peter on 23/11/15.
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

// klassen oprettes
public class ConfirmationPanel extends JPanel
{
    // deklarerer variabler for klassen
    private JLabel lblHeader;
    private JLabel lblTitle;
    private JLabel lblFirst;
    private JLabel lblSecond;
    private JLabel lblThird;
    private JLabel lblOk;
    private JButton btnOk;

    // konstruktør der instantierer variablene
    public ConfirmationPanel () {
        setLayout(null);
        setBounds(100, 100, 530, 350);
        setBackground(new Color(247, 247, 243));

        // label til overskriften
        lblHeader = new JLabel("");
        lblHeader.setFont(new Font("Lucida Grande", Font.PLAIN, 25));
        lblHeader.setForeground(new Color(73, 103, 170));
        add(lblHeader);

        // label til underoverskrift
        lblTitle = new JLabel();
        lblTitle.setText("Success!");
        lblTitle.setFont(new Font("Lucida Grande", Font.BOLD, 20));
        lblTitle.setBounds(215, 99, 99, 22);
        add(lblTitle);

        // label til øverste tekststreng
        lblFirst = new JLabel();
        lblFirst.setText("");
        lblFirst.setBounds(135, 126, 311, 22);
        add(lblFirst);

        // label til midterste tekststreng
        lblSecond = new JLabel();
        lblSecond.setText("");
        lblSecond.setBounds(135, 148, 311, 22);
        add(lblSecond);

        // label til nederste tekststreng
        lblThird = new JLabel();
        lblThird.setText("");
        lblThird.setBounds(135, 179, 285, 16);
        add(lblThird);

        // knap til at returnerer til menuen
        btnOk = new JButton("OK");
        add(btnOk);

        // label til at beskrive "ok" knappen
        lblOk = new JLabel("Press \"OK\" to return to the main menu");
        lblOk.setFont(new Font("Lucida Grande", Font.PLAIN, 9));
        add(lblOk);

    }

    // Metode til at ændre labels så de passer til "play" funktionen
    public void showPlay(String Name, String Moves)
    {
        lblHeader.setBounds(230, 56, 186, 31);
        lblHeader.setText("Play");
        lblTitle.setText("Success!");
        lblFirst.setText("You created the game: "+Name);
        lblFirst.setBounds(31, 126, 468, 22);
        lblSecond.setText("The moves you submitted are: "+Moves);
        lblSecond.setBounds(31, 148, 338, 22);
        btnOk.setBounds(206, 182, 117, 29);
        lblOk.setBounds(162, 210, 205, 16);
    }

    // metode til at ændre labels så de passer til "join game" funktionen
    public void showJoinGame(String Moves, String gameID)
    {
        lblHeader.setBounds(230, 56, 186, 31);
        lblHeader.setText("Play");
        lblTitle.setText("Success!");
        lblFirst.setText("You battled the owner og game: " + gameID);
        lblFirst.setBounds(135, 126, 468, 22);
        lblSecond.setText("With the moves: "+Moves);
        lblSecond.setBounds(135, 148, 338, 22);
        //lblThird.setText("The winner og the game is: " + winnerName);
        lblThird.setBounds(135, 179, 285, 16);
        btnOk.setBounds(206, 182, 117, 29);
        lblOk.setBounds(162, 210, 205, 16);

    }

    // metode til at ændre labels så de passer til "delete game" funktionen
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

    // getter til "ok" kanppen
    public JButton getBtnOk()
    {
        return btnOk;
    }

    // action listener til "ok" knappen
    public void addActionListener(ActionListener l) {
        btnOk.addActionListener(l);
    }
}
