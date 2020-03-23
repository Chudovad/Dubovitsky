package com.training.nmusabirova.hw6;

import com.sun.org.apache.xml.internal.utils.res.XResources_zh_CN;

import java.util.*;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.atomic.AtomicInteger;

public class HandlerString {
    private String[] duplicates;
    private int[] numberDuplicates;
    Map<String, Integer> map;

    public String[] getDuplicates() {
        return duplicates;
    }

    public int[] getNumberDuplication() {
        return numberDuplicates;
    }

    public void handle(String string) {
        if (string != null && string != "") {
            String[] words = searchWords(string);
            ignoreCase(words);

            Map<String, Integer> map = countWords(words);
            duplicates = new String[map.size()];
            numberDuplicates = new int[map.size()];
            convertToArray();

            print();
        } else {
            System.out.println("Error! String can not be empty!");
        }
    }

    private String[] searchWords(String s) {
        String[] words = s.split("\\W+");
        return words;
    }

    private void ignoreCase(String[] array) {
        for (int i = 0; i < array.length; i++) {
            array[i] = array[i].toLowerCase();
        }
    }

    private Map<String, Integer> countWords(String[] array) {
        map = new TreeMap<String, Integer>();
        int count = 0;

        for (String s : array) {
            if (map.containsKey(s)) {
                count = map.get(s);
                map.put(s, count + 1);
            } else {
                map.put(s, 1);
            }
        }
        return map;
    }

    private void convertToArray() {
        int count = 0;
        for (String key : map.keySet()) {
            convertToStringArray(key, count);
            convertToIntArray(key, count);
            count++;
        }
    }

    private void convertToStringArray(String key, int counter) {
        duplicates[counter] = key;
    }

    private void convertToIntArray(String key, int counter) {
        numberDuplicates[counter] = map.get(key);
    }

    private void print() {
        String letter = duplicates[0].substring(0, 1).toUpperCase();
        System.out.println(letter + ": " + duplicates[0] + " " + numberDuplicates[0]);

        for (int i = 1; i < duplicates.length; i++) {
            if (duplicates[i - 1].substring(0, 1).equals(duplicates[i].substring(0, 1))) {
                System.out.println("   " + duplicates[i] + " " + numberDuplicates[i]);
            } else {
                letter = duplicates[i].substring(0, 1).toUpperCase();
                System.out.println(letter + ": " + duplicates[i] + " " + numberDuplicates[i]);
            }
        }
    }
}
