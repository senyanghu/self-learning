package A_加强练习6_BinarySearch;

/*

Solution 1:
Step 1: we first move L and R by using binary search to make it close to the target number, until there are two or
fewer elements in between L and R.
Step 2: 谁小移谁
Time = O(log(n) + k)

Solution 2:
e.g. int[] a = {1, 2, 3, 4, 8, 9}

target = 4
找到了4以后

A[] = 3 2 1 -> 1(4-3) 2(4-2) 3(4-1)
B[] = 8 9 -> 4(8-4) 5(9-4)

那么就可以在这两个array里面跑一个FindKthSmallestFrom2Arrays来解决问题
Time = O(log(n) + log(k))
 */
public class Q02_FindCloestKElementsInAnArray {
}
