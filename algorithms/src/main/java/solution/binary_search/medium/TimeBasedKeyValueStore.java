package solution.binary_search.medium;

import java.util.*;

/**
 * @see <a href="https://leetcode.com/problems/time-based-key-value-store/">Task 981</a>
 */
public class TimeBasedKeyValueStore {

    /**
     * With binary search
     */
    public static class TimeMap {


        Map<String, List<Pair<String, Integer>>> map;

        public TimeMap() {
            map = new HashMap<>();
        }

        public void set(String key, String value, int timestamp) {
            if (!map.containsKey(key)) map.put(key, new ArrayList<>());
            map.get(key).add(new Pair<>(value, timestamp));
        }

        public String get(String key, int timestamp) {
            if (!map.containsKey(key)) return "";
            List<Pair<String, Integer>> list = map.get(key);
            return search(list, timestamp);
        }

        private String search(List<Pair<String, Integer>> list, int timestamp) {
            int start = 0;
            int end = list.size() - 1;
            while (start < end) {
                int mid = start + (end - start + 1) / 2;
                if (list.get(mid).second <= timestamp) {
                    start = mid;
                } else {
                    end = mid - 1;
                }
            }
            return list.get(start).second <= timestamp
                    ? list.get(start).first
                    : "";
        }
    }

    private static class Pair<F, S> {
        F first;
        S second;

        public Pair(F first, S second) {
            this.first = first;
            this.second = second;
        }
    }
}
