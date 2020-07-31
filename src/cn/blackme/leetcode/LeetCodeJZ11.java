package cn.blackme.leetcode;

public class LeetCodeJZ11 {

    public int minArray(int[] numbers) {
        int low = 0, high = numbers.length - 1;
        while (low < high) {
            int middle = low + (high - low >> 1);
            if (numbers[middle] > numbers[high])
                low = middle + 1;
            else if (numbers[middle] < numbers[high])
                high = middle;
            else
                high--;
        }
        return numbers[low];
    }

}
