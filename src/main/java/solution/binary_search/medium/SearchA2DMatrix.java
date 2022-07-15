package solution.binary_search.medium;

/**
 * @see <a href="https://leetcode.com/problems/search-a-2d-matrix/">Task 74</a>
 */
public class SearchA2DMatrix {

    /**
     * 1. Сначала ищем строку [row] в которой может располагаться наш элемент
     * 2. Ищем элемент в строке бинарным поиском
     */
    public boolean searchMatrix(int[][] matrix, int target) {
        int rows = matrix.length - 1;
        int colums = matrix[0].length - 1;

        int l = 0;
        int r = rows;
        while (l < r) {
            int m = l + (r - l) / 2;
            if (matrix[m][0] == target) return true;

            if (matrix[m][0] > target) {
                if (m == 0) return false;
                r = m - 1;
            } else {
                if (m == rows || matrix[m + 1][0] > target) {
                    l = m;
                    break;
                }
                l = m + 1;
            }
        }

        int row = l;
        l = 0;
        r = colums;
        while (l <= r) {
            int m = l + (r - l) / 2;
            if (matrix[row][m] == target) return true;
            if (matrix[row][m] > target) {
                r = m - 1;
            } else {
                l = m + 1;
            }
        }
        return false;
    }
}
