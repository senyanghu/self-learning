package A_11_DP_1;

// M[1] = 1
// M[i] represents the max product that could be achieved by cutting i-meter long rope at least one time
// 左大段 右小段 思想
// 左大段 本质上是更小号的问题
// 右小段 不切
public class Q02_MaxProductOfCuttingRope {
    public int maxProduct(int length) {
        int[] M = new int[length + 1];

        M[1] = 0;
        M[2] = 1;

        for (int i = 3; i <= length; i++) {
            for (int j = 1; j < i; j++) {
                int temp = Math.max(j, M[j]) * (i - j);
                M[i] = Math.max(temp, M[i]);
            }
        }

        return M[length];
    }
}
