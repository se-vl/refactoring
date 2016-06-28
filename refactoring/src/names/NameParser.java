package names;

public class NameParser
{
    public static final int ALLES_PALETTI = 0;
    public static final int MISSING_COMMA = 1;
    public static final int MULTIPLE_COMMAS = 2;

    public static int errorCode = ALLES_PALETTI;

    public static String[] parseName(String raw)
    {
        int firstComma = raw.indexOf(',');
        if (firstComma == -1)
        {
            errorCode = MISSING_COMMA;
            return null;
        }

        int lastComma = raw.lastIndexOf(',');
        if (lastComma != firstComma)
        {
            errorCode = MULTIPLE_COMMAS;
            return null;
        }

        String[] result = new String[2];
        result[0] = raw.substring(0, firstComma).trim();
        result[1] = raw.substring(firstComma + 1).trim();
        return result;
    }
}
