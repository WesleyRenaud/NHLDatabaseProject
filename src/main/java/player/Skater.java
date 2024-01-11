/**
 * A class used to represent a skater as a type of player.
 */

package player;

public class Skater extends Player {
    private static final long serialVersionUID = -8709147076463675210L;

    /**
     * Creates a new skater given their name, age and jersey number.
     * 
     * @param playerName    The skater's name.
     * @param playerAge     The skater's age.
     * @param playerNumber  The skater's jersey number.
     */
    public Skater(String playerName, int playerAge, int playerNumber) {
        super(playerName, playerAge, playerNumber);
    }
}