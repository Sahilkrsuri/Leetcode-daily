import java.util.*;

class Solution {
    public int maximumSaleItems(int[][] items, int budget) {

        int n = items.length;

        int[] freq = new int[n + 1];

        for (int[] item : items) {
            freq[item[0]]++;
        }

        int[] count = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            for (int j = i; j <= n; j += i) {
                count[i] += freq[j];
            }
        }

        Arrays.sort(items, (a, b) -> Integer.compare(a[1], b[1]));

        int minPrice = items[0][1];

        long remainingBudget = budget;
        long freeEligible = 0;

        for (int[] item : items) {

            int factor = item[0];
            int price = item[1];

            if (price > 2L * minPrice) {
                break;
            }

            int freeCount = count[factor] - 1;

            long canBuy = remainingBudget / price;

            long buy = Math.min(freeCount, canBuy);

            freeEligible += buy;
            remainingBudget -= buy * price;

            if (buy < freeCount) {
                break;
            }
        }

        long purchased = remainingBudget / minPrice;

        return (int)(2 * freeEligible + purchased);
    }
}