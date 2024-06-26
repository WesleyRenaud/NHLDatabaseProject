/**
 * A class used as a data structure for all players in the database. The class manages the data
 * structure and retrieves data from it.
 */

package player;


import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import input.InputAnalyzer;
import utilities.BufferGenerator;
import utilities.NHLConstants;


public class Players implements Serializable
{
    private static final long serialVersionUID = -2181392019916751192L;
    private List<Player> players;


    public Players()
    {
        players = new ArrayList<>();
    }


    /**
     * Adds a new skater to the list of players given their name, birthday, handedness, retired
     * status, number, and team.
     * 
     * @param name          The skater's name.
     * @param birthday      The skater's birthday.
     * @param handedness    The skater's handedness.
     * @param retired       The skater's retired status.
     * @param number        The skater's jersey number.
     * @param team          The skater's team.
     */
    public void addSkater( String name, String birthday, String handedness, boolean retired, int number, String team )
    {
        players.add( new Skater( name, birthday, handedness, retired, number, team ) );
    }

    /**
     * Adds a new goalie to the list of players given their name, birthday, handedness, 
     * retired status, number, and team.
     * 
     * @param name          The goalie's name.
     * @param birthday      The goalie's birthday.
     * @param handedness    The goalie's handedness.
     * @param retired       The goalie's retired status.
     * @param number        The goalie's jersey number.
     * @param team          The goalie's team.
     */
    public void addGoalie( String name, String birthday, String handedness, boolean retired, int number, String team )
    {
        players.add( new Goalie( name, birthday, handedness, retired, number, team ) );
    }

    /**
     * Appends a season to a given skater's career.
     * 
     * @param name          The skater whose stats are being edited
     * @param season        The season being added.
     * @param gamesPlayed   The number of games played during the season.
     * @param goals         The number of goals during the season.
     * @param assists       The number of assists during the season.
     * @param plusMinus     he plus-minus during the season.
     */
    public void addSkaterSeason( String name, String season, int gamesPlayed, int goals, int assists, int plusMinus )
    {
        int index = getPlayerIndex( name );
        players.get(index).addSkaterSeason( season, gamesPlayed, goals, assists, plusMinus );
    }

    /**
     * Appends a season to a given goalie's career.
     * 
     * @param playerName            The goalie whose stats are being edited.
     * @param season                The season being added.
     * @param wins                  The number of wins during the season.
     * @param loses                 The number of loses during the season.
     * @param overtimeLoses         The number of overtime loses during the season.
     * @param savePercentage        The save percentafe during the season
     * @param goalsAgainstAverage   The goals against average during the season.
     */
    public void addGoalieSeason( String playerName, String season, int wins, int loses, int overtimeLoses, double savePercentage, 
                                                                                                           double goalsAgainstAverage )
    {
        int index = getPlayerIndex( playerName );
        players.get(index).addGoalieSeason( season, wins, loses, overtimeLoses, savePercentage, goalsAgainstAverage );
    }

    /**
     * Removes a given player from the database.
     * 
     * @param playerName    The name of the player to remove.
     */
    public void removePlayer( String playerName )
    {
        int index = getPlayerIndex( playerName );
        players.remove( players.get(index) );
    }

    /**
     * Edits stats for a given skater during a given season.
     * 
     * @param playerName    The skater whose stats are being edited.
     * @param season        The season of which the stats are being edited.
     * @param gamesPlayed   The new number of games played.
     * @param goals         The new number of goals.
     * @param assists       The new number of assists.
     * @param plusMinus     The new plus-minus.
     */
    public void editSkaterSeasonStats( String playerName, String season, int gamesPlayed, int goals, int assists, int plusMinus )
    {
        int index = getPlayerIndex( playerName );
        players.get(index).editSkaterSeason( season, gamesPlayed, goals, assists, plusMinus );
    }

    /**
     * Edits stats for a given goalie during a given season.
     * 
     * @param playerName            The goalie whose stats are being updated.
     * @param season                The season of which the stats are being edited.
     * @param wins                  The new number of wins.
     * @param loses                 The new number of loses.
     * @param overtimeLoses         The new number of overtime loses.
     * @param savePercentage        The new save percentage.
     * @param goalsAgainstAverage   The new goals against average.
     */
    public void editGoalieSeasonStats( String playerName, String season, int wins, int loses, int overtimeLoses, double savePercentage, 
                                                                                                   double goalsAgainstAverage )
    {
        int index = getPlayerIndex( playerName );
        players.get(index).editGoalieSeason( season, wins, loses, overtimeLoses, savePercentage, goalsAgainstAverage );
    }

    /**
     * Edits the team for a given player.
     * 
     * @param playerName    The name of the player whose team is being edited.
     * @param team          The new team of the player.
     */
    public void editTeam( String playerName, String team )
    {
        int index = getPlayerIndex( playerName );
        players.get(index).setTeam( team );
    }

    /**
     * Edits the number for a given player.
     * 
     * @param playerName    The name of the player whose number is being edited.
     * @param number        The new number of the player.
     */
    public void editNumber( String playerName, int number )
    {
        int index = getPlayerIndex( playerName );
        players.get(index).setNumber( number );
    }

    /**
     * Edits the name of a given player.
     * 
     * @param currentName   The current name of the player.
     * @param newName       The new name of the player.
     */
    public void editName( String currentName, String newName )
    {
        int index = getPlayerIndex( currentName );
        players.get(index).setName( newName );
    }

    /**
     * Edits the name of a given player.
     * 
     * @param playerName    The name of the player whose birthday is being edited.
     * @param birthday      The new birthday of the player.
     */
    public void editBirthday( String playerName, String birthday )
    {
        int index = getPlayerIndex( playerName );
        players.get(index).setBirthday( birthday );
    }

    /**
     * Prints a given player's stats for the current season.
     * 
     * @param playerName    The name of the player whose stats we are printing.
     */
    public void printCurrentSeasonStats( String playerName )
    {
        int index = getPlayerIndex( playerName );
        players.get(index).printStatsFromSeason( "2023-2024" );
    }

    /**
     * Prints a given player's career stats.
     * 
     * @param playerName    The name of the player whose stats we are printing.
     */
    public void printCareerStats( String playerName )
    {
        int index = getPlayerIndex( playerName );
        players.get(index).printCareerStats();
    }

    /**
     * Prints a given player's stats from a given season.
     * 
     * @param playerName    The name of the player whose stats we are printing.
     * @param season        The season to print the stats of.
     */
    public void printStatsFromSeason( String playerName, String season )
    {
        int index = getPlayerIndex( playerName );
        players.get(index).printStatsFromSeason( season );
    }

    /**
     * Prints a given player's stats over a range of seasons, given a start and an end.
     * 
     * @param playerName    The name of the player whose stats we are printing.
     * @param firstSeason   The first season to print the stats of.
     * @param lastSeason    The last season to print the stats of.
     */
    public void printStatsFromStartUntilEnd( String playerName, String firstSeason, String lastSeason )
    {
        int index = getPlayerIndex( playerName );
        players.get(index).printStatsFromStartUntilEnd( firstSeason, lastSeason );
    }

    /**
     * Prints a given player's stats from a given starting season until the end of their
     * career.
     * 
     * @param playerName    The name of the player whose stats we are printing.
     * @param firstSeason   The first season to print the stats of.
     */
    public void printStatsFromStart( String playerName, String firstSeason )
    {
        int index = getPlayerIndex( playerName );
        players.get(index).printStatsFromStart( firstSeason );

    }

    /**
     * Prints a player's stats from the start of their career up until a given ending
     * season.
     * 
     * @param playerName    The name of the player whose stats we are printing.
     * @param lastSeason   The first season to print the stats of.
     */
    public void printStatsUntilEnd( String playerName, String lastSeason )
    {
        int index = getPlayerIndex( playerName );
        players.get(index).printStatsUntilEnd( lastSeason );
    }


    /**
     * Prints the stats of a team's skaters, sorted by points.
     * 
     * @param team  The team to print the skaters stats of.
     */
    public void printTeamLeaders_InPoints( String team )
    {
        List<Player> teamPlayers = getSkatersOnTeam( team );
        if (teamPlayers.size() > 0) {
            sortByPoints( teamPlayers );
            System.out.println();
            BufferGenerator.printBuffer( NHLConstants.players_WithName_BufferLength );
            printPlayersCurrentSeasonStats( teamPlayers );
        } else {
            System.out.println( "\n ! No Players Found !" );
        }
    }

    /**
     * Prints the stats of a team's skaters, sorted by goals.
     * 
     * @param team  The team to print the skaters stats of.
     */
    public void printTeamLeaders_InGoals( String team )
    {
        List<Player> teamPlayers = getSkatersOnTeam( team );
        if (teamPlayers.size() > 0) {
            sortByGoals( teamPlayers );
            System.out.println();
            BufferGenerator.printBuffer( NHLConstants.players_WithName_BufferLength );
            printPlayersCurrentSeasonStats( teamPlayers );
        } else {
            System.out.println( "\n ! No Players Found !" );
        }
    }

    /**
     * Prints the stats of a team's skaters, sorted by assists.
     * 
     * @param team  The team to print the skaters stats of.
     */
    public void printTeamLeaders_InAssists( String team )
    {
        List<Player> teamPlayers = getSkatersOnTeam( team );
        if (teamPlayers.size() > 0) {
            sortByAssists( teamPlayers );
            System.out.println();
            BufferGenerator.printBuffer( NHLConstants.players_WithName_BufferLength );
            printPlayersCurrentSeasonStats( teamPlayers );
        } else {
            System.out.println( "\n ! No Players Found !" );
        }
    }

    /**
     * Prints the stats of a team's skaters, sorted by plus-minus.
     * 
     * @param team  The team to print the skaters stats of.
     */
    public void printTeamLeaders_InPlusMinus( String team )
    {
        List<Player> teamPlayers = getSkatersOnTeam( team );
        if (teamPlayers.size() > 0) {
            sortByPlusMinus( teamPlayers );
            System.out.println();
            BufferGenerator.printBuffer( NHLConstants.players_WithName_BufferLength );
            printPlayersCurrentSeasonStats( teamPlayers );
        } else {
            System.out.println( "\n ! No Players Found !" );
        }
    }

    /**
     * Prints the stats of a team's goalies, sorted by wins.
     * 
     * @param team  The team to print the goalie' stats of.
     */
    public void printTeamLeaders_InWins( String team )
    {
        List<Player> teamPlayers = getGoaliesOnTeam( team );
        if (teamPlayers.size() > 0) {
            sortByWins( teamPlayers );
            System.out.println();
            BufferGenerator.printBuffer( NHLConstants.players_WithName_BufferLength );
            printPlayersCurrentSeasonStats( teamPlayers );
        } else {
            System.out.println( "\n ! No Players Found !" );
        }
    }

    /**
     * Prints the stats of a team's goalies, sorted by save percentage.
     * 
     * @param team  The team to print the goalies stats of.
     */
    public void printTeamLeaders_InSavePercentage( String team )
    {
        List<Player> teamPlayers = getGoaliesOnTeam( team );
        if (teamPlayers.size() > 0) {
            sortBySavePercentage( teamPlayers );
            System.out.println();
            BufferGenerator.printBuffer( NHLConstants.players_WithName_BufferLength );
            printPlayersCurrentSeasonStats( teamPlayers );
        } else {
            System.out.println( "\n ! No Players Found !" );
        }
    }

    /**
     * Prints the stats of a team's goalies, sorted by goals against average.
     * 
     * @param team  The team to print the goalies stats of.
     */
    public void printTeamLeaders_InGoalsAgainstAverage( String team )
    {
        List<Player> teamPlayers = getGoaliesOnTeam( team );
        if (teamPlayers.size() > 0) {
            sortByGoalsAgainstAverage( teamPlayers) ;
            System.out.println();
            BufferGenerator.printBuffer( NHLConstants.players_WithName_BufferLength );
            printPlayersCurrentSeasonStats( teamPlayers );
        } else {
            System.out.println( "\n ! No Players Found !" );
        }
    }

    /**
     * Prints the league leaders in points.
     */
    public void printPointLeaders()
    {
        List<Player> currentPlayers = getCurrentSkaters();
        if (currentPlayers.size() > 0) {
            sortByPoints( currentPlayers );
            System.out.println();
            BufferGenerator.printBuffer( NHLConstants.players_WithName_BufferLength );
            printPlayersCurrentSeasonStats( currentPlayers );
        } else {
            System.out.println( "\n ! No Players Found !" );
        }
    }

    /**
     * Prints the league leaders in goals.
     */
    public void printGoalLeaders()
    {
        List<Player> currentPlayers = getCurrentSkaters();
        if (currentPlayers.size() > 0) {
            sortByGoals( currentPlayers) ;
            System.out.println();
            BufferGenerator.printBuffer( NHLConstants.players_WithName_BufferLength );
            printPlayersCurrentSeasonStats( currentPlayers );
        } else {
            System.out.println( "\n ! No Players Found !" );
        }
    }

    /**
     * Prints the league leaders in assists.
     */
    public void printAssistLeaders()
    {
        List<Player> currentPlayers = getCurrentSkaters();
        if (currentPlayers.size() > 0) {
            sortByAssists( currentPlayers );
            System.out.println();
            BufferGenerator.printBuffer( NHLConstants.players_WithName_BufferLength );
            printPlayersCurrentSeasonStats( currentPlayers );
        } else {
            System.out.println( "\n ! No Players Found !" );
        }
    }

    /**
     * Prints the league leaders in plus-minus.
     */
    public void printPlusMinusLeaders()
    {
        List<Player> currentPlayers = getCurrentSkaters();
        if (currentPlayers.size() > 0) {
            sortByPlusMinus( currentPlayers );
            System.out.println();
            BufferGenerator.printBuffer( NHLConstants.players_WithName_BufferLength );
            printPlayersCurrentSeasonStats( currentPlayers );
        } else {
            System.out.println( "\n ! No Players Found !" );
        }
    }

    /**
     * Prints the league leaders in wins.
     */
    public void printWinLeaders()
    {
        List<Player> currentPlayers = getCurrentGoalies();
        if (currentPlayers.size() > 0) {
            sortByWins( currentPlayers );
            System.out.println();
            BufferGenerator.printBuffer( NHLConstants.players_WithName_BufferLength );
            printPlayersCurrentSeasonStats( currentPlayers );
        } else {
            System.out.println( "\n ! No Players Found !" );
        }
    }

    /**
     * Prints the league leaders in save percentage.
     */
    public void printSavePercentageLeaders()
    {
        List<Player> currentPlayers = getCurrentGoalies();
        if (currentPlayers.size() > 0) {
            sortBySavePercentage( currentPlayers );
            System.out.println();
            BufferGenerator.printBuffer( NHLConstants.players_WithName_BufferLength );
            printPlayersCurrentSeasonStats( currentPlayers );
        } else {
            System.out.println( "\n ! No Players Found !" );
        }
    }

    /**
     * Prints the league leaders in goals against average.
     */
    public void printGoalsAgainstAverageLeaders()
    {
        List<Player> currentPlayers = getCurrentGoalies();
        if (currentPlayers.size() > 0) {
            sortByGoalsAgainstAverage( currentPlayers );
            System.out.println();
            BufferGenerator.printBuffer( NHLConstants.players_WithName_BufferLength );
            printPlayersCurrentSeasonStats( currentPlayers );
        } else {
            System.out.println( "\n ! No Players Found !" );
        }
    }

    /**
     * Prints a list of players' stats for the current season.
     * 
     * @param list  The list of players we are printing.
     */
    private void printPlayersCurrentSeasonStats( List<Player> list )
    {
        for (int i = 0; i < list.size(); i++) {
            System.out.printf( "%d.\t", (i + 1) );
            list.get(i).printCurrentSeasonStats_WithPlayerName();
        }
    }

    /**
     * Gets a list of all the skaters on a given team.
     * 
     * @param team  The team to get the skaters of.
     * @return  The list of the skaters on the team.
     */
    private List<Player> getSkatersOnTeam( String team )
    {
        List<Player> teamSkaters = new ArrayList<>();
        for (int i = 0; i < players.size(); i++) {
            if (!players.get(i).isRetired() && players.get(i).isSkater() && players.get(i).getTeam().equals( team ) ) {
                teamSkaters.add(players.get(i));
            }
        }
        return teamSkaters;
    }

    /**
     * Gets a list of all the goalies on a given team.
     * 
     * @param team  The team to get the goalies of.
     * @return  The list of the goalies on the team.
     */
    private List<Player> getGoaliesOnTeam( String team )
    {
        List<Player> teamGoalies = new ArrayList<>();
        for (int i = 0; i < players.size(); i++) {        
            if (!players.get(i).isRetired() && players.get(i).isGoalie() && players.get(i).getTeam().equals( team )) {
                teamGoalies.add( players.get(i) );
            }
        }
        return teamGoalies;
    }


    /**
     * Sorts a list of players by number of points in the current season, in descending order.
     */
    private void sortByPoints( List<Player> list )
    {
        Collections.sort( list, new Comparator<Player>() {
            public int compare( Player player1, Player player2 ) {
                return player2.getCurrentSeasonPoints() - player1.getCurrentSeasonPoints();
            }
        });
    }

    /**
     * Sorts a list of players by number of goals in the current season, in descending order.
     */
    private void sortByGoals( List<Player> list )
    {
        Collections.sort( list, new Comparator<Player>() {
            public int compare( Player player1, Player player2 ) {
                return player2.getCurrentSeasonGoals() - player1.getCurrentSeasonGoals();
            }
        });
    }

    /**
     * Sorts a list of players by number of assists in the current season, in descending order.
     */
    private void sortByAssists( List<Player> list )
    {
        Collections.sort( list, new Comparator<Player>() {
            public int compare( Player player1, Player player2 ) {
                return player2.getCurrentSeasonAssists() - player1.getCurrentSeasonAssists();
            }
        });
    }

    /**
     * Sorts a list of players by plus-minus in the current season, in descending order.
     */
    private void sortByPlusMinus( List<Player> list )
    {
        Collections.sort( list, new Comparator<Player>() {
            public int compare( Player player1, Player player2 ) {
                return player2.getCurrentSeasonPlusMinus() - player1.getCurrentSeasonPlusMinus();
            }
        });
    }

    /**
     * Sorts a list of players by number of wins in the current season, in descending order.
     */
    private void sortByWins( List<Player> list )
    {
        Collections.sort( list, new Comparator<Player>() {
            public int compare( Player player1, Player player2 ) {
                return player2.getCurrentSeasonWins() - player1.getCurrentSeasonWins();
            }
        });
    }

    /**
     * Sorts a list of players by save percentage in the current season, in descending order.
     */
    private void sortBySavePercentage( List<Player> list )
    {
        Collections.sort( list, new Comparator<Player>() {
            public int compare( Player player1, Player player2 ) {
                return (int)(100 * (player2.getCurrentSeasonSavePercentage() - player1.getCurrentSeasonSavePercentage()));
            }
        });
    }

    /**
     * Sorts a list of players by goals against average in the current season, in descending order.
     */
    private void sortByGoalsAgainstAverage( List<Player> list )
    {
        Collections.sort( list, new Comparator<Player>() {
            public int compare( Player player1, Player player2 ) {
                return (int)(100 * (player1.getCurrentSeasonGoalsAgainstAverage() - player2.getCurrentSeasonGoalsAgainstAverage()));
            }
        });
    }

    /**
     * Gets a list of all of the active skaters in the league.
     * 
     * @return  A list of all of the active skaters in the league.
     */
    private List<Player> getCurrentSkaters()
    {
        List<Player> currentPlayers = new ArrayList<>();
        for (int i = 0; i < players.size(); i++) {
            if (!players.get(i).isRetired() && players.get(i).isSkater()) {
                currentPlayers.add( players.get(i) );
            }
        }
        return currentPlayers;
    }

    /**
     * Gets a list of all of the active goalies in the league.
     * 
     * @return  A list of all of the active goalies in the league.
     */
    private List<Player> getCurrentGoalies()
    {
        List<Player> currentPlayers = new ArrayList<>();
        for (int i = 0; i < players.size(); i++) {
            if (!players.get(i).isRetired()  && players.get(i).isGoalie()) {
                currentPlayers.add( players.get(i) );
            }
        }
        return currentPlayers;
    }

    /**
     * Checks if a player exists in the database.
     * 
     * @param playerName    The name of the player to check.
     * @return  True if the player is in the database and false otherwise.
     */
    public boolean checkPlayerExists( String playerName )
    {
        for (int i = 0; i < players.size(); i++) {
            if (InputAnalyzer.checkSpecificInput( players.get(i).getName(), playerName )) {
                return true;
            }
        }
        return false;
    }

    /**
     * Checks if a player is a skater.
     * 
     * @param playerName    The name of the player to check.
     * @return  True if the player is a skater, and false otherwise.
     */
    public boolean checkPlayerIsSkater( String playerName )
    {
        int index = getPlayerIndex( playerName );
        if (players.get(index).getClass().equals( Skater.class )) {
            return true;
        }
        return false;
    }

    /**
     * Checks if a player is a goalie.
     * 
     * @param playerName    The name of the player to check.
     * @return  True if the player is a goalie, and false otherwise.
     */
    public boolean checkPlayerIsGoalie( String playerName )
    {
        if (!checkPlayerIsSkater( playerName )) {
            return true;
        }
        return false;
    }   

    /**
     * Returns the index in the array of a specific player.
     * 
     * @param playerName    The name of the player to get the index of.
     * @return  The index of the player if it is found, and -1 otherwise.
     */
    private int getPlayerIndex( String playerName )
    {
        for (int i = 0; i < players.size(); i++) {
            if (players.get(i).getName().equals( playerName )) {
                return i;
            }
        }
        return -1;
    }
}