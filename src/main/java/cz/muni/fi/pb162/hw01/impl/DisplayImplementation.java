package cz.muni.fi.pb162.hw01.impl;

import cz.muni.fi.pb162.hw01.impl.displays.Display;

public class DisplayImplementation implements Display {
    private int size;

    private DisplayableCharacter[] characters;

    /**
     * Constructor
     *
     * @param size display size
     */
    public DisplayImplementation(int size) {
        this.size = size;
        characters = new DisplayableCharacter[size];
        for (int i = 0; i < size; i++){
            characters[i] = DisplayableCharacter.Empty;
        }
    }

    @Override
    public void set(String text) {
        set(0, text);
    }

    @Override
    public void set(int pos, String text) {
        int start = Math.min(pos, size - 1);
        int end = Math.min(pos + text.length(), size);
        for (int i = start; i < end; i++){
            characters[i] = DisplayableCharacter.getChar(text.charAt(i - pos));
        }
        for (int i = pos + text.length(); i < size; i++){
            characters[i] = DisplayableCharacter.Empty;
        }
    }

    @Override
    public void clear() {
        for (int i = 0; i < size; i++){
            clear(i);
        }
    }

    @Override
    public void clear(int pos) {
        characters[pos] = DisplayableCharacter.Empty;
    }

    private boolean inRange(int pos) {
        return pos >= 0 && pos < size;
    }

    public DisplayableCharacter[] getCharacters() {
        return characters;
    }
}
