// Задан массив, например, nums = [1,7,3,6,5,6].
// Написать программу, которая найдет индекс i для этого массива
// такой, что сумма элементов с индексами < i равна сумме
// элементов с индексами > i.

public class FindBalanceIndex {
    static int findBalanceIndex(int[] nums) {
        int totalSum = 0;
        for (int num : nums) {
            totalSum += num;
        }

        int leftSum = 0;
        for (int i = 0; i < nums.length; i++) {
            if (leftSum == totalSum - leftSum - nums[i]) {
                return i;
            }
            leftSum += nums[i];
        }

        return -1;
    }

    public static void main(String[] args) {
        int[] nums = { 1, 7, 3, 6, 5, 6 };

        int balanceIndex = findBalanceIndex(nums);
        if (balanceIndex != -1) {
            System.out.println("Индекс = " + balanceIndex);
        } else {
            System.out.println("Нет такого индекса");
        }
    }
}