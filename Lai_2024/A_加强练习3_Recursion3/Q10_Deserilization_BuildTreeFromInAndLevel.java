package A_加强练习3_Recursion3;

import Utils.TreeNode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
Recursion 的四层理解
1. 表象上 一个function call itself
2. 把一个大问题 boil down成 小一号 小两号 小一半 的问题去解决
3. 从实现上就是 base case + recursive rule
4. The input argument list of each recursion function in each call stack level must be consistent with each other
 */
public class Q10_Deserilization_BuildTreeFromInAndLevel {
    public TreeNode reconstruct(int[] in, int[] level) {
        // Write your solution here.
        Map<Integer, Integer> indexMap = getIndexMap(in);
        List<Integer> levelList = getlevelList(level);
        return reconstructHelper(indexMap, levelList);
    }

    private TreeNode reconstructHelper(Map<Integer, Integer> indexMap, List<Integer> levelList) {
        if (levelList.isEmpty()) {
            return null;
        }

        TreeNode root = new TreeNode(levelList.remove(0));
        List<Integer> leftList = new ArrayList<>();
        List<Integer> rightList = new ArrayList<>();

        for (int num : levelList) {
            if (indexMap.get(num) < indexMap.get(root.val)) {
                leftList.add(num);
            } else {
                rightList.add(num);
            }
        }

        root.left = reconstructHelper(indexMap, leftList);
        root.right = reconstructHelper(indexMap, rightList);

        return root;
    }

    private Map<Integer, Integer> getIndexMap(int[] in) {
        Map<Integer, Integer> indexMap = new HashMap<>();
        for (int i = 0; i < in.length; i++) {
            indexMap.put(in[i], i);
        }
        return indexMap;
    }

    private List<Integer> getlevelList(int[] level) {
        List<Integer> result = new ArrayList<>();
        for (int num : level) {
            result.add(num);
        }
        return result;
    }
}
