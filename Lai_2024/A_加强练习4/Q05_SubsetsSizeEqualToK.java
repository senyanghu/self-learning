package A_加强练习4;


import java.util.List;
import java.util.ArrayList;

/*
"Q2.1c Given an array of size n (with no duplicate), print all possible combinations of k elements in array.
For example, if input array is {2, 1, 3, 4} and k = 2, then output should be {1, 2}, {1, 3}, {1, 4},
{2, 3}, {2, 4} and {3, 4}. (That is, subset problem with size == k)"
 */
public class Q05_SubsetsSizeEqualToK {
    public List<List<Integer>> subsets_basic(int[] nums, int k) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> item = new ArrayList<>();

        dfs_basic(nums, 0, k, item, result);

        return result;
    }

    private void dfs_basic(int[] nums, int index, int k, List<Integer> item, List<List<Integer>> result) {
        if (index == nums.length) {
            if (item.size() == k) {
                result.add(new ArrayList<Integer>(item));
            }
            return;
        }

        item.add(nums[index]);
        dfs_basic(nums, index + 1, k, item, result);
        item.remove(item.size() - 1);

        dfs_basic(nums, index + 1, k, item, result);
    }

    public static void main(String args[]) {
        Q05_SubsetsSizeEqualToK sol = new Q05_SubsetsSizeEqualToK();
        int[] nums = {1, 2, 3};
        for (List<Integer> sub : sol.subsets_basic(nums, 2)) {
            System.out.println(sub.toString());
        }
    }
}
