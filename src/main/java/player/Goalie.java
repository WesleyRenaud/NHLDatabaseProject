/**
 * A class used to represent a goalie as a type of player.
 */

package player;


public class Goalie extends Player
{
    private static final long serialVersionUID = -4933314623253875845L;
    
    
    /**
     * Creates a new goalie given their name, birthday, handedness, retired status,
     * number, and team.
     * 
     * @param name          The goalie's name.
     * @param birthday      The goalie's birthday.
     * @param handedness    The goalie's handedness.
     * @param retired       The goalie's retired status.
     * @param number        The goalie's jersey number.
     * @param team          The goalie's team.
     */
    public Goalie( String name, String birthday, String handedness, boolean retired, int number, String team )
    {
        super( name, birthday, handedness, retired, number, team );
    }
}