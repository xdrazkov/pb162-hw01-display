package cz.muni.fi.pb162.hw01.impl.displays;


/**
 * Converts the contents of given display to {@link String}
 */
public interface DisplayStringifier {

    /**
     * Determines if given display can be stringified
     *
     * @param display display to check
     * @return true if this display can be stringified
     */
    boolean canStringify(Display display);

    /**
     * Stringify the contents of given display as lines
     *
     * @param display display to stringify
     * @return array of lines for given display or null if not possible
     */
    String[] asLines(Display display);

    /**
     * Stringify the contents of given display
     *
     * @param display display to stringify
     * @return stringified content of given display or null if not possible
     */
    // TODO: this method can have a default implementation
    // TODO: https://www.baeldung.com/java-static-default-methods
    default String asString(Display display) {
        if (!canStringify(display)) {
            return null;
        }
        return String.join(System.lineSeparator(), asLines(display));
    }
}
