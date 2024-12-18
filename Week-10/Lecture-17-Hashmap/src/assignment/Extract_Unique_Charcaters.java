package assignment;

import java.util.HashMap;

/*
Problem statement
Given a string S, you need to remove all the duplicates. That means, the output string should contain each character only once. The respective order of characters should remain same, as in the input string.

Detailed explanation ( Input/output format, Notes, Images )
Constraints :
0 <= Length of S <= 10^8
Time Limit: 1 sec
Sample Input 1 :
ababacd
Sample Output 1 :
abcd
Sample Input 2 :
abcde
Sample Output 2 :
abcde
 */
public class Extract_Unique_Charcaters {

    public static String uniqueChar(String str) {
        StringBuilder s = new StringBuilder();
        HashMap<Character, Boolean> hm = new HashMap<>();
        for (char c : str.toCharArray()) {
            if (hm.containsKey(c)) continue;
            s.append(c);
            hm.put(c, true);
        }


        return s.toString();
    }
}
