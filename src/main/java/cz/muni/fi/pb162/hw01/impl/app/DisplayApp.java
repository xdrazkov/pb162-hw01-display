package cz.muni.fi.pb162.hw01.impl.app;

import cz.muni.fi.pb162.hw01.cmd.Application;
import cz.muni.fi.pb162.hw01.impl.DisplayImplementation;
import cz.muni.fi.pb162.hw01.impl.DisplayStringifier;


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
        DisplayStringifier stringifier = new DisplayStringifier();

        display.set(options.getText());
        String result = stringifier.asString(display);
        System.out.println(result);
        return 0;
    }
}
