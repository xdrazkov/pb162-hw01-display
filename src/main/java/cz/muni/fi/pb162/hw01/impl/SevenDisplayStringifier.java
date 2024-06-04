package cz.muni.fi.pb162.hw01.impl;

import cz.muni.fi.pb162.hw01.impl.displays.Display;
import cz.muni.fi.pb162.hw01.impl.displays.DisplayStringifier;

public class SevenDisplayStringifier implements DisplayStringifier {
    @Override
    public boolean canStringify(Display display) {
        return true;
    }

    @Override
    public String[] asLines(Display display) {
        if (!canStringify(display)){
            return null;
        }
        StringBuilder line1 = new StringBuilder();
        StringBuilder line2 = new StringBuilder();
        StringBuilder line3 = new StringBuilder();
        for (DisplayableCharacter character : display.getCharacters()){
            String[] lines = character.getLines();
            line1.append(lines[0]);
            line2.append(lines[1]);
            line3.append(lines[2]);
        }
        return new String[]{line1.toString(), line2.toString(), line3.toString()};
    }
}
