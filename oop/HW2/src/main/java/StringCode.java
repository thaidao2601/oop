import java.util.HashSet;
import java.util.Set;

// CS108 HW1 -- String static methods

public class StringCode {
    /**
     * Given a string, returns the length of the largest run.
     * A a run is a series of adajcent chars that are the same.
     *
     * @return max run length
     */
    public static int maxRun(String str) {
        int n = str.length();
        if (n == 0) {
            return 0;
        }
        int res = 0;
        int count = 1;
        for (int i = 1; i < n; ++i) {
            if (str.charAt(i) != str.charAt(i - 1)) {
                res = Math.max(res, count);
                count = 1;
            } else ++count;
        }
        res = Math.max(res, count);
        return res;
    }

    /**
     * Given a string, for each digit in the original string,
     * replaces the digit with that many occurrences of the character
     * following. So the string "a3tx2z" yields "attttxzzz".
     *
     * @return blown up string
     */
    public static String blowup(String str) {
        StringBuilder s = new StringBuilder();
        int n = str.length();
        for (int i = 0; i < n; ++i) {
            if (str.charAt(i) >= '0' && str.charAt(i) <= '9' && i < n - 1) {
                int count = str.charAt(i) - '0';
                for (int j = 0; j < count; ++j) {
                    s.append(str.charAt(i + 1));
                }
            } else if (str.charAt(i) < '0' || str.charAt(i) > '9') {
                s.append(str.charAt(i));
            }
        }
        return s.toString();
    }

    /**
     * Given 2 strings, consider all the substrings within them
     * of length len. Returns true if there are any such substrings
     * which appear in both strings.
     * Compute this in linear time using a HashSet. Len will be 1 or more.
     */
    public static boolean stringIntersect(String a, String b, int len) {
        HashSet<String> hashSet = new HashSet<>();
        for (int i = 0; i <= a.length() - len; ++i) {
            hashSet.add(a.substring(i, i + len));
        }
        for (int i = 0; i <= b.length() - len; ++i) {
            if(hashSet.contains(b.substring(i, i + len))) {
                return true;
            }
        }
        return false;
    }
}
