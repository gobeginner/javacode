package cn.pan;


import java.util.*;

class Solution {
    /**
     * 给你一个整数数组 nums 。如果任一值在数组中出现 至少两次 ，返回 true ；
     * 如果数组中每个元素互不相同，返回 false 。
     *
     * @param nums 传入整数数组
     * @return 返回值
     * 使用set集合的特性，集合元素有序且唯一
     */
    public boolean containsDuplicate(int[] nums) {
        //方法一
        /*Arrays.sort(nums);
        for (int i = 0; i < nums.length-1; i++) {
            if (nums[i] == nums[i+1]) {
                return true;
            }
        }
        return false;*/

        /*HashSet<Integer> set = new HashSet<Integer>();
        boolean flag = false;
        for (int num : nums) {
            if(!set.add(num)){
                flag = true;
            }
        }
        return flag;*/

        HashSet<Integer> set = new HashSet<Integer>();
        for (int num : nums) {
            if (!set.add(num)) {
                return true;
            }
        }
        return false;
    }

    /**
     * 给你一个 非空 整数数组 nums ，除了某个元素只出现一次以外，其余每个元素均出现两次。
     * 找出那个只出现了一次的元素。
     *
     * @param nums 传入整数数组
     * @return 返回只出现一次的整数
     * 异或解法
     */
    public int singleNumber(int[] nums) {
        int res = nums[0];
        if (nums.length > 1) {
            for (int i = 1; i < nums.length; i++) {
                res = res ^ nums[i];
            }
        }
        return res;
    }

    /**
     * 给定一个大小为 n 的数组 nums ，返回其中的多数元素。
     * 多数元素是指在数组中出现次数 大于 ⌊ n/2 ⌋ 的元素。
     *
     * @param nums
     * @return
     */
    public int majorityElement(int[] nums) {
        int cur = nums[0];
        int count = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != cur) {
                count--;
                if (count == 0) {
                    count = 1;
                    cur = nums[i];
                }
            } else {
                count++;
            }
        }
        return cur;
    }

    /**
     * 三数之和
     * 解题思路：双指针
     * 1、判断数组是否为空或长度小于3
     * 2、将数组进行排序
     * 3、进行for循环，先判断num[i]是否大于0，若大于0则退出循环，因为最小数大于零，和不等于零
     * 4、对num[i]进行排重
     * 5、左指数（L）等于i+1，右指数（R）等于length-1
     * 6、计算三数相加的和，等于0则存入集合，并让左指数和右指数排重，最后左指数加一，右指数减一
     * 7、当sum>0，右指数太大，R--；当sum<0，左指数太小，L++
     *
     * @param nums
     * @return
     */
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> lists = new ArrayList<List<Integer>>();
        if (nums == null || nums.length < 3) {
            return lists;
        }
        Arrays.sort(nums);
        int length = nums.length;
        for (int i = 0; i < length; i++) {
            if (nums[i] > 0) {
                break;
            }
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            int L = i + 1;
            int R = length - 1;
            while (L < R) {
                int sum = nums[i] + nums[L] + nums[R];
                if (sum == 0) {
                    lists.add(Arrays.asList(nums[i], nums[L], nums[R]));
                    while (L < R && nums[L] == nums[L + 1]) L++;
                    while (L < R && nums[R] == nums[R - 1]) R--;
                    L++;
                    R--;
                }

                if (sum > 0) R--;
                if (sum < 0) L++;
            }
        }
        return lists;
    }

    public class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }


    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        /*if (l1 == null || l2 == null)
            return l1 == null ? l2 : l1;
        ListNode head = new ListNode();
        ListNode cur = new ListNode();
        cur = head;
        int temp = 0;
        while (l1 != null && l2 != null) {
            int val = l1.val + l2.val + temp;
            temp = val / 10;
            cur.next = new ListNode(val % 10);
            cur = cur.next;
            l1 = l1.next;
            l2 = l2.next;
        }
        while (l1 != null) {
            int val = l1.val + temp;
            temp = val / 10;
            cur.next = new ListNode(val % 10);
            cur = cur.next;
            l1 = l1.next;
        }
        while (l2 != null) {
            int val = l2.val + temp;
            temp = val / 10;
            cur.next = new ListNode(val % 10);
            cur = cur.next;
            l2 = l2.next;
        }
        if (temp > 0) {
            cur.next = new ListNode(temp);
            cur = cur.next;
        }
        cur.next = null;
        return head.next;*/

        ListNode head = new ListNode();
        ListNode cur = new ListNode();
        cur = head;
        int temp = 0;
        while (l1 != null || l2 != null) {
            int x = l1 != null ? l1.val : 0;
            int y = l2 != null ? l2.val : 0;
            int val = x + y + temp;
            cur.next = new ListNode(val % 10);
            temp = val / 10;
            cur = cur.next;
            if (l1 != null) {
                l1 = l1.next;
            }
            if (l2 != null) {
                l2 = l2.next;
            }
        }
        if (temp > 0) {
            cur.next = new ListNode(temp);
            cur = cur.next;
        }
        return head.next;
    }

    public void sortColors(int[] nums) {
        int num0 = 0, num1 = 0, num2 = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                nums[num2++] = 2;
                nums[num1++] = 1;
                nums[num0++] = 0;
            } else if (nums[i] == 1) {
                nums[num2++] = 2;
                nums[num1++] = 1;
            } else {
                nums[num2++] = 2;
            }
        }
    }

    /**
     * 给定一个字符串 s ，请你找出其中不含有重复字符的 最长子串 的长度。
     *
     * @param s
     * @return
     */
    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> map = new HashMap<>();
        int length = s.length();
        int start = 0;
        int ans = 0;
        for (int end = 0; end < length; end++) {
            char c = s.charAt(end);
            if (map.containsKey(c)) {
                start = Math.max(start, map.get(c));
            }
            map.put(c, end + 1);
            ans = Math.max(ans, end - start + 1);
        }
        return ans;
    }

    public String longestPalindrome(String s) {
        //babad
        /*if (s==null||s.length()==0){
            return "";
        }
        int left;
        int right;
        int maxLen = 0;
        int len = 1;
        int maxStart = 0;
        for (int cur = 0; cur < s.length(); cur++) {
            left = cur - 1;
            right = cur + 1;
            while (left >= 0 && s.charAt(cur) == s.charAt(left)) {
                left--;
                len++;
            }
            while (right < s.length() && s.charAt(cur) == s.charAt(right)) {
                right++;
                len++;
            }
            while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
                left--;
                right++;
                len += 2;
            }
            if (len > maxLen) {
                maxLen = len;
                maxStart = left;
            }
            len = 1;
        }
        return s.substring(maxStart + 1, maxStart + maxLen + 1);*/

        if (s == null || s.length() < 2) {
            return s;
        }
        int maxLen = 0;
        int maxStart = 0;
        int maxEnd = 0;
        int strlen = s.length();
        boolean[][] dp = new boolean[strlen][strlen];
        for (int r = 1; r < strlen; r++) {
            for (int l = 0; l < r; l++) {
                if (s.charAt(r) == s.charAt(l) && (r - l <= 2 || dp[l + 1][r - 1])) {
                    dp[l][r] = true;
                    if (r - l + 1 > maxLen) {
                        maxLen = r - l + 1;
                        maxStart = l;
                        maxEnd = r;
                    }
                }
            }
        }
        return s.substring(maxStart, maxEnd + 1);
    }

    public int maxSubArray(int[] nums) {
        int length = nums.length;
        int[] dp = new int[length];
        dp[0] = nums[0];
        int ans = nums[0];
        for (int i = 1; i < length; i++) {
            if (dp[i - 1] > 0) {
                dp[i] = nums[i] + dp[i - 1];
            } else {
                dp[i] = nums[i];
            }
            ans = Math.max(ans, dp[i]);
        }
        return ans;
    }

    /**
     * 杨辉三角（动态规划）
     *
     * @param numRows
     * @return
     */
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> dp = new ArrayList<>();
        for (int i = 0; i < numRows; i++) {
            ArrayList<Integer> list = new ArrayList<>();
            for (int j = 0; j <= i; j++) {
                if (j == 0 || i == j) {
                    list.add(1);
                } else {
                    list.add(dp.get(i - 1).get(j - 1) + dp.get(i - 1).get(j));
                }
            }
            dp.add(list);
        }
        return dp;
    }

}


public class Test {
    public static void main(String[] args) {
        int[] nums = {5, 4, -1, 7, 8};
        Solution solution = new Solution();
        List<List<Integer>> generate = solution.generate(5);
        System.out.println(generate);
    }
}
