package A_08_Hash_And_String_1;


// 使用"包括"的情况：
// 1. 需要时刻维护一个有效区间
// 2. 需要频繁比较slow指向的元素
// 3. 需要保持元素的相对顺序

// 使用"不包括"的情况：
// 1. 需要填充或覆盖元素
// 2. slow表示下一个可用位置
// 3. 不需要频繁访问slow之前的元素

import java.util.HashSet;
import java.util.Set;

public class Q06_RemoveCertainCharacters {
    public String remove(String input, String given) {
        if (given == null || given.length() == 0) {
            return input;
        }
        char[] inputArr = input.toCharArray();
        // Slow points to the next available slot
        // So the returned result is always [0, slow)
        int slow = 0;
        Set<Character> blocklistSet = this.buildBlocklist(given);

        for (int i = 0; i < inputArr.length; i++) {
            if (!blocklistSet.contains(inputArr[i])) {
                inputArr[slow] = inputArr[i];
                slow++;
            }
        }

        return new String(inputArr, 0, slow);
    }

    public Set<Character> buildBlocklist(String str) {
        Set<Character> set = new HashSet<>();
        for (int i = 0; i < str.length(); i++) {
            set.add(str.charAt(i));
        }
        return set;
    }
}
