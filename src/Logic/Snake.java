package Logic;

/**
 * Created by Peter on 19/11/15.
 */
import GUI.Screen;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Snake {
    // Opretter objekter af de forskellige klasser
    public Screen screen;


    public Snake() {
        // instantierer følgende variablerene
        screen = new Screen();
        screen.setVisible(true);
    }

    public void run() {
        // ActionListiners der refererer til alle de klasserne fra UI

        screen.getWelcome().addActionListener(new WelcomeActionListener());
        screen.getUserMenu().addActionListener(new UserMenuActionListener());
       // screen.getPlay().addActionListener(new DepositActionListener());
        //screen.getHighScore().addActionListener(new WithdrawActionListener());
        //screen.getDeleteGame().addActionListener(new TransferActionListener());

        screen.show(Screen.WELCOME);
    }

    // Welcome Action Listener, lavet af Peter og Henrik
    private class WelcomeActionListener implements ActionListener
    {
        @Override
        public void actionPerformed(ActionEvent e)
        {
            if (e.getSource() == screen.getWelcome().getBtnLogin())
            {
                screen.show(Screen.USERMENU);
                /**if(auth())
                {
                    logIn();
                }**/
            }
            else if (e.getSource() == screen.getWelcome().getBtnQuit())
            {
                System.exit(0);
            }
        }
    }


    //UserMenuAction Listener
    private class UserMenuActionListener implements ActionListener
    {
        @Override
        public void actionPerformed(ActionEvent e)
        {
            if (e.getSource() == screen.getUserMenu().getBtnPlay())
            {
                screen.show(Screen.PLAY);
            }
            else if (e.getSource() == screen.getUserMenu().getBtnHighscore())
            {
                screen.show(Screen.HIGHSCORE);
            }
            else if (e.getSource() == screen.getUserMenu().getBtnDelete())
            {
                screen.show(Screen.DELETEGAME);
            }
            else if (e.getSource() == screen.getUserMenu().getBtnLogOut())
            {
                screen.show(Screen.WELCOME);
            }
        }
    }



}
