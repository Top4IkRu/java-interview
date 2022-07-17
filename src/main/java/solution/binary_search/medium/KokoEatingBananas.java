package solution.binary_search.medium;

import java.util.Arrays;

/**
 * @see <a href="Koko Eating Bananas">Task 875</a>
 */
public class KokoEatingBananas {
    public int minEatingSpeed(int[] piles, int h) {
        Arrays.sort(piles);
        if (piles.length == h) return piles[piles.length - 1];
        int l = 1;
        int r = piles[piles.length - 1];
        while (l < r) {
            int m = (r + l) / 2;
            if (calcTime(piles, m) > h) {
                l = m + 1;
            } else {
                r = m;
            }
        }
        return l;
    }

    private int calcTime(int[] piles, int k) {
        int r = 0;
        for (int i : piles) {
            r += i / k;
            if (i % k > 0) r += 1;
        }
        return r;
    }
}
