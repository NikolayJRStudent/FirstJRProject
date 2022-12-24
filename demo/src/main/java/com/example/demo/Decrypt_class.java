package com.example.demo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Decrypt_class {

    public static List decrypt_method(String encrypt_message) {

        char[] array_with_encrypt_symbols = encrypt_message.toCharArray();

        char[] array_with_future_decrypt_symbols = new char[array_with_encrypt_symbols.length];

        int [] array_count_for_decrypt_lower_char = new int[array_with_encrypt_symbols.length - 1];

        int[] count_for_decrypt_upper_char = new int[array_with_encrypt_symbols.length - 1];

        int count_for_while = 1;

        boolean bool_variable_for_count_vowels;

        Arrays.fill(array_count_for_decrypt_lower_char,1);

        List<String> list_with_possible_decrypted_data = new ArrayList<>();

        while (count_for_while < 26) {

            for (int j = 0; j < array_with_encrypt_symbols.length; j++) {
                if ( array_with_encrypt_symbols[j] == ' ' ||array_with_encrypt_symbols[j] == '.'|| array_with_encrypt_symbols[j] == ','||array_with_encrypt_symbols[j] == '?'|| array_with_encrypt_symbols[j] == '!') {

                    array_with_future_decrypt_symbols[j] = array_with_encrypt_symbols[j];

                    continue;

                }

                array_with_future_decrypt_symbols[j] = (char) ((byte) array_with_encrypt_symbols[j] - (byte) count_for_while);

                if ((byte)array_with_future_decrypt_symbols[j] < (byte)65 ) {

                    array_with_future_decrypt_symbols[j] = (char) ((byte) 91 - (byte) count_for_decrypt_upper_char[j]);

                    count_for_decrypt_upper_char[j]++;

                } else if ((byte)  array_with_future_decrypt_symbols[j] < (byte)97 && !Character.isUpperCase(array_with_future_decrypt_symbols[j])) {

                    array_with_future_decrypt_symbols[j] = (char) ((byte) 123 - (byte) array_count_for_decrypt_lower_char[j]);

                    array_count_for_decrypt_lower_char[j]= (array_count_for_decrypt_lower_char[j] +1);

                } else if (((byte) array_with_encrypt_symbols[j] - (byte) count_for_while)<91 &&
                        ((byte) array_with_encrypt_symbols[j] - (byte) count_for_while)>65 &&
                        !Character.isUpperCase(array_with_encrypt_symbols[j])) {

                    array_with_future_decrypt_symbols[j] = (char) ((byte) 123 - (byte) array_count_for_decrypt_lower_char[j]);

                    array_count_for_decrypt_lower_char[j]= (array_count_for_decrypt_lower_char[j] +1);

                }

            }

            if(array_with_future_decrypt_symbols.length<3){

                bool_variable_for_count_vowels =  Count_vowels.count_vowels_method(array_with_future_decrypt_symbols) >= 1;

            }else if(array_with_future_decrypt_symbols.length>3 && array_with_future_decrypt_symbols.length<8){

                bool_variable_for_count_vowels = Count_vowels.count_vowels_method(array_with_future_decrypt_symbols) >= 1;

            }else if(array_with_future_decrypt_symbols.length>8 && array_with_future_decrypt_symbols.length<15){

                bool_variable_for_count_vowels = Count_vowels.count_vowels_method(array_with_future_decrypt_symbols) >= 3;

            }else {

                bool_variable_for_count_vowels = Count_vowels.count_vowels_method(array_with_future_decrypt_symbols) >=6 ;

            }

            Count_vowels.count_vowels_method(array_with_future_decrypt_symbols);

            if ( bool_variable_for_count_vowels  ) {

                String add_in_list = new String(array_with_future_decrypt_symbols);

                list_with_possible_decrypted_data.add(add_in_list+'\n');

            }

            count_for_while++;

        }

        return list_with_possible_decrypted_data;
    }

}
