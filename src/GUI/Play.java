package GUI;

/**
 * Created by Peter on 19/11/15.
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

//klassen oprettes
public class Play extends JPanel {

    // deklarerer variabler for klassen
    private JLabel lblHeader;
    private JLabel lblMove;
    private JLabel lblName;
    private JTextField txtName;
    private JTextField txtMove;
    private JButton btnPlay;
    private JButton btnCancel;

    private String Moves;
    private String Name;

    // konstruktør der instantierer variablene
    public Play()
    {
        setLayout(null);
        setBounds(100, 100, 530, 305);
        setBackground(new Color(247, 247, 243));

        // Label til header
        lblHeader = new JLabel("Play Snake");
        lblHeader.setFont(new Font("Lucida Grande", Font.PLAIN, 25));
        lblHeader.setForeground(new Color(73, 103, 170));
        lblHeader.setBounds(198, 36, 133, 31);
        add(lblHeader);

        // label til teksfeltet "txtMove"
        lblMove = new JLabel("Insert the snakes movement with w,a,s,d:");
        lblMove.setBounds(125, 151, 261, 16);
        add(lblMove);

        // tekstfelt der modtager de styringshandlinger brugeren taster
        txtMove = new JTextField();
        txtMove.setBounds(125, 172, 261, 31);
        add(txtMove);

        //knap til at oprette spillet
        btnPlay = new JButton("Submit moves");
        btnPlay.setBounds(198, 215, 117, 38);
        add(btnPlay);

        //knap til at returnere til hoved menuen
        btnCancel = new JButton("Cancel");
        btnCancel.setFont(new Font("Lucida Grande", Font.PLAIN, 9));
        btnCancel.setBounds(6, 265, 76, 29);
        add(btnCancel);

        // label til tekstfeltet "name"
        lblName = new JLabel("Type a name for your game:");
        lblName.setBounds(125, 87, 178, 16);
        add(lblName);

        // tekstfelt til at give spillet et navn
        txtName = new JTextField();
        txtName.setColumns(10);
        txtName.setBounds(125, 115, 261, 31);
        add(txtName);
    }

    // metode til at ryde tekstfeltet "play"
    public void clearPlay()
    {
        txtMove.setText("");
    }

    //metode til at ryde tekstfeltet "name"
    public void clearName() {
        txtName.setText("");
    }

    //getters til de forskellige knapper og tekstfelter
    public JButton getBtnPlay()
    {
        return btnPlay;
    }

    public JButton getBtnCancel()
    {
        return btnCancel;
    }

    public String getMoves()
    {
        Moves = txtMove.getText();
        return Moves;
    }
    public String getName() {
        Name = txtName.getText();
        return Name;
    }

    // Action listener til de to knapper, play og cancel
    public void addActionListener(ActionListener l) {
        btnPlay.addActionListener(l);
        btnCancel.addActionListener(l);
    }
}

