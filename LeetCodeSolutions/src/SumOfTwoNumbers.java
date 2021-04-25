import java.util.HashMap;
import java.util.Map;

/**
 * 1、两数之和
 *
 * @author: zheng donghui  E-mail:zheng.dong.hui@foxmail.com
 * @date: 2021-02-14 22:15
 */
public class SumOfTwoNumbers {
    public int[] twoSum(int[] nums, int target) {
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if ((nums[i] + nums[j]) == target) {
                    return new int[] {i, j};
                }
            }
        }
        return new int[0];
    }
}

/**
 * 使用 HashMap 优化后的代码
 */
class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> hash = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (hash.containsKey(target - nums[i])) {
                return new int[] {hash.get(target - nums[i]), i};
            }
            hash.put(nums[i], i);
        }
        return new int[0];
    }
}