package com.javarush.zinko.cryptography;

import static com.javarush.zinko.source.Alphabet.*;

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
            result = result + ALPHABET[(index + key) % ALPHABET.length];
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
            result = result + ALPHABET[(ALPHABET.length + index - key) % ALPHABET.length];
        }
        return result;
    }

    public static String bruteForce(String input) {
        String result = "";
        String resultDecode = "";
        double exp = 1;
        int key;
        char[] inputChar = input.toLowerCase().toCharArray();
        int index = 0;
        for (int k = 0; k < ALPHABET.length; k++) {
            key = k;
            double countO = 0;
            double countA = 0;
            double countE = 0;
            double countI = 0;
            double countN = 0;
            double countT = 0;
            double countSpace = 0;
            resultDecode = "";

            for (int i = 0; i < inputChar.length; i++) {
                for (int j = 0; j < ALPHABET.length; j++) {
                    if (inputChar[i] == ALPHABET[j]) {
                        index = j;
                    }
                }
                char letter = ALPHABET[(ALPHABET.length + index - key) % ALPHABET.length];
                if (letter == 'о') countO++;
                if (letter == 'а') countA++;
                if (letter == 'е') countE++;
                if (letter == 'и') countI++;
                if (letter == 'н') countN++;
                if (letter == 'т') countT++;
                if (letter == ' ') countSpace++;
                resultDecode = resultDecode + letter;
            }
            double exp1 = Math.abs(countO / inputChar.length - statisticsO) + Math.abs(countA / inputChar.length - statisticsA) +
                    Math.abs(countE / inputChar.length - statisticsE) + Math.abs(countI / inputChar.length - statisticsI) +
                    Math.abs(countN / inputChar.length - statisticsN) + Math.abs(countT / inputChar.length - statisticsT) +
                    Math.abs(countSpace/inputChar.length - statisticsSpase);
            if(exp1 < exp)
            {
                exp=exp1;
                result=resultDecode;
            }

        }
        return result;
    }
}
