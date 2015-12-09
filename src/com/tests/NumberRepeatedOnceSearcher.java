package com.tests;

import org.ho.yaml.Yaml;
import org.ho.yaml.YamlStream;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;


public class NumberRepeatedOnceSearcher {

    public static void main(String[] args) throws IOException {

        // Set a path to file
        String path = "C:\\testYaml.yml";
        generateArrayInFile(10, path);
        ArrayList<Integer> arrayOfNumbers = getArrayFromFile(path);
        System.out.println("Unrepeatable number in array: \n" + arrayOfNumbers + "\nis: " + findUnrepeatable(arrayOfNumbers));
    }

    // Generate a random array of numbers and write it to the file
    private static void generateArrayInFile(int size, String path) {
        ArrayList<Integer> result = new ArrayList<>();

        for (int i = 0; i < size; i++) {
            // Get a random number
            int randomNumber = (int) (Math.random() * size);

            // If the array already has this number, decrease the counter and start over
            if (result.contains(randomNumber)) {
                i--;
                continue;
            }
            // Add randomNumber to the array first time
            result.add(randomNumber);

            // Some logic to make an unrepeatable number
            if (i == size/2)
                continue;

            // Add randomNumber to the array second time
            result.add(randomNumber);
        }

        // Shuffle whole array. Not necessary
        Collections.shuffle(result);

        // Write the array to file in YAML format
        try {
            Yaml.dumpStream(result.iterator(), new File(path));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    // Get a stream from file, iterate it and add elements to the array
    private static ArrayList<Integer> getArrayFromFile(String path) {
        ArrayList<Integer> arrayOfNumbers = new ArrayList<>();

        try {
            YamlStream stream = Yaml.loadStream(new File(path));
            while (stream.hasNext())
                arrayOfNumbers.add((int) stream.next());
        } catch (FileNotFoundException | NullPointerException e) {
            e.printStackTrace();
        }

        return arrayOfNumbers;
    }

    // Find an unrepeatable number from array through XOR
    private static int findUnrepeatable(ArrayList<Integer> array) {
        int number = 0;

        for (int element : array) {
            number = number ^ element;
        }

        return number;
    }
}
