import java.util.*;

public class GroupAnagrams {

    public static List<List<String>> groupAnagrams(String[] str) {
        List<List<String>> result = new ArrayList<>();

        Map<String, List<String>> map = new HashMap<>();
        for (String s : str) {
            char[] chs = s.toCharArray();
            Arrays.sort(chs);
            String key = String.valueOf(chs);
            if (!map.containsKey(key)) {
                map.put(key, new ArrayList<>());
            }
            List<String> anagrams = map.get(key);
            anagrams.add(s);
            map.put(key, anagrams);
        }

        for (String key : map.keySet()) {
            List<String> anagrams = map.get(key);
            result.add(anagrams);
        }
        return result;
    }
}
