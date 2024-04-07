/**
 * A class that bridges the UI of the database and actual database, managing how the
 * user adds and edits team data.
 */

package ui;


import input.InputReader;
import utilities.BufferGenerator;
import utilities.SeasonHandler;
import team.Seasons;


public class NHLTeamEditor
{
    private Seasons seasons;


    protected void setSeasons( Seasons newSeasons )
    {
        seasons = newSeasons;
    }


    /**
     * Adds a new set of standings for a specific season to the database.
     */
    protected void addNewStandings()
    {
        String season = InputReader.getLineInput( " * Enter Season >> " );
        if (seasons.checkSeasonExists( season )) {
            System.out.println( " ! The Standings for " + season + " Already Exist !" );
        } else if (!SeasonHandler.isSeasonInput( season )) {
            System.out.println( " ! " + season + " is Not a Valid Season !" );
        } else {
            int numTeams = InputReader.getNaturalNumberInput( " * Enter Number of Teams >> " );
            InputReader.readBuffer();
            seasons.addSeason( season );
            for (int i = 0; i < numTeams; i++) {
                BufferGenerator.printBufferForScreenWidth();
                System.out.println( " * Entering Stats for Team #" + (i + 1) );
                addTeam( season );
            }
        }
    }

    /**
     * Adds a team to a given set of standings with a city, name, conference, division, and a record.
     */
    private void addTeam( String season )
    {   
        String city = InputReader.getLineInput( " * Enter Team City >> " );
        String name = InputReader.getLineInput( " * Enter Team Name >> " );
        String conference = InputReader.getStringInput( " * Enter Team Conference >> " );
        String division = InputReader.getStringInput( " * Enter Team Division >> " );
        int wins = InputReader.getIntegerInput( " * Enter Number of Wins >> " );
        int loses = InputReader.getIntegerInput( " * Enter Number of Loses >> " );
        int overtimeLoses = InputReader.getIntegerInput( " * Enter Number of Overtime Loses >> " );
        InputReader.readBuffer();
        seasons.addTeam( season, city, name, conference, division, wins, loses, overtimeLoses );
    }
    

    /**
     * Updates the city for a certain team supplied as input, in a certain season supplied as input.
     */
    protected void editTeamCity()
    {
        String season = InputReader.getLineInput( " * Enter Season >> " );
        if (seasons.checkSeasonExists( season )) {
            String fullName = InputReader.getLineInput( " * Enter Full Team Name >> " );
            if (seasons.checkTeamExists( season, fullName )) {
                String newCity = InputReader.getLineInput( " * Enter New City >> " );
                seasons.editTeamCity( season, fullName, newCity );
            } else {
                System.out.println( " ! The Team Does not Exist !" );
            } 
        } else {
            System.out.println( " ! The Standings for " + season + " Don't Exist !" );
        }
    }

    /**
     * Updates the name for a certain team supplied as input, in a certain season supplied as input.
     */
    protected void editTeamName()
    {
        String season = InputReader.getLineInput( " * Enter Season >> " );
        if (seasons.checkSeasonExists( season )) {
            String fullName = InputReader.getLineInput( " * Enter Full Team Name >> " );
            if (seasons.checkTeamExists( season, fullName )) {
                String newName = InputReader.getLineInput( " * Enter New Name >> " );
                seasons.editTeamName( season, fullName, newName );
            } else {
                System.out.println( " ! The Team Does not Exist !" );
            } 
        } else {
            System.out.println( " ! The Standings for " + season + " Don't Exist !" );
        }
    }

    /**
     * Updates the conference for a certain team supplied as input, in a certain season supplied as input.
     */
    protected void editTeamConference()
    {
        String season = InputReader.getLineInput( " * Enter Season >> " );
        if (seasons.checkSeasonExists( season )) {
            String fullName = InputReader.getLineInput( " * Enter Full Team Name >> " );
            if (seasons.checkTeamExists( season, fullName )) {
                String newConference = InputReader.getLineInput( " * Enter New Conference >> " );
                seasons.editTeamConference( season, fullName, newConference );
            } else {
                System.out.println( " ! The Team Does not Exist !" );
            } 
        } else {
            System.out.println( " ! The Standings for " + season + " Don't Exist !" );
        }
    }

    /**
     * Updates the division for a certain team supplied as input, in a certain season supplied as input.
     */
    protected void editTeamDivision()
    {
        String season = InputReader.getLineInput( " * Enter Season >> " );
        if (seasons.checkSeasonExists( season )) {
            String fullName = InputReader.getLineInput( " * Enter Full Team Name >> " );
            if (seasons.checkTeamExists( season, fullName )) {
                String newDivision = InputReader.getLineInput( " * Enter New Division >> " );
                seasons.editTeamDivision( season, fullName, newDivision );
            } else {
                System.out.println( " ! The Team Does not Exist !" );
            } 
        } else {
            System.out.println( " ! The Standings for " + season + " Don't Exist !" );
        }
    }

    /**
     * Updates the record for a certain team supplied as input, in a certain season supplied as input.
     */
    protected void editTeamRecord()
    {
        String season = InputReader.getLineInput( " * Enter Season >> " );
        if (seasons.checkSeasonExists( season )) {
            String fullName = InputReader.getLineInput( " * Enter Full Team Name >> " );
            if (seasons.checkTeamExists( season, fullName )) {
                int wins = InputReader.getIntegerInput( " * Enter Number of Wins >> " );
                int loses = InputReader.getIntegerInput( " * Enter Number of Loses >> " );
                int overtimeLoses = InputReader.getIntegerInput( " * Enter Number of Overtime Loses >> " );
                InputReader.readBuffer();
                seasons.editTeamRecord( season, fullName, wins, loses, overtimeLoses );
            } else {
                System.out.println( " ! The Team Does not Exist !" );
            } 
        } else {
            System.out.println( " ! The Standings for " + season + " Don't Exist !" );
        }
    }
}