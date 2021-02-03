package com.stackroute.oops.league.dao;

import com.stackroute.oops.league.exception.PlayerNotFoundException;
import com.stackroute.oops.league.model.Player;
import com.stackroute.oops.league.model.PlayerTeam;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Set;
import java.util.TreeSet;

/**
 * This class implements the PlayerTeamDao interface
 * This class has two fields playerTeamSet,playerDao and a String constant for storing file name.
 */
public class PlayerTeamDaoImpl implements PlayerTeamDao {
    private static final String TEAM_FILE_NAME = "src/main/resources/finalteam.csv";
    private Set<PlayerTeam> playerTeam;

    /**
     * Constructor to initialize an empty TreeSet and PlayerDao object
     */
    public PlayerTeamDaoImpl() {
        playerTeam = new TreeSet<>();
        PlayerDao playerDao = new PlayerDaoImpl();
    }

    /*
    Returns the list of players belonging to a particular teamTitle by reading
    from the file finalteam.csv
     */
    @Override
    public Set<PlayerTeam> getPlayerSetByTeamTitle(String teamTitle) {
        Set<PlayerTeam> playersOfSpecificTeam = new TreeSet<>();
        try(FileReader f = new FileReader(TEAM_FILE_NAME); BufferedReader br = new BufferedReader(f)){
            String line;
            while((line = br.readLine())!=null){
                String[] data = line.split(", ");
                if(teamTitle.equalsIgnoreCase(data[1])){
                    PlayerTeam pt = new PlayerTeam(data[0], data[1]);
                    playersOfSpecificTeam.add(pt);
                }
            }
        } catch (FileNotFoundException e){
            e.printStackTrace();
        } catch (IOException e){
            e.printStackTrace();
        }
        return playersOfSpecificTeam;
    }

    //Add he given PlayerTeam Object to finalteam.csv file
    @Override
    public boolean addPlayerToTeam(Player player) throws PlayerNotFoundException {
        File file = new File(TEAM_FILE_NAME);
        try(BufferedWriter bw = new BufferedWriter(new FileWriter(file, true))){
            bw.append(player.getPlayerId()+", "+player.getTeamTitle()+"\n");
        } catch (IOException e){
            e.printStackTrace();
        }
        return true;
    }

    //Return the set of all PlayerTeam by reading the file content from finalteam.csv file
    @Override
    public Set<PlayerTeam> getAllPlayerTeams() {
        Set<PlayerTeam> playerTeamData = new TreeSet<>();
        try(FileReader f = new FileReader(TEAM_FILE_NAME); BufferedReader br = new BufferedReader(f)){
            String line;
            while((line = br.readLine())!=null){
                String[] data = line.split(", ");
                PlayerTeam pt = new PlayerTeam(data[0], data[1]);
                playerTeamData.add(pt);
            }
        } catch (FileNotFoundException e){
            e.printStackTrace();
        } catch (IOException e){
            e.printStackTrace();
        }
        return playerTeamData;
    }
}
