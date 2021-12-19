import java.util.Scanner;

public class Exercise6 {
    public static boolean ifDigit(char k) {
        if ((k >= '1' && k <= '9')) {
            return true;
        } return false;
    }
    public static boolean ifArithmetic(char k) {
        char[] arithmetics = {'-', '+', '^', '*'};
        for (int i = 0; i < arithmetics.length; i++) {
            if (k == arithmetics[i]) {
                return true;
            }
        } return false;
    }

    public static boolean ifValid (String str) {
        char[] arr = new char[str.length()];
        for (int i = 0; i < str.length(); i++) {
            arr[i] = str.charAt(i);
        }

        if (!ifDigit(arr[0]) && arr[0] != '(') {  // arr[0] = digit / (
            return false;
        } else if (!ifDigit(arr[arr.length - 1]) && arr[arr.length - 1] != ')') {  // arr[last] = digit / )
            return false;
        }

        for (int i = 1; i < str.length() - 1; i++) {
            if (ifDigit(arr[i]) && (ifDigit(arr[i - 1]) || ifDigit(arr[i + 1]))) { // 46 not valid
                return false;
            } else if ((arr[i] == ')' || arr[i] == '(') && (arr[i - 1] == ')' || arr[i + 1] == '(')) { // (( not valid
                return false;
            } else if (ifArithmetic(arr[i]) && (ifArithmetic(arr[i + 1]) || ifArithmetic(arr[i - 1]))) { // ++ not valid
                return false;
            }
        } for (int i = 0; i < str.length() - 5; i++) {
            if (arr[i] == '(') {
                if (!ifDigit(arr[i+1]) || !ifArithmetic(arr[i+2]) || !ifDigit(arr[i+3]) || arr[i+4] != ')') { // if ( then ( > digit > arithmetic > digit > )
                    return false;
                }
            }
        } for (int i = 4; i < str.length(); i++) {
            if (arr[i] == ')') {
                if (!ifDigit(arr[i-1]) || !ifArithmetic(arr[i-2]) || !ifDigit(arr[i-3]) || arr[i-4] != '(') { // if ) then ( < digit < arithmetic < digit < )
                    return false;
                }
            }
        } for (int i = 0; i < str.length() - 1; i++) {
            if (ifDigit(arr[i]) && arr[i + 1] == '(') {
                return false;
            }
        } for (int i = 1; i < str.length(); i++) {
            if (ifDigit(arr[i]) && arr[i - 1] == ')') {
                return false;
            }
        }
        return true;
    }

    public static double solveEquation (String str) {
        double num1 = str.charAt(0) - '0';
        double num2 = -1;
        int indexNum2 = str.length();
        int indexNum1 = 1;
        int counter = 0;
        double res;

        while (indexNum1 != str.length() - 1) {
            for (int i = indexNum1; i <= indexNum2; i++) {
                if (ifDigit(str.charAt(i))) {
                    num2 = str.charAt(i) - '0';
                    counter = i;
                    break;
                }
            }
            for (int j = indexNum1; j < indexNum2; j++) {
                if (str.charAt(j) == '+') {
                    num1 = num1 + num2;
                    break;
                } else if (str.charAt(j) == '-') {
                    num1 = num1 - num2;
                    break;
                } else if (str.charAt(j) == '*') {
                    num1 = num1 * num2;
                    break;
                } else if (str.charAt(j) == '^') {
                    num1 = Math.pow(num1, num2);
                    break;
                }
            } indexNum1 = counter + 1;
        } res = num1;
        return res;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Please enter your equation: ");
        String str = sc.nextLine();
        while (!ifValid(str)) {
            System.out.println("Enter your equation again: ");
            str = sc.nextLine();
            ifValid(str);
        }
        double res2 = solveEquation(str);
        System.out.println(res2);
    }
}
