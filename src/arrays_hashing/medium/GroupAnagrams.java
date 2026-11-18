package arrays_hashing.medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GroupAnagrams {

    public List<List<String>> groupAnagrams(String[] strs) {

        HashMap<String, List<String>> result = new HashMap<>();
        List<List<String>> resList = new ArrayList<>();

        for (int i = 0; i < strs.length; i++) {

            int[] countArr = new int[26];
            String s = strs[i];
            StringBuilder keyBuilder = new StringBuilder();

            /*
            * For each string in our array
            * build a map of how many times
            * each character occurs
            */

            for (int j = 0; j < s.length(); j++) {

                char c = s.charAt(j);
                countArr[c - 'a'] += 1; //type promotion

            }

            /*
            * We should use a string as our
            * key as every countArr is a brand-new
            * object, so containsKey(countArr)
            * is always false
            */

            for (int a : countArr) {
                keyBuilder.append(a);
                keyBuilder.append('#');
            }

            String key = keyBuilder.toString();

            if (!result.containsKey(key)) {
                List<String> stringList = new ArrayList<>();
                stringList.add(s);
                result.put(key, stringList);
            } else {
                List<String> stringList = result.get(key);
                stringList.add(s);
                result.put(key, stringList);
            }


        }

        for (Map.Entry<String, List<String>> x : result.entrySet()) {
            resList.add(x.getValue());
        }

        return resList;

    }


}
