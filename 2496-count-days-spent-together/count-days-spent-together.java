class Solution {
public int countDaysTogether(String arriveAlice, String leaveAlice,String arriveBob, String leaveBob) {
    int[] month = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

    int aAriveMonth = Integer.parseInt(arriveAlice.substring(0, 2));
    int aAriveDay = Integer.parseInt(arriveAlice.substring(3, 5));
    int aLeaveMonth = Integer.parseInt(leaveAlice.substring(0, 2));
    int aLeaveDay = Integer.parseInt(leaveAlice.substring(3, 5));

    int bAriveMonth = Integer.parseInt(arriveBob.substring(0, 2));
    int bAriveDay = Integer.parseInt(arriveBob.substring(3, 5));
    int bLeaveMonth = Integer.parseInt(leaveBob.substring(0, 2));
    int bLeaveDay = Integer.parseInt(leaveBob.substring(3, 5));

    int startMonth, startDay;

    if (aAriveMonth > bAriveMonth ||
        (aAriveMonth == bAriveMonth && aAriveDay > bAriveDay)) {

        startMonth = aAriveMonth;
        startDay = aAriveDay;

    } else {
        startMonth = bAriveMonth;
        startDay = bAriveDay;
    }

    int endMonth, endDay;

    if (aLeaveMonth < bLeaveMonth ||
        (aLeaveMonth == bLeaveMonth && aLeaveDay < bLeaveDay)) {

        endMonth = aLeaveMonth;
        endDay = aLeaveDay;

    } else {
        endMonth = bLeaveMonth;
        endDay = bLeaveDay;
    }

    if (startMonth > endMonth ||
        (startMonth == endMonth && startDay > endDay)) {
        return 0;
    }

    int days = 0;

    for (int i = startMonth - 1; i < endMonth - 1; i++) {
        days += month[i];
    }
    days = days + (endDay - startDay + 1);

    return days;
}
}
