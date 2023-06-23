class Solution {
    public int reverse(int x) {
        int res = 0;
        while (x != 0) {
            //取末尾数字
            int temp = x % 10;
            //判断是否大于最大32位整数
            if (res > Integer.MAX_VALUE / 10 || (res == Integer.MAX_VALUE / 10 && temp > 7))
                return 0;
            //判断是否小于最小32位整数
            if (res < Integer.MIN_VALUE / 10 || (res == Integer.MIN_VALUE / 10 && temp < -8))
                return 0;
            res = res * 10 + temp;
            x /= 10;
        }
        return res;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        int test = 123;
        int res = sol.reverse(test);
        System.out.println("res = " + res);
    }
}