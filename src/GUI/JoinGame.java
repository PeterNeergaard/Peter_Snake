package GUI;

/**
 * Created by Peter on 26/11/15.
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

// klassen oprettes
public class JoinGame extends JPanel
{
    // deklarerer variabler for klassen
    private JLabel lblHeader;
    private JLabel lblBattle;
    private JLabel lblGameID;
    private JLabel lblMoves;
    private JTextField txtGameID;
    private JTextField txtMoves;
    private JButton btnPlay;
    private JButton btnCancel;
    private String gameID;
    private String moves;
    private JButton btnJoin;

    // konstruktør der instantierer variablene
    public JoinGame()
    {
        setLayout(null);
        setBounds(100, 100, 530, 305);
        setBackground(new Color(247, 247, 243));

        //label til overskriften
        lblHeader = new JLabel("Join Game");
        lblHeader.setFont(new Font("Lucida Grande", Font.PLAIN, 25));
        lblHeader.setForeground(new Color(73, 103, 170));
        lblHeader.setBounds(198, 56, 133, 31);
        add(lblHeader);

        // underoverskrift
        lblBattle = new JLabel("Get ready to battle!");
        lblBattle.setBounds(198, 85, 133, 16);
        add(lblBattle);

        // label til at beskrive tekstfeltet gameID
        lblGameID = new JLabel("Type the GameID of the game you wish to join:");
        lblGameID.setBounds(6, 119, 305, 16);
        add(lblGameID);

        // tekstfelt til at modtage det gameId brugeren vil joine
        txtGameID = new JTextField();
        txtGameID.setColumns(10);
        txtGameID.setBounds(310, 113, 117, 28);
        add(txtGameID);

        // label til at beskrive tesktfeltet moves
        lblMoves = new JLabel("Type your moves below (wasd):");
        lblMoves.setBounds(161, 147, 207, 16);
        add(lblMoves);

        // tekstfelt til at modtage styringshandlinger
        txtMoves = new JTextField();
        txtMoves.setColumns(10);
        txtMoves.setBounds(69, 181, 392, 28);
        add(txtMoves);

        // knap til at spille, og sende sine styringshandlinger osv. til serveren
        btnPlay = new JButton("Play");
        btnPlay.setEnabled(false);
        btnPlay.setVisible(false);
        btnPlay.setBounds(198, 221, 117, 38);
        add(btnPlay);

        // knap til at returnere til menuen
        btnCancel = new JButton("Cancel");
        btnCancel.setFont(new Font("Lucida Grande", Font.PLAIN, 9));
        btnCancel.setBounds(6, 265, 76, 29);
        add(btnCancel);

        btnJoin = new JButton("Join");
        btnJoin.setFont(new Font("Lucida Grande", Font.PLAIN, 9));
        btnPlay.setEnabled(true);
        btnPlay.setVisible(true);
        btnJoin.setBounds(439, 114, 76, 29);
        add(btnJoin);
    }

    public void clearGameID()
    {
        txtGameID.setText("");
    }

    public void clearMoves()
    {
        txtMoves.setText("");
    }

    // getters til de forskelige knapper og teksfelter
    public String getGameId()
    {
        gameID = txtGameID.getText();
        return gameID;
    }
    public int getIntGameId()
    {
        int gameId = Integer.parseInt(txtGameID.getText());
        return gameId;
    }

    public String getMoves()
    {
        moves = txtMoves.getText();
        return moves;
    }

    public JButton getBtnCancel()
    {
        return btnCancel;
    }

    public JButton getBtnJoin()
    {
        return btnJoin;
    }

    public JButton getBtnPlay()
    {
        return btnPlay;
    }

    // actionlisteners til de to knapper
    public void addActionListener(ActionListener l)
    {
        btnPlay.addActionListener(l);
        btnJoin.addActionListener(l);
        btnCancel.addActionListener(l);
    }
}