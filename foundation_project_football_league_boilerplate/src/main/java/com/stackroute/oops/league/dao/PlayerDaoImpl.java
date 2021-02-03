package com.stackroute.oops.league.dao;

import com.stackroute.oops.league.exception.PlayerAlreadyExistsException;
import com.stackroute.oops.league.exception.PlayerNotFoundException;
import com.stackroute.oops.league.model.Player;

import java.util.ArrayList;
import java.util.List;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;


/**
 * This class is implementing the PlayerDao interface
 * This class has one field playerList and a String constant for storing file name
 */
public class PlayerDaoImpl implements PlayerDao {
    private static final String PLAYER_FILE_NAME = "src/main/resources/player.csv";
    private List<Player> playerList;

    /**
     * Constructor to initialize an empty ArrayList for playerList
     */
    public PlayerDaoImpl() {
        playerList = new ArrayList<>();
    }

    /**
     * Return true if  player object is stored in "player.csv" as comma separated fields successfully
     * when password length is greater than six and yearExpr is greater than zero
     */
    @Override
    public boolean addPlayer(Player player) throws PlayerAlreadyExistsException {
        Player playerObj = null;
        try{
            playerObj = findPlayer(player.getPlayerId());
        } catch(PlayerNotFoundException e){
            e.printStackTrace();
        }
        if(playerObj == null){
            if((player.getPassword().length() > 6) && (player.getYearExpr() > 0)){
                File file = new File(PLAYER_FILE_NAME);
                try(BufferedWriter bw = new BufferedWriter(new FileWriter(file, true))){
                    bw.append(player.getPlayerId()+", "+player.getPlayerName()+", "+player.getPassword()+", "+player.getYearExpr()+", "+player.getTeamTitle()+"\n");
                    bw.close();
                } catch (IOException e){
                    e.printStackTrace();
                }
                return true;
            }
            else
                return false;
        }
        else
            throw(new PlayerAlreadyExistsException());
        // return false;
    }

    //Return the list of player objects by reading data from the file "player.csv"
    @Override
    public List<Player> getAllPlayers() {
        List<Player> playerObjects = new ArrayList<>();
        try(FileReader f = new FileReader(PLAYER_FILE_NAME); BufferedReader br = new BufferedReader(f)){
            String line;
            while((line = br.readLine())!=null){
                String[] data = line.split(", ");
                Player p = new Player(data[0], data[1], data[2], Integer.parseInt(data[3]));
                p.setTeamTitle(data[4]);
                playerObjects.add(p);
                playerList.add(p);
            }
        }catch (FileNotFoundException e){
            e.printStackTrace();
        } catch (IOException e){
            e.printStackTrace();
        }

        return playerObjects;
    }

    /**
     * Return Player object given playerId to search
     */
    @Override
    public Player findPlayer(String playerId) throws PlayerNotFoundException {
        List<Player> allPlayers = getAllPlayers();
        boolean flag = false;
        if(allPlayers.isEmpty())
            throw(new PlayerNotFoundException());
        else{
            for(Player p:allPlayers){
                if(p.getPlayerId().equals(playerId)){
                    flag = true;
                    return p;
                }
            }
            if(flag == false){
                throw (new PlayerNotFoundException());
            }
        }
        return null;

    }
}
