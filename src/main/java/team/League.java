/**
 * A class used as a data structure for all teams in the league, used to get the
 * standings sorted in different ways.
 */

package team;


import java.io.Serializable;
import java.util.List;
import java.util.ArrayList;

import input.InputAnalyzer;
import utilities.BufferGenerator;


public class League implements Serializable {
    private static final long serialVersionUID = 329208573326875283L;
    private List<Team> teams = new ArrayList<>();

    /**
     * Adds a team to the league (list of teams) given a team's city, name, conference, division
     * and record.
     * 
     * @param city  The team's city.
     * @param name  The team's name.
     * @param conference    The team's conference.
     * @param division  The team's division.
     * @param wins  The team's number of wins.
     * @param loses The team's number of loses.
     * @param overtimeLoses The team's number of overtime loses.
     */
    public void addTeam(String city, String name, String conference, String division, int wins, int loses, int overtimeLoses) {
        teams.add(new Team(city, name, conference, division, wins, loses, overtimeLoses));
    }

    /**
     * Adds a team to the league (list of teams) given a team's city, name, conference, and
     * division.
     * 
     * @param city  The team's city.
     * @param name  The team's name.
     * @param conference    The team's conference.
     * @param division  The team's division.
     */
    public void addTeam(String city, String name, String conference, String division) {
        teams.add(new Team(city, name, conference, division));
    }

    /**
     * Updates the city of a team provided from the given name.
     * 
     * @param fullName  The full name of the team to update.
     * @param city  The new city for the team.
     */
    public void updateCity(String fullName, String city) {
        int index = getTeamIndex(fullName);
        teams.get(index).setCity(city);
    }

    /**
     * Updates the name of a team based on the given current full name.
     * 
     * @param fullName  The current full name of the team.
     * @param name      The new name of the team.
     */
    public void updateName(String fullName, String name) {
        int index = getTeamIndex(fullName);
        teams.get(index).setName(name);
    }

    /**
     * Updates the conference of a team based on the given full name.
     * 
     * @param fullName      The full name of the team to update.
     * @param conference    The new conference of the team.
     */
    public void updateConference(String fullName, String conference) {
        int index = getTeamIndex(fullName);
        teams.get(index).setConference(conference);
    }

    /**
     * Updates the division of a team based on the given full name.
     * 
     * @param fullName  The full name of the team to update.
     * @param city      The new division of the team.
     */
    public void updateDivision(String fullName, String division) {
        int index = getTeamIndex(fullName);
        teams.get(index).setDivision(division);
    }

    /**
     * Updates the record for a team by supplying their wins, loses, and overtime loses.
     * 
     * @param fullName      The full name of the team to update.
     * @param wins          The new number of wins of the team.
     * @param loses         The new number of loses of the team.
     * @param overtimeLoses The new number of overtime loses of the team.
     */
    public void updateRecord(String fullName, int wins, int loses, int overtimeLoses) {
        int index = getTeamIndex(fullName);
        teams.get(index).setRecord(wins, loses, overtimeLoses);
    }


    /**
     * Returns a string showing the standings filtered by points.
     * 
     * @return  The standings filtered by only points.
     */
    public String getStandings_ByLeague_ByPoints() {
        if (teams.size() > 0) {
            sortByPoints();
            return getLeagueString();
        }
        return "\n ! No Teams In League !\n\n";
    }

    /**
     * Returns a string showing the playoff/wildcard race.
     * 
     * @return  The standings for the playoff/wildcard race.
     */
    public String getStandings_ByWildcard_ByPoints() {
        if (numInDivision("Atlantic") != 8 || numInDivision("Metropolitan") != 8
            || numInDivision("Central") != 8 || numInDivision("Pacific") != 8) {
            return "\n ! Teams are not in Proper Divisions ! \n\n";
        } else {
            sortByWildcard();
            return getWildcardString();
        }
    }

    /**
     * Returns a string showing the standings filtered by division and then by points.
     * 
     * @return  The standings filtered by division and then points.
     */
    public String getStandings_ByDivision_ByPoints() {
        if (numInDivision("Atlantic") != 8 || numInDivision("Metropolitan") != 8
            || numInDivision("Central") != 8 || numInDivision("Pacific") != 8) {
            return "\n ! Teams are not in Proper Divisions ! \n\n";
        }
        sortByDivision();
        sortByPoints(0, 7);
        sortByPoints(8, 15);
        sortByPoints(16, 23);
        sortByPoints(24, 31);
        return getDivisionString();
    }

    /**
     * Returns a string showing the standings filtered by conference and then by points.
     * 
     * @return  The standings filtered by conference and then by points.
     */
    public String getStandings_ByConference_ByPoints() {
        if (numInConference("Eastern") != 16 || numInConference("Western") != 16) {
            return "\n ! Teams are not in Proper Conferences ! \n\n";
        }
        sortByConference();
        sortByPoints(0, 15);
        sortByPoints(16, 31);
        return getConferenceString();
    }

    /**
     * Returns a string showing the standings filtered by wins.
     * 
     * @return  The standings filtered by wins.
     */
    public String getStandings_ByLeague_ByWins() {
        if (teams.size() > 0) {
            sortByWins();
            return getLeagueString();
        }
        return "\n ! No Teams In League !\n\n";
    }

    /**
     * Returns a string showing the standings filtered by loses.
     * 
     * @return  The standings filtered by loses.
     */
    public String getStandings_ByLeague_ByLoses() {
        if (teams.size() > 0) {
            sortByLoses();
            return getLeagueString();
        }
        return "\n ! No Teams In League !\n\n";
    }

    /**
     * Returns a string showing the standings filtered by overtime loses.
     * 
     * @return  The standings filtered by overtime loses.
     */
    public String getStandings_ByLeague_ByOvertimeLoses() {
        if (teams.size() > 0) {
            sortByOvertimeLoses();
            return getLeagueString();
        }
        return "\n ! No Teams In League !\n\n";
    }


    /**
     * Sorts the list of teams by the number of points, in descending order.
     */
    private void sortByPoints() {
        for (int i = 0; i < teams.size(); i++) {
            for (int j = 0; j < teams.size() - i - 1; j++) {
                if (teams.get(j).getPoints() < teams.get(j + 1).getPoints()) {
                    swapTeams(j, j + 1);
                }
            }
        }
    }

    /**
     * Sorts some sublist of the list where the endpoints are given as parameters, and are
     * included, by the number of points, in descending order.
     * 
     * @param min   The minimum index of the sublist being sorted.
     * @param max   The maximum index of the sublist being sorted.
     */
    private void sortByPoints(int min, int max) {
        int iterator = 0;
        for (int i = min; i <= max; i++) {
            for (int j = min; j <= max - iterator - 1; j++) {
                if (teams.get(j).getPoints() < teams.get(j + 1).getPoints()) {
                    swapTeams(j, j + 1);
                }
            }
            iterator++;
        }
    }

    /**
     * Sorts the list of teams by the number of wins, in descending order.
     */
    private void sortByWins() {
        for (int i = 0; i < teams.size(); i++) {
            for (int j = 0; j < teams.size() - i - 1; j++) {
                if (teams.get(j).getWins() < teams.get(j + 1).getWins()) {
                    swapTeams(j, j + 1);
                }
            }
        }
    }

    /**
     * Sorts the list of teams by the number of loses, in descending order.
     */
    private void sortByLoses() {
        for (int i = 0; i < teams.size(); i++) {
            for (int j = 0; j < teams.size() - i - 1; j++) {
                if (teams.get(j).getLoses() < teams.get(j + 1).getLoses()) {
                    swapTeams(j, j + 1);
                }
            }
        }
    }

    /**
     * Sorts the list of teams by the number of overtime loses, in descending order.
     */
    private void sortByOvertimeLoses() {
        for (int i = 0; i < teams.size(); i++) {
            for (int j = 0; j < teams.size() - i - 1; j++) {
                if (teams.get(j).getOvertimeLoses() < teams.get(j + 1).getOvertimeLoses()) {
                    swapTeams(j, j + 1);
                }
            }
        }
    }

    /**
     * Sorts a list of teams into a format that shows the wildcard race, showing the east and
     * then the west.
     */
    private void sortByWildcard() {
        sortByDivision();
        sortByPoints(0, 7);
        sortByPoints(8, 15);
        swapTeams(3, 8);
        swapTeams(4, 9);
        swapTeams(5, 10);
        sortByPoints(6, 15);
        sortByPoints(16, 23);
        sortByPoints(24, 31);
        swapTeams(19, 24);
        swapTeams(20, 25);
        swapTeams(21, 26);
        sortByPoints(22, 31);
    }

    /**
     * Sorts a list of teams by division, specifically, the Atlantic teams followed by the
     * Metro, then the Central and finally the Pacific.
     */
    private void sortByDivision() {
        List<Team> sortedByDivision = new ArrayList<>();
        int index = 0, numberFound = 0;
        while (index < 32 && numberFound < 8) {
            if (teams.get(index).getDivision().equals("Atlantic")) {
                sortedByDivision.add(teams.get(index));
                numberFound++;
            }
            index++;
        }
        numberFound = 0;
        index = 0;
        while (index < 32 && numberFound < 8) {
            if (teams.get(index).getDivision().equals("Metropolitan")) {
                sortedByDivision.add(teams.get(index));
                numberFound++;
            }
            index++;
        }
        numberFound = 0;
        index = 0;
        while (index < 32 && numberFound < 8) {
            if (teams.get(index).getDivision().equals("Central")) {
                sortedByDivision.add(teams.get(index));
                numberFound++;
            }
            index++;
        }
        numberFound = 0;
        index = 0;
        while (index < 32 && numberFound < 8) {
            if (teams.get(index).getDivision().equals("Pacific")) {
                sortedByDivision.add(teams.get(index));
                numberFound++;
            }
            index++;
        }
        teams = sortedByDivision;
    }

    /**
     * Sorts a list of teams by the conference, putting all Eastern teams before all Western
     * teams.
     */
    private void sortByConference() {
        List<Team> sortedByConference = new ArrayList<>();
        int index = 0, numberFound = 0;
        while (index < 32 && numberFound < 16) {
            if (teams.get(index).getConference().equals("Eastern")) {
                sortedByConference.add(teams.get(index));
                numberFound++;
            }
            index++;
        }
        numberFound = 0;
        index = 0;
        while (index < 32 && numberFound < 16) {
            if (teams.get(index).getConference().equals("Western")) {
                sortedByConference.add(teams.get(index));
                numberFound++;
            }
            index++;
        }
        teams = sortedByConference;
    }


    /**
     * Returns a string for the standings assuming the teams are not sorted by division nor by
     * conference.
     * 
     * @return  A string showing the standings by league.
     */
    private String getLeagueString() {
        String listString = "";
        listString += "\t\t\t\t\tLeague\n";
        listString += BufferGenerator.addLineBufferForScreenWidth();
        for (int i = 0; i < teams.size(); i++) {
            listString += i+1 + ". \t" + teams.get(i).toString();
            listString += "\n";
        }
        return listString;
    }

    /**
     * Returns a string for the standings assuming the teams are sorted into the wildcard
     * race.
     * 
     * @return  A string showing the wildcard standings.
     */
    private String getWildcardString() {
        String listString = "";
        int i = 0;
        listString += "\nEast\n";
        listString += "\t\t\t\t\tAtlantic\n";
        listString += BufferGenerator.addLineBufferForScreenWidth();
        while (i < 3) {
            listString += i+1 + ". \t" + teams.get(i).toString();
            listString += "\n";
            i++;
        }
        listString += "\n\t\t\t\t\tMetropolitan\n";
        listString += BufferGenerator.addLineBufferForScreenWidth();
        while (i < 6) {
            listString += i-2 + ". \t" + teams.get(i).toString();
            listString += "\n";
            i++;
        }
        listString += "\n\t\t\t\t\tWildcard\n";
        listString += BufferGenerator.addLineBufferForScreenWidth();
        while (i < 16) {
            listString += i-5 + ". \t" + teams.get(i).toString();
            listString += "\n";
            i++;
        }
        listString += BufferGenerator.addLineBufferForScreenWidth();

        listString += "West\n";
        listString += "\t\t\t\t\tCentral\n";
        listString += BufferGenerator.addLineBufferForScreenWidth();
        while (i < 19) {
            listString += i-15 + ". \t" + teams.get(i).toString();
            listString += "\n";
            i++;
        }
        listString += "\n\t\t\t\t\tPacific\n";
        listString += BufferGenerator.addLineBufferForScreenWidth();
        while (i < 22) {
            listString += i-18 + ". \t" + teams.get(i).toString();
            listString += "\n";
            i++;
        }
        listString += "\n\t\t\t\t\tWildcard\n";
        listString += BufferGenerator.addLineBufferForScreenWidth();
        while (i < 32) {
            listString +=  i-21 + ". \t" + teams.get(i).toString();
            listString += "\n";
            i++;
        }
        return listString;
    }

    /**
     * Returns a string for the standings assuming the teams are sorted by division.
     * 
     * @return  A string showing the standings by division.
     */
    private String getDivisionString() {
        String listString = "";
        listString += "\t\t\t\t\tAtlantic\n";
        listString += BufferGenerator.addLineBufferForScreenWidth();
        int i = 0;
        while (i < 8) {
            listString += i+1 + ". \t" + teams.get(i).toString();
            listString += "\n";
            i++;
        }
        listString += "\t\t\t\t\tMetropolitan\n";
        listString += BufferGenerator.addLineBufferForScreenWidth();
        while (i < 16) {
            listString += i-7 + ". \t" + teams.get(i).toString();
            listString += "\n";
            i++;
        }
        listString += "\t\t\t\t\tCentral\n";
        listString += BufferGenerator.addLineBufferForScreenWidth();
        while (i < 24) {
            listString += i-15 + ". \t" + teams.get(i).toString();
            listString += "\n";
            i++;
        }
        listString += "\t\t\t\t\tPacific\n";
        listString += BufferGenerator.addLineBufferForScreenWidth();
        while (i < 32) {
            listString += i-23 + ". \t" + teams.get(i).toString();
            listString += "\n";
            i++;
        }
        return listString;
    }

    /**
     * Returns a string for the standings assuming the teams are sorted by conference.
     * 
     * @return  A string showing the standings by conference.
     */
    private String getConferenceString() {
        String listString = "";
        listString += "\t\t\t\t\tEastern\n";
        listString += BufferGenerator.addLineBufferForScreenWidth();
        int i = 0;
        while (i < 16) {
            listString += i+1 + ". \t" + teams.get(i).toString();
            listString += "\n";
            i++;
        }
        listString += "\t\t\t\t\tWestern\n";
        listString += BufferGenerator.addLineBufferForScreenWidth();
        while (i < 32) {
            listString += i-15 + ". \t" + teams.get(i).toString();
            listString += "\n";
            i++;
        }
        return listString;
    }


    /**
     * Checks if a given team belongs to the league.
     * 
     * @param fullName  The full name to check for.
     * @return  True if the name is found, and false otherwise.
     */
    public boolean checkTeamExists(String fullName) {
        for (int i = 0; i < teams.size(); i++) {
            if (InputAnalyzer.checkSpecificInput(fullName, teams.get(i).getFullName())) {
                return true;
            }
        }
        return false;
    }

    /**
     * Gets the index of a team in the ArrayList of teams by searching for the given full name.
     * 
     * @param fullName  The name of the team which we are finding the index of.
     * @return  The index of the team in the ArrayList, if found, and -1 otherwise.
     */
    private int getTeamIndex(String fullName) {
        for (int i = 0; i < teams.size(); i++) {
            if (InputAnalyzer.checkSpecificInput(fullName, teams.get(i).getFullName())) {
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
    private void swapTeams(int first, int second) {
        Team temp = teams.get(first);
        teams.set(first, teams.get(second));
        teams.set(second, temp);
    }

    /**
     * Finds the number of teams in a given division.
     * 
     * @param division  The division which we are checking for teams of.
     * @return  The number of teams in the division.
     */
    private int numInDivision(String division) {
        int numInDivision = 0;
        for (int i = 0; i < teams.size(); i++) {
            if (InputAnalyzer.checkSpecificInput(teams.get(i).getDivision(), division)) {
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
    private int numInConference(String conference) {
        int numInConference = 0;
        for (int i = 0; i < teams.size(); i++) {
            if (InputAnalyzer.checkSpecificInput(teams.get(i).getDivision(), conference)) {
                numInConference++;
            }
        }
        return numInConference;
    }
}