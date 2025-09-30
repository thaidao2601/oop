import java.util.*;

public class Appearances {
    /**
     * Returns the number of elements that appear the same number
     * of times in both collections. Static method. (see handout).
     * @return number of same-appearance elements
     */
    public static <T> int sameCount(Collection<T> a, Collection<T> b) {
        List<T> listA = new ArrayList<>(a);
        List<T> listB = new ArrayList<>(b);

        int countSame = 0;

        for (int i = 0; i < listA.size(); i++) {
            T elem = listA.get(i);

            // kiểm tra đã duyệt phần tử này chưa
            boolean checked = false;
            for (int j = 0; j < i; j++) {
                if (listA.get(j).equals(elem)) {
                    checked = true;
                    break;
                }
            }
            if (checked) continue;

            // đếm trong listA
            int countA = 0;
            for (int j = 0; j < listA.size(); j++) {
                if (listA.get(j).equals(elem)) countA++;
            }

            // đếm trong listB
            int countB = 0;
            for (int j = 0; j < listB.size(); j++) {
                if (listB.get(j).equals(elem)) countB++;
            }

            // so sánh
            if (countA == countB && countA > 0) {
                countSame++;
            }
        }
        return countSame;
    }
}