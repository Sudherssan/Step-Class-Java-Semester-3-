package Homework;

import java.util.Scanner;

public class MaximumSubarray {

    static int maxSubArray(int[] nums) {
        int current = nums[0];
        int max = nums[0];

        for (int i = 1; i < nums.length; i++) {
            if (current + nums[i] > nums[i])
                current = current + nums[i];
            else
                current = nums[i];

            if (current > max)
                max = current;
        }

        return max;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] nums = new int[n];

        for (int i = 0; i < n; i++)
            nums[i] = sc.nextInt();

        System.out.println(maxSubArray(nums));

        sc.close();
    }
}