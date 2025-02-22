package A_加强练习5;

import java.util.Stack;

public class Q08_LargestHistogram {

    public int largestRectangleArea(int[] heights) {
        if (heights == null || heights.length == 0) {
            return 0;
        }

        int maxArea = 0;
        // 栈中存储索引，对应的高度是递增的
        Stack<Integer> stack = new Stack<>();

        // 遍历每个位置，包括最后一个虚拟位置
        for (int i = 0; i <= heights.length; i++) {
            // 当前高度（如果是最后一个位置，高度为0）
            int currHeight = (i == heights.length) ? 0 : heights[i];

            // 当栈不为空，且当前高度小于栈顶索引对应的高度
            while (!stack.isEmpty() && currHeight < heights[stack.peek()]) {
                // 弹出栈顶元素，计算以该高度为高的最大矩形面积
                int height = heights[stack.pop()];
                // 计算宽度：如果栈为空，宽度是i；否则是i - 栈顶索引 - 1
                // 如果栈为空：说明左边没有比当前高度更低的柱子，宽度就是i
                // 如果栈不为空：宽度是当前位置i减去新的栈顶位置再减1
                int width = stack.isEmpty() ? i : i - stack.peek() - 1;
                // 更新最大面积
                maxArea = Math.max(maxArea, height * width);
            }

            stack.push(i);
        }

        return maxArea;
    }
}
