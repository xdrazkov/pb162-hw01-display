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

    /**
     * Get DisplayableCharacter representation of the input character
     *
     * @param character character to display
     * @return DisplayableCharacter representation of the character
     */
    public static DisplayableCharacter getChar(char character) {
        switch (character) {
            case ' ':
                return Empty;
            case '0':
                return Number_0;
            case '1':
                return Number_1;
            case '2':
                return Number_2;
            case '3':
                return Number_3;
            case '4':
                return Number_4;
            case '5':
                return Number_5;
            case '6':
                return Number_6;
            case '7':
                return Number_7;
            case '8':
                return Number_8;
            case '9':
                return Number_9;
            default:
                return Error;
        }
    }

    public String[] getLines(){
        return toLines.get(this);
    }
}
