package com.stackroute.oops.league.model;

/**
 * This class contains five fields playerId,playerName,password,yearExpr and teamTitle
 * It is a subclass of Comparable interface
 */
public class Player extends Thread implements Comparable {
    private String playerId;
    private String playerName;
    private String password;
    private int yearExpr;
    private String teamTitle;
    //Parameterized Constructor to initialize all properties
    public Player(String playerId, String playerName, String password, int yearExpr) {
        this.playerId = playerId;
        this.playerName = playerName;
        this.password = password;
        this.yearExpr = yearExpr;
    }

    public String getPlayerId() {
        return playerId;
    }

    public String getPlayerName() {
        return playerName;
    }

    public String getPassword() {
        return password;
    }

    public int getYearExpr() {
        return yearExpr;
    }

    public void setPlayerId(String playerId) {
        this.playerId = playerId;
    }

    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setYearExpr(int yearExpr) {
        this.yearExpr = yearExpr;
    }

    //Return teamTitle if it is present and not empty
    public String getTeamTitle() {
        if(teamTitle == null || teamTitle =="")
            return null;
        else
            return teamTitle;
    }

    public void setTeamTitle(String teamTitle) {
        this.teamTitle = teamTitle;
    }

    /**
     * This overridden method should return player details in below format
     * Player{playerId=xxxxx, playerName=xxxxxx, yearExpr=xxxxxx,teamTitle=xxxxxxxx}-> if league team title is set
     * Player{playerId=xxxxx, playerName=xxxxxx, yearExpr=xxxxxx}-> if league team title not set
     */
    @Override
    public String toString() {
        if(getTeamTitle() == null)
            return ("Player{playerId="+getPlayerId()+", playerName="+getPlayerName()+", yearExpr="+getYearExpr()+"}");
        else
            return ("Player{playerId="+getPlayerId()+", playerName="+getPlayerName()+", yearExpr="+getYearExpr()+", teamTitle="+getTeamTitle()+"}");
    }

    //Overridden equals method
    @Override
    public boolean equals(Object object) {
        return false;
    }

    //Overridden hashcode method
    @Override
    public int hashCode() {
        return 0;
    }

    //compares player object based on playerId
    @Override
    public int compareTo(Object o) {
        return 0;
    }

}
