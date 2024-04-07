/**
 * A class used for strings treated as birthdays in the form YYYY-MM-DD.
 */

package utilities;


import input.InputAnalyzer;


public class BirthdayHandler
{
    private static String currentDate = "2024-04-04";
    private static int draftYear = 2005;


    /**
     * Checks if a string follows the format of a birthday for an NHL player.
     * 
     * @param birthday  The string to check if it is a birthday.
     * @return  True if it matches the birthday format, and false otherwise.
     */
    public static boolean isValidBirthday( String birthday )
    {
        if (birthday.length() != 10) {
            return false;
        }
        String birthYear = birthday.substring( 0, 4 );
        String month = birthday.substring( 5, 7 );
        String day = birthday.substring( 8, 10 );
        if (isValidBirthYear( birthYear ) && isValidMonth( month ) && isValidDay( birthYear, month, day )) {
            return true;
        }
        return false;
    }

    /**
     * Checks if a string follows the format of a year representing a birthday of a 
     * current or previous NHL player.
     * 
     * @param birthYear The string to check if it is a year.
     * @return  True if it matches the birth year format, and false otherwise.
     */
    private static boolean isValidBirthYear( String birthYear )
    {
        if (birthYear.length() != 4) {
            return false;
        }
        if (InputAnalyzer.isIntegerInput( birthYear )) {
            int intBirthYear = Integer.parseInt( birthYear );
            if (intBirthYear <= draftYear && intBirthYear >= 1923) {
                return true;
            }
        }
        return false;

    }

    /**
     * Checks if a string follows the format of a month.
     * 
     * @param month  The string to check if it is a month.
     * @return  True if it matches the month format, and false otherwise.
     */
    private static boolean isValidMonth( String month )
    {
        if (month.length() != 2) {
            return false;
        }
        if (InputAnalyzer.isIntegerInput( month )) {
            int intMonth = Integer.parseInt( month );
            if (intMonth >= 1 && intMonth <= 12) {
                return true;
            }
        }
        return false;
    }

    /**
     * Checks if a string is a valid day during a given month and year.
     * 
     * @param year  The year of the day.
     * @param month The month of the day.
     * @param day   The day of consideration.
     * 
     * @return  True if it is a valid day, and false otherwise.
     */
    private static boolean isValidDay( String birthYear, String month, String day )
    {
        if (!isValidBirthYear( birthYear ) || !isValidMonth( month ) || !InputAnalyzer.isIntegerInput( day )) {
            return false;
        }
        int intBirthYear = Integer.parseInt( birthYear );
        int intMonth = Integer.parseInt( month );
        int intDay = Integer.parseInt( day );
        if (InputAnalyzer.checkSpecificInput( month, "02" )) {
            return considerLeapYear( intBirthYear, intDay );
        } else {
            if (intDay >= 1 && intDay <= getNumDaysInMonth( intBirthYear, intMonth )) {
                return true;
            }
        }
        return false;
    }

    /**
     * Checks if a day in February is valid in part by evaluating whether it is a leap year.
     * 
     * @param birthYear The year which the day occurred.
     * @param day       The day of consideration.
     * @return  True if the day is valid, and false otherwise.
     */
    private static boolean considerLeapYear( int birthYear, int day )
    {
        if (birthYear % 4 == 0) {
            if (day >= 1 && day <= 29) {
                return true;
            }
        } else {
            if (day >= 1 && day <= 28) {
                return true;
            }
        }
        return false;
    }

    /**
     * Gets the number of days in a given month based on that month plus the year.
     * 
     * @param year  The year of the month.
     * @param month The month of consideration.
     * @return  The number of days during the specific month.
     */
    private static int getNumDaysInMonth( int year, int month )
    {
        if (month == 2) {
            if (year % 4 == 0) {
                return 29;
            }
            return 28;
        } else if (month == 4 || month == 6 || month == 9 || month == 11) {
            return 30;
        }
        return 31;
    }

    /**
     * Gets the age of someone or something based on thier birthday plus the current
     * date.
     * 
     * @param birthday      The birthday of consideration.
     * @param currentDay    The current date used to calculate the age.
     * @return  The age based on the birthday and current date.
     */
    public static int getAge( String birthday )
    {
        int daysInBirthYear = 0;
        int daysInCurrentYear = 0;

        for (int i = 1; i <= getMonth( birthday ); i++) {
            daysInBirthYear += getNumDaysInMonth( getBirthYear( birthday), i );
        }
        for (int i = 1; i <= getMonth( currentDate ); i++) {
            daysInCurrentYear += getNumDaysInMonth( getBirthYear( currentDate), i );
        }

        if (daysInCurrentYear >= daysInBirthYear) {
            return getBirthYear( currentDate ) - getBirthYear( birthday );
        }
        return getBirthYear( currentDate ) - getBirthYear( birthday ) - 1;
    }

    /**
     * Parses the birth year from a birthday string of the form YYYY-MM-DD
     * 
     * @param birthday  The birthday string to parse from.
     * @return  The integer birth year parsed out of the birthday.
     */
    private static int getBirthYear( String birthday )
    {
        return Integer.parseInt( birthday.substring( 0, 4 ) );
    }

    /**
     * Parses the month from a birthday string of the form YYYY-MM-DD
     * 
     * @param birthday  The birthday string to parse from.
     * @return  The integer month parsed out of the birthday.
     */
    private static int getMonth( String birthday )
    {
        return Integer.parseInt( birthday.substring( 5, 7 ) );
    }
}
