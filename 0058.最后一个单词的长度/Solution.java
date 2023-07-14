class Solution {
    public int lengthOfLastWord(String s) {
        int end = s.length() - 1;
        // 先去除空格，找到最后一个单词的末尾
        while (end >= 0 && s.charAt(end) == ' ') {
            end--;
        }
        int start = end;
        // 找到最后一个单词的开始
        while (start >= 0 && s.charAt(start) != ' ') {
            start--;
        }
        return end - start;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        int result = sol.lengthOfLastWord("   fly me   to   the moon  ");
        System.out.println(result);
    }
}