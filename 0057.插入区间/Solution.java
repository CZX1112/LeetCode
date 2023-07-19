import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        int left = newInterval[0];
        int right = newInterval[1];
        boolean placed = false;
        List<int[]> ansList = new ArrayList<int[]>();
        for (int i = 0; i < intervals.length; i++) {
            // 当前块在插入区间的左侧且无交集
            if (intervals[i][1] < left) {
                ansList.add(intervals[i]);
            }
            // 当前块在插入区间的右侧且无交集
            else if (intervals[i][0] > right) {
                if (!placed) {
                    ansList.add(new int[]{left, right});
                    placed = true;
                }
                ansList.add(intervals[i]);
            }
            // 与插入区间有交集，计算它们的并集更新插入块左右边界
            else {
                left = Math.min(left, intervals[i][0]);
                right = Math.max(right, intervals[i][1]);
            }
        }
        // 插入块在最右侧
        if (!placed) {
            ansList.add(new int[]{left, right});
        }
        return ansList.toArray(new int[ansList.size()][]);
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        int[][] intervals = {{1, 3}, {6, 9}};
        int[] newInterval = {2, 5};

        int[][] mergedIntervals = solution.insert(intervals, newInterval);

        System.out.println("Merged Intervals:");
        for (int[] interval : mergedIntervals) {
            System.out.println(Arrays.toString(interval));
        }
    }
}