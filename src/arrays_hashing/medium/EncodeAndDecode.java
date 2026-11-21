package arrays_hashing.medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class EncodeAndDecode {

    public String encode(List<String> strs) {

        String seperator = "漢";
        Map<Character, Character> encoder = new HashMap<>();
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < 256; i++) {

            int j;
            char a, b;

            if (i == 255) {
                j = 0;
            } else {
                j = i + 1;
            }

            a = (char) i;
            b = (char) j;

            encoder.put(a, b);

        }

        for (String s : strs) {
            for (int i = 0; i < s.length(); i++) {
                char c = encoder.get(s.charAt(i));
                sb.append(c);
            }
            sb.append(seperator);
        }

        return sb.toString();
    }

    public List<String> decode(String str) {

        List<String> lStr = new ArrayList<>();
        String seperator = "漢";
        Map<Character, Character> decoder = new HashMap<>();
        StringBuilder sb = new StringBuilder();
        int whileCounter = 0;

        for (int i = 0; i < 256; i++) {

            int val, key = i;
            char a, b;

            if (i == 0) {
                val = 255;
            } else {
                val = i - 1;
            }

            a = (char) key;
            b = (char) val;

            decoder.put(a, b);

        }


        while (whileCounter < str.length()) {

            if (!decoder.containsKey(str.charAt(whileCounter))) {
                lStr.add(sb.toString());
                sb = new StringBuilder();
            } else {
                char decoded = decoder.get(str.charAt(whileCounter));
                sb.append(decoded);
            }

            whileCounter++;

        }

        return lStr;
    }

}
