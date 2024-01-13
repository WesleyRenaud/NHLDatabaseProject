/**
 * A class that bridges the UI of the database and actual database, managing how the
 * user adds and edits team data.
 */

package ui;

import team.League;
import utilities.BufferGenerator;
import utilities.InputAnalyzer;

public class NHLTeamEditor {
    private League league;

    protected void setLeague(League newLeague) {
        league = newLeague;
    }

    /**
     * Adds a team to the league with a city, name, conference, division, and possibly a record.
     */
    protected void addTeam() {
        BufferGenerator.printBuffer(100);
        String city = InputAnalyzer.getLineInput("Enter Team City >> ");
        String name = InputAnalyzer.getLineInput("Enter Team Name >> ");
        String conference = InputAnalyzer.getStringInput("Enter Team Conference >> ");
        String division = InputAnalyzer.getStringInput("Enter Team Division >> ");
            if (InputAnalyzer.getYesNoInput("Does this team have a record? ")) {
            int wins = InputAnalyzer.getIntegerInput("Enter Number of Wins >> ");
            int loses = InputAnalyzer.getIntegerInput("Enter Number of Loses >> ");
            int overtimeLoses = InputAnalyzer.getIntegerInput("Enter Number of Overtime Loses >> ");
            InputAnalyzer.readBuffer();
            league.addTeam(city, name, conference, division, wins, loses, overtimeLoses);
        } else {
            league.addTeam(city, name, conference, division);
        }
    }

    /**
     * Updates the city for a team supplied as input.
     */
    protected void editTeamCity() {
        String fullName = InputAnalyzer.getLineInput("Enter Full Team Name >> ");
        if (league.checkTeamExists(fullName)) {
            String newCity = InputAnalyzer.getLineInput("Enter New City >> ");
            league.updateCity(fullName, newCity);
        } else {
            System.out.println("The Team Does not Exist");
        }
    }

    /**
     * Updates the name for a team supplied as input.
     */
    protected void editTeamName() {
        String fullName = InputAnalyzer.getLineInput("Enter Full Team Name >> ");
        if (league.checkTeamExists(fullName)) {
            String newName = InputAnalyzer.getLineInput("Enter New Name >> ");
            league.updateName(fullName, newName);
        } else {
            System.out.println("The Team Does not Exist");
        }
    }

    /**
     * Updates the conference for a team supplied as input.
     */
    protected void editTeamConference() {
        String fullName = InputAnalyzer.getLineInput("Enter Full Team Name >> ");
        if (league.checkTeamExists(fullName)) {
            String newConference = InputAnalyzer.getStringInput("Enter New Conference >> ");
            league.updateConference(fullName, newConference);
        } else {
            System.out.println("The Team Does not Exist");
        }
    }

    /**
     * Updates the division for a team supplied as input.
     */
    protected void editTeamDivision() {
        String fullName = InputAnalyzer.getLineInput("Enter Full Team Name >> ");
        if (league.checkTeamExists(fullName)) {
            String newDivision = InputAnalyzer.getStringInput("Enter New Division >> ");
            league.updateDivision(fullName, newDivision);
        } else {
            System.out.println("The Team Does not Exist");
        }
    }

    /**
     * Updates the record for a team supplied as input.
     */
    protected void editTeamRecord() {
        String fullName = InputAnalyzer.getLineInput("Enter Full Team Name >> ");
        if (league.checkTeamExists(fullName)) {
            int wins = InputAnalyzer.getIntegerInput("Wins >> ");
            int loses = InputAnalyzer.getIntegerInput("Loses >> ");
            int overtimeLoses = InputAnalyzer.getIntegerInput("Overtime Loses >> ");
            InputAnalyzer.readBuffer();
            league.updateRecord(fullName, wins, loses, overtimeLoses);
        } else {
            System.out.println("The Team Does not Exist");
        }
    }   
}