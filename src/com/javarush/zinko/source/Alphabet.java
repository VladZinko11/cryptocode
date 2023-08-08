package com.javarush.zinko.source;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Alphabet {
    public static final String alphabetRusStr = "абвгдеёжзийклмнопрстуфхцчшщыъьэюя.,\":!? ";
    public static final char[] ALPHABET = alphabetRusStr.toCharArray();

    public static final Map<Character, Double> statistics = new HashMap<>(); {
        statistics.put('о', 0.1098);
        statistics.put('е', 0.0848);
        statistics.put('а', 0.0800);
        statistics.put('и', 0.0737);
        }
}
