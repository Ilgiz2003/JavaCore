package task_2;

import java.util.Arrays;
import java.util.HashMap;

public class Main {
    public static void main(String[] args) {
        int[] array = {3, 4, 2, 7};
        int sum = 10;
        findPair(array, sum);
    }

    public static void findPair(int[] array, int sum) {
        HashMap<Integer, Integer> nums = new HashMap<>();
        for (int i = 0; i < array.length; i++) {
            if (nums.containsKey(sum - array[i])) {
                System.out.println(Arrays.toString(array) + ", " + sum + " -> " + "[" + array[nums.get(sum - array[i])] + ", " + array[i] + "]");
                return;
            }
            nums.put(array[i], i);
        }
        System.out.println("Подходящей пары не найдено.");
    }
}
