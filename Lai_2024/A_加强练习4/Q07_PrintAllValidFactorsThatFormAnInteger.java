package A_加强练习4;

/*
The text in the image reads:

"Q2.3b Print all valid combination of factors that form an integer.

12
= 6 x 2
= 4 x 3
= 3 x 2 x 2
...

1. what does it store on each level? (每层代表什么意义？一般来讲解题之前就知道DFS要recurse多少层) 6 4 3 2 → 4 levels
2. How many different states should we try to put on this level? (每层有多少个状态/case 需要try?)

                                                  12
                                             /           \
L0 how many 6s in result        0 six (rem=12)                1 six (rem=2)
                               /                \                    |
L1 how many 4s in result   0 four (rem=12)    1 four (rem=3)    0 four (rem=2)
                          /               \          \        \
L2 how many 3s in result 0 three (rem=12) 1 three (rem=4) 0three(rem=3) 1three(rem=1)
....
L3 how many 2s in result ....

Time = O((n/2)^4) = O((n/2) ^ factor)"

鼻祖题目是 coin combination
 */
public class Q07_PrintAllValidFactorsThatFormAnInteger {
}
