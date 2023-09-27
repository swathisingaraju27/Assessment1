import java.util.HashMap;
import java.util.Map;

public class RomanNumeralConverter {
    
    // Define a map to store the Roman numeral symbols and their corresponding values.
    private static final Map<Character, Integer> romanSymbols = new HashMap<>();
    
    static {
        romanSymbols.put('I', 1);
        romanSymbols.put('V', 5);
        romanSymbols.put('X', 10);
        romanSymbols.put('L', 50);
        romanSymbols.put('C', 100);
        romanSymbols.put('D', 500);
        romanSymbols.put('M', 1000);
    }
    
    // Method to convert an integer to a Roman numeral.
    public static String intToRoman(int num) {
        if (num <= 0 || num >= 3000) {
            throw new IllegalArgumentException("Input should be between 1 and 3999");
        }
        
        StringBuilder romanNumeral = new StringBuilder();
        
        // Define the Roman numeral symbols in descending order of value.
        char[] symbols = {'M', 'D', 'C', 'L', 'X', 'V', 'I'};
        int[] values = {1000, 500, 100, 50, 10, 5, 1};
        
        for (int i = 0; i < symbols.length; i++) {
            while (num >= values[i]) {
                romanNumeral.append(symbols[i]);
                num -= values[i];
            }
        }
        
        return romanNumeral.toString();
    }
    
    // Method to convert a Roman numeral to an integer.
    public static int romanToInt(String s) {
        int result = 0;
        int prevValue = 0;
        
        for (int i = s.length() - 1; i >= 0; i--) {
            char symbol = s.charAt(i);
            int value = romanSymbols.get(symbol);
            
            if (value < prevValue) {
                result -= value;
            } else {
                result += value;
            }
            
            prevValue = value;
        }
        
        return result;
    }
    
    public static void main(String[] args) {
        // Test cases
        int[] integers = {1, 4, 9, 49, 1987};
        String[] romanNumerals = {"I", "IV", "IX", "XLIX", "MCMLXXXVII"};
        
        System.out.println("Integer to Roman Numeral:");
        for (int num : integers) {
            System.out.println(num + " => " + intToRoman(num));
        }
        
        System.out.println("\nRoman Numeral to Integer:");
        for (String roman : romanNumerals) {
            System.out.println(roman + " => " + romanToInt(roman));
        }
    }
}
