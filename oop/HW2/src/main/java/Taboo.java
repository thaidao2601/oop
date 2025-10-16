
/*
 HW1 Taboo problem class.
 Taboo encapsulates some rules about what objects
 may not follow other objects.
 (See handout).
*/

import java.util.*;

public class Taboo<T> {
    private Map<T, Set<T>> rulesMap = new HashMap<>();

    /**
     * Constructs a new Taboo using the given rules (see handout.)
     *
     * @param rules rules for new Taboo
     */
    public Taboo(List<T> rules) {
        for (int i = 0; i < rules.size() - 1; i++) {
            T first = rules.get(i);
            T second = rules.get(i + 1);
            if (first == null || second == null) continue;
            Set<T> forbidden = rulesMap.computeIfAbsent(first, k -> new HashSet<>());
            forbidden.add(second);
        }
    }

    /**
     * Returns the set of elements which should not follow
     * the given element.
     *
     * @param elem
     * @return elements which should not follow the given element
     */
    public Set<T> noFollow(T elem) {
        return rulesMap.getOrDefault(elem, Collections.emptySet());
    }

    /**
     * Removes elements from the given list that
     * violate the rules (see handout).
     *
     * @param list collection to reduce
     */
    public void reduce(List<T> list) {
        if (list == null || list.size() < 2) return;
        int i = 0;
        while (i < list.size() - 1) {
            T current = list.get(i);
            T next = list.get(i + 1);
            Set<T> forbidden = noFollow(current);
            if (forbidden.contains(next)) {
                list.remove(i + 1);
            } else {
                i++;
            }
        }
    }
}
