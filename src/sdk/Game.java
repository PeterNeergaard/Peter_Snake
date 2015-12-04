package sdk;

import java.sql.Date;

/**
 * Created by Peter on 12-10-2015.
 * OBS! fra serveren
 */

// klassen oprettes
public class Game {

    // Deklarerer variablerne til Game klassen
    private int gameId;
    private Gamer winner;
    private String name;
    private Gamer host;
    private Gamer opponent;
    private String status;
    private Date created;
    private int mapSize;

    public Game(){}

    //Laver getters og setters til alle variablerne
    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public int getMapSize() {
        return mapSize;
    }

    public void setMapSize(int mapSize) {
        this.mapSize = mapSize;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getGameId(){
        return gameId;
    }

    public void setGameId(int gameId){
        this.gameId = gameId;
    }

    public Gamer getHost(){
        return host;
    }

    public void setHost(Gamer host){
        this.host = host;
    }

    public Gamer getOpponent(){
        return opponent;
    }

    public void setOpponent(Gamer opponent){
        this.opponent = opponent;
    }

    public String getStatus(){
        return status;
    }

    public void setStatus(String status){
        this.status = status;
    }

    public Gamer getWinner() {
        return winner;
    }

    public void setWinner(Gamer winner) {
        this.winner = winner;
    }
} //end of class
