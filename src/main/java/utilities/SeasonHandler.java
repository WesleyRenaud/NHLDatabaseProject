/**
 * A class used to analyze and manage seasons in the form of strings.
 */

package utilities;

import input.InputAnalyzer;

public class SeasonHandler {

    /**
     * Checks if a given string is of the form of a season.
     * 
     * @param season    The string to check if it is a season.
     * @return  True if it is of the form of a season, and false otherwise.
     */
    public static boolean isSeasonInput(String season) {
        season.trim();
        if (season.length()!=9) {
            return false;
        }
        String firstYear = season.substring(0, 4);
        String secondYear = season.substring(5, 9);
        if (InputAnalyzer.isIntegerInput(firstYear) && InputAnalyzer.isIntegerInput(secondYear) && season.contains("-")
            && Integer.parseInt(firstYear) == Integer.parseInt(secondYear) - 1 || InputAnalyzer.checkSpecificInput(season, "2021")) {
            return true;
        }
        return false;
    }

    /**
     * Gets the first year of a given season as an integer.
     * 
     * @param season    The given season.
     * @return  The first year of a season, if the string is a season, and -1 otherwise.
     */
    public static int getFirstYear_AsInt(String season) {
        if (isSeasonInput(season)) {
            return Integer.parseInt(season.substring(0, 4));
        }
        return -1;
    }

    /**
     * Gets the first year of a given season as a string.
     * 
     * @param season    The given season.
     * @return  The first year of a season, if the string is a season, and null otherwise.
     */
    public static String getFirstYear_AsString(String season) {
        if (isSeasonInput(season)) {
            return season.substring(0, 4);
        }
        return null;
    }

    /**
     * Gets the second year of a given season as an integer.
     * 
     * @param season    The given season.
     * @return  The second year of a season, if the string is a season, and -1 otherwise.
     */
    public static int getSecondYear_AsInt(String season) {
        if (isSeasonInput(season)) {
            return Integer.parseInt(season.substring(5, 9));
        }
        return -1;
    }

    /**
     * Gets the second year of a given season as a String.
     * 
     * @param season    The given season.
     * @return  The second year of a season, if the string is a season, and null otherwise.
     */
    public static String getSecondYear_AsString(String season) {
        if (isSeasonInput(season)) {
            return season.substring(5, 9);
        }
        return null;
    }

    /**
     * Gets a string showing the season following a season given as input.
     * 
     * @param season    The given season.
     * @return  The season directly after that season.
     */
    public static String nextSeason(String season) {
        if (isSeasonInput(season)) {
            if (InputAnalyzer.checkSpecificInput(season, "2003-2004")) {
                return "2005-2006";
            } if (InputAnalyzer.checkSpecificInput(season, "20192-2020")) {
                return "2021";
            } if (InputAnalyzer.checkSpecificInput(season, "2021")) {
                return "2021-2022";
            }
            int firstSeason = getFirstYear_AsInt(season) + 1;
            int secondSeason = getSecondYear_AsInt(season) + 1;
            return Integer.toString(firstSeason) + "-" + Integer.toString(secondSeason);
        }
        return null;
    }
}