package hashmapproject;

import java.util.*;

public class HashMapComparer extends MapComparer {
    
    /**
     * Select names of deleted Web pages.
     * @param m1 Today hashmap.
     * @param m2 Yesterday hashmap.
     * @return String array of names of deleted Web pages.
     */
    public String[] namesDeleted(Map<String, String> m1, Map<String, String> m2) {
        List<String> lst = new ArrayList<>();
        m2.entrySet().stream().filter((item) -> (!m1.containsKey(item.getKey()))).forEachOrdered((item) -> {
            lst.add(item.getKey());
        });
        String result[] = lst.toArray(new String[0]);
        return result;
    }
    
    /**
     * Select names of newly added Web pages.
     * @param m1 Today hashmap.
     * @param m2 Yesterday hashmap.
     * @return String array of names of added Web pages.
     */
    public String[] namesAdded(Map<String, String> m1, Map<String, String> m2) {
        List<String> lst = new ArrayList<>();
        m1.entrySet().stream().filter((item) -> (!m2.containsKey(item.getKey()))).forEachOrdered((item) -> {
            lst.add(item.getKey());
        });
        String result[] = lst.toArray(new String[0]);
        return result;
    }
    
    /**
     * Select names of modified Web pages.
     * @param m1 Today hashmap.
     * @param m2 Yesterday hashmap.
     * @return String array of names of modified Web pages.
     */
    public String[] namesModified(Map<String, String> m1, Map<String, String> m2) {
        List<String> lst = new ArrayList<>();
        m1.entrySet().stream().filter((item) -> (m2.containsKey(item.getKey()) && !m2.get(item.getKey()).equals(item.getValue()))).forEachOrdered((item) -> {
            lst.add(item.getKey());
        });
        String result[] = lst.toArray(new String[0]);
        return result;
    }
}
