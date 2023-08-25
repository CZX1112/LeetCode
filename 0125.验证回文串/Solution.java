class Solution {
    // 法一：用一个额外数组先存储处理后的字符串
    // public boolean isPalindrome(String s) {
    //     StringBuilder sb = new StringBuilder();
    //     int length = s.length();
    //     for (int i = 0; i < length; i++) {
    //         int ch = s.charAt(i);
    //         if (Character.isLetterOrDigit(ch)) {
    //             sb.append(ch);
    //         }
    //     }
    //     int newLength = sb.length();
    //     for (int i = 0; i < newLength / 2; i++) {
    //         if (sb.charAt(i) != sb.charAt(newLength - i - 1)) {
    //             return false;
    //         }
    //     }
    //     return true;
    // }

    // 法二：直接在原字符串基础上判断
    public boolean isPalindrome(String s) {
        int left = 0, right = s.length() - 1;
        while (left < right) {
            while (left < right && !Character.isLetterOrDigit(s.charAt(left))) {
                left++;
            }
            while (left < right && !Character.isLetterOrDigit(s.charAt(right))) {
                right--;
            }
            if (left < right) {
                if (Character.toLowerCase(s.charAt(left)) != Character.toLowerCase(s.charAt(right))) {
                    return false;
                }
                left++;
                right--;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        String str = "race a car";
        Boolean result = sol.isPalindrome(str);
        System.out.println("result = " + result);
    }
}