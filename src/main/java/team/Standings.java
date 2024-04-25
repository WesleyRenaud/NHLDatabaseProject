/**
 * A class used as a data structure for all teams in the league, used to get the
 * standings sorted in different ways.
 */

package team;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import input.InputAnalyzer;
import utilities.BufferGenerator;
import utilities.NHLConstants;


public class Standings implements Serializable
{
    private static final long serialVersionUID = 329208573326875283L;
    private List<Team> teams;
    private String season;


    public Standings()
    {
        teams = new ArrayList<>();
        season = null;
    }

    public Standings( String newSeason )
    {
        teams = new ArrayList<>();
        season = newSeason;
    }


    /**
     * Adds a team to the standings given the team's city, name, conference, division and record.
     * 
     * @param city          The team's city.
     * @param name          The team's name.
     * @param conference    The team's conference.
     * @param division      The team's division.
     * @param wins          The team's number of wins.
     * @param loses         The team's number of loses.
     * @param overtimeLoses The team's number of overtime loses.
     */
    public void addTeam( String city, String name, String conference, String division, int wins, int loses, int overtimeLoses )
    {
        teams.add( new Team( city, name, conference, division, wins, loses, overtimeLoses ) );
    }

    /**
     * Adds a team to the standings given the team's city, name, conference, and division.
     * 
     * @param city          The team's city.
     * @param name          The team's name.
     * @param conference    The team's conference.
     * @param division      The team's division.
     */
    public void addTeam( String city, String name, String conference, String division )
    {
        teams.add( new Team( city, name, conference, division ) );
    }

    /**
     * Edits the city of a given team.
     * 
     * @param fullName  The full name of the team whose city is being edited.
     * @param city      The new city for the team.
     */
    public void editCity( String fullName, String city )
    {
        int index = getTeamIndex( fullName );
        teams.get(index).setCity( city );
    }

    /**
     * Edits the name of a given team.
     * 
     * @param fullName  The full name of the team whose name is being edited.
     * @param name      The new name for the team.
     */
    public void editName( String fullName, String name )
    {
        int index = getTeamIndex( fullName );
        teams.get(index).setName( name );
    }

    /**
     * Edits the conference of a given team.
     * 
     * @param fullName      The full name of the team whose conference is being edited.
     * @param conference    The new conference for the team.
     */
    public void editConference( String fullName, String conference )
    {
        int index = getTeamIndex( fullName );
        teams.get(index).setConference( conference );
    }

    /**
     * Edits the division of a given team.
     * 
     * @param fullName  The full name of the team whose division is being edited.
     * @param division  The new division for the team.
     */
    public void editDivision( String fullName, String division )
    {
        int index = getTeamIndex( fullName );
        teams.get(index).setDivision( division );
    }

    /**
     * Edits the record of a given team.
     * 
     * @param fullName      The full name of the team whose record is being edited.
     * @param wins          The new number of wins for the team.
     * @param loses         The new number of loses for the team.
     * @param overtimeLoses The new number of overtime loses for the team.
     */
    public void editRecord( String fullName, int wins, int loses, int overtimeLoses )
    {
        int index = getTeamIndex( fullName );
        teams.get(index).setRecord( wins, loses, overtimeLoses );
    }


    public String getSeason()
    {
        return season;
    }


    /**
     * Prints the league-wide standings.
     */
    public void printStandings_ByLeague_ByPoints()
    {
        if (teams.size() == 0) {
            System.out.println( "\n ! No Teams In League !\n" );
        } else {
            sortByPoints();
            printTeams_ByLeague();
        }
        
    }

    /**
     * Prints the wildcard race standings.
     */
    public void printStandings_ByWildcard_ByPoints()
    {
        if (teams.size() == 0) {
            System.out.println( "\n ! No Teams In League !\n" );
        } else if (numInDivision( "Atlantic" ) != 8 || numInDivision( "Metropolitan" ) != 8
                || numInDivision( "Central" ) != 8 || numInDivision( "Pacific" ) != 8) {
            System.out.println( "\n ! Teams are not in Proper Divisions ! \n" );
        } else {
            sortByWildcard();
            printTeams_ByWildcard();
        }
    }

    /**
     * Prints the divisional standings.
     */
    public void printStandings_ByDivision_ByPoints()
    {
        if (teams.size() == 0) {
            System.out.println( "\n ! No Teams In League !\n" );
        } else if (numInDivision( "Atlantic" ) != 8 || numInDivision( "Metropolitan" ) != 8
                || numInDivision( "Central" ) != 8 || numInDivision( "Pacific" ) != 8) {
            System.out.println( "\n ! Teams are not in Proper Divisions ! \n" );
        } else {
            sortByDivision();
            sortByPoints( 0, 7 );
            sortByPoints( 8, 15 );
            sortByPoints( 16, 23 );
            sortByPoints( 24, 31 );
            printTeams_ByDivision();
        }
    }

    /**
     * Prints the standings by conference. 
     */
    public void printStandings_ByConference_ByPoints()
    {
        if (teams.size() == 0) {
            System.out.println( "\n ! No Teams In League !\n" );
        } else if (numInConference( "Eastern" ) != 16 || numInConference( "Western" ) != 16) {
            System.out.println( "\n ! Teams are not in Proper Conferences ! \n" );
        } else {
            sortByConference();
            sortByPoints(0, 15);
            sortByPoints(16, 31);
            printTeams_ByConference();
        }
    }

    /**
     * Prints the league-wide standings by wins.
     */
    public void printStandings_ByLeague_ByWins()
    {
        if (teams.size() == 0) {
            System.out.println( "\n ! No Teams In League !\n" );
        } else {
            sortByWins();
            printTeams_ByLeague();
        }
    }

    /**
     * Prints the league-wide standings by loses.
     */
    public void printStandings_ByLeague_ByLoses()
    {
        if (teams.size() == 0) {
            System.out.println( "\n ! No Teams In League !\n" );
        } else {
            sortByLoses();
            printTeams_ByLeague();
        }
    }

    /**
     * Prints the league-wide standings by overtime loses.
     */
    public void printStandings_ByLeague_ByOvertimeLoses()
    {
        if (teams.size() == 0) {
            System.out.println( "\n ! No Teams In League !\n" );
        } else {
            sortByOvertimeLoses();
            printTeams_ByLeague();
        }
    }


    /**
     * Sorts the list of teams by the number of points, in descending order.
     */
    private void sortByPoints()
    {
        Collections.sort( teams, new Comparator<Team>() {
            public int compare( Team team1, Team team2 ) {
                return team2.getPoints() - team1.getPoints();
            }
        });
    }

    /**
     * Sorts some sublist of the list where the endpoints are given as parameters, and are
     * included, by the number of points, in descending order.
     * 
     * @param min   The minimum index of the sublist being sorted.
     * @param max   The maximum index of the sublist being sorted.
     */
    private void sortByPoints( int min, int max )
    {
        Collections.sort( teams.subList( min, max ), new Comparator<Team>() {
            public int compare( Team team1, Team team2 ) {
                return team2.getPoints() - team1.getPoints();
            }
        });
    }

    /**
     * Sorts the list of teams by the number of wins, in descending order.
     */
    private void sortByWins()
    {
        Collections.sort( teams, new Comparator<Team>() {
            public int compare( Team team1, Team team2 ) {
                return team2.getWins() - team1.getWins();
            }
        });
    }

    /**
     * Sorts the list of teams by the number of loses, in descending order.
     */
    private void sortByLoses()
    {
        Collections.sort( teams, new Comparator<Team>() {
            public int compare( Team team1, Team team2 ) {
                return team2.getLoses() - team1.getLoses();
            }
        });
    }

    /**
     * Sorts the list of teams by the number of overtime loses, in descending order.
     */
    private void sortByOvertimeLoses()
    {
        Collections.sort( teams, new Comparator<Team>() {
            public int compare( Team team1, Team team2 ) {
                return team2.getOvertimeLoses() - team1.getOvertimeLoses();
            }
        });
    }

    /**
     * Sorts a list of teams into a format that shows the wildcard race, showing the east and
     * then the west.
     */
    private void sortByWildcard()
    {
        /* We order the teams by points in each of their divisions, and then move around some to
           get the divisions' leaders in the correct spots. */
        sortByDivision();
        sortByPoints( 0, 7 );
        sortByPoints( 8, 15 );
        swapTeams( 3, 8 );
        swapTeams( 4, 9 );
        swapTeams( 5, 10 );
        sortByPoints( 6, 15 );
        sortByPoints( 16, 23 );
        sortByPoints( 24, 31 );
        swapTeams( 19, 24 );
        swapTeams( 20, 25 );
        swapTeams( 21, 26 );
        sortByPoints( 22, 31 );
    }

    /**
     * Sorts a list of teams by division, specifically, the Atlantic teams followed by the
     * Metro, then the Central and finally the Pacific.
     */
    private void sortByDivision()
    {
        List<Team> sortedByDivision = new ArrayList<>();
        int index = 0, numberFound = 0;
        while (index < 32 && numberFound < 8) {
            if (teams.get(index).getDivision().equals( "Atlantic" )) {
                sortedByDivision.add( teams.get(index) );
                numberFound++;
            }
            index++;
        }
        numberFound = 0;
        index = 0;
        while (index < 32 && numberFound < 8) {
            if (teams.get(index).getDivision().equals( "Metropolitan" )) {
                sortedByDivision.add( teams.get(index) );
                numberFound++;
            }
            index++;
        }
        numberFound = 0;
        index = 0;
        while (index < 32 && numberFound < 8) {
            if (teams.get(index).getDivision().equals( "Central" )) {
                sortedByDivision.add( teams.get(index) );
                numberFound++;
            }
            index++;
        }
        numberFound = 0;
        index = 0;
        while (index < 32 && numberFound < 8) {
            if (teams.get(index).getDivision().equals( "Pacific" )) {
                sortedByDivision.add( teams.get(index) );
                numberFound++;
            }
            index++;
        }
        teams = sortedByDivision;
    }

    /**
     * Sorts a list of teams by the conference, specifically putting all Eastern teams before 
     * all Western teams.
     */
    private void sortByConference()
    {
        List<Team> sortedByConference = new ArrayList<>();
        int index = 0, numberFound = 0;
        while (index < 32 && numberFound < 16) {
            if (teams.get(index).getConference().equals( "Eastern" )) {
                sortedByConference.add( teams.get(index) );
                numberFound++;
            }
            index++;
        }
        numberFound = 0;
        index = 0;
        while (index < 32 && numberFound < 16) {
            if (teams.get(index).getConference().equals( "Western" )) {
                sortedByConference.add( teams.get(index) );
                numberFound++;
            }
            index++;
        }
        teams = sortedByConference;
    }

    /**
     * Prints the teams in the league.
     */
    private void printTeams_ByLeague()
    {
        System.out.println( "\t\t\t\t\tLeague" );
        BufferGenerator.printBuffer( NHLConstants.teams_BufferLength );
        for (int i = 0; i < teams.size(); i++) {
            System.out.println( (i + 1) +  ". \t" + teams.get(i) );
        }
    }

    /**
     * Prints the teams in the league assuming they are sorted according to the wildcare race
     */
    private void printTeams_ByWildcard()
    {
        int i = 0;
        System.out.println( "\nEast" );
        System.out.println( "\t\t\t\t\tAtlantic" );
        BufferGenerator.printBuffer( NHLConstants.teams_BufferLength );
        while (i < 3) {
            System.out.println( (i + 1) + ". \t" + teams.get(i) );
            i++;
        }
        System.out.println( "\n\t\t\t\tMetropolitan" );
        BufferGenerator.printBuffer( NHLConstants.teams_BufferLength );
        while (i < 6) {
            System.out.println( (i - 2) + ". \t" + teams.get(i) );
            i++;
        }
        System.out.println( "\n\t\t\t\t\tWildcard" );
        BufferGenerator.printBuffer( NHLConstants.teams_BufferLength );
        while (i < 8) {
            System.out.println( (i - 5) + ". \t" + teams.get(i) );
            i++;
        }
        BufferGenerator.printBufferForScreenWidth();
        while (i < 16) {
            System.out.println(( i - 5) + ". \t" + teams.get(i) );
            i++;
        }
        BufferGenerator.printBuffer( NHLConstants.teams_BufferLength );

        System.out.println( "West" );
        System.out.println( "\t\t\t\t\tCentral" );
        BufferGenerator.printBuffer( NHLConstants.teams_BufferLength );
        while (i < 19) {
            System.out.println( (i - 15) + ". \t" + teams.get(i) );
            i++;
        }
        System.out.println( "\n\t\t\t\t\tPacific" );
        BufferGenerator.printBufferForScreenWidth();
        while (i < 22) {
            System.out.println( (i - 18) + ". \t" + teams.get(i) );
            i++;
        }
        System.out.println( "\n\t\t\t\t\tWildcard" );
        BufferGenerator.printBuffer( NHLConstants.teams_BufferLength );
        while (i < 24) {
            System.out.println( (i - 21) + ". \t" + teams.get(i) );
            i++;
        }
        BufferGenerator.printBuffer( NHLConstants.teams_BufferLength );
        while (i < 32) {
            System.out.println( (i - 21) + ". \t" + teams.get(i) );
            i++;
        }
    }

    /**
     * Prints the teams in the league assuming they are sorted by division.
     */
    private void printTeams_ByDivision()
    {
        System.out.println( "\t\t\t\t\tAtlantic" );
        BufferGenerator.printBuffer( NHLConstants.teams_BufferLength );
        int i = 0;
        while (i < 8) {
            System.out.println( (i + 1) + ". \t" + teams.get(i) );
            i++;
        }
        System.out.println( "\t\t\t\t\tMetropolitan" );
        BufferGenerator.printBuffer( NHLConstants.teams_BufferLength );
        while (i < 16) {
            System.out.println( (i - 7) + ". \t" + teams.get(i) );
            i++;
        }
        System.out.println( "\t\t\t\t\tCentral" );
        BufferGenerator.printBuffer( NHLConstants.teams_BufferLength );
        while (i < 24) {
            System.out.println( (i - 15) + ". \t" + teams.get(i) );
            i++;
        }
        System.out.println( "\t\t\t\t\tPacific" );
        BufferGenerator.printBuffer( NHLConstants.teams_BufferLength );
        while (i < 32) {
            System.out.println( (i - 23) + ". \t" + teams.get(i) );
            i++;
        }
    }

    /**
     * Prints the teams in the league assuming they are sorted by conference.
     */
    private void printTeams_ByConference()
    {
        System.out.println( "\t\t\t\t\tEastern" );
        BufferGenerator.printBuffer( NHLConstants.teams_BufferLength );
        int i = 0;
        while (i < 16) {
            System.out.println( (i + 1) + ". \t" + teams.get(i) );
            i++;
        }
        System.out.println( "\t\t\t\t\tWestern" );
        BufferGenerator.printBuffer( NHLConstants.teams_BufferLength );
        while (i < 32) {
            System.out.println( (i - 15) + ". \t" + teams.get(i) );
            i++;
        }
    }

    /**
     * Checks if a given team belongs to the league.
     * 
     * @param fullName  The full name to check for.
     * @return  True if the name is found, and false otherwise.
     */
    public boolean checkTeamExists( String fullName )
    {
        for (int i = 0; i < teams.size(); i++) {
            if (InputAnalyzer.checkSpecificInput( fullName, teams.get(i).getFullName() )) {
                return true;
            }
        }
        return false;
    }

    /**
     * Gets the index of a team in the ArrayList of teams by searching for the given full name.
     * 
     * @param fullName  The name of the team which we are finding the index of.
     * @return  The index of the team in the ArrayList if found, and -1 otherwise.
     */
    private int getTeamIndex( String fullName )
    {
        for (int i = 0; i < teams.size(); i++) {
            if (InputAnalyzer.checkSpecificInput( fullName, teams.get(i).getFullName() )) {
                return i;
            }
        }
        return -1;
    }

    /**
     * Swaps two given teams' positions in the list of teams.
     * 
     * @param first     The position of the first team to swap.
     * @param second    The position of the second team to swap.
     */
    private void swapTeams( int first, int second )
    {
        Team temp = teams.get(first);
        teams.set( first, teams.get(second) );
        teams.set( second, temp );
    }

    /**
     * Finds the number of teams in a given division.
     * 
     * @param division  The division which we are checking for teams of.
     * @return  The number of teams in the division.
     */
    private int numInDivision( String division )
    {
        int numInDivision = 0;
        for (int i = 0; i < teams.size(); i++) {

            if (InputAnalyzer.checkSpecificInput( teams.get(i).getDivision(), division )) {
                numInDivision++;
            }
        }
        return numInDivision;
    }

    /**
     * Finds the number of teams in a given conference.
     * 
     * @param conference    The conference which we are checking for teams of.
     * @return  The number of teams in the conference.
     */
    private int numInConference( String conference )
    {
        int numInConference = 0;
        for (int i = 0; i < teams.size(); i++) {
            System.out.println( teams.get(i).getFullName() + ": " + teams.get(i).getConference() );
            if (InputAnalyzer.checkSpecificInput( teams.get(i).getConference(), conference )) {
                numInConference++;
            }
        }
        return numInConference;
    }
}