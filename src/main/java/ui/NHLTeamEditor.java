/**
 * A class that bridges the UI of the database and actual database, managing how the
 * user adds and edits team data.
 */

package ui;

<<<<<<< HEAD

import input.InputAnalyzer;
import input.InputReader;
import utilities.BufferGenerator;
import team.League;

=======
import team.League;
import utilities.BufferGenerator;
import utilities.InputAnalyzer;
>>>>>>> 6814e25f9da3ed0ca82d45bef8836113876b42a0

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
<<<<<<< HEAD
        String city = InputReader.getLineInput(" * Enter Team City >> ");
        String name = InputReader.getLineInput(" * Enter Team Name >> ");
        String conference = InputReader.getStringInput(" * Enter Team Conference >> ");
        String division = InputReader.getStringInput(" * Enter Team Division >> ");
            if (InputReader.getYesNoInput(" * Does this team have a record? ")) {
            int wins = InputReader.getIntegerInput(" * Enter Number of Wins >> ");
            int loses = InputReader.getIntegerInput(" * Enter Number of Loses >> ");
            int overtimeLoses = InputReader.getIntegerInput(" * Enter Number of Overtime Loses >> ");
            InputReader.readBuffer();
=======
        String city = InputAnalyzer.getLineInput("Enter Team City >> ");
        String name = InputAnalyzer.getLineInput("Enter Team Name >> ");
        String conference = InputAnalyzer.getStringInput("Enter Team Conference >> ");
        String division = InputAnalyzer.getStringInput("Enter Team Division >> ");
            if (InputAnalyzer.getYesNoInput("Does this team have a record? ")) {
            int wins = InputAnalyzer.getIntegerInput("Enter Number of Wins >> ");
            int loses = InputAnalyzer.getIntegerInput("Enter Number of Loses >> ");
            int overtimeLoses = InputAnalyzer.getIntegerInput("Enter Number of Overtime Loses >> ");
            InputAnalyzer.readBuffer();
>>>>>>> 6814e25f9da3ed0ca82d45bef8836113876b42a0
            league.addTeam(city, name, conference, division, wins, loses, overtimeLoses);
        } else {
            league.addTeam(city, name, conference, division);
        }
    }
<<<<<<< HEAD
    
=======
>>>>>>> 6814e25f9da3ed0ca82d45bef8836113876b42a0

    /**
     * Updates the city for a team supplied as input.
     */
    protected void editTeamCity() {
<<<<<<< HEAD
        String fullName = InputReader.getLineInput(" * Enter Full Team Name or c to Cancel >> ");
        if (!(InputAnalyzer.checkSpecificInput(fullName, "C") || InputAnalyzer.checkSpecificInput(fullName, "c"))) {
            if (league.checkTeamExists(fullName)) {
                String newCity = InputReader.getLineInput(" * Enter New City or c to Cancel >> ");
                league.updateCity(fullName, newCity);
            } else {
                System.out.println(" ! The Team Does not Exist !");
            }
=======
        String fullName = InputAnalyzer.getLineInput("Enter Full Team Name >> ");
        if (league.checkTeamExists(fullName)) {
            String newCity = InputAnalyzer.getLineInput("Enter New City >> ");
            league.updateCity(fullName, newCity);
        } else {
            System.out.println("The Team Does not Exist");
>>>>>>> 6814e25f9da3ed0ca82d45bef8836113876b42a0
        }
    }

    /**
     * Updates the name for a team supplied as input.
     */
    protected void editTeamName() {
<<<<<<< HEAD
        String fullName = InputReader.getLineInput(" * Enter Full Team Name or c to Cancel >> ");
        if (!(InputAnalyzer.checkSpecificInput(fullName, "C") || InputAnalyzer.checkSpecificInput(fullName, "c"))) {
            if (league.checkTeamExists(fullName)) {
                String newName = InputReader.getLineInput(" * Enter New Name >> ");
                league.updateName(fullName, newName);
            } else {
                System.out.println(" ! The Team Does not Exist !");
            }
=======
        String fullName = InputAnalyzer.getLineInput("Enter Full Team Name >> ");
        if (league.checkTeamExists(fullName)) {
            String newName = InputAnalyzer.getLineInput("Enter New Name >> ");
            league.updateName(fullName, newName);
        } else {
            System.out.println("The Team Does not Exist");
>>>>>>> 6814e25f9da3ed0ca82d45bef8836113876b42a0
        }
    }

    /**
     * Updates the conference for a team supplied as input.
     */
    protected void editTeamConference() {
<<<<<<< HEAD
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
=======
        String fullName = InputAnalyzer.getLineInput("Enter Full Team Name >> ");
        if (league.checkTeamExists(fullName)) {
            String newConference = InputAnalyzer.getStringInput("Enter New Conference >> ");
            league.updateConference(fullName, newConference);
        } else {
            System.out.println("The Team Does not Exist");
        }
>>>>>>> 6814e25f9da3ed0ca82d45bef8836113876b42a0
    }

    /**
     * Updates the division for a team supplied as input.
     */
    protected void editTeamDivision() {
<<<<<<< HEAD
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
=======
        String fullName = InputAnalyzer.getLineInput("Enter Full Team Name >> ");
        if (league.checkTeamExists(fullName)) {
            String newDivision = InputAnalyzer.getStringInput("Enter New Division >> ");
            league.updateDivision(fullName, newDivision);
        } else {
            System.out.println("The Team Does not Exist");
        }
>>>>>>> 6814e25f9da3ed0ca82d45bef8836113876b42a0
    }

    /**
     * Updates the record for a team supplied as input.
     */
    protected void editTeamRecord() {
<<<<<<< HEAD
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
=======
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
>>>>>>> 6814e25f9da3ed0ca82d45bef8836113876b42a0
    }   
}