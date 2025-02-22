package Notes;

/*
时间复杂度是 O(n)
 */
public class Notes_01_Heapify {
    public static void heapify(int[] arr, int n, int i) {
        int largest = i; // 初始化最大元素为根
        int left = 2 * i + 1; // 左子节点
        int right = 2 * i + 2; // 右子节点

        // 如果左子节点大于根
        if (left < n && arr[left] > arr[largest])
            largest = left;

        // 如果右子节点大于目前的最大值
        if (right < n && arr[right] > arr[largest])
            largest = right;

        // 如果最大值不是根
        if (largest != i) {
            int swap = arr[i];
            arr[i] = arr[largest];
            arr[largest] = swap;

            // 递归地堆化受影响的子树
            heapify(arr, n, largest);
        }
    }

    // 构建堆的方法
    public static void buildHeap(int[] arr) {
        int n = arr.length;

        // 从最后一个非叶子节点开始，自底向上堆化
        for (int i = n / 2 - 1; i >= 0; i--)
            heapify(arr, n, i);
    }

    // 打印数组的辅助方法
    public static void printArray(int[] arr) {
        for (int i : arr)
            System.out.print(i + " ");
        System.out.println();
    }

    public static void main(String[] args) {
        int[] arr = {12, 11, 13, 5, 6, 7};
        System.out.println("原始数组：");
        printArray(arr);

        buildHeap(arr);

        System.out.println("堆化后的数组：");
        printArray(arr);
    }
}
