class Solution {
    public String countAndSay(int n) {
        String str = "1";
        for (int i = 2; i <= n; i++) {
            StringBuilder sb = new StringBuilder();
            int start = 0;
            int currloc = 0;

            while (currloc < str.length()) {
                while (currloc < str.length() && str.charAt(currloc) == str.charAt(start)) {
                    currloc++;
                }
                sb.append(Integer.toString(currloc - start)).append(str.charAt(start));
                start = currloc;
            }
            str = sb.toString();
        }
        return str;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        String result = sol.countAndSay(5);
        System.out.println(result);
    }
}