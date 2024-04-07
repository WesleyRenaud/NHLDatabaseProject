/**
 * A class used to represent a skater as a type of player.
 */

package player;


public class Skater extends Player
{
    private static final long serialVersionUID = -8709147076463675210L;

    
    /**
     * Creates a new skater given their name, birthday, handedness, retired status, number,
     * and team.
     * 
     * @param name          The skater's name.
     * @param birthday      The skater's birthday.
     * @param handedness    The skater's handedness.
     * @param retired       The skater's retired status.
     * @param number        The skater's jersey number.
     * @param team          The skater's team.
     */
    public Skater( String name, String birthday, String handedness, boolean retired, int number, String team )
    {
        super( name, birthday, handedness, retired, number, team );
    }
}