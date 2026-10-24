class Solution {

    public int countDaysTogether(String arriveAlice, String leaveAlice,
            String arriveBob, String leaveBob) {

        int[] month = { 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };

        int aStart = toDay(arriveAlice, month);
        int aEnd = toDay(leaveAlice, month);

        int bStart = toDay(arriveBob, month);
        int bEnd = toDay(leaveBob, month);

        int start = Math.max(aStart, bStart);
        int end = Math.min(aEnd, bEnd);

        return Math.max(0, end - start + 1);
    }

    private int toDay(String date, int[] month) {

        int m = Integer.parseInt(date.substring(0, 2));
        int d = Integer.parseInt(date.substring(3, 5));

        for (int i = 0; i < m - 1; i++) {
            d += month[i];
        }

        return d;
    }
}