package com.company;
import java.util.ArrayList;
import java.util.LinkedList;

/**
 * Assumptions: There are no duplicates in the dictionary
 *              All of the words in the dictionary are capitalized
 * Created by marvindo on 9/15/17.
 */
public class SocialNetwork {

    // Fields/Variable
    private ArrayList<String> dictionary;

    public SocialNetwork(String filePath) {
        dictionary = new ReadDictionary(filePath).getDictionary();
    }


    public int findNetworkSize(String source) {
        //Removes input string itself from the dictionary to avoid loops
        ArrayList<String> dictionary_to_traverse = dictionary;
        dictionary_to_traverse.remove(dictionary_to_traverse.indexOf(source));

        // We include the additional 1 to the size to account for source.
        return 1 + recursiveFriendNetwork(source, dictionary_to_traverse);
    }


    /*
    Two strings cannot be direct friends if it is two or more direct length away from each other.
     */
    private int recursiveFriendNetwork(String source, ArrayList<String> dictionary_to_traverse) {
        int index = 0;
        LinkedList<String> isFriends = new LinkedList<String>();
        // Update index so it starts from length - 1 of source
        while (dictionary_to_traverse.get(index).length() < source.length() - 1) {
            index++;
        }
        while (dictionary_to_traverse.get(index).length() < source.length() + 2 &&
                index < dictionary_to_traverse.size()) {

            //If they are friends
            if( DetermineFriends.isFriends(source, dictionary_to_traverse.get(index)) ) {
                // add it to the isFriends list
                isFriends.add(dictionary_to_traverse.remove(index));

            }
            index++;
        }

        /*********************
        Tail recursive
         *********************/
        if (isFriends.isEmpty()) {
            return 0;
        }
        else {
            //Iterate through the isFriends to find their friends as well.
            int friend_network = isFriends.size();
            for (int i = 0; i < isFriends.size(); i++) {
                int friendPointer = recursiveFriendNetwork(isFriends.get(i), dictionary_to_traverse);

                friend_network += friendPointer;
            }
            return friend_network;
        }
    }



    // For Testing
    public static void main(String[] args) {
        SocialNetwork network = new SocialNetwork("example.txt");
        System.out.println(network.findNetworkSize("HI"));
    }

}
