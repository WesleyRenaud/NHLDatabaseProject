/**
 * A class that bridges the UI of the database and actual database, managing how the
 * user adds and edits player data.
 */

package ui;


import input.InputReader;
import input.NHLInputReader;
import utilities.BufferGenerator;
import utilities.SeasonHandler;
import player.Players;


public class NHLPlayerEditor {
    private Players players;

    protected void setPlayers(Players newPlayers) {
        players = newPlayers;
    }

    /**
     * Adds a player to the database.
     */
    protected void addPlayer() {
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
                break;
        }
    }

    /**
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
        while (SeasonHandler.getFirstYear_AsInt(currentSeason) < 2024) {
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
        while (SeasonHandler.getFirstYear_AsInt(currentSeason) < 2024) {
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
        while (SeasonHandler.getFirstYear_AsInt(currentSeason) < 2024) {
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
        while (SeasonHandler.getFirstYear_AsInt(currentSeason) < 2024) {
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
    protected void editPlayerCurrentSeasonStats() {
        String playerName = InputReader.getLineInput(" * Enter Full Player Name >> ");
        if (players.checkPlayerExists(playerName)) {
            String season = "2023-2024";
            if (players.checkPlayerIsSkater(playerName)) {
                editSkaterSeasonStats(playerName, season);
            } else {
                editGoalieSeasonStats(playerName);
            }
            InputReader.readBuffer();
        } else {
            System.out.println(" ! The Player Does not Exist !");
        }
    }

    /**
     * Updates the current season stats for a player supplied as input.
     */
    protected void editPlayerPastSeasonStats() {
        String playerName = InputReader.getLineInput(" * Enter Full Player Name >> ");
        if (players.checkPlayerExists(playerName)) {
            String season = NHLInputReader.getSeasonInput(" * Enter the Season >> ");
            if (players.checkPlayerIsSkater(playerName)) {
                editSkaterSeasonStats(playerName, season);
            } else {
                editGoalieSeasonStats(playerName);
            }
            InputReader.readBuffer();
        } else {
            System.out.println(" ! The Player Does not Exist !");
        }
    }

    /**
     * Updates the current season stats for a skater supplied as a parameter.
     * 
     * @param playerName    The name of the player whose stats are being edited.
     * @param season        The season of which the stats are being edited.
     */
    protected void editSkaterSeasonStats(String playerName, String season) {
        int gamesPlayed = InputReader.getIntegerInput(" * Games Played >> ");
        int goals = InputReader.getIntegerInput(" * Goals >> ");
        int assists = InputReader.getIntegerInput(" * Assists >> ");
        int plusMinus = InputReader.getIntegerInput(" * Plus-Minus >> ");
        players.updateSkaterSeasonStats(playerName, season, gamesPlayed, goals, assists, plusMinus);
    }

    /**
     * Updates the current season stats for a goalie supplied as a parameter.
     */
    protected void editGoalieSeasonStats(String playerName) {
        int wins = InputReader.getIntegerInput(" * Wins >> ");
        int loses = InputReader.getIntegerInput(" * Loses >> ");
        int overtimeLoses = InputReader.getIntegerInput(" * Overtime Loses >> ");
        double savePercentage = InputReader.getDoubleInput(" * Save Percentage >> ");
        double goalsAgainstAverage = InputReader.getDoubleInput(" * Goals Against Average >> ");
        players.updateGoalieSeasonStats(playerName, wins, loses, overtimeLoses, savePercentage, goalsAgainstAverage);
    }

    /**
     * Adds a season's stats for a player.
     */
    protected void addPlayerSeason() {
        String playerName = InputReader.getLineInput(" * Enter Full Player Name >> ");
        String season = NHLInputReader.getSeasonInput(" * Enter Season >> ");
        if (players.checkPlayerExists(playerName)) {
            if (players.checkPlayerIsSkater(playerName)) {
                addSkaterSeason(playerName, season);
            }  else {
                addGoalieSeason(playerName, season);
            }
        } else {
            System.out.println(" ! The Player Does not Exist !");
        }
    }

    /**
     * Adds a season's stats for a skater supplied as input.
     * 
     * @param playerName    The name of the skater whose stats are being updated.
     * @param season        The season of which the stats are being added.
     */
    protected void addSkaterSeason(String playerName, String season) {
        int gamesPlayed = InputReader.getIntegerInput(" * Games Played >> ");
        int goals = InputReader.getIntegerInput(" * Goals >> ");
        int assists = InputReader.getIntegerInput(" * Assists >> ");
        int plusMinus = InputReader.getIntegerInput(" * Plus-Minus >> ");
        players.addSkaterSeason(playerName, season, gamesPlayed, goals, assists, plusMinus);
    }

    /**
     * Adds a season's stats for a goalie supplied as input.
     * 
     * @param playerName    The name of the goalie whose stats are being updated.
     * @param season        The season of which the stats are being added.
     */
    protected void addGoalieSeason(String playerName, String season) {
        int wins = InputReader.getIntegerInput(" * Wins >> ");
        int loses = InputReader.getIntegerInput(" * Loses >> ");
        int overtimeLoses = InputReader.getIntegerInput(" * Overtime Loses >> ");
        double savePercentage = InputReader.getDoubleInput(" * Save Percentage >> ");
        double goalsAgainstAverage = InputReader.getDoubleInput(" * Goals Against Average >> ");
        players.addGoalieSeason(playerName, season, wins, loses, overtimeLoses, savePercentage, goalsAgainstAverage);
    }

    /**
     * Updates the team of a player.
     */
    protected void editPlayerTeam() {
        String playerName = InputReader.getLineInput(" * Enter Full Player Name >> ");
        if (players.checkPlayerExists(playerName)) {
            String team = InputReader.getLineInput(" * Enter New Team >> ");
            players.updateTeam(playerName, team);
        } else {
            System.out.println(" ! The Player Does not Exist !");
        }
    }

    /**
     * Updates the jersey number of a player.
     */
    protected void editPlayerNumber() {
        String playerName = InputReader.getLineInput(" * Enter Full Player Name >> ");
        if (players.checkPlayerExists(playerName)) {
            int number = InputReader.getIntegerInput(" * Enter New Number >> ");
            players.updateNumber(playerName, number);
        } else {
            System.out.println(" ! The Player Does not Exist !");
        }
    }

    /**
     * Updates the name of a player.
     */
    protected void editPlayerName() {
        String currentName = InputReader.getLineInput(" * Enter Current Full Player Name >> ");
        if (players.checkPlayerExists(currentName)) {
            String newName = InputReader.getLineInput(" * Enter New Name >> ");
            players.updateName(currentName, newName);
        } else {
            System.out.println(" ! The Player Does not Exist !");
        }
    }

    /**
     * Updates the birthday of a player.
     */
    protected void editPlayerBirthday() {
        String playerName = InputReader.getLineInput(" * Enter Full Player Name >> ");
        if (players.checkPlayerExists(playerName)) {
            String birthday = NHLInputReader.getBirthdayInput(" * Enter New Birthday >> ");
            players.updateBirthday(playerName, birthday);
        } else {
            System.out.println(" ! The Player Does not Exist !");
        }
    }
}