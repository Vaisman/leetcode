import org.junit.Test;

import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertFalse;

public class Solution24 {

    boolean isFit(String s, String pattern) {
        if (s == null || s.isEmpty()) {
            if (pattern == null || pattern.isEmpty())
                return true;
        }

        // go by pattern and check s
        int sIndex = 0;
        StringBuilder stringNumber = new StringBuilder();

        for(char c : pattern.toCharArray()) {
            if (!Character.isDigit(c)) {

                // process number, if exists
                if (stringNumber.length() != 0) {
                    int num = Integer.parseInt(stringNumber.toString());
                    sIndex += num;
                    stringNumber = new StringBuilder();
                }

                // process current char
                if (sIndex >= s.length())
                    return false;

                if (s.charAt(sIndex) == c) {
                    sIndex++;
                    continue;
                }
                else {
                    return false;
                }
            }
            else {
                stringNumber.append(c);
            }
        }

        return true;
    }

    @Test
    public void test() {
        assertTrue(isFit("internationalization", "internationalization"));
        assertFalse(isFit("internationalization", "internationalizatiox"));
        assertFalse(isFit("internationalization", "internationalizatio-"));
        assertTrue(isFit("", ""));
        assertTrue(isFit("", null));
        assertTrue(isFit(null, null));
        assertTrue(isFit("internationalization", "i18n"));
        assertTrue(isFit("", "0"));
        assertTrue(isFit("", "000"));
        assertTrue(isFit(null, "0"));
        assertFalse(isFit("internationalization", "i19n"));
        assertTrue(isFit("internationalization", "6a6izati2"));
        assertTrue(isFit("internationalization", "20"));
        assertTrue(isFit("internationalization", "21"));
        assertTrue(isFit("internationalization", "internationalizatio0n"));
        assertTrue(isFit("internationalization", "000i000nternation000alizatio0n000"));
        assertTrue(isFit("internationalization", "00i18n00"));
        assertTrue(isFit("localization", "l10n"));
    }
}
