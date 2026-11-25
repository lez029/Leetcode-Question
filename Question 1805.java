/**
 * LeetCode 1805: Number of Different Integers in a String
 * Source: https://leetcode.com/problems/number-of-different-integers-in-a-string/
 *
 * Problem summary:
 * The input word mixes decimal digits with lowercase English letters. Treat
 * every letter as a separator, then count the distinct integer values formed
 * by the remaining consecutive digit groups. Ignore leading zeros when
 * comparing groups, so "1", "01", and "001" count as one value.
 *
 * Examples:
 * - "a123bc34d8ef34" -> 3 (123, 34, and 8).
 * - "leet1234code234" -> 2.
 * - "a1b01c001" -> 1.
 *
 * Limits: The word contains 1 to 1000 characters, all digits or lowercase
 * English letters.
 */

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
