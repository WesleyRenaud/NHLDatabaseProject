package team;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import input.InputAnalyzer;


public class Seasons implements Serializable
{
    private static final long serialVersionUID = -1992656083889052631L;
    private List<Standings> seasons = new ArrayList<>();

    
    /**
     * Adds a season of standings to the database.
     * 
     * @param season    The season for the new set of standings.
     */
    public void addSeason( String season )
    {
        seasons.add( new Standings( season ));
    }

    
    /**
     * Adds a new team to a given year of standings.
     * 
     * @param season        The year of standings to add the team to.
     * @param city          The team's city.
     * @param name          The team's name.
     * @param conference    The team's conference.
     * @param division      The team's divison.
     * @param wins          The team's number of wins.
     * @param loses         The team's number of loses.
     * @param overtimeLoses The team's number of overtime loses.
     */
    public void addTeam( String season, String city, String name, String conference, String division, int wins, int loses, 
                                                                                                        int overtimeLoses )
    {
        getStandings( season ).addTeam( city, name, conference, division, wins, loses, overtimeLoses );
    }


    /**
     * Edits the city for a team in a given season.
     * 
     * @param season    The year of standings to edit the team within.
     * @param fullName  The full name of the team whose city is being edited.
     * @param newCity   The new city for the team.
     */
    public void editTeamCity( String season, String fullName, String newCity )
    {
        getStandings( season ).editCity( fullName, newCity );
    }

    /**
     * Edits the name for a team in a given season.
     * 
     * @param season    The year of standings to edit the team within.
     * @param fullName  The full name of the team whose name is being edited.
     * @param newCity   The new name for the team.
     */
    public void editTeamName( String season, String fullName, String newName )
    {
        getStandings( season ).editName( fullName, newName );
    }

    /**
     * Edits the conference for a team in a given season.
     * 
     * @param season    The year of standings to edit the team within.
     * @param fullName  The full name of the team whose conference is being edited.
     * @param newCity   The new conference for the team.
     */
    public void editTeamConference( String season, String fullName, String newConference )
    {
        getStandings( season ).editConference( fullName, newConference );
    }

    /**
     * Edits the divison for a team in a given season.
     * 
     * @param season    The year of standings to edit the team within.
     * @param fullName  The full name of the team whose division is being edited.
     * @param newCity   The new division for the team.
     */
    public void editTeamDivision( String season, String fullName, String newDivision )
    {
        getStandings( season ).editDivision( fullName, newDivision );
    }

    /**
     * Edits the record for a team in a given season.
     * 
     * @param season        The year of standings to edit the team within.
     * @param fullName      The full name of the team whose record is being edited.
     * @param wins          The new number of wins for the team.
     * @param loses         The new number of loses for the team.
     * @param overtimeLoses The new number of overtime loses for the team.
     */
    public void editTeamRecord( String season, String fullName, int wins, int loses, int overtimeLoses )
    {
        getStandings( season ).editRecord( fullName, wins, loses, overtimeLoses );
    }
    

    public void printStandings_ByLeague_ByPoints( String season )
    {
        getStandings( season ).printStandings_ByLeague_ByPoints();
    }

    public void printStandings_ByWildcard_ByPoints( String season )
    {
        getStandings( season ).printStandings_ByWildcard_ByPoints();
    }

    public void printStandings_ByDivision_ByPoints( String season )
    {
        getStandings( season ).printStandings_ByDivision_ByPoints();
    }

    public void printStandings_ByConference_ByPoints( String season )
    {
        getStandings( season ).printStandings_ByConference_ByPoints();
    }

    public void printStandings_ByLeague_ByWins( String season )
    {
        getStandings( season ).printStandings_ByLeague_ByWins();
    }

    public void printStandings_ByLeague_ByLoses( String season )
    {
        getStandings( season ).printStandings_ByLeague_ByLoses();
    }   

    public void printStandings_ByLeague_ByOvertimeLoses( String season )
    {
        getStandings( season ).printStandings_ByLeague_ByOvertimeLoses();
    }


    /**
     * Returns the standings object of a specific season.
     * 
     * @param season    The seasons for which we are looking for the standings
     * @return  The standings object if it is found for the season, or null.
     */
    private Standings getStandings( String season )
    {
        if (checkSeasonExists( season )) {
            for (int i = 0; i < seasons.size(); i++) {
                if (InputAnalyzer.checkSpecificInput( seasons.get(i).getSeason(), season )) {
                    return seasons.get(i);
                }
            }
        }
        return null;
    }

    /**
     * Checks if the standings for a certain season already exist in the database.
     * 
     * @param season    The season to check for.
     * @return  True if the season is found, and false otherwise.
     */
    public boolean checkSeasonExists( String season )
    {
        for (int i = 0; i < seasons.size(); i++) {
            if (InputAnalyzer.checkSpecificInput( seasons.get(i).getSeason(), season )) {
                return true;
            }
        }
        return false;
    }

    /**
     * Checks if the standings for a certain season already exist in the database.
     * 
     * @param season    The season to check for.
     * @return  True if the season is found, and false otherwise.
     */
    public boolean checkTeamExists( String season, String fullName )
    {
        Standings standings = getStandings( season );
        if (standings != null && standings.checkTeamExists( fullName )) {
            return true;
        }
        return false;
    }
}