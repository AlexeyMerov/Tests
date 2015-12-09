package com.tests;


public class MoreByValuePalindromeSearcher {

    public static void main(String[] args) {

        int number = 256;

        System.out.println("Palindrome for the number: " + number + "\nis " + palindrome(number));
//        System.out.println("Palindrome for the number: " + number + "\nis " + palindrome2(number));
    }

    /**
     * Make palindrome through char array
     */
    private static int palindrome(int number) {
        int result;

        // Make an array of chars from a String which was received from incoming number
        char[] chars = String.valueOf(number).toCharArray();

        // Reverse first part of the array on the second
        for (int i = 0;  i <= chars.length/2; i++)
            chars[chars.length - 1 - i] = chars[i];

        // If number has middle digit increase it by 1
        if (chars.length % 2 != 0) {
            int middle = chars.length/2;
            chars[middle] = (char) (chars[middle] + 1);
        }

        // Get Integer from chars through String
        result = Integer.valueOf(String.valueOf(chars));

        return result;
    }

    /**
     * Make palindrome through StringBuilder
     */
    private static int palindrome2(int number) {
        int result;
        StringBuilder resultString = new StringBuilder();

        // Get a string from the number
        String str = String.valueOf(number);

        // Get first half of the number and put it into result String
        StringBuilder firstHalf = new StringBuilder(str.substring(0, str.length()/2));
        resultString.append(firstHalf);

        // If number has a middle digit, increase it by 1 and append it to the result String
        if (str.length() % 2 != 0) {
            int n = Character.getNumericValue(str.charAt(str.length() / 2)) + 1;
            resultString.append(n);
        }

        // Reverse first half of the number and append it to the result String
        resultString.append(firstHalf.reverse());

        // Get Integer from the result String
        result = Integer.valueOf(resultString.toString());

        return result;
    }

}
