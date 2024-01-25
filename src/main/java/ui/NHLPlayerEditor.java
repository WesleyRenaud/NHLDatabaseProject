/**
 * A class that bridges the UI of the database and actual database, managing how the
 * user adds and edits player data.
 */

package ui;

<<<<<<< HEAD

import input.InputReader;
import input.NHLInputReader;
import utilities.BufferGenerator;
import utilities.SeasonHandler;
import player.Players;

=======
import player.Players;
import utilities.BufferGenerator;
import utilities.InputAnalyzer;
>>>>>>> 6814e25f9da3ed0ca82d45bef8836113876b42a0

public class NHLPlayerEditor {
    private Players players;

    protected void setPlayers(Players newPlayers) {
        players = newPlayers;
    }

    /**
     * Adds a player to the database.
     */
    protected void addPlayer() {
<<<<<<< HEAD
        BufferGenerator.printBufferForScreenWidth();
        String name = InputReader.getLineInput(" * Enter Player Name >> ");
        String birthday = NHLInputReader.getBirthdayInput(" * Enter Player Birthday >> ");
        String handedness = NHLInputReader.getHandednessInput(" * Enter Player Handedness >> ");
        boolean retired = InputReader.getYesNoInput(" * Is the Player Retired? ");
        int number;
        String team;
        if (!retired) {
            number = InputReader.getIntegerInput(" * Enter Current Jersey Number >> ");
            InputReader.readBuffer();
            team = InputReader.getLineInput(" * Enter Current Team >> ");
        } else {
            number = -1;
            team = null;
        }
        String firstSeason = NHLInputReader.getSeasonInput(" * Enter First Season of Career >> ");
        InputReader.readBuffer();
        int playerType = InputReader.getValidInput(" * Is this Player a Skater [1] or a Goalie [2]? ", 2);
        switch (playerType) {
            case 1:
                players.addSkater(name, birthday, handedness, retired, number, team);
                if (!retired) {
                    addCurrentSkaterStats(firstSeason, name, birthday, handedness, number, team);
                } else {
                    String lastSeason = NHLInputReader.getSeasonInput(" * Enter Last Season of Career >> ");
                    addRetiredSkaterStats(firstSeason, lastSeason, name, birthday, handedness, number, team);
                }
                break;
            
            default:
                players.addGoalie(name, birthday, handedness, retired, number, team);
                if (!retired) {
                    addCurrentGoalieStats(firstSeason, name, birthday, handedness, number, team);
                } else {
                    String lastSeason = NHLInputReader.getSeasonInput(" * Enter Last Season of Career >> ");
                    addRetiredGoalieStats(firstSeason, lastSeason, name, birthday, handedness, number, team);
                }
=======
        BufferGenerator.printBuffer(100);
        String name = InputAnalyzer.getLineInput("Enter Player Name >> ");
        int age = InputAnalyzer.getNaturalNumberInput("Enter Player Age >> ");
        int number = InputAnalyzer.getIntegerInput("Enter Current Jersey Number or -1 if Retired >> ");
        String team = InputAnalyzer.getLineInput("Enter Current Team or NA if Retired >> ");
        InputAnalyzer.getLineInput("Team Does Not Exist\nEnter Current Team or NA if Retired >> ");
        int playerType = InputAnalyzer.getValidInput("Is this Player a Skater [1] or a Goalie [2]? ", 2);
        switch (playerType) {
            case 1:
                //addSkater(name, age, number, team);
                break;
            
            default:
                //addGoalie(name, age, number, team);
>>>>>>> 6814e25f9da3ed0ca82d45bef8836113876b42a0
                break;
        }
    }

    /**
<<<<<<< HEAD
     * Adds a current skater to the database given their name, birthday, handedness, retired
     * status, number, and team.
     * 
     * @param firstSeason   The first season which the skater played during.
     * @param name          The skater's name.
     * @param birthday      The skater's birthday.
     * @param handedness    The skater's handedness.
     * @param retired       The skater's retired status.
     * @param number        The skater's jersey number.
     * @param team          The skater's team.
     */
    private void addCurrentSkaterStats(String firstSeason, String name, String birthday, String handedness, int number, String team) {
        String currentSeason = firstSeason;
        for (int i = SeasonHandler.getFirstYear_AsInt(firstSeason); i <= 2023; i++) {
            System.out.println();
            System.out.println(" * Entering stats for " + currentSeason);
            int gamesPlayed = InputReader.getIntegerInput(" * Games Played >> ");
            int goals = InputReader.getIntegerInput(" * Goals >> ");
            int assists = InputReader.getIntegerInput(" * Assists >> ");
            int plusMinus = InputReader.getIntegerInput(" * Plus-Minus >> ");
            players.addSkaterSeason(name, currentSeason, gamesPlayed, goals, assists, plusMinus);
            currentSeason = SeasonHandler.nextSeason(currentSeason);
        }
    }

    /**
     * Adds a retired skater to the database given their name, birthday, handedness, retired
     * status, number, and team.
     * 
     * @param firstSeason   The first season which the skater played during.
     * @param lastSeason    The last season which the skater played during.
     * @param name          The skater's name.
     * @param birthday      The skater's birthday.
     * @param handedness    The skater's handedness.
     * @param retired       The skater's retired status.
     * @param number        The skater's jersey number.
     * @param team          The skater's team.
     */
    private void addRetiredSkaterStats(String firstSeason, String lastSeason, String name, String birthday, String handedness, int number, String team) {
        String currentSeason = firstSeason;
        for (int i = SeasonHandler.getFirstYear_AsInt(firstSeason); i <= SeasonHandler.getFirstYear_AsInt(lastSeason); i++) {
            System.out.println(" * Entering stats for " + currentSeason);
            int gamesPlayed = InputReader.getIntegerInput(" * Games Played >> ");
            int goals = InputReader.getIntegerInput(" * Goals >> ");
            int assists = InputReader.getIntegerInput(" * Assists >> ");
            int plusMinus = InputReader.getIntegerInput(" * Plus-Minus >> ");
            players.addSkaterSeason(name, currentSeason, gamesPlayed, goals, assists, plusMinus);
            currentSeason = SeasonHandler.nextSeason(currentSeason);
            System.out.println();
        }
    }

    /**
     * Adds a current goalie to the database given their name, birthday, handedness, retired
     * status, number, and team.
     * 
     * @param firstSeason   The first season which the goalie played during.
     * @param name          The goalie's name.
     * @param birthday      The goalie's birthday.
     * @param handedness    The goalie's handedness.
     * @param retired       The goalie's retired status.
     * @param number        The goalie's jersey number.
     * @param team          The goalie's team.
     */
    private void addCurrentGoalieStats(String firstSeason, String name, String birthday, String handedness, int number, String team) {
        String currentSeason = firstSeason;
        for (int i = SeasonHandler.getFirstYear_AsInt(firstSeason); i <= 2023; i++) {
            System.out.println(" * Entering stats for " + currentSeason);
            int wins = InputReader.getIntegerInput(" * Wins >> ");
            int loses = InputReader.getIntegerInput(" * Loses >> ");
            int overtimeLoses = InputReader.getIntegerInput(" * Overtime Loses >> ");
            double savePercentage = InputReader.getDoubleInput(" * Save Percentage >> ");
            double goalsAgainstAverage = InputReader.getDoubleInput(" * Goals Against Average >> ");
            players.addGoalieSeason(name, currentSeason, wins, loses, overtimeLoses, savePercentage, goalsAgainstAverage);
            currentSeason = SeasonHandler.nextSeason(currentSeason);
            System.out.println();
        }
    }

    /**
     * Adds a retired goalie to the database given their name, birthday, handedness, retired
     * status, number, and team.
     * 
     * @param firstSeason   The first season which the goalie played during.
     * @param lastSeason    The last season which the goalie played during.
     * @param name          The goalie's name.
     * @param birthday      The goalie's birthday.
     * @param handedness    The goalie's handedness.
     * @param retired       The goalie's retired status.
     * @param number        The goalie's jersey number.
     * @param team          The goalie's team.
     */
    private void addRetiredGoalieStats(String firstSeason, String lastSeason, String name, String birthday, String handedness, int number, String team) {
        String currentSeason = firstSeason;
        for (int i = SeasonHandler.getFirstYear_AsInt(firstSeason); i <= SeasonHandler.getFirstYear_AsInt(lastSeason); i++) {
            System.out.println(" * Entering stats for " + currentSeason);
            int wins = InputReader.getIntegerInput(" * Wins >> ");
            int loses = InputReader.getIntegerInput("* Loses >> ");
            int overtimeLoses = InputReader.getIntegerInput(" * Overtime Loses >> ");
            double savePercentage = InputReader.getDoubleInput(" * Save Percentage >> ");
            double goalsAgainstAverage = InputReader.getDoubleInput(" * Goals Against Average >> ");
            players.addGoalieSeason(name, currentSeason, wins, loses, overtimeLoses, savePercentage, goalsAgainstAverage);
            currentSeason = SeasonHandler.nextSeason(currentSeason);
            System.out.println();
        }
    }
    

    /**
     * Updates the current season stats for a player supplied as input.
     */
    protected void editPlayerSeasonStats() {
        String playerName = InputReader.getLineInput(" * Enter Full Player Name >> ");
=======
     * Updates the current season stats for a player supplied as input.
     */
    protected void editPlayerSeasonStats() {
        String playerName = InputAnalyzer.getLineInput("Enter Full Player Name >> ");
>>>>>>> 6814e25f9da3ed0ca82d45bef8836113876b42a0
        if (players.checkPlayerExists(playerName)) {
            if (players.checkPlayerIsSkater(playerName)) {
                editSkaterSeasonStats(playerName);
            } else {
                editGoalieSeasonStats(playerName);
            }
        } else {
<<<<<<< HEAD
            System.out.println(" ! The Player Does not Exist !");
=======
            System.out.println("The Player Does not Exist");
>>>>>>> 6814e25f9da3ed0ca82d45bef8836113876b42a0
        }
    }

    /**
     * Updates the current season stats for a skater supplied as a parameter.
     */
    protected void editSkaterSeasonStats(String playerName) {
<<<<<<< HEAD
        int gamesPlayed = InputReader.getIntegerInput(" * Games Played >> ");
        int goals = InputReader.getIntegerInput(" * Goals >> ");
        int assists = InputReader.getIntegerInput(" * Assists >> ");
        int plusMinus = InputReader.getIntegerInput(" * Plus-Minus >> ");
        players.updateSkaterSeasonStats(playerName, gamesPlayed, goals, assists, plusMinus);
=======
        int gamesPlayed = InputAnalyzer.getIntegerInput("Games Played >> ");
        int points = InputAnalyzer.getIntegerInput("Points >> ");
        int goals = InputAnalyzer.getIntegerInput("Goals >> ");
        int assists = InputAnalyzer.getIntegerInput("Assists >> ");
        int plusMinus = InputAnalyzer.getIntegerInput("Plus-Minus >> ");
        players.updateSkaterSeasonStats(playerName, gamesPlayed, points, goals, assists, plusMinus);
>>>>>>> 6814e25f9da3ed0ca82d45bef8836113876b42a0
    }

    /**
     * Updates the current season stats for a goalie supplied as a parameter.
     */
    protected void editGoalieSeasonStats(String playerName) {
<<<<<<< HEAD
        int wins = InputReader.getIntegerInput(" * Wins >> ");
        int loses = InputReader.getIntegerInput(" * Loses >> ");
        int overtimeLoses = InputReader.getIntegerInput(" * Overtime Loses >> ");
        double savePercentage = InputReader.getDoubleInput(" * Save Percentage >> ");
        double goalsAgainstAverage = InputReader.getDoubleInput(" * Goals Against Average >> ");
        players.updateGoalieSeasonStats(playerName, wins, loses, overtimeLoses, savePercentage, goalsAgainstAverage);
=======
        int gamesPlayed = InputAnalyzer.getIntegerInput("Games Played >> ");
        int wins = InputAnalyzer.getIntegerInput("Wins >> ");
        int loses = InputAnalyzer.getIntegerInput("Loses >> ");
        int overtimeLoses = InputAnalyzer.getIntegerInput("Overtime Loses >> ");
        double savePercentage = InputAnalyzer.getDoubleInput("Save Percentage >> ");
        double goalsAgainstAverage = InputAnalyzer.getDoubleInput("Goals Against Average >> ");
        players.updateGoalieSeasonStats(playerName, gamesPlayed, wins, loses, overtimeLoses, savePercentage, goalsAgainstAverage);
>>>>>>> 6814e25f9da3ed0ca82d45bef8836113876b42a0
    }

    /**
     * Adds one or more historical seasons' stats for a player supplied as input.
     */
    protected void addPlayerSeasons() {
<<<<<<< HEAD
        String playerName = InputReader.getLineInput(" * Enter Full Player Name >> ");
        if (players.checkPlayerExists(playerName)) {
            int num = InputReader.getIntegerInput(" * Enter Number of Seasons to Add >> ");
=======
        String playerName = InputAnalyzer.getLineInput("Enter Full Player Name >> ");
        if (players.checkPlayerExists(playerName)) {
            int num = InputAnalyzer.getIntegerInput("Enter Number of Seasons to Add >> ");
>>>>>>> 6814e25f9da3ed0ca82d45bef8836113876b42a0
            if (players.checkPlayerIsSkater(playerName)) {
                for (int i = 0; i < num; i++) {
                    addSkaterSeason(playerName);
                }
            }  else {
                for (int i = 0; i < num; i++) {
                    addGoalieSeason(playerName);
                }
            }
        } else {
<<<<<<< HEAD
            System.out.println(" ! The Player Does not Exist !");
=======
            System.out.println("The Player Does not Exist");
>>>>>>> 6814e25f9da3ed0ca82d45bef8836113876b42a0
        }
    }

    /**
     * Adds one or more historical seasons' stats for a player supplied as input.
     */
    protected void addSkaterSeason(String playerName) {
<<<<<<< HEAD
        String season = NHLInputReader.getSeasonInput(playerName);
        int gamesPlayed = InputReader.getIntegerInput(" * Games Played >> ");
        int goals = InputReader.getIntegerInput(" * Goals >> ");
        int assists = InputReader.getIntegerInput(" * Assists >> ");
        int plusMinus = InputReader.getIntegerInput(" * Plus-Minus >> ");
        players.addSkaterSeason(playerName, season, gamesPlayed, goals, assists, plusMinus);
=======
        String season = InputAnalyzer.getSeasonInput(playerName);
        int gamesPlayed = InputAnalyzer.getIntegerInput("Games Played >> ");
        int points = InputAnalyzer.getIntegerInput("Points >> ");
        int goals = InputAnalyzer.getIntegerInput("Goals >> ");
        int assists = InputAnalyzer.getIntegerInput("Assists >> ");
        int plusMinus = InputAnalyzer.getIntegerInput("Plus-Minus >> ");
        players.addSkaterSeason(playerName, season, gamesPlayed, points, goals, assists, plusMinus);
>>>>>>> 6814e25f9da3ed0ca82d45bef8836113876b42a0
    }

    /**
     * Adds one or more historical seasons' stats for a player supplied as input.
     */
    protected void addGoalieSeason(String playerName) {
<<<<<<< HEAD
        String season = NHLInputReader.getSeasonInput(playerName);
        int wins = InputReader.getIntegerInput(" * Wins >> ");
        int loses = InputReader.getIntegerInput(" * Loses >> ");
        int overtimeLoses = InputReader.getIntegerInput(" * Overtime Loses >> ");
        double savePercentage = InputReader.getDoubleInput(" * Save Percentage >> ");
        double goalsAgainstAverage = InputReader.getDoubleInput(" * Goals Against Average >> ");
        players.addGoalieSeason(playerName, season, wins, loses, overtimeLoses, savePercentage, goalsAgainstAverage);
=======
        String season = InputAnalyzer.getSeasonInput(playerName);
        int gamesPlayed = InputAnalyzer.getIntegerInput("Games Played >> ");
        int wins = InputAnalyzer.getIntegerInput("Wins >> ");
        int loses = InputAnalyzer.getIntegerInput("Loses >> ");
        int overtimeLoses = InputAnalyzer.getIntegerInput("Overtime Loses >> ");
        double savePercentage = InputAnalyzer.getDoubleInput("Save Percentage >> ");
        double goalsAgainstAverage = InputAnalyzer.getDoubleInput("Goals Against Average >> ");
        players.addGoalieSeason(playerName, season, gamesPlayed, wins, loses, overtimeLoses, savePercentage, goalsAgainstAverage);
>>>>>>> 6814e25f9da3ed0ca82d45bef8836113876b42a0
    }

    /**
     * Updates the jersey number for a player supplied as input.
     */
    protected void editPlayerNumber() {
<<<<<<< HEAD
        String playerName = InputReader.getLineInput(" * Enter Full Player Name >> ");
        if (players.checkPlayerExists(playerName)) {
            int number = InputReader.getIntegerInput(" * Enter New Number >> ");
            players.updateNumber(playerName, number);
        } else {
            System.out.println(" ! The Player Does not Exist !");
=======
        String playerName = InputAnalyzer.getLineInput("Enter Full Player Name >> ");
        if (players.checkPlayerExists(playerName)) {
            int number = InputAnalyzer.getIntegerInput("Enter New Number >> ");
            players.updateNumber(playerName, number);
        } else {
            System.out.println("The Player Does not Exist");
>>>>>>> 6814e25f9da3ed0ca82d45bef8836113876b42a0
        }
    }

    /**
     * Updates the team for a player supplied as input.
     */
    protected void editPlayerTeam() {
<<<<<<< HEAD
        String playerName = InputReader.getLineInput(" * Enter Full Player Name >> ");
        if (players.checkPlayerExists(playerName)) {
            String team = InputReader.getLineInput(" * Enter New Team >> ");
            players.updateTeam(playerName, team);
        } else {
            System.out.println(" ! The Player Does not Exist !");
=======
        String playerName = InputAnalyzer.getLineInput("Enter Full Player Name >> ");
        if (players.checkPlayerExists(playerName)) {
            String team = InputAnalyzer.getLineInput("Enter New Team >> ");
            players.updateTeam(playerName, team);
        } else {
            System.out.println("The Player Does not Exist");
>>>>>>> 6814e25f9da3ed0ca82d45bef8836113876b42a0
        }
    }
}