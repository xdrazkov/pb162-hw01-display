package cz.muni.fi.pb162.hw01.impl;

public class DisplayImplementation implements cz.muni.fi.pb162.hw01.impl.displays.Display {
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
        clear();
    }

    @Override
    public void set(String text) {
        set(0, text);
    }

    @Override
    public void set(int pos, String text) {
        for (int i = pos; i < text.length(); i++){
            if (!inRange(i)) {
                break;
            }
            characters[i] = DisplayableCharacter.getChar(text.charAt(i));
        }
    }

    @Override
    public void clear() {
        clear(0);
    }

    @Override
    public void clear(int pos) {
        for (int i = pos; i < size; i++){
            characters[i] = DisplayableCharacter.Empty;
        }
    }

    private boolean inRange(int pos) {
        return pos >= 0 && pos < size;
    }

    public DisplayableCharacter[] getCharacters() {
        return characters;
    }
}
