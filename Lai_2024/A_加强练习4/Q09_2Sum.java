package A_加强练习4;

import java.util.HashMap;
import java.util.Map;

public class Q09_2Sum {
    public int[] twoSum(int[] nums, int target) {
        int result[] = new int[2];
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);
        }

        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(target - nums[i])) {
                result[0] = i;
                result[1] = map.get(target - nums[i]);
                if (result[0] != result[1]) {
                    break;
                }
            }
        }
        return result;
    }
}
