package cz.muni.fi.pb162.hw01.impl;

import cz.muni.fi.pb162.hw01.impl.displays.Display;
import cz.muni.fi.pb162.hw01.impl.displays.DisplayStringifier;
import org.assertj.core.api.SoftAssertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static java.util.stream.Collectors.joining;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

public class DisplayTest {

    private static final String EMPTY_LINE = " ".repeat(3);
    private static Factory factory;
    private static DisplayStringifier stringifier;


    @BeforeAll
    public static void beforeAll() {
        factory = new Factory();
        stringifier = factory.stringifier();
    }

    @Test
    public void shouldCreateEmptyDisplay() {
        var display = factory.display(1);

        assertSoftly(softly -> {
            assertDisplayLines(softly, display, EMPTY_LINE, EMPTY_LINE, EMPTY_LINE);
            assertDisplayString(softly, display, EMPTY_LINE, EMPTY_LINE, EMPTY_LINE);
        });
    }


    @Test
    public void shouldContainMultipleSymbols() {
        var display = factory.display(11);

        display.set("0123456789E");

        var expected = """
                 _     _  _     _     _  _  _  _\s
                | |  | _| _||_||_ |_   ||_||_||_\s
                |_|  ||_  _|  | _||_|  ||_|  ||_\s
                """;

        assertSoftly(softly -> {
            assertDisplayString(softly, display, expected);
            assertDisplayLines(softly, display, expected.split(System.lineSeparator()));
        });
    }

    @Test
    public void shouldHandleLongerInput() {
        var display = factory.display(4);

        display.set("0123456789E");

        var expected = """
                 _     _  _\s    
                | |  | _| _|
                |_|  ||_  _|
                """;

        assertSoftly(softly -> {
            assertDisplayString(softly, display, expected);
            assertDisplayLines(softly, display, expected.split(System.lineSeparator()));
        });
    }

    @Test
    public void shouldHandleUnknownSymbol() {
        var display = factory.display(4);

        display.set("01k2");

        var expected = """ 
                 _     _  _\s
                | |  ||_  _|
                |_|  ||_ |_\s
                """;

        assertSoftly(softly -> {
            assertDisplayString(softly, display, expected);
            assertDisplayLines(softly, display, expected.split(System.lineSeparator()));
        });
    }

    @Test
    public void shouldHandleShorterInput() {
        var display = factory.display(6);

        display.set("8012");

        var expected = """
                 _  _     _      \s
                |_|| |  | _|     \s
                |_||_|  ||_      \s
                """;

        assertSoftly(softly -> {
            assertDisplayString(softly, display, expected);
            assertDisplayLines(softly, display, expected.split(System.lineSeparator()));
        });
    }

    @Test
    public void shouldHandleIndexedPlacement() {
        var display = factory.display(3);

        display.set(1,"E");

        var expected = """
                \s   _   \s    
                \s  |_   \s
                \s  |_   \s
                """;

        assertSoftly(softly -> {
            assertDisplayString(softly, display, expected);
            assertDisplayLines(softly, display, expected.split(System.lineSeparator()));
        });
    }

    @Test
    public void shouldKeepPrefixAndClearSuffixOnIndexedTextPlacement() {
        var display = factory.display(10);

        display.set("0123456789E");
        display.set(4,"3210");

        var expected = """
                 _     _  _  _  _     _      \s
                | |  | _| _| _| _|  || |     \s
                |_|  ||_  _| _||_   ||_|     \s
                """;

        assertSoftly(softly -> {
            assertDisplayString(softly, display, expected);
            assertDisplayLines(softly, display, expected.split(System.lineSeparator()));
        });
    }

    private void assertDisplayLines(SoftAssertions assertions, Display display, String... expected) {
        var actual = stringifier.asLines(display);

        assertions
                .assertThat(actual)
                .describedAs("String lines of display")
                .containsExactly(expected);
    }

    @Test
    public void shouldClearDisplay() {
        var display = factory.display(11);

        display.set("0123456789E");
        display.clear();

        var expectedLine = EMPTY_LINE.repeat(11);

        assertSoftly(softly -> {
            assertDisplayString(softly, display, expectedLine, expectedLine, expectedLine);
            assertDisplayLines(softly, display, expectedLine, expectedLine, expectedLine);
        });
    }

    @Test
    public void shouldClearSpecifiedPositions() {
        var display = factory.display(11);

        display.set("0123456789E");
        display.clear(3);
        display.clear(7);

        var expected = """
                 _     _        _        _  _  _\s
                | |  | _|   |_||_ |_    |_||_||_\s
                |_|  ||_      | _||_|   |_|  ||_\s
                """;

        assertSoftly(softly -> {
            assertDisplayString(softly, display, expected);
            assertDisplayLines(softly, display, expected.split(System.lineSeparator()));
        });
    }

    private void assertDisplayString(SoftAssertions assertions, Display display, String... lines) {
        var expected = Arrays.stream(lines).collect(joining(System.lineSeparator()));
        assertDisplayString(assertions, display, expected);
    }

    private void assertDisplayString(SoftAssertions assertions, Display display, String expected) {
        var actual = removeSuffixNewLine(stringifier.asString(display));
        var description = "String representation of" + (expected.isBlank() ? "empty" : "") + " display";

        assertions
                .assertThat(actual)
                .describedAs(description)
                .isEqualTo(removeSuffixNewLine(expected));
    }

    private static String removeSuffixNewLine(String string) {
        if (string.endsWith(System.lineSeparator())) {
            return string.substring(0, string.length() - 1);
        }
        return string;
    }
}
