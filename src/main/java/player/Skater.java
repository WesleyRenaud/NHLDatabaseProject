/**
 * A class used to represent a skater as a type of player.
 */

package player;

<<<<<<< HEAD

=======
>>>>>>> 6814e25f9da3ed0ca82d45bef8836113876b42a0
public class Skater extends Player {
    private static final long serialVersionUID = -8709147076463675210L;

    /**
<<<<<<< HEAD
     * Creates a new skater given their name, birthday, handedness, retired status,
     * number, and team.
     * 
     * @param name          The skater's name.
     * @param birthday      The skater's birthday.
     * @param handedness    The skater's handedness.
     * @param retired       The skater's retired status.
     * @param number        The skater's jersey number.
     * @param team          The skater's team.
     */
    public Skater(String name, String birthday, String handedness, boolean retired, int number, String team) {
        super(name, birthday, handedness, retired, number, team);
=======
     * Creates a new skater given their name, age and jersey number.
     * 
     * @param playerName    The skater's name.
     * @param playerAge     The skater's age.
     * @param playerNumber  The skater's jersey number.
     */
    public Skater(String playerName, int playerAge, int playerNumber) {
        super(playerName, playerAge, playerNumber);
>>>>>>> 6814e25f9da3ed0ca82d45bef8836113876b42a0
    }
}