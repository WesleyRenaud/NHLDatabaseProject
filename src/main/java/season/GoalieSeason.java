/**
 * A class used to hold the stats of a goalie for one season.
 */

package season;


public class GoalieSeason extends Season {
    private static final long serialVersionUID = -2958302393599929753L;
    private int wins;
    private int loses;
    private int overtimeLoses;
    private double savePercentage;
    private double goalsAgainstAverage;

    /**
     * Makes a goalie season with given stats.
     * 
     * @param playerYear                The year which the season occurred.
     * @param playerWins                The number of wins during the season.
     * @param playerLoses               The number of loses during the season.
     * @param playerOvertimeLoses       The number of overtime loses during the season.
     * @param playerSavePercentage      The save percentage during the season.
     * @param playerGoalsAgainstAverage The goals against average during the season.
     */
    public GoalieSeason(String year, int playerWins, int playerLoses, int playerOvertimeLoses, double playerSavePercentage, double playerGoalsAgainstAverage) {
        setYear(year);
        setGamesPlayed(playerWins + playerLoses + playerOvertimeLoses);
        wins = playerWins;
        loses = playerLoses;
        overtimeLoses = playerOvertimeLoses;
        savePercentage = playerSavePercentage;
        goalsAgainstAverage = playerGoalsAgainstAverage;
    }

    protected void setWins(int newWins) {
        wins = newWins;
    }

    protected void setLoses(int newLoses) {
        loses = newLoses;
    }

    protected void setOvertimeLoses(int newOvertimeLoses) {
        overtimeLoses = newOvertimeLoses;
    }

    protected void setSavePercentage(double newSavePercentage) {
        savePercentage = newSavePercentage;
    }

    protected void setGoalsAgainstAverage(double newGoalsAgainstAverage) {
        goalsAgainstAverage = newGoalsAgainstAverage;
    }


    public int getWins() {
        return wins;
    }

    public int getLoses() {
        return loses;
    }

    public int getOvertimeLoses() {
        return overtimeLoses;
    }

    public double getSavePercentage() {
        return savePercentage;
    }

    public double getGoalsAgainstAverage() {
        return goalsAgainstAverage;
    }

    
    /**
     * Creates a String generation of the goalie season.
     */
    @Override
    public String toString() {
        return "Wins: " + wins + "\t| Loses: " + loses + "\t| Overtime Loses: " + overtimeLoses + "\t Sv%: " + savePercentage + "\t| GAA: " + goalsAgainstAverage + "\n";
    }
}
