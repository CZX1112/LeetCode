import java.util.List;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

class Solution {
    private Map<Character, String> phoneMap = new HashMap<Character, String>() {{
        put('2', "abc");
        put('3', "def");
        put('4', "ghi");
        put('5', "jkl");
        put('6', "mno");
        put('7', "pqrs");
        put('8', "tuv");
        put('9', "wxyz");
    }};

    public List<String> letterCombinations(String digits) {
        List<String> combinations = new ArrayList<String>();
        if (digits.length() == 0)
            return combinations;
        StringBuilder sb = new StringBuilder();
        backtrace(combinations, digits, 0, sb);
        return combinations;
    }

    public void backtrace(List<String> combinations, String digits, int index, StringBuilder combination) {
        if (index == digits.length())
            combinations.add(combination.toString());
        else {
            char digit = digits.charAt(index);
            String letters = phoneMap.get(digit);
            for (int i = 0; i < letters.length(); i++) {
                combination.append(letters.charAt(i));
                backtrace(combinations, digits, index + 1, combination);
                combination.deleteCharAt(index);
            }
            
        }
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        List<String> combinations = sol.letterCombinations("23456");
        for (int i = 0; i < combinations.size(); i++) {
            System.out.println(combinations.get(i));
        }
    }
}