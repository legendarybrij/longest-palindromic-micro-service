package com.brij.model;

//**Problem 1:**
//Given a string _s_, find the longest palindromic substring in _s_. You may assume that the maximum length of _s_ is 1000.
//
//**Solution?:**
//Write a Spring Boot micro-service that completes the following:
//
//1. Receives string input over an API
//2. Stores the longest palindrome in provided database
//3. Retrieves the stored palindrome over an API
//
//You should be able to run your micro-service locally and use an API client (such as PostMan) to test your results.


public class TestPalindrome {
   
    
    public static boolean isPalindrome(String word) {
        boolean isEven = word.length() % 2 == 0;
        return isPalindrome(word, isEven, isEven ? 0 : 1);
    }
    
    public static boolean isPalindrome(String word, boolean isEven, int offset) {
        int midpoint = word.length() / 2;
        if (offset > midpoint + (isEven ? -1 : 0) ) {
            return true;
        } 
        char xchar = word.charAt(midpoint - offset + (isEven ? -1 : 0));
        char ychar = word.charAt(midpoint + offset);
        if (xchar != ychar) {
            return false;
        }
        return isPalindrome(word, isEven, offset + 1);
    }
}
