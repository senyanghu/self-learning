package A_加强练习4_DFS;

/*
这种写法可以保证 for for loop 里，枚举的每个 pair <i, j>

每个 pair <i, j> 的 right_index j 是递增的

每个 pair <i, j> 的 left_index i < j 并且 i 也是递增的。由此，可以保证 for each sum = X, its right border is as small as possible.

1__________7
    2__________9
不用担心，因为 <1, 2> <7, 9>，必定会被找到。

1__2
           7___9
 */
public class Q11_4Sum {
}
