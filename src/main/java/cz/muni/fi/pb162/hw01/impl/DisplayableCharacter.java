package cz.muni.fi.pb162.hw01.impl;

import java.util.HashMap;
import java.util.Map;

public enum DisplayableCharacter {
    Empty, Number_0, Number_1, Number_2, Number_3, Number_4, Number_5, Number_6, Number_7, Number_8, Number_9, Error;

    private static Map<DisplayableCharacter, String[]> toLines = new HashMap<>();

    static {
        toLines.put(Empty, new String[]{"   ", "   ", "   "});
        toLines.put(Number_0, new String[]{" _ ", "| |", "|_|"});
        toLines.put(Number_1, new String[]{"   ", "  |", "  |"});
        toLines.put(Number_2, new String[]{" _ ", " _|", "|_ "});
        toLines.put(Number_3, new String[]{" _ ", " _|", " _|"});
        toLines.put(Number_4, new String[]{"   ", "|_|", "  |"});
        toLines.put(Number_5, new String[]{" _ ", "|_ ", " _|"});
        toLines.put(Number_6, new String[]{"   ", "|_ ", "|_|"});
        toLines.put(Number_7, new String[]{" _ ", "  |", "  |"});
        toLines.put(Number_8, new String[]{" _ ", "|_|", "|_|"});
        toLines.put(Number_9, new String[]{" _ ", "|_|", "  |"});
        toLines.put(Error, new String[]{" _ ", "|_ ", "|_ "});
    }

    private static HashMap<Character, DisplayableCharacter> charMap = new HashMap<>();
    static {
        charMap.put(' ', Empty);
        charMap.put('0', Number_0);
        charMap.put('1', Number_1);
        charMap.put('2', Number_2);
        charMap.put('3', Number_3);
        charMap.put('4', Number_4);
        charMap.put('5', Number_5);
        charMap.put('6', Number_6);
        charMap.put('7', Number_7);
        charMap.put('8', Number_8);
        charMap.put('9', Number_9);
    }


    /**
     * Get DisplayableCharacter representation of the input character
     *
     * @param character character to display
     * @return DisplayableCharacter representation of the character
     */
    public static DisplayableCharacter getChar(char character) {
        if (charMap.containsKey(character)) {
            return charMap.get(character);
        }
        return Error;
    }

    public String[] getLines(){
        return toLines.get(this);
    }
}
