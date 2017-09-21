package com.company;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

/**
 * Initializing a ReadDictionary reads the text file to put all String value
 * into an ArrayList in ascending string length.
 * Created by marvindo on 9/15/17.
 */
class ReadDictionary {

    // Variables/Field
    private String path;                        // dictionary text file string name
    private ArrayList<String> dictionary;       // Sorted dictionary as an ArrayList

    /**
     * Calls FileReader and BufferedReader to iterate through the textfile
     * Places the string values in an ArrayList in ascending string length order.
     * @param filePath                          text file to open
     */
    public ReadDictionary(String filePath) {
        path = filePath;
        dictionary = new ArrayList<String>();
        try {
            openFile();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

        Collections.sort(dictionary, (o1, o2) -> Integer.compare(o1.length(), o2.length()));
    }

    /**
     * openFile calls FileReader and BufferedReader and iterates through each line and adds to the dictionary
     * @throws IOException
     */
    private void openFile() throws IOException {
        FileReader fileReader = new FileReader(path);
        BufferedReader textReader = new BufferedReader(fileReader);

        //iteration through text file
        String lineToRead;

        while ((lineToRead = textReader.readLine()) != null) {
            dictionary.add(lineToRead);
        }

    }

    /**
     * Getter Method
     * @return          dictionary arraylist
     */
    public ArrayList<String> getDictionary() {
        return dictionary;
    }

    //Testing
    public static void main(String[] args) {
        ReadDictionary readSmallDictionary = new ReadDictionary("very_small_test_dictionary.txt");
        ArrayList<String> smallDictionary = readSmallDictionary.getDictionary();
        for (int i = 0; i < smallDictionary.size(); i++) {
            System.out.println(smallDictionary.get(i));
        }
    }
}
