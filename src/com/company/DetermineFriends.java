package com.company;

/**
 * isFriends method determines whether two strings are friends.
 * Created by marvindo on 9/15/17.
 */
public class DetermineFriends {

    /**
     * Verifies the length of both strings and call isOneCharReplacement or isOneCharAddition to determine if friends
     * @param first         string to compare
     * @param second        string to compare to first
     * @return              if one char different in same length or one length apart, return true, else false
     */
    public static boolean isFriends(String first, String second) {
        // Check if it's the same string, and if empty string for first and second
        if (first.equals(second) || first.length() == 0 || second.length() == 0) {
            //System.out.println("It's the same word");
            return false;
        }
        // Same length, checks to see if it requires only one replacement
        if (first.length() == second.length()) {
            return isOneCharReplacement(first, second);
        }
        // second string has a greater length, determine if first string is one char away from second
        if (first.length() + 1 == second.length()) {
            return isOneCharAddition(first, second);
        }
        // first string has a greater length, determine if second string is one char away from first
        if (first.length() - 1 == second.length()) {
            return isOneCharAddition(second, first);
        }

        //System.out.println(first + " is not friends with" + " " + second);
        return false;
    }

    /**
     * Assuming two strings are of same length, iterates through both strings to find one char difference
     * @param first
     * @param second
     * @return if only one char difference, return true, else return false
     */
    private static boolean isOneCharReplacement(String first, String second) {
        boolean foundDifference = false;
        for (int i = 0; i < first.length(); i++) {
            if (first.charAt(i) != second.charAt(i)) {

                // Found another different char after previously finding one
                if (foundDifference) {
                    return false;
                }
                foundDifference = true;
            }
        }
        //System.out.println(first + " is friends with " + second);
        return true;
    }

    /**
     * determine if second string only requires one char addition to match with first
     * @param first          larger than second by length of 1
     * @param second
     * @return               return true if missing one char somewhere in the second string, else return false
     */
    private static boolean isOneCharAddition(String first, String second) {
        int firstIndex = 0;
        int secondIndex = 0;

        while (firstIndex < first.length() && secondIndex < second.length()) {
            // Found difference
            if (first.charAt(firstIndex) != second.charAt(secondIndex)) {
                // If already found difference before
                if (firstIndex != secondIndex) {
                    return false;
                }
                secondIndex++;
            } else {
                firstIndex++;
                secondIndex++;
            }
        }
        //System.out.println(first + " is friends with " + second);
        return true;
    }

    //To Test
     public static void main(String[] args) {
     System.out.println(isFriends("TEAST", "TEST"));
     }

}
