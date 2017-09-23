package com.company;
import java.util.ArrayList;

/**
 * SocialNetwork takes in a dictionary text file and finds the network size from the desired string
 * by calling findNetworkSize(String source);
 * Assumptions: There are no duplicates in the dictionary
 *              All of the words in the dictionary are capitalized
 * Created by marvindo on 9/15/17.
 */
public class SocialNetwork {

    // Fields/Variable
    private ArrayList<String> edited_dictionary;        // edited dictionary used in findNetworkSize
    private int tempCount;                              // counter during traversal

    /**
     * Constructor for SocialNetwork.
     * Sorts the desired dictionary in ascending string length order by calling ReadDictionary.
     * @param filePath
     */
    public SocialNetwork(String filePath) {
        edited_dictionary = new ReadDictionary(filePath).getDictionary();
    }


    /**
     * Traverses through the dictionary and finds friends of friends of source until there is no connection
     * @param string_source     the string that user wants to find the network size of
     * @return                  size of the string's network
     */
    public int findNetworkSize(String string_source) {

        Friend_Network source = new Friend_Network(string_source);
        edited_dictionary.remove(string_source);
        if (edited_dictionary.isEmpty()) return 1;

        this.tempCount = 1;

        traversal_add_network(source);

        return tempCount;
    }

    /**
     * Adds the appropriate list of friends to the source and traverses through the list of source's friends
     * @param source            Friend_Network source to traverse and edit its list of friends
     */
    private void traversal_add_network(Friend_Network source) {
        int index;
        //System.out.println("Currently traversing " + source.source);

        /*
        while (edited_dictionary.get(index).length() < source.getSourceLength() - 1 &&
                index < edited_dictionary.size()) {
            index++;
        }*/

        //Binary Search to get appropriate index
        index = firstIndexBinarySearch(source.getSourceLength());

        // Traverse from source's length - 1 to source' length + 1
        // A string can only be friends if it is at most one length apart
        while ( index < edited_dictionary.size() &&
                edited_dictionary.get(index).length() < (source.getSourceLength() + 2) ) {

            // Determine if two strings are friends
            if (DetermineFriends.isFriends(source.toString(), edited_dictionary.get(index)) ) {

                source.addFriend(edited_dictionary.get(index) );

            }
            index++;
        }
        // Removes list of friends from the temp dictionary
        remove_from_dictionary(source.friends_of_source);

        // Traversal
        if (source.isEmpty()) return;

        for (Friend_Network friend : source.friends_of_source) {
            this.tempCount++;
            traversal_add_network(friend);
        }

    }

    /**
     * Because we are using the Levenshtein distance, we only need to look at the strings
     * that are length - 1, length, and length + 1.
     * If binarySearch for length - 1 doesn't exist, calls for length, and so on.
     * @param length_value
     * @return                      If no strings that are Levenshtein distance apart, returns -1
     *                              else returns binarySearch(length_value) after shifting k values to the left.
     */
    private int firstIndexBinarySearch(int length_value) {
        int binaryIndex = dictionaryBinarySearch(length_value - 1, 0, edited_dictionary.size());

        // If strings that are length_value - 1 of length does not exist.
        if (binaryIndex == -1) {
            binaryIndex = dictionaryBinarySearch(length_value, 0, edited_dictionary.size());

            // If strings that are length_value of length does not exist.
            if (binaryIndex == -1) {
                binaryIndex = dictionaryBinarySearch(length_value+1, 0, edited_dictionary.size());
            }
        }

        // If no strings that are Levenshtein distance apart exists.
        if (binaryIndex == -1) {
            return edited_dictionary.size() - 1;
        }

        // Shifts index left by k value so that the resulting index represents
        // the first index that has the same length.
        while (binaryIndex != 0 &&
                edited_dictionary.get(binaryIndex).length() == edited_dictionary.get(binaryIndex - 1).length()) {
            binaryIndex--;
        }

        return binaryIndex;
    }

    /**
     * Binary search function
     * @param length_value          desired string length to find
     * @param left                  start index value
     * @param right                 end index value
     * @return                      Returns the index of a string that has the length of length_value
     */
    private int dictionaryBinarySearch(int length_value, int left, int right) {

        if (left > right) {
            return -1;                  // if no string with length_value exists, return -1
        }

        int middle = left + (right - left) / 2;
        if (edited_dictionary.get(middle).length() == length_value) {
            return middle;
        }
        else if (edited_dictionary.get(middle).length() > length_value) {
            return dictionaryBinarySearch(length_value, left, middle - 1);
        }
        else {
            return dictionaryBinarySearch(length_value, middle + 1, right);
        }

    }

    /**
     * To avoid error of adding the same friend multiple times, temporarily removes list of friends from dictionary.
     * @param network_of_friends    network of friends to remove from dictionary
     */
    private void remove_from_dictionary(ArrayList<Friend_Network> network_of_friends) {
        for(Friend_Network friend : network_of_friends) {
            edited_dictionary.remove(friend.toString());
        }
    }

    /**
     * Friend_Network inner class takes in a source (Friend) and acts as a parent
     * for friends that the source is connected with
     */
    class Friend_Network {

        // Variables/Fields
        private String source;                                      // String source
        private ArrayList<Friend_Network> friends_of_source;        // List of friends to the source

        /**
         * Initialize source to create a Friend's Network node
         * @param source
         */
        public Friend_Network(String source) {
            this.source = source;
            friends_of_source = new ArrayList<Friend_Network>();
        }

        /**
         * Initializes Friend_Network class for toAdd string and adds to list of friends of source
         * @param toAdd         string to add to the list of friends of source
         */
        public void addFriend(String toAdd) {
            //Instantiate new node for toAdd
            Friend_Network to_add = new Friend_Network(toAdd);
            friends_of_source.add(to_add);
        }

        /**
         * @return              returns boolean of list of friends
         */
        public boolean isEmpty() {
            return friends_of_source.isEmpty();
        }

        /**
         * Getter Method
         * @return              returns length of source string
         */
        public int getSourceLength() {
            return this.source.length();
        }

        /**
         * Override toString to return source string
         * @return              returns string of source
         */
        @Override
        public String toString() {
            return this.source;
        }

    }

    public static void main(String[] args) {
        SocialNetwork network = new SocialNetwork("example.txt");
        String find_network_of = "HI";
        System.out.println("The string, " + find_network_of + ", has a network size of: " +
                network.findNetworkSize(find_network_of));
    }

}
