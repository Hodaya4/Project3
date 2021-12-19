import java.util.Scanner;

public class Exercise8 {
    public static String subString(String str, int start, int end) {   //substring
        String str2 = "";
        for (int i = start; i < end; i++) {
            str2 += str.charAt(i);
        }
        return str2;
    }

    public static String[] buildArr() {
        Scanner sc = new Scanner(System.in);
        String arrTemp[] = new String[100];
        int index = 0;
        System.out.println("Enter string: ");
        String answer = sc.nextLine();
        while (answer.length() >= 4) {
            arrTemp[index] = answer;
            index++;
            System.out.println("Enter another string: ");
            answer = sc.nextLine();
        }

        String arr[] = new String[index];
        for (int i = 0; i < arrTemp.length; i++) {
            if (arrTemp[i] != null) {
                arr[i] = arrTemp[i];
            }
        }
        return arr;
    }

    public static String[] allSubStrings(String str) {
        int index = 0;
        String arr[] = new String[100];
        for (int i = 0; i < str.length(); i++) {
            for (int j = i + 2; j <= str.length(); j++) {
                String res = subString(str, i, j);
                if (res.length() != str.length()) {
                    arr[index] = res;
                    index++;
                }
            }
        } String arr2[] = new String[index];
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != null) {
                arr2[i] = arr[i];
            }
        }
        return arr2;
    }

    public static String popularSubString(String arr[]) {
        int length = 0;
        for (int i = 0; i < arr.length; i++) {  //combine all substring arr lengths into new arr length
            String str = arr[i];
            String[] arrTemp = allSubStrings(str);
            length += arrTemp.length;
        }
        String[] arr3 = new String[length];  // <
        int index = 0;

        for (int i = 0; i < arr.length; i++) {  // creates arr with all substrings
            String str = arr[i];
            String[] arrTemp = allSubStrings(str);
            for (int j = 0; j < arrTemp.length; j++) {
                if (arr3[index] == null) {
                    arr3[index] = arrTemp[j];
                    index++;
                }
            }
        }
        int countTemp = 0;
        int count = 0;
        String popularSubString = "";

        for (int i = 0; i < arr3.length; i++) {  // check highest popularity
            for (int j = 0; j < arr3.length; j++) {
                if (arr3[i] == arr3[j]) {
                    countTemp++;
                }
            } if (countTemp > count) {
                count = countTemp;
                popularSubString = arr3[i];
            }
        }
        return popularSubString;
    }


    public static void main (String[]args){
        String[] arr = buildArr();
        String str = popularSubString(arr);
        System.out.println(str);
    }
}