class Solution {
    public String minWindow(String s, String t) {
        if (s == null || t == null || s.length() == 0 || t.length() == 0) {
            return "";
        }
        int[] need = new int[128];
        // 记录需要的字符个数
        for (int i = 0; i < t.length(); i++) {
            need[t.charAt(i)]++;
        }
        // l是当前左边界，r是当前右边界，size记录窗口大小，count是需求的字符个数，start是最小覆盖串开始的index
        int l = 0, r = 0, size = Integer.MAX_VALUE, count = t.length(), start = 0;
        // 遍历所有字符
        while (r < s.length()) {
            char c = s.charAt(r);
            // 需要字符c
            if (need[c] > 0) {
                count--;
            }
            // 把右边的字符加入窗口
            need[c]--;
            // 窗口中已经包含所有字符
            if (count == 0) {
                while (l < r && need[s.charAt(l)] < 0) {
                    // 释放左边移出窗口的元素
                    need[s.charAt(l)]++;
                    // 左侧指针右移
                    l++;
                }
                // 左侧指针右移结束后，与当前最小长度比较，看是否需要更新
                if (r - l + 1 < size) {
                    size = r - l + 1;
                    // 记录下最小值开始的位置，最后返回串是需要
                    start = l;
                }
                // 先将l位置的字符计数重新加1
                need[s.charAt(l)]++;
                // 重新维护左边界值和当前所需字符的值count
                l++;
                count++;
            }
            // 右移边界，开始下一个元素
            r++;
        }
        return size == Integer.MAX_VALUE ? "" : s.substring(start, start + size);
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        String s = "ADOBECODEBANC";
        String t = "ABC";
        String result = solution.minWindow(s, t);
        System.out.println("Input s: " + s);
        System.out.println("Input t: " + t);
        System.out.println("Output: " + result);
    }
}