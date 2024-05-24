import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TestSwidNo2 {

    public static void main(String[] args) {
        String[] input1 = {"Abc", "bCd"};
        String[] input2 = {"Oke", "One"};
        String[] input3 = {"Pendanaan", "Terproteksi", "Untuk", "Dampak", "Berarti"};

        System.out.println(groupAndSortCharacters(input1));
        System.out.println(groupAndSortCharacters(input2));
        System.out.println(groupAndSortCharacters(input3));
    }


    public static String groupAndSortCharacters(String[] input) {
        Map<Character, Integer> charCountMap = new HashMap<>();
        for (String str : input) {
            for (char ch : str.toCharArray()) {
                charCountMap.put(ch, charCountMap.getOrDefault(ch, 0) + 1);
            }
        }
        final List<Map.Entry<Character, Integer>> charCountList = getEntries(charCountMap);
        StringBuilder result = new StringBuilder();
        for (Map.Entry<Character, Integer> entry : charCountList) {
            result.append(entry.getKey());
        }

        return result.toString();
    }

    private static List<Map.Entry<Character, Integer>> getEntries(Map<Character, Integer> charCountMap) {
        List<Map.Entry<Character, Integer>> charCountList = new ArrayList<>(charCountMap.entrySet());
        charCountList.sort((entry1, entry2) -> {
            int freqCompare = entry2.getValue().compareTo(entry1.getValue());
            if (freqCompare != 0) {
                return freqCompare;
            }
            if (Character.isUpperCase(entry1.getKey()) && Character.isLowerCase(entry2.getKey())) {
                return -1;
            }
            if (Character.isLowerCase(entry1.getKey()) && Character.isUpperCase(entry2.getKey())) {
                return 1;
            }
            return entry1.getKey().compareTo(entry2.getKey());
        });
        return charCountList;
    }

}
