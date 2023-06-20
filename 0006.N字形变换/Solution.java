import java.util.ArrayList;

class Solution {
    public String convert(String s, int numRows) {
        if (numRows < 2)
            return s;
        ArrayList<StringBuilder> myList = new ArrayList<StringBuilder>();
        for (int i = 0; i < numRows; i++)
            myList.add(new StringBuilder());
        int count = 0, flag = -1;
        for (int i = 0; i < s.length(); i++) {
            myList.get(count).append(s.charAt(i));
            if (count == 0 || count == numRows - 1)
                flag = -flag;
            count += flag;
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < numRows; i++) {
            String output = myList.get(i).toString();
            System.out.println(output);
            sb.append(myList.get(i));
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println("begin");
        String s = "123456789";
        int numRows = 3;
        Solution sol = new Solution();
        String res = sol.convert(s, numRows);
        System.out.println(res);
    }
}