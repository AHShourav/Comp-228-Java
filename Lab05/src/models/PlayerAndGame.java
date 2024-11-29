package models;

import java.util.Date; //allows to create, modify date and time

public class PlayerAndGame {
    private int playerGameId;
    private int playerId;
    private int gameId;
    private Date playingDate;
    private int score;

    //constructor
    public PlayerAndGame(int playerGameId, int playerId, int gameId, Date playingDate, int score) {
        this.playerGameId = playerGameId;
        this.playerId = playerId;
        this.gameId = gameId;
        this.playingDate = playingDate;
        this.score = score;
    }

    public int getPlayerGameId() {
        return playerGameId;
    }

    public void setPlayerGameId(int playerGameId) {
        this.playerGameId = playerGameId;
    }

    public int getPlayerId() {
        return playerId;
    }

    public void setPlayerId(int playerId) {
        this.playerId = playerId;
    }

    public int getGameId() {
        return gameId;
    }

    public void setGameId(int gameId) {
        this.gameId = gameId;
    }

    public Date getPlayingDate() {
        return playingDate;
    }

    public void setPlayingDate(Date playingDate) {
        this.playingDate = playingDate;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }
}
