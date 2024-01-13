/**
 * A class that bridges the UI of the database and actual database, managing how the
 * user adds and edits player data.
 */

package ui;

import player.Players;
import utilities.BufferGenerator;
import utilities.InputAnalyzer;

public class NHLPlayerEditor {
    private Players players;

    protected void setPlayers(Players newPlayers) {
        players = newPlayers;
    }

    /**
     * Adds a player to the database.
     */
    protected void addPlayer() {
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
                break;
        }
    }

    /**
     * Updates the current season stats for a player supplied as input.
     */
    protected void editPlayerSeasonStats() {
        String playerName = InputAnalyzer.getLineInput("Enter Full Player Name >> ");
        if (players.checkPlayerExists(playerName)) {
            if (players.checkPlayerIsSkater(playerName)) {
                editSkaterSeasonStats(playerName);
            } else {
                editGoalieSeasonStats(playerName);
            }
        } else {
            System.out.println("The Player Does not Exist");
        }
    }

    /**
     * Updates the current season stats for a skater supplied as a parameter.
     */
    protected void editSkaterSeasonStats(String playerName) {
        int gamesPlayed = InputAnalyzer.getIntegerInput("Games Played >> ");
        int points = InputAnalyzer.getIntegerInput("Points >> ");
        int goals = InputAnalyzer.getIntegerInput("Goals >> ");
        int assists = InputAnalyzer.getIntegerInput("Assists >> ");
        int plusMinus = InputAnalyzer.getIntegerInput("Plus-Minus >> ");
        players.updateSkaterSeasonStats(playerName, gamesPlayed, points, goals, assists, plusMinus);
    }

    /**
     * Updates the current season stats for a goalie supplied as a parameter.
     */
    protected void editGoalieSeasonStats(String playerName) {
        int gamesPlayed = InputAnalyzer.getIntegerInput("Games Played >> ");
        int wins = InputAnalyzer.getIntegerInput("Wins >> ");
        int loses = InputAnalyzer.getIntegerInput("Loses >> ");
        int overtimeLoses = InputAnalyzer.getIntegerInput("Overtime Loses >> ");
        double savePercentage = InputAnalyzer.getDoubleInput("Save Percentage >> ");
        double goalsAgainstAverage = InputAnalyzer.getDoubleInput("Goals Against Average >> ");
        players.updateGoalieSeasonStats(playerName, gamesPlayed, wins, loses, overtimeLoses, savePercentage, goalsAgainstAverage);
    }

    /**
     * Adds one or more historical seasons' stats for a player supplied as input.
     */
    protected void addPlayerSeasons() {
        String playerName = InputAnalyzer.getLineInput("Enter Full Player Name >> ");
        if (players.checkPlayerExists(playerName)) {
            int num = InputAnalyzer.getIntegerInput("Enter Number of Seasons to Add >> ");
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
            System.out.println("The Player Does not Exist");
        }
    }

    /**
     * Adds one or more historical seasons' stats for a player supplied as input.
     */
    protected void addSkaterSeason(String playerName) {
        String season = InputAnalyzer.getSeasonInput(playerName);
        int gamesPlayed = InputAnalyzer.getIntegerInput("Games Played >> ");
        int points = InputAnalyzer.getIntegerInput("Points >> ");
        int goals = InputAnalyzer.getIntegerInput("Goals >> ");
        int assists = InputAnalyzer.getIntegerInput("Assists >> ");
        int plusMinus = InputAnalyzer.getIntegerInput("Plus-Minus >> ");
        players.addSkaterSeason(playerName, season, gamesPlayed, points, goals, assists, plusMinus);
    }

    /**
     * Adds one or more historical seasons' stats for a player supplied as input.
     */
    protected void addGoalieSeason(String playerName) {
        String season = InputAnalyzer.getSeasonInput(playerName);
        int gamesPlayed = InputAnalyzer.getIntegerInput("Games Played >> ");
        int wins = InputAnalyzer.getIntegerInput("Wins >> ");
        int loses = InputAnalyzer.getIntegerInput("Loses >> ");
        int overtimeLoses = InputAnalyzer.getIntegerInput("Overtime Loses >> ");
        double savePercentage = InputAnalyzer.getDoubleInput("Save Percentage >> ");
        double goalsAgainstAverage = InputAnalyzer.getDoubleInput("Goals Against Average >> ");
        players.addGoalieSeason(playerName, season, gamesPlayed, wins, loses, overtimeLoses, savePercentage, goalsAgainstAverage);
    }

    /**
     * Updates the jersey number for a player supplied as input.
     */
    protected void editPlayerNumber() {
        String playerName = InputAnalyzer.getLineInput("Enter Full Player Name >> ");
        if (players.checkPlayerExists(playerName)) {
            int number = InputAnalyzer.getIntegerInput("Enter New Number >> ");
            players.updateNumber(playerName, number);
        } else {
            System.out.println("The Player Does not Exist");
        }
    }

    /**
     * Updates the team for a player supplied as input.
     */
    protected void editPlayerTeam() {
        String playerName = InputAnalyzer.getLineInput("Enter Full Player Name >> ");
        if (players.checkPlayerExists(playerName)) {
            String team = InputAnalyzer.getLineInput("Enter New Team >> ");
            players.updateTeam(playerName, team);
        } else {
            System.out.println("The Player Does not Exist");
        }
    }
}