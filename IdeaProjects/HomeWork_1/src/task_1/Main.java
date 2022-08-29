package task_1;

public class Main {

    public static void main(String[] args) {
        int[][] array = new int[5][5];
        int []maxMinSum = new int[3];
        int sizeArray = array.length * array.length;
        fillingArray(array, -100, 100);
        printArray(array);
        searchMaxMinSumInArray(array,maxMinSum);
        printMaxMinMiddleInArray(maxMinSum,sizeArray);

    }
    public static void printMaxMinMiddleInArray(int []maxMinSum, int sizeArray){
        System.out.println("Максимальный элемент = " + maxMinSum[0]);
        System.out.println("Минимальный элемент = " + maxMinSum[1]);
        System.out.println("Среднее арифметическое = " + (double)maxMinSum[2]/sizeArray);
    }
    public static void printArray(int [][]array){
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                System.out.printf("%3d ",array[i][j]);
            }
            System.out.println();
        }
    }

    public static int random(int num) {
        int mod = (int) 281474976710655L;
        int multiplier = (int) 25214903917L;
        int inc = 11;
        num = (num * multiplier + inc) & mod;
        return num;
    }
    public static void fillingArray(int[][] array, int start, int end) {
        int num = 1;
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                num = random(num);
                array[i][j] = num;
                if (start >= 0 && end > 0) {
                    array[i][j] = Math.abs(array[i][j]) % (end - start) + start;
                } else if (start < 0 && end > 0) {
                    if (array[i][j] > 0) {
                        array[i][j] = array[i][j] % (end);
                    }
                    else {
                        array[i][j] = array[i][j] % (start);
                    }
                } else if (start < 0 && end > start) {
                    if (array[i][j] % (start - end) > 0) {
                        array[i][j] = array[i][j] % (start - end) * (-1) + end;
                    } else {
                        array[i][j] = array[i][j] % (start - end) + end;
                    }
                }
            }
        }
    }
    public static void searchMaxMinSumInArray(int [][]array, int []maxMinSum){
        int max = array[0][0];
        int min = array[0][0];
        int sum = 0;
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                if(array[i][j] > max){
                    max = array[i][j];
                }
                if(array[i][j] < min){
                    min = array[i][j];
                }
                sum = sum + array[i][j];
            }
        }
        maxMinSum[0] = max;
        maxMinSum[1] = min;
        maxMinSum[2] = sum;
    }
}
