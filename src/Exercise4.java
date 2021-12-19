import java.util.Scanner;

public class Exercise4 {
    public static int check (int arr[]) {          //ASK SHAI
        int count = 0;
        boolean res = true;

        if (arr.length == 1) {   // if only 1 int on arr then full
            return 1;
        }

        for (int k = 0; k < arr.length; k++) {   // if duplicated numbers then not full
            for (int j = 0; j < arr.length; j++) {
                if (arr[k] == arr[j]) {
                    count++;
                } if (count > 1) {
                    res = false;
                    return 2;
                }
            } count = 0;
        } return 3;
    }

    public static boolean fullArr(int arr[]) {
        int i = 0;
        int min = arr[i];
        int max = arr[i];
        boolean res = true;

         int answer = check(arr);
         if (answer == 1) {
             return true;
         } else if (answer == 2) {
             return false;
         }

        for (i = 0; i < arr.length; i++) {   // check for min and max numbers on arr
            if (arr[i] < min) {
                min = arr[i];
            } if (arr[i] > max) {
                max = arr[i];
            }
        }

        int count2 = 0;

        for (int k = 0; k < arr.length; k++) {   //if not full return false
            for (int j = 0; j < arr.length; j++) {
                if (arr[j] == min + 1) {
                    min = arr[j];
                    count2++;
                }
            }
        } if (count2 == arr.length - 1) {
            return true;
        } else {
            res = false;
        }
        return res;
    }

    public static boolean fullArrOrganized(int arr[]) {
        boolean res = true;
        int max = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] == max - 1) {
                max = arr[i];
            } else {
                res = false;
            }
        } return res;
    }

    public static void main(String[] args) {
        int[] arr = {15,19,17,16,18,14};
        boolean res = fullArr(arr);
        System.out.println(res);
        boolean res2 = fullArrOrganized(arr);
        System.out.println(res2);
    }
}