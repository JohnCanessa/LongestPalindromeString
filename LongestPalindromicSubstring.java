import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


/**
 * 
 */
public class LongestPalindromicSubstring {


    /**
     * Auxiliary function.
     * Looks for palindromes starting at the specified range.
     * O(n)
     */
    static private int expandFromHere(String s, int left, int right) {

        // **** sanity check(s) ****
        if (s == null || left > right) return 0;

        // **** expand the palindrome range as far as possible ****
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--; right++;
        }     

        // **** length of palindrome ****
        return right - left - 1;
    }


    /**
     * Given a string s, return the longest palindromic substring in s.
     * Execution: O(n^2) and space: O(1)
     * 
     * 177 / 177 test cases passed.
     * Status: Accepted
     * Runtime: 24 ms
     * Memory Usage: 39 MB
     */
    static String longestPalindrome(String s) {
        
        // **** sanity check(s) ****
        if (s != null && s.length() <= 1) return s;

       // **** initialization ****
       int start    = 0;
       int end      = 0;

       int len      = 0;
       int len1     = 0;
       int len2     = 0;

        // **** traverse the string left to right - O(n) ****
        for (int i = 0; i < s.length(); i++) {

            // **** single character at center (odd number of characters in s) - O(n)****
            len1     = expandFromHere(s, i, i);

            // **** contiguous characters at center (even number of characters in s) - O(n) ****
            len2    = expandFromHere(s, i, i + 1);

            // **** select the max length for the palindrome ****
            len = Math.max(len1, len2);

            // **** update the start and end characters in the palindrome (if needed) ****
            if (len > end - start) {

                // **** update start and end indices in palindrome ****
                start   = i - (len - 1) / 2;
                end     = i + (len / 2);

                // ???? ????
                System.out.println("longestPalindrome <<< i: " + i + " palindrome ==>" + s.substring(start, end + 1) + "<==");
            }
        }
 
        // **** return the longest palindrome ****
        return s.substring(start, end + 1);
    }


    /**
     * Test scaffold.
     * @throws IOException
     */
    public static void main(String[] args) throws IOException {
        
        // **** open a buffered reader ****
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // **** read string ****
        String s = br.readLine().trim();

        // **** close the buffered reader ****
        br.close();

        // ???? ????
        System.out.println("main <<< s ==>" + s + "<==");

        // **** compute and display longest palindromic substring ****
        System.out.println("main <<< output ==>" + longestPalindrome(s) + "<==");
    }
}