/**
 * A class used as a data structure for all teams in the league, used to get the
 * standings sorted in different ways.
 */

package team;

import java.io.Serializable;
import java.util.List;
import java.util.ArrayList;

import ui.InputAnalyzer;

public class League implements Serializable {
    private static final long serialVersionUID = 329208573326875283L;
    private ArrayList<Team> teams = new ArrayList<>();

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
     * Checks if a team belongs to the league.
     * 
     * @param teamName  The team name to check for.
     * @return  True if the team name is found, and false otherwise.
     */
    public boolean checkTeamExists(String team) {
        for (int i = 0; i < teams.size(); i++) {
            if (InputAnalyzer.checkSpecificInput(team, teams.get(i).getTeam())) {
                return true;
            }
        }
        return false;
    }

    /**
     * Updates the city of a team based on the given name.
     * 
     * @param name  The name of the team to update.
     * @param city  The new city for the team.
     */
    public void updateCity(String name, String city) {
        for (int i = 0; i < teams.size(); i++) {
            if (InputAnalyzer.checkSpecificInput(name, teams.get(i).getName())) {
                teams.get(i).setCity(city);
            }
        }
    }

    /**
     * Updates the name of a team based on the given previous name.
     * 
     * @param oldName   The old name of the team.
     * @param newName   The new name of the team.
     */
    public void updateName(String oldName, String newName) {
        for (int i = 0; i < teams.size(); i++) {
            if (InputAnalyzer.checkSpecificInput(oldName, teams.get(i).getName())) {
                teams.get(i).setName(newName);
            }
        }
    }

    /**
     * Updates the conference of a team based on the given name.
     * 
     * @param name  The name of the team to update.
     * @param city  The new conference of the team.
     */
    public void updateConference(String name, String conference) {
        for (int i = 0; i < teams.size(); i++) {
            if (InputAnalyzer.checkSpecificInput(name, teams.get(i).getName())) {
                teams.get(i).setConference(conference);
            }
        }
    }

    /**
     * Updates the division of a team based on the given name.
     * 
     * @param name  The name of the team to update.
     * @param city  The new division of the team.
     */
    public void updateDivision(String name, String conference) {
        for (int i = 0; i < teams.size(); i++) {
            if (InputAnalyzer.checkSpecificInput(name, teams.get(i).getName())) {
                teams.get(i).setDivision(conference);
            }
        }
    }

    /**
     * Updates the record for a team by supplying their wins, loses, and overtime loses.
     * 
     * @param name  The name of the team to update.
     * @param wins  The new number of wins of the team.
     * @param loses The new number of loses of the team.
     * @param overtimeLoses The new number of overtime loses of the team.
     */
    public void updateRecord(String name, int wins, int loses, int overtimeLoses) {
        for (int i = 0; i < teams.size(); i++) {
            if (InputAnalyzer.checkSpecificInput(name, teams.get(i).getName())) {
                teams.get(i).setRecord(wins, loses, overtimeLoses);
            }
        }
    }

    /**
     * Returns a string showing the standings filtered by points.
     * 
     * @return  The standings filtered by only points.
     */
    public String getStandings_ByLeague_ByPoints() {
        ArrayList<Team> leagueStandingsByPoints = sortByPoints(teams);
        return getLeagueString(leagueStandingsByPoints);
    }

    /**
     * Returns a string showing the playoff/wildcard race.
     * 
     * @return  The standings for the playoff/wildcard race.
     */
    public String getStandings_ByWildcard_ByPoints() {
        ArrayList<Team> leagueByWildcard = sortByWildcard(teams);
        return getWildcardString(leagueByWildcard);
    }

    /**
     * Returns a string showing the standings filtered by division and then by points.
     * 
     * @return  The standings filtered by division and then points.
     */
    public String getStandings_ByDivision_ByPoints() {
        ArrayList<Team> leagueByDivision = sortByDivision(teams);
        sortByPoints(leagueByDivision.subList(0, 7));
        sortByPoints(leagueByDivision.subList(8, 15));
        sortByPoints(leagueByDivision.subList(16, 23));
        sortByPoints(leagueByDivision.subList(24, 31));
        return getDivisionString(leagueByDivision);
    }

    /**
     * Returns a string showing the standings filtered by conference and then by points.
     * 
     * @return  The standings filtered by conference and then by points.
     */
    public String getStandings_ByConference_ByPoints() {
        ArrayList<Team> leagueByConference = sortByConference(teams);
        sortByPoints(leagueByConference.subList(0, 7));
        sortByPoints(leagueByConference.subList(8, 15));
        return getConferenceString(leagueByConference);
    }

    /**
     * Returns a string showing the standings filtered by wins.
     * 
     * @return  The standings filtered by wins.
     */
    public String getStandings_ByLeague_ByWins() {
        ArrayList<Team> leagueByWins = sortByWins(teams);
        return getLeagueString(leagueByWins);
    }

    /**
     * Returns a string showing the standings filtered by loses.
     * 
     * @return  The standings filtered by loses.
     */
    public String getStandings_ByLeague_ByLoses() {
        ArrayList<Team> leagueByLoses = sortByLoses(teams);
        return getLeagueString(leagueByLoses);
    }

    /**
     * Returns a string showing the standings filtered by overtime loses.
     * 
     * @return  The standings filtered by overtime loses.
     */
    public String getStandings_ByLeague_ByOvertimeLoses() {
        ArrayList<Team> leagueByOvertimeLsoes = sortByOvertimeLoses(teams);
        return getLeagueString(leagueByOvertimeLsoes);
    }

    /**
     * Sorts a list of teams by the number of points, in descending order.
     * 
     * @param list  The list to sort.
     * @return  The new, sorted list.
     */
    private List<Team> sortByPoints(List<Team> list) {
        for (int i = 0; i < list.size() - 1; i++) {
            for (int j = 0; j < list.size() - i - 1; j++) {
                if (list.get(j).getPoints() > list.get(j + 1).getPoints()) {
                    swapTeams(list, j + 1, j);
                }
            }
        }

        return list;
    }

    /**
     * Sorts a list of teams by the number of points, in descending order.
     * 
     * @param list  The list to sort.
     * @return  The new, sorted list.
     */
    private ArrayList<Team> sortByPoints(ArrayList<Team> list) {
        for (int i = 0; i < list.size() - 1; i++) {
            for (int j = 0; j < list.size() - i - 1; j++) {
                if (list.get(j).getPoints() > list.get(j + 1).getPoints()) {
                    swapTeams(list, j, j + 1);
                }
            }
        }

        return list;
    }

    /**
     * Sorts a list of teams by the number of wins, in descending order.
     * 
     * @param list  The list to sort.
     * @return  The new, sorted list.
     */
    private ArrayList<Team> sortByWins(ArrayList<Team> list) {
        ArrayList<Team> newList = new ArrayList<>();

        int highestWins = 0, index = -1;
        for (int i = 0; i < list.size(); i++) {
            for (int j = i; j < list.size(); j++) {
                if (list.get(j).getWins() > highestWins) {
                    highestWins = list.get(j).getWins();
                    index = j;
                }
            }

            if (index != -1) {
                newList.add(list.get(index));
                newList.get(index).setWins(-1);
            } else {
                return newList;
            }
        }
        return newList;
    }

    /**
     * Sorts a list of teams by the number of loses, in descending order.
     * 
     * @param list  The list to sort.
     * @return  The new, sorted list.
     */
    private ArrayList<Team> sortByLoses(ArrayList<Team> list) {
        ArrayList<Team> newList = new ArrayList<>();

        int highestLoses = 0, index = -1;
        for (int i = 0; i < list.size(); i++) {
            for (int j = i; j < list.size(); j++) {
                if (list.get(j).getLoses() > highestLoses) {
                    highestLoses = list.get(j).getLoses();
                    index = j;
                }
            }

            if (index != -1) {
                newList.add(list.get(index));
                list.get(index).setLoses(-1);
            } else {
                return newList;
            }
        }
        return newList;
    }

    /**
     * Sorts a list of teams by the number of overtime loses, in descending order.
     * 
     * @param list  The list to sort.
     * @return  The new, sorted list.
     */
    private ArrayList<Team> sortByOvertimeLoses(ArrayList<Team> list) {
        ArrayList<Team> newList = new ArrayList<>();

        int highestOvertimeLoses = 0, index = -1;
        for (int i = 0; i < list.size(); i++) {
            for (int j = i; j < list.size(); j++) {
                if (list.get(j).getOvertimeLoses() > highestOvertimeLoses) {
                    highestOvertimeLoses = list.get(j).getOvertimeLoses();
                    index = j;
                }
            }

            if (index != -1) {
                newList.add(list.get(index));
                newList.get(index).setOvertimeLoses(-1);
            } else {
                return newList;
            }
        }
        return newList;
    }

    /**
     * Sorts a list of teams into a format that shows the wildcard race, showing the east and
     * then the west.
     * 
     * @param list  The list to sort.
     * @return      The new, sorted list.
     */
    private ArrayList<Team> sortByWildcard(ArrayList<Team> list) {
        ArrayList<Team> sortedIntoWildcard = sortByDivision(teams);
        sortByPoints(sortedIntoWildcard.subList(0, 7));
        sortByPoints(sortedIntoWildcard.subList(8, 15));
        swapTeams(sortedIntoWildcard, 3, 8);
        swapTeams(sortedIntoWildcard, 4, 9);
        swapTeams(sortedIntoWildcard, 5, 10);
        sortByPoints(sortedIntoWildcard.subList(6, 15));
        sortByPoints(sortedIntoWildcard.subList(16, 23));
        sortByPoints(sortedIntoWildcard.subList(24, 31));
        swapTeams(sortedIntoWildcard, 19, 24);
        swapTeams(sortedIntoWildcard, 20, 25);
        swapTeams(sortedIntoWildcard, 21, 26);
        sortByPoints(sortedIntoWildcard.subList(22, 31));
        return sortedIntoWildcard;
    }

    /**
     * Sorts a list of teams by division, specifically, the Atlantic teams followed by the
     * Metro, then the Central and finally the Pacific.
     * 
     * @param list  The list to sort.
     * @return  The new, sorted list.
     */
    private ArrayList<Team> sortByDivision(ArrayList<Team> list) {
        ArrayList<Team> sortedByDivision = new ArrayList<>();
        int index = 0, numberFound = 0;
        while (index < 32 && numberFound < 8) {
            if (list.get(index).getDivision().equals("Atlantic")) {
                sortedByDivision.add(list.get(index));
                numberFound++;
            }
            index++;
        }
        numberFound = 0;
        index = 0;
        while (index < 32 && numberFound < 8) {
            if (list.get(index).getDivision().equals("Metropolitan")) {
                sortedByDivision.add(list.get(index));
                numberFound++;
            }
            index++;
        }
        numberFound = 0;
        index = 0;
        while (index < 32 && numberFound < 8) {
            if (list.get(index).getDivision().equals("Central")) {
                sortedByDivision.add(list.get(index));
                numberFound++;
            }
            index++;
        }
        numberFound = 0;
        index = 0;
        while (index < 32 && numberFound < 8) {
            if (list.get(index).getDivision().equals("Pacific")) {
                sortedByDivision.add(list.get(index));
                numberFound++;
            }
            index++;
        }
        return sortedByDivision;
    }

    /**
     * Sorts a list of teams by the conference, putting all Eastern teams before all Western
     * teams.
     * 
     * @param list  The list to sort.
     * @return  The new, sorted list.
     */
    private ArrayList<Team> sortByConference(ArrayList<Team> list) {
        ArrayList<Team> sortedByConference = new ArrayList<>();
        int index = 0, numberFound = 0;
        while (index < 32 && numberFound < 16) {
            if (list.get(index).getConference().equals("Eastern")) {
                sortedByConference.add(list.get(index));
                numberFound++;
            }
            index++;
        }
        numberFound = 0;
        index = 0;
        while (index < 32 && numberFound < 8) {
            if (list.get(index).getConference().equals("Western")) {
                sortedByConference.add(list.get(index));
                numberFound++;
            }
            index++;
        }
        return sortedByConference;
    }

    /**
     * Returns a string for the standings assuming the teams are not sorted by division nor by
     * conference.
     * 
     * @param list  The list to sort.
     * @return  The new, sorted list.
     */
    private String getLeagueString(ArrayList<Team> list) {
        String listString = "";

        for (int i = 0; i < list.size(); i++) {
            listString += i+1 + ". \t" + list.get(i).toString();
            listString += "\n";
        }
        return listString;
    }

    /**
     * Returns a string for the standings assuming the teams are sorted by division.
     * 
     * @param list  The list to sort.
     * @return  The new, sorted list.
     */
    private String getDivisionString(ArrayList<Team> list) {
        String listString = "";
        listString += "\t\tAtlantic\t\t\n";
        int i = 0;
        while (i < 8) {
            listString += list.get(i).toString();
            listString += "\n";
            i++;
        }
        listString += "\n\t\tMetropolitan\t\t\n";
        while (i < 16) {
            listString += list.get(i).toString();
            listString += "\n";
            i++;
        }
        listString += "\n\t\tCentral\t\t\n";
        while (i < 24) {
            listString += list.get(i).toString();
            listString += "\n";
            i++;
        }
        listString += "\n\t\tPacific\t\t\n";
        while (i < 32) {
            listString += list.get(i).toString();
            listString += "\n";
            i++;
        }
        return listString;
    }

    /**
     * Returns a string for the standings assuming the teams are sorted by conference.
     * 
     * @param list  The list to sort.
     * @return  The new, sorted list.
     */
    private String getConferenceString(ArrayList<Team> list) {
        String listString = "";
        listString += "\t\tEast\t\t\n";
        int i = 0;
        while (i < 16) {
            listString += list.get(i).toString();
            listString += "\n";
            i++;
        }
        listString += "\n\t\tWest\t\t\n";
        while (i < 32) {
            listString += list.get(i).toString();
            listString += "\n";
            i++;
        }
        return listString;
    }

    /**
     * Returns a string for the standings assuming the teams are sorted into the wildcard
     * race.
     * 
     * @param list  The list to sort.
     * @return  The new, sorted list.
     */
    private String getWildcardString(ArrayList<Team> list) {
        String listString = "";
        int i = 0;
        listString += "\t\tEast\t\t\n\t\tAtlantic\t\t\n";
        while (i < 3) {
            listString += list.get(i).toString();
            listString += "\n";
            i++;
        }
        listString += "\n\t\tMetropolitan\t\t\n";
        while (i < 6) {
            listString += list.get(i).toString();
            listString += "\n";
            i++;
        }
        listString += "\t\tWildcard Race\t\t\n";
        while (i < 16) {
            listString +=  list.get(i).toString();
            listString += "\n";
            i++;
        }
        listString += "\t\tWest\t\t\n\t\tCentral\t\t\n";
        while (i < 19) {
            listString += list.get(i).toString();
            listString += "\n";
            i++;
        }
        listString += "\n\t\tPacific\t\t\n";
        while (i < 22) {
            listString += list.get(i).toString();
            listString += "\n";
            i++;
        }
        listString += "\t\tWildcard Race\t\t\n";
        while (i < 32) {
            listString +=  list.get(i).toString();
            listString += "\n";
            i++;
        }
        return listString;
    }

    /**
     * Swaps two given teams' positions in a list of teams.
     * 
     * @param list      The list of the teams.
     * @param first     The first team to swap.
     * @param second    The second team to swap.
     */
    private void swapTeams(List<Team> list, int first, int second) {
        Team temp = list.get(first);
        list.set(first, list.get(second));
        list.set(second, temp);
    }

    /**
     * Swaps two given teams' positions in a list of teams.
     * 
     * @param list      The list of the teams.
     * @param first     The first team to swap.
     * @param second    The second team to swap.
     */
    private void swapTeams(ArrayList<Team> list, int first, int second) {
        Team temp = list.get(first);
        list.set(first, list.get(second));
        list.set(second, temp);
    }
}
