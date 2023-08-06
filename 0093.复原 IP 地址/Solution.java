import java.util.List;
import java.util.ArrayList;

class Solution {
    public List<String> restoreIpAddresses(String s) {
        List<String> result = new ArrayList<>();
        // temp用于将原字符串截取分成四段
        List<String> temp = new ArrayList<>();
        int len = s.length();
        if (len <= 3 || len >= 13) {
            return result;
        }
        dfs(s, 0, result, temp);
        return result;
    }

    public void dfs(String s, int begin, List<String> result, List<String> temp) {
        // 满足要求：到字符串末尾 && 四个字符串
        if (begin == s.length() && temp.size() == 4) {
            StringBuilder sb = new StringBuilder();
            sb.append(temp.get(0));
            for (int i = 1; i < 4; i++) {
                sb.append(".").append(temp.get(i));
            }
            result.add(sb.toString());
        }
        // 未满足：四个字符串 && 未到达末尾
        if (begin < s.length() && temp.size() == 4) {
            return;
        }

        for (int len = 1; len <= 3; len++) {
            // 保证字符串未越界
            if (begin + len - 1 >= s.length()) {
                return;
            }
            // 剔除不合法的前导0
            if (len != 1 && s.charAt(begin) == '0') {
                return;
            }
            // 截取字符串
            String nowStr = s.substring(begin, begin + len);
            // 截取的字符串长度为3时，大小不能超过255
            if (len == 3 && Integer.parseInt(nowStr) > 255) {
                return;
            }
            temp.add(nowStr);
            dfs(s, begin + len, result, temp);
            temp.remove(temp.size() - 1);
        }
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        String str = "25525511135";
        List<String> result = sol.restoreIpAddresses(str);
        System.out.println(result);
    }
}