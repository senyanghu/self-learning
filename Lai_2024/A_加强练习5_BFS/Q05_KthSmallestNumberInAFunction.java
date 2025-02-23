package A_加强练习5_BFS;

/*
How to find the k-th smallest number in the function
f(x, y, z) = 3^x * 5^y * 7^z (int x>0, y>0, z>0)

Here's the text from the image:

1. initial state: <x=1, y=1, z=1>
2. exp/gen rule: <x, y, z> → <x+1, y, z>, <x, y+1, z>, <x, y, z+1>
3. termination condition: when the k-th element is popped out of the heap.
4. Deduplication when generating a new state:
   a. example: <5, 5, 5> can be generated from <4, 5, 5> <5, 4, 5> <5, 5, 4>
 */
public class Q05_KthSmallestNumberInAFunction {
}
