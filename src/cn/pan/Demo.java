package cn.pan;


import java.util.HashMap;

class Solutions {
    public int lengthOfLongestSubstring(String s) {
        HashMap<Character, Integer> hashMap = new HashMap<>();
        int length = s.length();
        int start = 0;
        int ans = 0;
        for (int end = 0; end < length; end++) {
            char c = s.charAt(end);
            if (hashMap.containsKey(c)) {
                start = Math.max(start, hashMap.get(c) + 1);
            }
            hashMap.put(c, end);
            ans = Math.max(ans, end - start + 1);
        }
        return ans;
    }

    /*public String MaxLength(String s) {
        int length = s.length();
        int left;
        int right;
        int count = 0;
        int maxStart=0;
        int maxSize=0;
        for (int cur = 1; cur < length; cur++) {
            left = cur - 1;
            right = cur + 1;
            while (s.charAt(cur) == s.charAt(left) && left > 0) {
                left--;
                count++;
            }
            while (s.charAt(cur) == s.charAt(right) && right < length) {
                right++;
                count++;
            }
            while (s.charAt(left) == s.charAt(right) && left > 0 && right < length) {
                left--;
                right++;
                count++;
            }
            if()
        }
        return "";
    }*/

    public void printOut(int n) {
        /*if (n >= 10)
            printOut(n / 10);
        System.out.print(n % 10);*/
        if (n < 10) {
            System.out.print(n);
        } else {
            printOut(n / 10);
            System.out.print(n % 10);
        }
    }

    public int maxSubArray(int[] nums) {
        int preSum = nums[0];
        int maxSum = nums[0];
        int thisSum = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (preSum < 0) {
                thisSum = nums[i];
                preSum = nums[i];
            }else {
                thisSum = nums[i] + preSum;
                preSum += nums[i];
            }
            maxSum = Math.max(thisSum, maxSum);
        }
        return maxSum;
    }


}

public class Demo {
    public static void main(String[] args) {
        Solutions solutions = new Solutions();
        int i = solutions.maxSubArray(new int[]{-2});
        System.out.println(i);
    }
}
