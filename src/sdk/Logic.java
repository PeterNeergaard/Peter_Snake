package sdk;

/**
 * Created by Peter on 19/11/15.
 */
import GUI.Screen;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Logic {
    // Opretter objekter af de forskellige klasser
    private Screen screen;


    public Logic() {
        // instantierer følgende variablerene
        screen = new Screen();
        screen.setVisible(true);
    }

    public void run() {
        // ActionListiners der refererer til alle de klasserne fra UI

        screen.getWelcome().addActionListener(new WelcomeActionListener());
        screen.getUserMenu().addActionListener(new UserMenuActionListener());
        screen.getPlay().addActionListener(new PlayActionListener());
        screen.getHighScore().addActionListener(new HighScoreActionListener());
        screen.getDeleteGame().addActionListener(new DeleteActionListener());
        screen.getConfirmationPanel().addActionListener(new ConfirmationPanelActionListener());

        screen.show(Screen.WELCOME);
    }

    // Welcome ActionListener
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


    //UserMenu ActionListener
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

    // Play ActionListener
    private class PlayActionListener implements ActionListener
    {
        @Override
        public void actionPerformed(ActionEvent e) {

                // Actions hvis man klikker på Submit knappen
                if (e.getSource() == screen.getPlay().getBtnPlay())
                {
                    screen.getConfirmationPanel().showPlay(screen.play.gettxtMove());
                    screen.show(Screen.CONFIRMATION);
                    screen.getPlay().clearPlay();

                }
                else if (e.getSource() == screen.getPlay().getBtnCancel())
                {
                    screen.show(Screen.USERMENU);
                    screen.getPlay().clearPlay();
                }
        }
    }

    // Delete ActionListener
    private class DeleteActionListener implements ActionListener
    {
        @Override
        public void actionPerformed(ActionEvent e) {

            // Actions hvis man klikker på delete knappen
            if (e.getSource() == screen.getDeleteGame().getBtnDeleteGame())
            {
                screen.getConfirmationPanel().showDelete(screen.deleteGame.gettxtDelete());
                screen.show(Screen.CONFIRMATION);
                screen.getDeleteGame().clearDeleteGame();

            }
            else if (e.getSource() == screen.getDeleteGame().getBtnCancel())
            {
                screen.show(Screen.USERMENU);
                screen.getDeleteGame().clearDeleteGame();
            }
        }
    }
    // High score ActionListener
    private class HighScoreActionListener implements ActionListener
    {
        @Override
        public void actionPerformed(ActionEvent e) {

            // Actions hvis man klikker på tilbage knappen
            if (e.getSource() == screen.getHighScore().getBtnBack())
            {

                screen.show(Screen.USERMENU);

            }
        }
    }

    private class ConfirmationPanelActionListener implements ActionListener
    {
        @Override
        public void actionPerformed(ActionEvent e)
        {
            if (e.getSource() == screen.getConfirmationPanel().getBtnOk());
            screen.show(Screen.USERMENU);
        }
    }

}
