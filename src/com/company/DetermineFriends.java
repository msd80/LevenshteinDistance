package com.company;

/**
 * isFriends method determines whether two strings are friends.
 * Created by marvindo on 9/15/17.
 */
public class DetermineFriends {

    /**
     * Verifies the length of both strings and call isOneCharReplacement or isOneCharAddition
     * @param first
     * @param second
     * @return
     */
    public static boolean isFriends(String first, String second) {
        // Check if it's the same string
        if (first.equals(second)) {
            //System.out.println("It's the same word");
            return false;
        }
        // Same length, checks to see if it requires only one replacement
        if (first.length() == second.length()) {
            return isOneCharReplacement(first, second);
        }
        // One length apart, checks to see if adding a char will make it equal
        if (first.length() + 1 == second.length()) {
            return isOneCharAddition(first, second);
        }
        // One length apart, checks to see if adding a char will make it equal
        // Switched parameters
        if (first.length() - 1 == second.length()) {
            return isOneCharReplacement(second, first);
        }

        //System.out.println(first + " is not friends with" + " " + second);
        return false;
    }

    /**
     * Assuming two strings are of same length, iterates through both strings to find the difference
     * @param first
     * @param second
     * @return
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
     * @param first - larger than second by length of 1
     * @param second
     * @return
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
     System.out.println(isFriends("LISTY", "LITCHI"));
     System.out.println("\n");
     }

}
