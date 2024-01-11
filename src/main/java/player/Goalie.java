/**
 * A class used to represent a goalie as a type of player.
 */

package player;

public class Goalie extends Player {
    private static final long serialVersionUID = -4933314623253875845L;
    
    /**
     * Creates a goalie given their name, age and jersey number.
     * 
     * @param playerName    The goalie's name.
     * @param playerAge     The goalie's age.
     * @param playerNumber  The goalie's jersey number.
     */
    public Goalie(String playerName, int playerAge, int playerNumber) {
        super(playerName, playerAge, playerNumber);
    }
}