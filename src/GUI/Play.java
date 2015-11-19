package GUI;

/**
 * Created by Peter on 19/11/15.
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class Play extends JPanel {

    private JLabel lblHeader;
    private JLabel lblMove;
    private JTextField txtMove;
    private JButton btnPlay;
    private JButton btnCancel;

    public Play()
    {
        setLayout(null);
        setBounds(100, 100, 530, 305);
        setBackground(new Color(247, 247, 243));

        lblHeader = new JLabel("Play Snake");
        lblHeader.setFont(new Font("Lucida Grande", Font.PLAIN, 25));
        lblHeader.setForeground(new Color(73, 103, 170));
        lblHeader.setBounds(198, 56, 133, 31);
        add(lblHeader);

        lblMove = new JLabel("Insert the snakes movement with w,a,s,d:");
        lblMove.setBounds(125, 99, 261, 16);
        add(lblMove);

        txtMove = new JTextField();
        txtMove.setBounds(125, 121, 261, 57);
        add(txtMove);
        txtMove.setColumns(10);

        btnPlay = new JButton("Submit moves");
        btnPlay.setBounds(198, 215, 117, 38);
        add(btnPlay);

        btnCancel = new JButton("Cancel");
        btnCancel.setFont(new Font("Lucida Grande", Font.PLAIN, 9));
        btnCancel.setBounds(6, 265, 76, 29);
        add(btnCancel);
    }

    public void clearPlay()
    {
        txtMove.setText("");
    }

    public JButton getBtnPlay()
    {
        return btnPlay;
    }

    public JButton getBtnCancel()
    {
        return btnCancel;
    }

    public void addActionListener(ActionListener l)
    {
        btnPlay.addActionListener(l);
        btnCancel.addActionListener(l);
    }
}

