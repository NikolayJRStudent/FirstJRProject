package com.example.demo;

public class Count_vowels {

    public static int count_vowels_method(char[] array_with_encrypt_symbols ){

        char[] all_vowels_chars = new char []{'A', 'E', 'I', 'O', 'U', 'Y'};

        int counter_vowels = 0;

        for (char ch : array_with_encrypt_symbols) {
            for (char ch2 : all_vowels_chars) {
                if (Character.toUpperCase(ch)  == ch2){
                    counter_vowels++;
                }
            }
        }

        return counter_vowels;

    }

}
