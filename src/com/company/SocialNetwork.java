package com.company;
import java.util.ArrayList;
import java.util.LinkedList;

/**
 * Created by marvindo on 9/15/17.
 */
public class SocialNetwork {

    // Fields/Variable
    private ArrayList<String> dictionary;

    public SocialNetwork(String filePath) {
        dictionary = new ReadDictionary(filePath).getDictionary();
    }

    public int findNetworkSize(String source, ArrayList<String> dictionary_to_traverse) {
        //Removes input string itself from the dictionary to avoid loops
        dictionary_to_traverse.remove(dictionary_to_traverse.indexOf(source));
        List<String> = 

    }




    // For Testing
    public static void main(String[] args) {
        SocialNetwork network = new SocialNetwork("very_small_test_dictionary.txt");
        for (int i =0; i < network.dictionary.size(); i++) {
            System.out.println(network.dictionary.get(i));
        }
    }

}
