package A_14_DP_3_Practice_Class;

/*
这段代码做什么
求二维整数矩阵中“和最大”的子矩阵的和（最大子矩阵和）。
核心思路（行压缩 + 一维最大子数组）
外层固定上边界行 i，内层不断下移下边界行 j。
用一维数组 cur 记录从第 i 行到第 j 行的“逐列累加和”（行压缩）。
对 cur 执行 Kadane 算法（最大子数组和），得到在这些行之间最佳的列区间之和。
对所有 i、j 的结果取最大。
关键函数含义
largest(int[][] matrix): 双层循环枚举行对 (i, j)，每次更新 cur，并用 max(cur) 更新答案。
add(int[] cur, int[] add): 把第 j 行逐列累加到 cur（行压缩的实现）。
max(int[] cur): Kadane 算法，线性求一维数组 cur 的最大子数组和；temp 为当前子段和，若为负则从当前位置重启。
复杂度与注意
时间复杂度: O(R^2 * C)，空间: O(C)。
适用于含负数的矩阵（全负时会返回最大元素）。
代码假设矩阵非空且每行等长；若可能为空，需在开头加空值检查避免异常。
如果你需要同时返回子矩阵的坐标（上/下边界与左/右边界），我可以在保持算法不变的基础上补上索引记录。
 */
public class Q05_LargestSubmatrixSum {
    public int largest(int[][] matrix) {
        int row = matrix.length;
        int column = matrix[0].length;
        int result = Integer.MIN_VALUE;
        for (int i = 0; i < row; i++) {
            int[] cur = new int[column];
            for (int j = i; j < row; j++) {
                add(cur, matrix[j]);
                result = Math.max(result, max(cur));
            }
        }
        return result;
    }

    private void add(int[] cur, int[] add) {
        for (int i = 0; i < cur.length; i++) {
            cur[i] += add[i];
        }
    }

    private int max(int[] cur) {
        int result = cur[0];
        int temp = cur[0];
        for (int i = 1; i < cur.length; i++) {
            if (temp > 0) {
                temp = temp + cur[i];
            } else {
                temp = cur[i];
            }
            result = Math.max(result, temp);
        }
        return result;
    }
}
