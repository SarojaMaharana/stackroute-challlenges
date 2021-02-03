package com.stackroute.oops.league.service;

import com.stackroute.oops.league.dao.PlayerDao;
import com.stackroute.oops.league.dao.PlayerDaoImpl;
import com.stackroute.oops.league.dao.PlayerTeamDao;
import com.stackroute.oops.league.dao.PlayerTeamDaoImpl;
import com.stackroute.oops.league.exception.PlayerAlreadyAllottedException;
import com.stackroute.oops.league.exception.PlayerAlreadyExistsException;
import com.stackroute.oops.league.exception.PlayerNotFoundException;
import com.stackroute.oops.league.exception.TeamAlreadyFormedException;
import com.stackroute.oops.league.model.Player;
import com.stackroute.oops.league.model.PlayerTeam;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

/**
 * This class implements leagueTeamService
 * This has four fields: playerDao, playerTeamDao and registeredPlayerList and playerTeamSet
 */
public class LeagueTeamServiceImpl implements LeagueTeamService {
    PlayerDao playerDao;
    PlayerTeamDao playerTeamDao;
    List<Player> registeredPlayersList;
    Set<PlayerTeam> playerTeamSet;

    /**
     * Constructor to initialize playerDao, playerTeamDao
     * empty ArrayList for registeredPlayerList and empty TreeSet for playerTeamSet
     */
    public LeagueTeamServiceImpl() {
        playerDao = new PlayerDaoImpl();
        playerTeamDao = new PlayerTeamDaoImpl();
        registeredPlayersList = new ArrayList<>();
        playerTeamSet = new TreeSet<>();
    }

    //Add player data to file using PlayerDao object
    @Override
    public boolean addPlayer(Player player) throws PlayerAlreadyExistsException {
        playerDao.addPlayer(player);
        return true;
    }

    /**
     * Register the player for the given teamTitle
     * Throws PlayerNotFoundException if the player does not exists
     * Throws PlayerAlreadyAllottedException if the player is already allotted to team
     * Throws TeamAlreadyFormedException if the maximum number of players has reached for the given teamTitle
     * Returns null if there no players available in the file "player.csv"
     * Returns "Registered" for successful registration
     * Returns "Invalid credentials" when player credentials are wrong
     */
    @Override
    public synchronized String registerPlayerToLeague(String playerId, String password, LeagueTeamTitles teamTitle)
            throws PlayerNotFoundException, TeamAlreadyFormedException, PlayerAlreadyAllottedException {
        Player playerObj = playerDao.findPlayer(playerId);

        if(playerDao.getAllPlayers().isEmpty()){
            return null;
        }

        if(playerObj == null)
            throw(new PlayerNotFoundException());

        if(!playerObj.getPassword().equals(password))
            return "Invalid credentials";

        playerTeamSet = playerTeamDao.getAllPlayerTeams();
        PlayerTeam pt = new PlayerTeam(playerId, teamTitle.getTeamName());

        if(playerTeamSet.contains(pt))
            throw(new PlayerAlreadyAllottedException());

        playerObj.setPlayerId(playerId);
        playerObj.setPassword(password);
        playerObj.setTeamTitle(teamTitle.getTeamName());
        registeredPlayersList.add(playerObj);
        return "Registered";
            
    }

    /**
     * Return the list of all registered players
     */
    @Override
    public List<Player> getAllRegisteredPlayers() {
        return registeredPlayersList;
    }


    /**
     * Return the existing number of players for the given title
     */
    @Override
    public int getExistingNumberOfPlayersInTeam(LeagueTeamTitles teamTitle) {
        Set<PlayerTeam> tempSet = playerTeamDao.getPlayerSetByTeamTitle(teamTitle.getTeamName());
        return tempSet.size();
    }

    /**
     * Admin credentials are authenticated and registered players are allotted to requested teams if available
     * If the requested teams are already formed,admin randomly allocates to other available teams
     * PlayerTeam object is added to "finalteam.csv" file allotted by the admin using PlayerTeamDao
     * Return "No player is registered" when registeredPlayerList is empty
     * Throw TeamAlreadyFormedException when maximum number is reached for all teams
     * Return "Players allotted to teams" when registered players are successfully allotted
     * Return "Invalid credentials for admin" when admin credentials are wrong
     */
    @Override
    public String allotPlayersToTeam(String adminName, String password, LeagueTeamTitles teamTitle)
            throws TeamAlreadyFormedException, PlayerNotFoundException {
        List<Player> playerLst = playerDao.getAllPlayers();
        // List<Player> playerLst = registeredPlayersList;
        String toReturn = "";
        int counter = 0;
        
        if(!(adminName.equals("admin") && password.equals("pass")))
            return "Invalid credentials for admin";
        
        if(playerLst.isEmpty())
            return "No player is registered";
        
        for(Player p:playerLst){
            if(p.getTeamTitle() == null)
                continue;
            if(p.getTeamTitle().equals(teamTitle.getTeamName()))
                counter++;
        }
        if(counter == 11)
            throw (new TeamAlreadyFormedException());

        for(Player p:playerLst){
            if(getExistingNumberOfPlayersInTeam(teamTitle)<11){
                System.out.println(getExistingNumberOfPlayersInTeam(teamTitle)+"default");
                p.setTeamTitle(teamTitle.getTeamName());
                playerTeamDao.addPlayerToTeam(p);
                toReturn = "Players allotted to teams";
            }
            else if(getExistingNumberOfPlayersInTeam(LeagueTeamTitles.HIPHOP) < 11){
                System.out.println(getExistingNumberOfPlayersInTeam(LeagueTeamTitles.valueOf("Hiphop"))+"hiphop");
                p.setTeamTitle("Hiphop");
                playerTeamDao.addPlayerToTeam(p);
                toReturn = "Players allotted to teams";
            }
            else if(getExistingNumberOfPlayersInTeam(LeagueTeamTitles.WIN2WIN) < 11){
                System.out.println(getExistingNumberOfPlayersInTeam(LeagueTeamTitles.valueOf("Win2Win"))+"WIN2WIN");
                p.setTeamTitle("Win2Win");
                playerTeamDao.addPlayerToTeam(p);
                toReturn = "Players allotted to teams";
            }
            else if(getExistingNumberOfPlayersInTeam(LeagueTeamTitles.HAPPYFEET) < 11){
                System.out.println(getExistingNumberOfPlayersInTeam(LeagueTeamTitles.valueOf("Happy Feet"))+"HAPPYFEET");
                p.setTeamTitle("Happy Feet");
                playerTeamDao.addPlayerToTeam(p);
                toReturn = "Players allotted to teams";
            }
            else if(getExistingNumberOfPlayersInTeam(LeagueTeamTitles.LUCKYSTRIKE) < 11){
                System.out.println(getExistingNumberOfPlayersInTeam(LeagueTeamTitles.valueOf("Lucky Strike"))+"LUCKYSTRIKE");
                p.setTeamTitle("Lucky Strike");
                playerTeamDao.addPlayerToTeam(p);
                toReturn = "Players allotted to teams";
            }
            else
                throw(new TeamAlreadyFormedException());
        }
           
        return toReturn;
    }


    /**
     * static nested class to initialize admin credentials
     * admin name='admin' and password='pass'
     */
    static class AdminCredentials {
        private static String admin = "admin";
        private static String password = "pass";
    }
}

