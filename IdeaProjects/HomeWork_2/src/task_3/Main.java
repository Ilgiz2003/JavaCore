package task_3;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        LinkedHashMap<String, String> strings = new LinkedHashMap<>();
        strings.put("car", "ca6$$#_rtwheel");
        strings.put("cwhl", "cartwheel");
        strings.put("cwhee", "cartwheel");
        strings.put("cartwheel", "cartwheel");
        strings.put("cwheeel", "cartwheel");
        strings.put("lw", "cartwheel");
        strings.put("463", "jsin53jdk4k4fm5m63");
        strings.put("r", "cas_rtwheel");
        strings.put("tree", "cas_rtwheel");
        strings.put("c1r", "ca111s_rtwheel");
        strings.put("crd", "cas_rtwdecrdel");
        tests(strings);
    }

    public static boolean fuzzySearch(String s1, String s2) {
        int indexLetter = 0;
        int counterS1Letters = 0;
        for (int i = 0; i < s1.length(); i++) {
            for (int j = indexLetter; j < s2.length(); j++) {
                if (s1.charAt(i) == s2.charAt(j)) {
                    indexLetter = j + 1;
                    counterS1Letters++;
                    break;
                }
            }
        }
        return counterS1Letters == s1.length();
    }

    public static void tests(LinkedHashMap<String, String> strings) {
        boolean[] expectancy = {
                true,
                true,
                true,
                true,
                false,
                false,
                true,
                true,
                false,
                true,
                true
        };
        int i = 0;
        for (Map.Entry<String, String> new_Map : strings.entrySet()) {
            System.out.println("\"" + new_Map.getKey() + "\"" + " -> \"" + new_Map.getValue() + "\"" + " result:" + fuzzySearch(new_Map.getKey(), new_Map.getValue()));
            assert fuzzySearch(new_Map.getKey(), new_Map.getValue()) == expectancy[i];
            i++;
        }
    }
}
