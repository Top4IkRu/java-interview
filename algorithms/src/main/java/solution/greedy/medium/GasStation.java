package solution.greedy.medium;

/**
 * @see <a href="https://leetcode.com/problems/gas-station/">Task 134</a>
 */
public class GasStation {

    public int canCompleteCircuit(int[] gas, int[] cost) {
        int gasSum = 0, costSum = 0;

        for (int i = 0; i < gas.length; i++) {
            gasSum += gas[i];
            costSum += cost[i];
        }
        // если на сумма на заправках меньше суммы расхода, то нельзя посетить все станции
        if (gasSum < costSum) return -1;

        int result = 0, total = 0;
        for (int i = 0; i < gas.length; i++) {
            total += gas[i] - cost[i];
            if (total < 0) {
                total = 0;
                result = i + 1;
            }
        }
        return result;
    }
}
