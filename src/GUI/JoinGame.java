package GUI;

/**
 * Created by Peter on 26/11/15.
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class JoinGame extends JPanel
{
    private JLabel lblHeader;
    private JLabel lblBalance;
    private JLabel lblGameID;
    private JLabel lblMoves;
    private JTextField txtGameID;
    private JTextField txtMoves;
    private JButton btnPlay;
    private JButton btnCancel;
    private String gameID;
    private String moves;

    public JoinGame()
    {
        setLayout(null);
        setBounds(100, 100, 530, 305);
        setBackground(new Color(247, 247, 243));

        lblHeader = new JLabel("Join Game");
        lblHeader.setFont(new Font("Lucida Grande", Font.PLAIN, 25));
        lblHeader.setForeground(new Color(73, 103, 170));
        lblHeader.setBounds(198, 56, 133, 31);
        add(lblHeader);

        lblBalance = new JLabel("Get ready to battle!");
        lblBalance.setBounds(198, 85, 133, 16);
        add(lblBalance);

        lblGameID = new JLabel("Type the GameID of the game you wish to join:");
        lblGameID.setBounds(6, 119, 305, 16);
        add(lblGameID);

        txtGameID = new JTextField();
        txtGameID.setColumns(10);
        txtGameID.setBounds(310, 113, 117, 28);
        add(txtGameID);

        lblMoves = new JLabel("Type your moves below (wasd):");
        lblMoves.setBounds(161, 147, 207, 16);
        add(lblMoves);

        txtMoves = new JTextField();
        txtMoves.setColumns(10);
        txtMoves.setBounds(69, 181, 392, 28);
        add(txtMoves);

        btnPlay = new JButton("Play");
        btnPlay.setBounds(198, 221, 117, 38);
        add(btnPlay);

        btnCancel = new JButton("Cancel");
        btnCancel.setFont(new Font("Lucida Grande", Font.PLAIN, 9));
        btnCancel.setBounds(6, 265, 76, 29);
        add(btnCancel);
    }



    // GameID
    public String getGameID()
    {
        gameID = txtGameID.getText();
        return gameID;
    }

    public void clearGameID()
    {
        txtGameID.setText("");
    }
    // Amount
    public String getMoves()
    {
        moves = txtMoves.getText();
        return moves;
    }

    public void clearMoves()
    {
        txtMoves.setText("");
    }

    public JButton getBtnCancel()
    {
        return btnCancel;
    }

    public JButton getBtnPlay()
    {
        return btnPlay;
    }

    public void addActionListener(ActionListener l)
    {
        btnPlay.addActionListener(l);
        btnCancel.addActionListener(l);
    }
}
