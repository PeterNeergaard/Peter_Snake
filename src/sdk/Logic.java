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
        // ActionListeners der refererer til alle  klasserne fra UI
        screen.getWelcome().addActionListener(new WelcomeActionListener());
        screen.getUserMenu().addActionListener(new UserMenuActionListener());
        screen.getPlay().addActionListener(new PlayActionListener());
        screen.getJoingame().addActionListener(new JoinGameActionListener());
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
            if (e.getSource() == screen.getWelcome().getBtnLogin()) { // når der trykkes på "login"

                // opretter to strings og deklarerer dem til det brugeren indtaster
                String username = screen.getWelcome().getUserName();
                String password = screen.getWelcome().getPassword();

                currentUser = new User(); // instantierer current user
                //sætter username og password for currentUser
                currentUser.setUsername(username);
                currentUser.setPassword(password);

                //kører logIn() med currentUsers variabler. og sætter derefter currentUser lig med det der retuneres
                currentUser = serverConnection.logIn(currentUser);

                //hvis der ikke retuneres null:
                if (currentUser != null) {
                    screen.show(screen.USERMENU); //brugeren føres til Usermenu
                    screen.getWelcome().getWrongUser().setVisible(false); //viser ikke wrong user tekst
                    screen.getWelcome().getError().setVisible(false); //viser ikke error tekst
                }

                // hvis der retuneres null:
                if (currentUser == null) {
                    screen.getWelcome().getWrongUser().setVisible(true); // der vises wrong user label
                }
            } else if (e.getSource() == screen.getWelcome().getBtnQuit()) { //hvis der trykkes på exit
                System.exit(0); // klienten lukker ned
            }
        }
    }

    //UserMenu ActionListener
    private class UserMenuActionListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == screen.getUserMenu().getBtnPlay()) // når brugeren trykker på play
            {
                screen.getPlay().clearPlay(); // rydder feltet play i tilfælde af der står noget
                screen.getPlay().clearName(); // rydder feltet name i tilfælde af der står noget
                screen.show(Screen.PLAY); //viser play skærmen
            }
            else if (e.getSource() == screen.getUserMenu().getBtnJoinGame()) // når brugeren trykker på join game
            {
                //ændrer synlighed af nogle knapper på skærmen
                screen.getJoingame().getBtnJoin().setVisible(true);
                screen.getJoingame().getBtnJoin().setEnabled(true);
                screen.getJoingame().getBtnPlay().setVisible(false);
                screen.getJoingame().getBtnPlay().setEnabled(false);

                screen.getJoingame().clearGameID(); // rydder feltet gameID i tilfælde af der står noget
                screen.getJoingame().clearMoves(); // rydder feltet moves i tilfælde af der står noget
                screen.show(Screen.JOINGAME); // viser join game skærmen
            }
            else if (e.getSource() == screen.getUserMenu().getBtnHighscore()) // når brugeren trykker på highscore
            {
                //Opretter en arraylist Score[] som får værdierne der returneres fra highscore() metoden i serverconnection
                Score[] highScores = serverConnection.highScore();

                screen.show(Screen.HIGHSCORE); // viser highscore skærmen
                screen.getHighScore().HighScoreTable(highScores); //henter tabellen til at vise highscore

            }
            else if (e.getSource() == screen.getUserMenu().getBtnDelete()) // når brugeren trykker på delete
            {
                screen.show(Screen.DELETEGAME); //viser delete skærmen
            }
            else if (e.getSource() == screen.getUserMenu().getBtnLogOut()) // når brugeren trykker på log out
            {
                screen.show(Screen.WELCOME); //viser welcome skærmen
                screen.getWelcome().clearUserName(); //rydder username feltet
                screen.getWelcome().clearPassword(); //rydder password feltet

            }
        }
    }


    // Play ActionListener
    private class PlayActionListener implements ActionListener
    {
        @Override
        public void actionPerformed(ActionEvent e) {

                // Actions hvis man trykker på Submit knappen
                if (e.getSource() == screen.getPlay().getBtnPlay())
                {
                    Gamer host = new Gamer(); // opretter et object af Gamer med navnet host
                    host.setId(currentUser.getId()); //sætter hostID til at være lig med den bruger som er logget ind
                    host.setControls(screen.getPlay().getMoves()); //sætter host control til det bugeren taster

                    Game game = new Game(); //opretter et objekt af Game, med navnet game
                    game.setName(screen.getPlay().getName()); // sætter spillets navn til det brugeren taster
                    game.setHost(host); // sætter spillet host til at være host
                    game.setMapSize(20); //sætter map size som 20

                    serverConnection.playGame(game); //kører playGame metoden fra serverconnection

                    // viser confirmation panel
                    screen.getConfirmationPanel().showPlay(screen.play.getName(), screen.play.getMoves());
                        screen.show(Screen.CONFIRMATION);


                }
                else if (e.getSource() == screen.getPlay().getBtnCancel()) // hvis brugeren trykker på back
                {
                    screen.show(Screen.USERMENU); //viser menuen
                }
        }
    }

    // Join game ActionListener
    private class JoinGameActionListener implements ActionListener
    {
        @Override
        public void actionPerformed(ActionEvent e) {

            // Actions hvis man trykker på join knappen
            if (e.getSource() == screen.getJoingame().getBtnJoin())
            {
                int gameId = screen.getJoingame().getIntGameId(); //opretter et gameID og sætter det lig det brugeren taster

                Gamer opponent = new Gamer(); //opretter et objekt af Gamer, med navnet opponent
                opponent.setId(currentUser.getId()); //sætter opponentID til at være lig med den bruger som er logget ind

                Game game = new Game(); //opretter et objekt af Game, med navnet game
                game.setOpponent(opponent); //sætter opponent til at være opponent
                game.setGameId(gameId); //sætter gameID til at være det brugeren har tastet

                //kører join game metoden og sætter den lig med en boolean success
                boolean success = serverConnection.joinGame(game);

                if (success) { //returneres true vises en ny knap
                    //skjuler/viser nogle knapper
                    screen.getJoingame().getBtnJoin().setVisible(false);
                    screen.getJoingame().getBtnJoin().setEnabled(false);
                    screen.getJoingame().getBtnPlay().setVisible(true);
                    screen.getJoingame().getBtnPlay().setEnabled(true);
                }
                else { // returneres false printes der fail
                    System.out.println("fail");
                }
            }
            else if (e.getSource() == screen.getJoingame().getBtnPlay()) { //når brugeren trykke på play knappen

                int gameId = screen.getJoingame().getIntGameId();

                Gamer opponent = new Gamer();
                opponent.setControls(screen.getJoingame().getMoves()); //sætter opponent control til det bugeren taster

                Game game = new Game(); //opretter et objekt af Game, med navnet game
                game.setOpponent(opponent); //sætter opponent til at være opponent
                game.setGameId(gameId); //sætter gameID til at være det brugeren har tastet

                serverConnection.startGame(game); // kører start game metoden fra serverConnection

                //viser confirmationpanel
                screen.getConfirmationPanel().showJoinGame(screen.joinGame.getMoves(), screen.joinGame.getGameId());
                screen.show(Screen.CONFIRMATION);
            }
            else if (e.getSource() == screen.getJoingame().getBtnCancel()) { //hvis der trykkes på back
                screen.show(Screen.USERMENU); // viser menuen
                screen.getJoingame().clearGameID(); //ryder GameID feltet
                screen.getJoingame().clearMoves(); // rydder moves feltet
            }
        }
    }

    // Delete ActionListener
    private class DeleteActionListener implements ActionListener
    {
        @Override
        public void actionPerformed(ActionEvent e) {

            // Actions hvis man trykker på delete knappen
            if (e.getSource() == screen.getDeleteGame().getBtnDeleteGame()) {

                // String sættes lig med det brugeren indtaster
                String gameId = screen.getDeleteGame().gettxtDelete();

                //kører delete game metoden og sætter den lig med en boolean success
                boolean success = serverConnection.deleteGame(gameId);

                if (success) { //retuneres true slettes spillet
                    //confirmation panel vises
                    screen.getConfirmationPanel().showDelete(screen.deleteGame.gettxtDelete());
                    screen.show(Screen.CONFIRMATION);
                    screen.getDeleteGame().clearDeleteGame(); //rydder delete game feltet
                }
                else { // returneres false printes fail
                    System.out.println("fail");
                }
            }
            else if (e.getSource() == screen.getDeleteGame().getBtnCancel()) // hvis der trykkes på back
            {
                screen.show(Screen.USERMENU); // bruger menuen vises
                screen.getDeleteGame().clearDeleteGame(); // rydder delete game felt
            }
        }
    }
    // High score ActionListener
    private class HighScoreActionListener implements ActionListener
    {
        @Override
        public void actionPerformed(ActionEvent e) {

            // Actions hvis man trykker på back knappen
            if (e.getSource() == screen.getHighScore().getBtnBack())
            {
                screen.getHighScore().clearTable(); //rydder highscore tabellen
                screen.show(Screen.USERMENU); //viser menuen
            }
        }
    }

    // Confirmation panel ActionListener
    private class ConfirmationPanelActionListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == screen.getConfirmationPanel().getBtnOk()) ; // når der trykkes på ok

            screen.show(Screen.USERMENU); // menuen vises
        }
    }


}