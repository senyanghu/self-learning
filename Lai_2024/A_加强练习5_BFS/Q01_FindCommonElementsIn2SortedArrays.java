package A_加强练习5_BFS;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/*
Find common elements in two sorted arrays
 */
public class Q01_FindCommonElementsIn2SortedArrays {
    public List<Integer> common(int[] A, int[] B) {
        // 处理边界情况
        if (A == null || B == null || A.length == 0 || B.length == 0) {
            return new ArrayList<>();
        }

        List<Integer> result = new ArrayList<>();
        int i = 0;  // A的指针
        int j = 0;  // B的指针

        // 双指针遍历
        while (i < A.length && j < B.length) {

            // This if statement is needed when handling duplicated elements
            // 跳过A当中重复的元素
            if (i > 0 && A[i] == A[i - 1]) {
                i++;
                continue;
            }

            if (A[i] == B[j]) {
                // 找到公共元素
                result.add(A[i]);
                i++;
                j++;
            } else if (A[i] < B[j]) {
                // A中的当前元素较小，移动A的指针
                i++;
            } else {
                // B中的当前元素较小，移动B的指针
                j++;
            }
        }
        return result;
    }

    /*
如果采用hash 那么把更长的array转化成hashset 还是说更短的array?

非常好的问题！在使用哈希方法处理两个数组的公共元素问题时，我们应该将较短的数组转化为 HashSet。这里是原因和具体实现：

原因
空间效率：将较短的数组转为 HashSet 可以最小化额外空间使用。
时间效率：遍历较长的数组并在 HashSet 中查找，可以减少总的查找次数。
内存使用：如果数组长度差异很大，将较短数组转为 HashSet 可以显著减少内存使用。
     */
    public List<Integer> commonWithHash(int[] A, int[] B) {
        if (A == null || B == null || A.length == 0 || B.length == 0) {
            return new ArrayList<>();
        }

        // 确保 A 是较短的数组
        if (A.length > B.length) {
            return commonWithHash(B, A);
        }

        Set<Integer> set = new HashSet<>();
        List<Integer> result = new ArrayList<>();

        // 将较短的数组 A 转换为 HashSet
        for (int num : A) {
            set.add(num);
        }

        // 遍历较长的数组 B，检查是否在 set 中
        for (int num : B) {
            if (set.contains(num)) {
                result.add(num);
                set.remove(num);  // 避免重复添加
            }
        }

        return result;
    }
}
