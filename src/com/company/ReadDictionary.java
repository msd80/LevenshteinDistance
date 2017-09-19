package com.company;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

/**
 * Initializing a ReadDictionary reads the text file to put all String value
 * into an ArrayList in ascending String length.
 * Created by marvindo on 9/15/17.
 */
class ReadDictionary {

    private String path;
    private ArrayList<String> dictionary;

    // Constructor
    public ReadDictionary(String filePath) {
        path = filePath;
        dictionary = new ArrayList<String>();
        try {
            openFile();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        // Override String compare method to sort ArrayList
        Collections.sort(dictionary, (o1, o2) -> Integer.compare(o1.length(), o2.length()));
    }

    private void openFile() throws IOException {
        FileReader fileReader = new FileReader(path);
        BufferedReader textReader = new BufferedReader(fileReader);

        //iteration through text file
        String lineToRead;

        while ((lineToRead = textReader.readLine()) != null) {
            dictionary.add(lineToRead);
        }

    }

    /*
    Necessary getter/setter method
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
