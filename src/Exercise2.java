import java.util.Scanner;

public class Exercise2 {
    public static final int DIVISION_NUMBER = 10;

    public static int closenessLevel(int arr1[], int arr2[]) {
        int sum1 = 0;
        int sum2 = 0;
        int closenessLevelCount = 0;
        int highestClosenessLevel = 0;
        int index = 0;
        for (int i = 0; i < arr1.length; i++) {
            closenessLevelCount = 0;
            int numFromArr1 = arr1[i];
            for (sum1 = 0; numFromArr1 != 0; numFromArr1 = numFromArr1 / DIVISION_NUMBER) {
                sum1 = sum1 + numFromArr1 % DIVISION_NUMBER;
            }
            for (int j = 0; j < arr2.length; j++) {
                int numFromArr2 = arr2[j];
                for (sum2 = 0; numFromArr2 != 0; numFromArr2 = numFromArr2 / DIVISION_NUMBER) {
                    sum2 = sum2 + numFromArr2 % DIVISION_NUMBER;
            } if (sum1 == sum2) {
                    closenessLevelCount++;
                }
        }
            if (closenessLevelCount > highestClosenessLevel) {
                highestClosenessLevel = closenessLevelCount;
                index = i;
            }
        } return index;
    }

    public static void main(String[] args) {
        int[] arr1 = {12, 245, 826, 44, 98, 72, 658, 992};
        int[] arr2 = {7, 15, 3, 2855, 323, 27, 53, 4598, 2231};
        int index = closenessLevel(arr1, arr2);
        System.out.println("The index of highest closeness level from arr1 to arr2 is " + index);
    }
}


