import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * Given an array of meeting time intervals intervals where intervals[i] = [starti, endi], return the minimum number of conference rooms required.
 * Example 1:
 * Input: intervals = [[0,30],[5,10],[15,20]]
 * Output: 2
 *
 * Example 2:
 * Input: intervals = [[7,10],[2,4]]
 * Output: 1
 *
 * Constraints:
 * 1 <= intervals.length <= 104
 * 0 <= starti < endi <= 106
 */
public class MeetingRoomsII {
    public static int maxMeetingRooms(int[][] intervals) {
        if (intervals == null || intervals.length == 0) return 0;
        if (intervals.length == 1) return 1;
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a, b) -> a[1] - b[1]);
        int maxRooms = 0;
        for (int[] interval : intervals) {
            int curStartTime = interval[0];

            while (!minHeap.isEmpty() && minHeap.peek()[1] <= curStartTime) {
                minHeap.poll();
            }
            minHeap.offer(interval);
            maxRooms = Math.max(maxRooms, minHeap.size());
        }
        return maxRooms;
    }

    public static void main(String[] args) {
        int[][] intervals = {{0,30}, {5,10}, {15,20}};
        int maxRooms = maxMeetingRooms(intervals);
        System.out.println(maxRooms);
    }


}
