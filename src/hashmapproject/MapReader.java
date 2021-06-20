package hashmapproject;

import java.util.HashMap;

public abstract class MapReader {
    private HashMap<String, String> yesterday;
    private HashMap<String, String> today;
    public abstract void parseFormat(String filepath) throws Exception;
    protected abstract HashMap<String, String> getHashMap(String name, Object param);
    /**
     * @return the yesterday hashmap
     */
    public HashMap<String, String> getYesterday() {
        return yesterday;
    }

    /**
     * @param yesterday the yesterday hashmap to set
     */
    protected void setYesterday(HashMap<String, String> yesterday) {
        this.yesterday = yesterday;
    }

    /**
     * @return the today hashmap
     */
    public HashMap<String, String> getToday() {
        return today;
    }

    /**
     * @param today the today hashmap to set
     */
    protected void setToday(HashMap<String, String> today) {
        this.today = today;
    }
}
