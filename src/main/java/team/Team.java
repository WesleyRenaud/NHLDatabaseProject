/**
 * A class used to represent an NHL team with a name and a record.
 */

package team;


import java.io.Serializable;

import utilities.DoubleRounder;

public class Team implements Serializable
{
    private static final long serialVersionUID = 535072393016375807L;
    private String city;
    private String name;
    private String conference;
    private String division;
    private int wins;
    private int loses;
    private int overtimeLoses;

    /**
     * Creates a new team with a given city, name, conference, division, number of points, and record.
     * 
     * @param teamCity  The team's city.
     * @param teamName  The team's name.
     * @param teamConference    The team's conference.
     * @param teamDivision  The team's division.
     * @param teamWins  The team's number of wins.
     * @param teamLoses The team's number of loses.
     * @param teamOvertimeLoses The team's number of overtime loses.
     */
    public Team( String teamCity, String teamName, String teamConference, String teamDivision, int teamPoints, int teamWins, 
                                                                                               int teamLoses, int teamOvertimeLoses )
    {
        city = teamCity;
        name = teamName;
        conference = teamConference;
        division = teamDivision;
        wins = teamWins;
        loses = teamLoses;
        overtimeLoses = teamOvertimeLoses;
    }

    /**
     * Creates a new team with a given city, name, conference, division, and record.
     * 
     * @param teamCity  The team's city.
     * @param teamName  The team's name.
     * @param teamConference    The team's conference.
     * @param teamDivision  The team's division.
     * @param teamWins  The team's number of wins.
     * @param teamLoses The team's number of loses.
     * @param teamOvertimeLoses The team's number of overtime loses.
     */
    public Team( String teamCity, String teamName, String teamConference, String teamDivision, int teamWins, int teamLoses, 
                                                                                                             int teamOvertimeLoses )
    {
        city = teamCity;
        name = teamName;
        conference = teamConference;
        division = teamDivision;
        wins = teamWins;
        loses = teamLoses;
        overtimeLoses = teamOvertimeLoses;
    }

    /**
     * Creates a new team with a given city, name, conference, and division. The record is set as blank.
     * 
     * @param teamCity  The team's city.
     * @param teamName  The team's name.
     */
    public Team( String teamCity, String teamName, String teamConference, String teamDivision )
    {
        city = teamCity;
        name = teamName;
        conference = teamConference;
        division = teamDivision;
        wins = 0;
        loses = 0;
        overtimeLoses = 0;
        
    }

    protected void setCity( String newCity )
    {
        city = newCity;
    }

    protected void setName( String newName )
    {
        name = newName;
    }

    protected void setConference( String newConference )
    {
        conference = newConference;
    }

    protected void setDivision( String newDivision )
    {
        division = newDivision;
    }

    protected void setWins( int newWins )
    {
        wins = newWins;
    }

    protected void setLoses( int newLoses )
    {
        loses = newLoses;
    }

    protected void setOvertimeLoses( int newOvertimeLoses )
    {
        overtimeLoses = newOvertimeLoses;
    }

    protected void setRecord( int newWins, int newLoses, int newOvertimeLoses )
    {
        wins = newWins;
        loses = newLoses;
        overtimeLoses = newOvertimeLoses;
    }


    public String getCity()
    {
        return city;
    }

    public String getName()
    {
        return name;
    }
    
    public String getConference()
    {
        return conference;
    }

    public String getDivision()
    {
        return division;
    }

    public int getWins()
    {
        return wins;
    }

    public int getLoses()
    {
        return loses;
    }

    public int getOvertimeLoses()
    {
        return overtimeLoses;
    }

    public int getPoints()
    {
        return wins * 2 + overtimeLoses;
    }

    public int getGamesPlayed()
    {
        return wins + loses + overtimeLoses;
    }

    public double getPointsPercentage()
    {
        double pointsPercentage = getPoints() / (getGamesPlayed() * 2.0);
        pointsPercentage = DoubleRounder.round( pointsPercentage, 3 );
        return pointsPercentage;
    }

    /**
     * Returns the full name of the team consisting of the city and team name.
     * 
     * @return  The team city plus the team name.
     */
    public String getFullName()
    {
        return city + " " + name;
    }

    /**
     * Returns a string showing the team's record of the form <wins>-<loses>-<overtime_loses>
     * 
     * @return  A string showing the team's record.
     */
    public String getRecord()
    {
        return wins + "-" + loses + "-" + overtimeLoses;
    }

    
    /**
     * Prints a string showing the team and its record.
     */
    @Override
    public String toString()
    {
        return String.format( "%-23s| GP: %-5d| Points: %-5d| Record: %-10s| PP%%: %-7.3f", getFullName(), getGamesPlayed(), 
                            getPoints(), getRecord(), getPointsPercentage() );
    }
}