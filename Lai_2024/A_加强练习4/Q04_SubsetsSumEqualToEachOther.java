package A_加强练习4;

import java.util.ArrayList;
import java.util.List;

/*
Given an array of integers, how to divide the whole array into two parts, where their sums equal to each other.
 */
public class Q04_SubsetsSumEqualToEachOther {

    public List<List<Integer>> subsets_sum_equal_to_each_other(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> item = new ArrayList<>();

        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
        }
        int target = sum / 2;
        dfs(nums, target, 0, item, res);
        return res;
    }

    private void dfs(int[] nums, int target, int index, List<Integer> item, List<List<Integer>> res) {
        if (index == nums.length) {
            if (target == 0) {
                res.add(new ArrayList<>(item));
            }
            return;
        }

        item.add(nums[index]);
        dfs(nums, target - nums[index], index + 1, item, res);
        item.remove(item.size() - 1);

        dfs(nums, target, index + 1, item, res);
    }
}
