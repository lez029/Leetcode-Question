import java.util.HashSet;
import java.util.Set;

class Solution {

    public int numDifferentIntegers(String word) {
        
        String[] str_numbers = word.replaceAll("\\D", " ").trim().split("\\s+");
        int count = 0;
        for (int i = 0; i < str_numbers.length; i++) {
            str_numbers[i] = str_numbers[i].replaceFirst("^0+(?!$)", "");
        }

        Set<String> seen = new HashSet<>();
        for (String str_num : str_numbers) {
            if (str_num.equals(""))
                break;
            if (seen.add(str_num))
                count++;
        }

        return count;
    }
}