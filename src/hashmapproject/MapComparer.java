package hashmapproject;

import java.util.*;

public abstract class MapComparer {
    /**
     * Counts the number of new Web pages added.
     * @param m1 Today hashmap.
     * @param m2 Yesterday hashmap.
     * @return Number of new Web pages added.
     */
    public int countAdded(Map<String, String> m1, Map<String, String> m2) {
        int count = 0;
        count = m1.entrySet().stream().filter((item) -> (!m2.containsKey(item.getKey()))).map((_item) -> 1).reduce(count, Integer::sum);
        return count;
    }
    /**
     * Counts the number of deleted Web pages.
     * @param m1 Today hashmap.
     * @param m2 Yesterday hashmap.
     * @return Number of deleted Web pages.
     */
    public int countDeleted(Map<String, String> m1, Map<String, String> m2) {
        int count = 0;
        count = m2.entrySet().stream().filter((item) -> (!m1.containsKey(item.getKey()))).map((_item) -> 1).reduce(count, Integer::sum);
        return count;
    }
    /**
     * Counts the number of modified Web pages.
     * @param m1 Today hashmap.
     * @param m2 Yesterday hashmap.
     * @return Number of modified Web pages.
     */
    public int countChanged(Map<String, String> m1, Map<String, String> m2) {
        int count = 0;
        count = m1.entrySet().stream().filter((item) -> (m2.containsKey(item.getKey()) 
                && !item.getValue().equalsIgnoreCase(m2.get(item.getKey())))).map((_item) -> 1).reduce(count, Integer::sum);
        return count;
    }
}
