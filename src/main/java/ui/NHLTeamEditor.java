/**
 * A class that bridges the UI of the database and actual database, managing how the
 * user adds and edits team data.
 */

package ui;


import input.InputAnalyzer;
import input.InputReader;
import utilities.BufferGenerator;
import team.League;


public class NHLTeamEditor {
    private League league;

    protected void setLeague(League newLeague) {
        league = newLeague;
    }

    /**
     * Adds a team to the league with a city, name, conference, division, and possibly a record.
     */
    protected void addTeam() {
        BufferGenerator.printBufferForScreenWidth();
        String city = InputReader.getLineInput(" * Enter Team City >> ");
        String name = InputReader.getLineInput(" * Enter Team Name >> ");
        String conference = InputReader.getStringInput(" * Enter Team Conference >> ");
        String division = InputReader.getStringInput(" * Enter Team Division >> ");
        int wins = InputReader.getIntegerInput(" * Enter Number of Wins >> ");
        int loses = InputReader.getIntegerInput(" * Enter Number of Loses >> ");
        int overtimeLoses = InputReader.getIntegerInput(" * Enter Number of Overtime Loses >> ");
        InputReader.readBuffer();
        league.addTeam(city, name, conference, division, wins, loses, overtimeLoses);
    }
    

    /**
     * Updates the city for a team supplied as input.
     */
    protected void editTeamCity() {
        String fullName = InputReader.getLineInput(" * Enter Full Team Name or c to Cancel >> ");
        if (!(InputAnalyzer.checkSpecificInput(fullName, "C") || InputAnalyzer.checkSpecificInput(fullName, "c"))) {
            if (league.checkTeamExists(fullName)) {
                String newCity = InputReader.getLineInput(" * Enter New City or c to Cancel >> ");
                league.updateCity(fullName, newCity);
            } else {
                System.out.println(" ! The Team Does not Exist !");
            }
        }
    }

    /**
     * Updates the name for a team supplied as input.
     */
    protected void editTeamName() {
        String fullName = InputReader.getLineInput(" * Enter Full Team Name or c to Cancel >> ");
        if (!(InputAnalyzer.checkSpecificInput(fullName, "C") || InputAnalyzer.checkSpecificInput(fullName, "c"))) {
            if (league.checkTeamExists(fullName)) {
                String newName = InputReader.getLineInput(" * Enter New Name >> ");
                league.updateName(fullName, newName);
            } else {
                System.out.println(" ! The Team Does not Exist !");
            }
        }
    }

    /**
     * Updates the conference for a team supplied as input.
     */
    protected void editTeamConference() {
        String fullName = InputReader.getLineInput(" * Enter Full Team Name  or c to Cancel >> ");
        if (!(InputAnalyzer.checkSpecificInput(fullName, "C") || InputAnalyzer.checkSpecificInput(fullName, "c"))) {
            if (league.checkTeamExists(fullName)) {
                String newConference = InputReader.getStringInput(" * Enter New Conference >> ");
                league.updateConference(fullName, newConference);
            } else {
                System.out.println(" ! The Team Does not Exist !");
            }
        }
        InputReader.readBuffer();
    }

    /**
     * Updates the division for a team supplied as input.
     */
    protected void editTeamDivision() {
        String fullName = InputReader.getLineInput(" * Enter Full Team Name or c to Cancel >> ");
        if (!(InputAnalyzer.checkSpecificInput(fullName, "C") || InputAnalyzer.checkSpecificInput(fullName, "c"))) {
            if (league.checkTeamExists(fullName)) {
                String newDivision = InputReader.getStringInput(" * Enter New Division >> ");
                league.updateDivision(fullName, newDivision);
            } else {
                System.out.println(" ! The Team Does not Exist !");
            }
        }
        InputReader.readBuffer();
    }

    /**
     * Updates the record for a team supplied as input.
     */
    protected void editTeamRecord() {
        String fullName = InputReader.getLineInput(" * Enter Full Team Name or c to Cancel >> ");
        if (!(InputAnalyzer.checkSpecificInput(fullName, "C") || InputAnalyzer.checkSpecificInput(fullName, "c"))) {
            if (league.checkTeamExists(fullName)) {
                int wins = InputReader.getIntegerInput(" * Wins >> ");
                int loses = InputReader.getIntegerInput(" * Loses >> ");
                int overtimeLoses = InputReader.getIntegerInput(" * Overtime Loses >> ");
                league.updateRecord(fullName, wins, loses, overtimeLoses);
            } else {
                System.out.println(" ! The Team Does not Exist !");
            }
        }
        InputReader.readBuffer();
    }   
}