/**
 * A class used to represent an NHL team with a name and a record.
 */

package team;

import java.io.Serializable;

public class Team implements Serializable {
    private static final long serialVersionUID = 535072393016375807L;
    private String city;
    private String name;
    private String conference;
    private String division;
    private int points;
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
     * @param points    The team's number of points.
     * @param teamWins  The team's number of wins.
     * @param teamLoses The team's number of loses.
     * @param teamOvertimeLoses The team's number of overtime loses.
     */
    public Team(String teamCity, String teamName, String teamConference, String teamDivision, int teamPoints, int teamWins, int teamLoses, int teamOvertimeLoses) {
        city = teamCity;
        name = teamName;
        conference = teamConference;
        division = teamDivision;
        points = teamPoints;
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
    public Team(String teamCity, String teamName, String teamConference, String teamDivision, int teamWins, int teamLoses, int teamOvertimeLoses) {
        city = teamCity;
        name = teamName;
        conference = teamConference;
        division = teamDivision;
        points = 2 * teamWins + teamOvertimeLoses;
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
    public Team(String teamCity, String teamName, String teamConference, String teamDivision) {
        city = teamCity;
        name = teamName;
        conference = teamConference;
        division = teamDivision;
        points = 0;
        wins = 0;
        loses = 0;
        overtimeLoses = 0;
        
    }

    protected void setCity(String newCity) {
        city = newCity;
    }

    protected void setName(String newName) {
        name = newName;
    }

    protected void setConference(String newConference) {
        conference = newConference;
    }

    protected void setDivision(String newDivision) {
        division = newDivision;
    }

    protected void setPoints(int newPoints) {
        points = newPoints;
    }

    protected void setWins(int newWins) {
        wins = newWins;
    }

    protected void setLoses(int newLoses) {
        loses = newLoses;
    }

    protected void setOvertimeLoses(int newOvertimeLoses) {
        overtimeLoses = newOvertimeLoses;
    }

    protected void setRecord(int newWins, int newLoses, int newOvertimeLoses) {
        wins = newWins;
        loses = newLoses;
        overtimeLoses = newOvertimeLoses;
        points = wins * 2 + overtimeLoses;
    }

    public String getCity() {
        return city;
    }

    public String getName() {
        return name;
    }
    
    public String getConference() {
        return conference;
    }

    public String getDivision() {
        return division;
    }

    public int getPoints() {
        return points;
    }

    public int getWins() {
        return wins;
    }

    public int getLoses() {
        return loses;
    }

    public int getOvertimeLoses() {
        return overtimeLoses;
    }

    /**
     * Returns the full name of the team consisting of the city and team name.
     * 
     * @return  The team city plus the team name.
     */
    public String getTeam() {
        return city + " " + name + "\t";
    }

    /**
     * Returns the record of the team via the wins, loses and overtime loses.
     * 
     * @return  The points plus the wins plus the loses plus the overtime loses.
     */
    public String getRecord() {
        return "Points: " + points + "\t| Wins: " + wins + "\t| Loses: " + loses + "\t| Overtime Loses: " + overtimeLoses;
    }

    /**
     * Returns a string showing the team and its record.
     * 
     * @return  The team's city and name plus its record and number of points.
     */
    public String toString() {
        return getTeam() + " | " + getRecord();
    }
}