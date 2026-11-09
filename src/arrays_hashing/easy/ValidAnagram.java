package arrays_hashing.easy;

import java.util.Map;
import java.util.Objects;
import java.util.TreeMap;

public class ValidAnagram {

    public TreeMap<Character, Integer> mapBuild(TreeMap<Character, Integer> map, String s) {

        for (int i = 0; i < s.length(); i++) {

            char c = s.charAt(i);

            if (!map.containsKey(c)) {
                map.put(c, 1);
            } else {
                int x = map.get(c);
                x++;
                map.put(c, x);
            }

        }

        return map;

    }

    public boolean isAnagram(String s, String t) {

        TreeMap<Character, Integer> sMap = new TreeMap<>();
        TreeMap<Character, Integer> tMap = new TreeMap<>();

        sMap = mapBuild(sMap, s);
        tMap = mapBuild(tMap, t);


        return sMap.equals(tMap);

    }

}
