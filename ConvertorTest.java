import org.example.Convertor;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ConvertorTest {

    @Test
    public void testForMidnightAndNoon() {
        assertEquals("midnight", Convertor.convertTimeToWords("00:00"));
        assertEquals("noon", Convertor.convertTimeToWords("12:00"));
    }

    @Test
    public void testForMultipleOfFiveMinutes() {
        assertEquals("quarter past twelve", Convertor.convertTimeToWords("12:15"));
        assertEquals("half past twelve", Convertor.convertTimeToWords("12:30"));
        assertEquals("quarter to one", Convertor.convertTimeToWords("12:45"));
    }

    @Test
    public void testNonMultipleTime() {
        assertEquals("twelve one", Convertor.convertTimeToWords("12:01"));
        assertEquals("twenty past twelve", Convertor.convertTimeToWords("12:20"));
        assertEquals("twenty to one", Convertor.convertTimeToWords("12:40"));
        assertEquals("twelve fifty-nine", Convertor.convertTimeToWords("12:59"));
    }
}
