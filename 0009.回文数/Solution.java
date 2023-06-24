class Solution {
    // 法一：转为字符串判断
    // public boolean isPalindrome(int x) {
    // String str = Integer.toString(x);
    // for (int i = 0; i < str.length() / 2; i++)
    // if (str.charAt(i) != str.charAt(str.length() - i - 1))
    // return false;
    // return true;
    // }

    // 法二：数学方法
    public boolean isPalindrome(int x) {
        if (x < 0)
            return false;
        int cur = 0, num = x;
        while (num != 0) {
            cur *= 10;
            cur += num % 10;
            num /= 10;
        }
        return cur == x;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.isPalindrome(-1));
    }
}