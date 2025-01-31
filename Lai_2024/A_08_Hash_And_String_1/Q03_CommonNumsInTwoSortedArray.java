package A_08_Hash_And_String_1;

import java.util.ArrayList;
import java.util.List;

public class Q03_CommonNumsInTwoSortedArray {
    public List<Integer> commonNums(List<Integer> A, List<Integer> B) {
        List<Integer> res = new ArrayList<>();
        int index1 = 0, index2 = 0;

        while (index1 < A.size() && index2 < B.size()) {
            if (A.get(index1) == B.get(index2)) {
                res.add(A.get(index1));
                index1++;
                index2++;
            } else if (A.get(index1) < B.get(index2)) {
                index1++;
            } else {
                index2++;
            }
        }

        return res;
    }
}
