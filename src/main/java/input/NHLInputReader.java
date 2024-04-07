/*
 * A class used to analyze input as treated as different values concerning NHL data.
 */

package input;


import utilities.BirthdayHandler;
import utilities.SeasonHandler;


public class NHLInputReader 
{
    /**
     * Returns input from a given prompt in the form of a season (Y1Y1-Y2Y2).
     * 
     * @param prompt    The string that prompts the user for input.
     * @return  The season given as input after the prompt.
     */
    public static String getSeasonInput( String prompt )
    {
        String season = InputReader.getStringInput( prompt );
        while (!SeasonHandler.isSeasonInput( season )) 
        {
            System.out.println( "Error - Input Must be a Season (Y1Y1-Y2Y2)" );
            season = InputReader.getStringInput( prompt );      
        }
        return season;
    }

    /**
     * Returns input from a given prompt in the form of an NHL birthday (YYYY-MM-DD).
     * 
     * @param prompt    The string that prompts the user for input.
     * @return  The birthday given as input after the prompt.
     */
    public static String getBirthdayInput( String prompt )
    {
        String birthday = InputReader.getStringInput( prompt );
        while (!BirthdayHandler.isValidBirthday( birthday )) 
        {
            System.out.println( "Error - Input Must be a Birthday (YYYY-MM-DD)" );
            birthday = InputReader.getStringInput( prompt );      
        }
        return birthday;
    }

    /**
     * Returns input from a given prompt in the form of a handedness (left or right).
     * 
     * @param prompt    The string that prompts the user for input.
     * @return  The handedness given as input after the prompt; either 'Left', 'left', 'Right', or
                'right'.
     */
    public static String getHandednessInput( String prompt )
    {
        String handedness = InputReader.getStringInput( prompt );
        while (!InputAnalyzer.checkSpecificInput( handedness, "Right" ) && !InputAnalyzer.checkSpecificInput( handedness, "right" )
            && !InputAnalyzer.checkSpecificInput( handedness, "Left" ) && !InputAnalyzer.checkSpecificInput( handedness, "left" ))
        {
            System.out.println( "Error - Input Must be a Handedness (Left or Right)" );
            handedness = InputReader.getStringInput( prompt );
        }
        return handedness;
    }
}