import java.util.*;
import java.util.stream.Collectors;

public class RomanNumerals {
    public static Map<Character, Integer> numbers = new HashMap<Character, Integer>();
    static{
        numbers.put('M', 1000);
        numbers.put('D', 500);
        numbers.put('C', 100);
        numbers.put('L', 50);
        numbers.put('X', 10);
        numbers.put('V', 5);
        numbers.put('I', 1);
    }

    enum characters{
        M(1000), CM(900), D(500),CD(400),
        C(100), XC(90), L(50), XL(40),
        X(10), IX(9), V(5), IV(4), I(1);

        private int value;

        characters(int value){
            this.value = value;
        }

        public int getValue() {
            return value;
        }

        public static List<characters> getReverseSortedValues() {
            return Arrays.stream(values()).sorted(Comparator.comparing((characters e) -> e.value).reversed()).collect(Collectors.toList());
        }
    }
    public static int romanToArabic(String roman){
        if(!checkString(roman)) return -1;
        int arabic = 0;
        for(int i = roman.length()-1 ; i >= 0; i--){
            if(i > 0 && numbers.get(roman.charAt(i)) > numbers.get(roman.charAt(i-1))){
                arabic += (numbers.get(roman.charAt(i)) - numbers.get(roman.charAt(i-1)));
                i--;
            }else{
                arabic += numbers.get(roman.charAt(i));
            }
        }
        return arabic;
    }

    public static String arabicToRoman(int arabic){
        if (arabic < 1) return "Numero no valido";
        List<characters> arabicList = characters.getReverseSortedValues();
        StringBuilder roman = new StringBuilder();
        int i = 0;
        while (i < arabicList.size() && (arabic > 0)){
            characters current = arabicList.get(i);
            if(current.getValue() <= arabic){
                roman.append(current.name());
                arabic -= current.getValue();
            }else{
                i++;
            }
        }
        return roman.toString();
    }

    private static boolean checkString(String roman){
        for (int i = 0 ; i < roman.length(); i++){
            if(!checkNumber(roman.charAt(i))) return false;
        }
        return true;
    }

    private static boolean checkNumber(char num){
        return num == 'M' ||
                num == 'D' ||
                num == 'C' ||
                num == 'L' ||
                num == 'X' ||
                num == 'V' ||
                num == 'I';
    }


}
