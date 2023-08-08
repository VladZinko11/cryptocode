package com.javarush.zinko.cryptography;

import static com.javarush.zinko.source.Alphabet.ALPHABET;
import static com.javarush.zinko.source.Alphabet.statistics;

public class Crypto {
    public static String encode(String input, int key) {
        String result = "";
        char[] inputChar = input.toLowerCase().toCharArray();
        int index = 0;
        for (int i = 0; i < inputChar.length; i++) {
            for (int j = 0; j < ALPHABET.length; j++) {
                if (inputChar[i] == ALPHABET[j]) {
                    index = j;
                }
            }
            result = result + ALPHABET[index + (key % ALPHABET.length)];
        }
        return result;
    }

    public static String decode(String input, int key) {
        String result = "";
        char[] inputChar = input.toLowerCase().toCharArray();
        int index = 0;
        for (int i = 0; i < inputChar.length; i++) {
            for (int j = 0; j < ALPHABET.length; j++) {
                if (inputChar[i] == ALPHABET[j]) {
                    index = j;
                }
            }
            result = result + ALPHABET[(index - (key % ALPHABET.length)) < 0 ? ALPHABET.length + index - (key % ALPHABET.length) : index - (key % ALPHABET.length)];
        }
        return result;
    }

    public static String bruteForce(String input) {
        double epsilon = 1;
        String result = "";
        String resultDecode = "";
        int key;
        char[] inputChar = input.toLowerCase().toCharArray();
        int index = 0;
        int countO = 0;
        int countE = 0;
        int countA = 0;
        int countI = 0;
        for (int k = 0; k < ALPHABET.length; k++) {
            key = k;
            countO = 0;
            countA = 0;
            countI = 0;
            countE = 0;
            for (int i = 0; i < inputChar.length; i++) {
                for (int j = 0; j < ALPHABET.length; j++) {
                    if (inputChar[i] == ALPHABET[j]) {
                        index = j;
                    }
                }
                char letter = ALPHABET[(index - (key % ALPHABET.length)) < 0 ? ALPHABET.length + index - (key % ALPHABET.length) : index - (key % ALPHABET.length)];
                if (letter == 'о')
                    countO++;
                if (letter == 'е')
                    countE++;
                if (letter == 'а')
                    countA++;
                if (letter == 'и')
                    countI++;

                resultDecode = resultDecode + letter;
            }
            double epsilon1 = Math.abs((countO / ALPHABET.length) - statistics.get('о')) + Math.abs((countA / ALPHABET.length) - statistics.get('а'))
                    + Math.abs((countE / ALPHABET.length) - statistics.get('е')) + Math.abs((countI / ALPHABET.length) - statistics.get('и'));
            if (epsilon1 < epsilon) {
                epsilon = epsilon1;
                result = resultDecode;
            }
        }
        return result;
    }
}
