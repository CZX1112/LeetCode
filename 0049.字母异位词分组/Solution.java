import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
import java.util.Arrays;

class Solution {
    // 法一：排序
    // public List<List<String>> groupAnagrams(String[] strs) {
    //     Map<String, ArrayList<String>> map = new HashMap<>();
    //     for (int i = 0; i < strs.length; i++) {
    //         char[] chars = strs[i].toCharArray();
    //         Arrays.sort(chars);
    //         String key = String.valueOf(chars);
    //         if (!map.containsKey(key)) {
    //             map.put(key, new ArrayList<>());
    //         }
    //         map.get(key).add(strs[i]);
    //     }
    //     return new ArrayList<>(map.values());
    // }

    // 法二：计数
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, ArrayList<String>> map = new HashMap<>();
        for (int i = 0; i < strs.length; i++) {
            int[] counts = new int[26];
            for (int j = 0; j < strs[i].length(); j++) {
                counts[strs[i].charAt(j) - 'a']++;
            }
            // 将每个出现次数大于 0 的字母和出现次数按顺序拼接成字符串，作为哈希表的键
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < 26; j++) {
                if (counts[j] != 0) {
                    sb.append((char)('a' + j));
                    sb.append(counts[j]);
                }
            }
            String key = sb.toString();
            if (!map.containsKey(key)) {
                map.put(key, new ArrayList<>());
            }
            map.get(key).add(strs[i]);
        }
        return new ArrayList<>(map.values());
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        String[] strs = {"eat", "tea", "tan", "ate", "nat", "bat"};
        List<List<String>> result = solution.groupAnagrams(strs);
        System.out.println("输出:");
        for (List<String> group : result) {
            System.out.println(group);
        }
    }
}