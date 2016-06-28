package names;

import static org.junit.Assert.*;

import org.junit.Test;

public class NameParserTest
{
    @Test
    public void maxMustermann()
    {
        String[] muma = NameParser.parseName("Mustermann, Max");
        assertEquals("Mustermann", muma[0]);
        assertEquals("Max", muma[1]);
    }

    @Test
    public void missingComma()
    {
        String[] muma = NameParser.parseName("Mustermann Max");
        assertNull(muma);
        assertEquals(NameParser.MISSING_COMMA, NameParser.errorCode);
    }

    @Test
    public void multipleCommas()
    {
        String[] muma = NameParser.parseName("Mustermann, Max, Moritz");
        assertNull(muma);
        assertEquals(NameParser.MULTIPLE_COMMAS, NameParser.errorCode);
    }
}
