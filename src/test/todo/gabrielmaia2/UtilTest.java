package test.todo.gabrielmaia2;

import static org.junit.Assert.assertEquals;

import main.todo.gabrielmaia2.*;

import org.junit.Test;

public class UtilTest {
    @Test
    public void testCheckTabSingleLine() {
        String original = "one line string";

        String res = Util.tabString(original);
        String expectedStr = "  one line string";

        assertEquals(expectedStr, res);
    }

    @Test
    public void testCheckTabMultiline() {
        String original = "multi line string\n";
        original += "line 2\n";
        original += "this is line 3\n";
        original += "line 4";

        String res = Util.tabString(original);
        String expectedStr = "  multi line string\n";
        expectedStr += "  line 2\n";
        expectedStr += "  this is line 3\n";
        expectedStr += "  line 4";

        assertEquals(expectedStr, res);
    }

    @Test
    public void testCheckMultipleTabsSingleLine() {
        String original = "one line string";

        String res = Util.tabString(original);
        res = Util.tabString(res);
        res = Util.tabString(res);
        String expectedStr = "      one line string";

        assertEquals(expectedStr, res);
    }

    @Test
    public void testCheckMultipleTabsMultiline() {
        String original = "this is line 3\n";
        original += "line 4";

        String res = Util.tabString(original);

        res = "line 2\n" + res;
        res = Util.tabString(res);

        res = "multi line string\n" + res;
        res = Util.tabString(res);

        String expectedStr = "  multi line string\n";
        expectedStr += "    line 2\n";
        expectedStr += "      this is line 3\n";
        expectedStr += "      line 4";

        assertEquals(expectedStr, res);
    }
}
