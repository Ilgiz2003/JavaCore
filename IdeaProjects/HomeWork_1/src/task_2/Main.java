package task_2;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        int []array1 = new int[] {15, 62, 31, 41 , 62, 51, 65, 73, 64, 33};
        int []array2 = new int[] {334, 662, 321, 401 , 620, 511, 65, 773, 164, 903};
        int []array3 = new int[] {444, 662, 555, 401 , 655, 555, 255, 444, 194, 53};

        int []arrayExpected1 = new int[] {15, 31, 33, 41, 51, 62, 62, 64, 65, 73};
        int []arrayExpected2 = new int[] {65,164,321,334,401,511,620,662,773,903};
        int []arrayExpected3 = new int[] {53,194,255,401,444,444,555,555,655,662};
        System.out.println("До сортировки");
        System.out.println(Arrays.toString(array1));
        quickSort(array1,0,array1.length - 1);
        System.out.println("После сортировки");
        System.out.println(Arrays.toString(array1));

        System.out.println("\nДо сортировки");
        System.out.println(Arrays.toString(array2));
        quickSort(array2,0,array2.length - 1);
        System.out.println("После сортировки");
        System.out.println(Arrays.toString(array2));

        System.out.println("\nДо сортировки");
        System.out.println(Arrays.toString(array3));
        quickSort(array3,0,array3.length - 1);
        System.out.println("После сортировки");
        System.out.println(Arrays.toString(array3));

        test(arrayExpected1, array1);
        test(arrayExpected2, array2);
        test(arrayExpected3, array3);
    }
    public static void quickSort(int []array, int start, int end){
        int divideIndex;
        if(start < end){

            divideIndex = split(array,start,end);

            quickSort(array, start,  divideIndex - 1);
            quickSort(array,divideIndex,end);
        }
    }
    public static int split(int []array, int start, int end){
        int leftIndex = start;
        int rightIndex = end;

        int pivot = array[start + (end - start) / 2];
        while (leftIndex <= rightIndex){
            while (array[leftIndex] < pivot){
                leftIndex++;
            }
            while (array[rightIndex] > pivot){
                rightIndex--;
            }
            if(leftIndex <= rightIndex){
                swap(array, leftIndex, rightIndex);
                leftIndex++;
                rightIndex--;
            }
        }
        return leftIndex;
    }
    public static void swap(int []array, int leftIndex, int rightIndex){
        int temp;
        temp = array[leftIndex];
        array[leftIndex] = array[rightIndex];
        array[rightIndex] = temp;
    }
    public static void test(int []arrayExpected, int []array){
        assert Arrays.equals(arrayExpected,array);
    }
}
