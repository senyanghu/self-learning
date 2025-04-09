package A_加强练习1;

// Here's the text from the image:
//
//Q5.6 LCA for two nodes a and b in a very large tree that contains billions of nodes
public class Q15_LCA6 {
}


/*
given 32 machine.
Mapper: 1 job → distribute to 32 machines
Reducer: collect results from each of the 32 machines to do some aggregation/post-processing.

Case 1: both nodes a and b are within the top 5 layers. (We can run BFS1 within top 5 layers.)
Call LCA(root, a, b, level_limit=5)

Case 2: either a or b is within top 5 layers. (Assume a is in the top 5 layers, and b is not.)
Call Find(M1, b), Find(M2, b) ... Find(M32, b)     ⇒ Say, M7 found b.
Call LCA(root, a, M7, level_limit=5)

Case 3: neither a nor b is within top 5 layers.
Call LCA(M1, a, b), LCA(M2, a, b) ... LCA(M32, a, b)


 */