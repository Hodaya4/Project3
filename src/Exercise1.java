import java.util.Scanner;

public class Exercise1 {
    public static boolean changingNumbers(String num) {
        boolean outcome = false;
        if (num.length() == 1) {
            outcome = true;
            return outcome;
        }
        for (int i = 0; i < num.length() - 1; i++) {
            if (num.charAt(i) % 2 == 0 && num.charAt(i+1) % 2 != 0 || num.charAt(i) % 2 != 0 && num.charAt(i+1) % 2 == 0 ) {
                outcome =  true;
            } else {
                outcome =  false;
                break;
            }
        } return outcome;
    }

    public static int indexOfSmallestChangingNumber(int arr[]) {
        int divisionNum = 10;
        int index = 0;
        int sum = 0;
        int smallestSum;
        int tempSmallest = arr[0];
        for (sum = 0; tempSmallest != 0; tempSmallest = tempSmallest / divisionNum) {
            sum = sum + tempSmallest % divisionNum;
        } smallestSum = sum; // temporary smallest sum for future comparison

        boolean changingNumberExists = false;

        for (int i = 0; i < arr.length; i++) {
            String num = "" + arr[i];
            boolean res = changingNumbers(num);
            if (res == true) {
                changingNumberExists = true;
                int numFromArr = arr[i];
                for (sum = 0; numFromArr != 0; numFromArr = numFromArr / divisionNum) {
                    sum = sum + numFromArr % divisionNum;
                    if (sum < smallestSum) {
                        index = i;
                    }
                }
            }
        } if (changingNumberExists == true) {
            return index;
        } else {
            return -1;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a number: ");
        String num = sc.nextLine();
        boolean res = changingNumbers(num);
        System.out.println(res);
        System.out.println("---");
        int[] arr = {77, 33, 97, 13, 24, 57};     //23, 77, 5, 98, 234, 544, 1
        int answer = indexOfSmallestChangingNumber(arr);
        System.out.println(answer);
    }
}
