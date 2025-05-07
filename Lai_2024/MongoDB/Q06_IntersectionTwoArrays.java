package MongoDB;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Given two integer arrays nums1 and nums2, return an array of their intersection. Each element in the result must be unique and you may return the result in any order.
 * <p>
 * Example 1:
 * <p>
 * Input: nums1 = [1,2,2,1], nums2 = [2,2]
 * Output: [2]
 */
public class Q06_IntersectionTwoArrays {
    public int[] intersection(int[] nums1, int[] nums2) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i : nums1) {
            map.put(i, map.getOrDefault(i, 0) + 1);
        }

        List<Integer> res = new ArrayList<>();
        for (int j : nums2) {
            if (map.containsKey(j)) {
                map.remove(j);
                res.add(j);
            }
        }

        // convert the array list into int[]
        return res.stream().mapToInt(Integer::intValue).toArray();
    }
}
