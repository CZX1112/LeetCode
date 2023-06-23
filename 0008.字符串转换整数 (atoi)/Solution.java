class Solution {
    public int myAtoi(String s) {
        int result = 0;
        //符号默认为正
        int sign = 1;
        int len = s.length(), loc = 0;
        while (loc < len && s.charAt(loc) == ' ')
            loc++;
        int start = loc;
        for (; loc < len; loc++) {
            char ch = s.charAt(loc);
            if (loc == start && ch == '+')
                sign = 1;
            else if (loc == start && ch == '-')
                sign = -1;
            else if (Character.isDigit(ch)) {
                int num = ch - '0';
                // 判断是否越界
                if (result > Integer.MAX_VALUE / 10 || (result == Integer.MAX_VALUE / 10 && num > Integer.MAX_VALUE % 10))
                    return Integer.MAX_VALUE;
                if (result < Integer.MIN_VALUE / 10 || (result == Integer.MIN_VALUE / 10 && -num < Integer.MIN_VALUE % 10))
                    return Integer.MIN_VALUE;
                result = result * 10 + sign * num;
            }
            else
                break;
        }
        return result;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        String teststr = "4193 with words";
        int result = sol.myAtoi(teststr);
        System.out.println("result = " + result);
    }
}