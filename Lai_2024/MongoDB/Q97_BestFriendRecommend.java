package MongoDB;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/*
在一个社交媒体网络中，每个用户都有其好友列表。给定一个表示社交关系的图（用一个 Map<Integer, List<Integer>> 表示，其中键是用户ID，值是该用户的直接好友列表），以及一个特定用户ID，请为该用户推荐一个“最佳新朋友”。推荐的规则是：
优先推荐：与当前用户有最多共同好友的用户。
次级规则：如果共同好友数相同，推荐用户ID较小的用户。
限制条件：不能推荐当前用户自己，且不能推荐当前用户的直接好友。
输入：
connections：一个映射，表示每个用户及其直接好友。
person：目标用户ID。
输出：
返回推荐的新朋友的用户ID。
 */
public class Q97_BestFriendRecommend {
    public static int bestRecommendation(Map<Integer, List<Integer>> connections, int person) {
        if (!connections.containsKey(person)) {
            return -1;  // the person is not valid
        }

        Set<Integer> friendSetOfPerson = new HashSet<>(connections.get(person));
        int maxCommonFriendNum = -1;
        int recommendFriend = -1;

        for (int candidate : connections.keySet()) {
            if (friendSetOfPerson.contains(candidate) || candidate == person) {
                continue; // skip direct friends and self
            }
            int commonFriendNum = 0;
            Set<Integer> friendSetOfCandidate = new HashSet<>(connections.get(candidate));
            for (int friend : friendSetOfCandidate) {
                if (friendSetOfPerson.contains(friend)) {
                    commonFriendNum++;
                }
            }
            if (commonFriendNum > maxCommonFriendNum) {
                maxCommonFriendNum = commonFriendNum;
                recommendFriend = candidate;
            } else if (commonFriendNum == maxCommonFriendNum && candidate < recommendFriend) {
                recommendFriend = candidate;
            }
        }

        return recommendFriend;
    }

    public static void main(String[] args) {
        Map<Integer, List<Integer>> connections = new HashMap<>();
        connections.put(1, Arrays.asList(2, 3, 4));
        connections.put(2, Arrays.asList(1, 3));
        connections.put(3, Arrays.asList(1, 2, 5));
        connections.put(4, Arrays.asList(1, 6));
        connections.put(5, Arrays.asList(3));
        connections.put(6, Arrays.asList(4));
        connections.put(7, Arrays.asList(3, 4));

        int person1 = 1;
        int recommendation1 = bestRecommendation(connections, person1);
        System.out.println("For user " + person1 + ", the best recommendation is: " + recommendation1); // Expected: 5 or 7 (both have 1 common friend, 5 < 7)

        int person2 = 2;
        int recommendation2 = bestRecommendation(connections, person2);
        System.out.println("For user " + person2 + ", the best recommendation is: " + recommendation2); // Expected: 4 (common with 1: 1 common friend) or 5 (common with 3: 1 common friend), 4 < 5

        int person3 = 3;
        int recommendation3 = bestRecommendation(connections, person3);
        System.out.println("For user " + person3 + ", the best recommendation is: " + recommendation3); // Expected: 4 (common with 1: 1), 6 (common with 4: 0), 7 (common with 1: 1), so 4

        int person4 = 4;
        int recommendation4 = bestRecommendation(connections, person4);
        System.out.println("For user " + person4 + ", the best recommendation is: " + recommendation4); // Expected: 2 (common with 1: 1), 3 (common with 1: 1), 5 (common with 3: 0), so 2

        int person5 = 5;
        int recommendation5 = bestRecommendation(connections, person5);
        System.out.println("For user " + person5 + ", the best recommendation is: " + recommendation5); // Expected: 2 (common with 3: 1), 4 (common with 1: 0), 6 (common with 4: 0), 7 (common with 3: 1), so 2

        int person6 = 6;
        int recommendation6 = bestRecommendation(connections, person6);
        System.out.println("For user " + person6 + ", the best recommendation is: " + recommendation6); // Expected: 2 (common with 1: 0), 3 (common with 1: 0), 5 (common with 3: 0), 7 (common with 4: 1), so 7

        int person7 = 7;
        int recommendation7 = bestRecommendation(connections, person7);
        System.out.println("For user " + person7 + ", the best recommendation is: " + recommendation7); // Expected: 2 (common with 3: 1), 4 (common with 4: 1), 5 (common with 3: 1), so 2
    }
}
