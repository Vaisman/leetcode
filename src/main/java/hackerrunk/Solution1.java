package hackerrunk;
import org.junit.Test;
import java.io.*;
import java.util.regex.*;
import java.net.*;

import static org.junit.Assert.assertEquals;

public class Solution1 {

    public static String longestEvenWord(String sentence) {
        if (sentence == null || sentence.length() == 0) return "";
        String[] splitted = sentence.split(" ");
        int maxLength = 0;
        String maxLengthString = "00";
        for(String s : splitted) {
            if (s.length() % 2 !=0) continue;
            if (s.length() > maxLength) {
                maxLength = s.length();
                maxLengthString = s;
            }
        }
        return maxLengthString;
    }

    /*
     * Complete the function below.
     * https://en.wikipedia.org/w/api.php?action=parse&section=0&prop=text&format=json&page=[topic]
     */
    private static final String URL = "https://en.wikipedia.org/w/api.php?action=parse&section=0&prop=text&format=json&page=";
    private static String inputStreamToString(InputStream inputStream, String encoding) throws IOException {
        try(ByteArrayOutputStream result = new ByteArrayOutputStream()) {
            byte[] buffer = new byte[1024];
            int length;
            while ((length = inputStream.read(buffer)) != -1) {
                result.write(buffer, 0, length);
            }
            return result.toString(encoding);
        }
    }

    static int getTopicCount(String topic) {
        URL url = null;
        try {
            url = new URL(URL + topic);
            URLConnection con = url.openConnection();
            InputStream inputStream = con.getInputStream();
            String encoding = con.getContentEncoding();
            encoding = encoding == null ? "UTF-8" : encoding;
            String body = inputStreamToString(inputStream, encoding);
            return countOfOccurrences(body, topic);

        } catch (IOException e) {
            e.printStackTrace();
        }
        return 1;
    }

    private static int countOfOccurrences(String str, String subStr) {
        return (str.length() - str.replaceAll(Pattern.quote(subStr), "").length()) / subStr.length();
    }

    @Test
    public void testLongestEvenWord() {
        assertEquals(longestEvenWord("It is a pleasant day today"), "pleasant");
        assertEquals(longestEvenWord("hey"), "00");
    }

    @Test
    public void testGetTopicCount() {
        assertEquals(getTopicCount("pizza"), 133);
    }
}