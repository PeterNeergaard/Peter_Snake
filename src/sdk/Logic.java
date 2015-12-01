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
    private ServerConnection serverConnection;
    private User currentUser;


    public Logic() {
        // instantierer følgende variablerene
        screen = new Screen();
        serverConnection = new ServerConnection();
        screen.setVisible(true);
    }

    public void run() {
        // ActionListiners der refererer til alle de klasserne fra UI
        screen.getWelcome().addActionListener(new WelcomeActionListener());
        screen.getUserMenu().addActionListener(new UserMenuActionListener());
        screen.getPlay().addActionListener(new PlayActionListener());
        //screen.getJoingame().addActionListener(new JoinGameActionListener());
        screen.getHighScore().addActionListener(new HighScoreActionListener());
        screen.getDeleteGame().addActionListener(new DeleteActionListener());
        screen.getConfirmationPanel().addActionListener(new ConfirmationPanelActionListener());

        screen.show(Screen.WELCOME);
    }

    // Welcome ActionListener
    private class WelcomeActionListener implements ActionListener
    {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == screen.getWelcome().getBtnLogin()) {
                String username = screen.getWelcome().getUserName();
                String password = screen.getWelcome().getPassword();

                currentUser = new User();
                currentUser.setUsername(username);
                currentUser.setPassword(password);

                currentUser = serverConnection.logIn(currentUser);

                if (currentUser != null) {
                    screen.show(screen.USERMENU);
                    screen.getWelcome().getWrongUser().setVisible(false);
                    screen.getWelcome().getError().setVisible(false);
                    System.out.println(currentUser.getId());
                }

                if (currentUser == null) {
                    screen.getWelcome().getWrongUser().setVisible(true);
                }
            } else if (e.getSource() == screen.getWelcome().getBtnQuit()) {
                System.exit(0);
            }
        }
    }

    //UserMenu ActionListener
    private class UserMenuActionListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == screen.getUserMenu().getBtnPlay())
            {
                screen.show(Screen.PLAY);
            }
            else if (e.getSource() == screen.getUserMenu().getBtnJoinGame())
            {
                screen.show(Screen.JOINGAME);
            }
            else if (e.getSource() == screen.getUserMenu().getBtnHighscore())
            {
                Score[] highScores = serverConnection.highScore();
                screen.getHighScore().HighScoreTable(highScores);
                screen.show(Screen.HIGHSCORE);
            }
            else if (e.getSource() == screen.getUserMenu().getBtnDelete())
            {
                screen.show(Screen.DELETEGAME);
            }
            else if (e.getSource() == screen.getUserMenu().getBtnLogOut())
            {
                screen.show(Screen.WELCOME);
                screen.getWelcome().clearUserName();
                screen.getWelcome().clearPassword();
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
                    Gamer host = new Gamer();
                    host.setId(currentUser.getId());
                    host.setControls(screen.getPlay().getMoves());

                    Game game = new Game();
                    game.setName(screen.getPlay().getName());
                    game.setHost(host);
                    game.setMapSize(20);

                    serverConnection.playGame(game);

                        screen.getConfirmationPanel().showPlay(screen.play.getName(), screen.play.getMoves());
                        screen.show(Screen.CONFIRMATION);
                        screen.getPlay().clearPlay();
                        screen.getPlay().clearName();

                }
                else if (e.getSource() == screen.getPlay().getBtnCancel())
                {
                    screen.show(Screen.USERMENU);
                    screen.getPlay().clearPlay();
                }
        }
    }

    /**private class JoinGameActionListener implements ActionListener
    {
        @Override
        public void actionPerformed(ActionEvent e) {

            // Actions hvis man klikker på play knappen
            if (e.getSource() == screen.getJoingame().getBtnPlay())
            {
                Gamer opponent = new Gamer();
                opponent.setId(currentUser.getId());
                opponent.setControls(screen.getJoingame().getMoves());

                Game game = new Game();
                game.setOpponent(opponent);
                game.setGameId(screen.getJoingame().getIntGameId());

                String json = new Gson().toJson(game);

                ServerConnection con = new ServerConnection();
                ClientResponse response = con.post(json, "games/join/");

                if (response.getStatus() == 201) {
                    System.out.println("Game joined");

                    screen.getConfirmationPanel().showPlay(screen.play.getName(), screen.play.getMoves());
                    screen.show(Screen.CONFIRMATION);
                    screen.getPlay().clearPlay();
                    screen.getPlay().clearName();

                }
                if (response.getStatus() == 400) {
                    System.out.println("Something went wrong");

                 }

                screen.getConfirmationPanel().showJoinGame(screen.joinGame.getMoves(), screen.joinGame.getGameId());
                screen.show(Screen.CONFIRMATION);
                screen.getJoingame().clearGameID();
                screen.getJoingame().clearMoves();
            }
            else if (e.getSource() == screen.getJoingame().getBtnCancel())
            {
                screen.show(Screen.USERMENU);
                screen.getJoingame().clearGameID();
                screen.getJoingame().clearMoves();
            }
        }
    }*/

    // Delete ActionListener
    private class DeleteActionListener implements ActionListener
    {
        @Override
        public void actionPerformed(ActionEvent e) {

            // Actions hvis man klikker på delete knappen
            if (e.getSource() == screen.getDeleteGame().getBtnDeleteGame()) {

                String gameId = screen.getDeleteGame().gettxtDelete();

                boolean success = serverConnection.deleteGame(gameId);
                if (success) {
                        screen.getConfirmationPanel().showDelete(screen.deleteGame.gettxtDelete());
                        screen.show(Screen.CONFIRMATION);
                        screen.getDeleteGame().clearDeleteGame();
                }
                else {
                    System.out.println("fail");
                }
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

    private class ConfirmationPanelActionListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == screen.getConfirmationPanel().getBtnOk()) ;
            screen.show(Screen.USERMENU);
        }
    }


}

