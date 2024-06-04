package cz.muni.fi.pb162.hw01.impl.app;

import cz.muni.fi.pb162.hw01.cmd.Application;
import cz.muni.fi.pb162.hw01.impl.DisplayImplementation;
import cz.muni.fi.pb162.hw01.impl.SevenDisplayStringifier;


/**
 * Display application
 */
public class DisplayApp implements Application<DisplayAppOptions> {

    /**
     * Runtime logic of the application
     *
     * @param options
     * @return exit status code
     */
    public int run(DisplayAppOptions options) {
        DisplayImplementation display = new DisplayImplementation(options.getSize());
        SevenDisplayStringifier stringifier = new SevenDisplayStringifier();

        display.set(options.getText());
        System.out.println(stringifier.asString(display));
        return 0;
    }
}
