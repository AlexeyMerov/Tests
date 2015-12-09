package com.tests;


import java.util.ArrayList;
import java.util.Collections;

public class CompoundWordSearcher {

    // Variable to find out the result
    private static boolean found = false;

    public static void main(String[] args) {
        String[] array = {"five", "fivetwo", "fourfive", "fourfivetwo", "one", "onefiveone", "two", "twofivefourone"};
        new CompoundWordSearcher(array);
    }

    // Get an array and finding word. If there is no word, outputs "No Word"
    public CompoundWordSearcher(String[] array) {
        // Make a list from array. it needs for find out a longest word
        ArrayList<String> list = new ArrayList<>();
        Collections.addAll(list, array);

        finding(list, array);

        if (!found) {
            System.out.println("There is no compound word in the array.");
        }
    }

    private void finding(ArrayList<String> list, String[] array) {

        // Finds a longest word in list
        String word = findLongest(list);

        if (word != null) {

            // Get each element from array and makes all possible combination with other elements
            // List needs to ignore the current item for concat with others
            for (int i = 0; i < array.length; i++) {
                ArrayList<Integer> arrOfNum = new ArrayList<>();
                arrOfNum.add(i);
                recurse(array, array[i], arrOfNum, word);
            }

            // If there are no combination, deletes current word and finds next longest
            if (!found) {
                list.remove(word);
                finding(list, array);
            }
        }
    }

    // Find longest word in the array
    private String findLongest(ArrayList<String> list) {

        int length = 1;
        String word = null;

        for (String element : list) {
            if (element.length() > length) {
                length = element.length();
                word = element;
            }
        }

        return word;
    }

    // Main method for makes all possible combinations of elements in the array
    private void recurse(String[] arr, String str, ArrayList<Integer> e, String word) {

        String temp;

        for (int i = 0; i < arr.length; i++) {

            // If the current element has already been, skip the current lap.
            // Needs to avoid concatenation element with string where it already has
            if (e.contains(i))
                continue;

            temp = str.concat(arr[i]);

            // If current combination of elements equals to longest word output the word and break the cycle
            if (temp.equals(word) && !found) {
                System.out.println("Longest compound word: \"" + word + "\", with " + word.length() + " letters");
                found = true;
                break;
            }

            // Add current number of element in the array to avoid him from concatenation
            // Send the data themselves for the following combinations
            // Remove last added number of elements in the array
            e.add(i);
            recurse(arr, temp, e, word);
            e.remove(e.size() - 1);
        }
    }

}
