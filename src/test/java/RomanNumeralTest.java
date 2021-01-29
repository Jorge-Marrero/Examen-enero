import org.junit.Test;
import static org.junit.Assert.*;

public class RomanNumeralTest {

    @Test
    public void testArabicToRoman(){
        assertTrue(RomanNumerals.arabicToRoman((16)).equals("XVI"));
        assertTrue(RomanNumerals.arabicToRoman((4)).equals("IV"));
        assertTrue(RomanNumerals.arabicToRoman((1666)).equals("MDCLXVI"));
        assertTrue(RomanNumerals.arabicToRoman((1990)).equals("MCMXC"));
        assertTrue(RomanNumerals.arabicToRoman((-4562)).equals("Numero no valido"));
    }

    @Test
    public void testRomanToArabic(){
        assertTrue(RomanNumerals.romanToArabic("XVI") == 16);
        assertTrue(RomanNumerals.romanToArabic("IV") == 4);
        assertTrue(RomanNumerals.romanToArabic("MDCLXVI") == 1666);
        assertTrue(RomanNumerals.romanToArabic("MCMXC") == 1990);
        assertTrue(RomanNumerals.romanToArabic("Esto no es un numero") == -1);
        assertTrue(RomanNumerals.romanToArabic("MDCGXVI") == -1);
        assertTrue(RomanNumerals.romanToArabic("ZDCXVI") == -1);
        assertTrue(RomanNumerals.romanToArabic("MDCXVP") == -1);
    }
}
