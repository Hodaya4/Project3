import java.util.Scanner;

public class Exercise7 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter you equation: ");
        String equation = scanner.nextLine();
        int [] param = isValid(equation);
        if (param != null) {
            System.out.println("a = " + param[0]);
            System.out.println("b = " + param[1]);
            System.out.println("c = " + param[2]);
            double[] result = solveEquation(param);
            if (result[1] == result[0]) {
                System.out.println("x = " + result[0]);
            } else {
                System.out.println("x1 = " + result[0] +
                        "\nx2 = " + result[1]);
                }
        } else {
            System.out.println("Not a valid equation!");
        }
    }

    public static int[] isValid(String eq) {
        int [] param = new int[3];
        int nextChar = 1;
        char c = eq.charAt(0);
        if (isDigit(c)) { // ax^2
            param[0] = c - '0'; // param[0] = a
        } if (c == '-' && eq.charAt(1) == 'x') {// -x^2
            param[0] = -1;
        } if (c == '-' && isDigit(eq.charAt(1))) { // -ax^2
            param[0] = -(eq.charAt(1) - '0');
            nextChar = 2;
        }
        if (c == 'x') { // x^2
            param[0] = 1;
            nextChar = 0;
        }
        if ((eq.charAt(nextChar) == 'x' || eq.charAt(nextChar + 1) == '^' || eq.charAt(nextChar + 2) =='2')) {
            return null;
        }
        boolean flag = false;
        nextChar = nextChar + 3; // look for b
        c = eq.charAt(nextChar);

        if (plusOrMinus(c) && isDigit(eq.charAt(nextChar + 1)) && eq.charAt(nextChar + 2) == 'x')  { // case 1   :  [+ / -, 2 ,x]
            if (c == '+') {
                param[1] = eq.charAt(nextChar + 1) - '0';
            } else {
                param[1] = -(eq.charAt(nextChar + 1) - '0');
            } nextChar = nextChar + 3;
            flag = true;
        }

        if (plusOrMinus(c) && eq.charAt(nextChar + 1) == 'x') { // case 2 :  [+/-, x]
            if (c == '+') {
                param[1] = 1;
            } else {
                param[1] = -1;
            } nextChar = nextChar + 2;
            flag = true;
        }

        if (!flag) {// none of the cases above
            return null;
        }

        c = eq.charAt(nextChar); // [+ \ - ,c]
        if (plusOrMinus(c)) {
            if (c == '+') {
                param[2] = eq.charAt(nextChar + 1) - '0';
            } else {
                param[2] = -(eq.charAt(nextChar + 1) - '0');
            }
        }
        else {
            return null;
        }
        nextChar = nextChar + 2;
        // check if last chars is '=0'
        if (nextChar + 1 != eq.length() - 1) {
            return null;
        } if (eq.charAt(nextChar) == '=' && eq.charAt(nextChar + 1) == '0') {
            return param;
        } else {
            return null;
        }
    }

    public static double[] solveEquation(int [] params) {
        int a = params[0];
        int b = params[1];
        int c = params[2];
        double denominator = 2 * a;
        double [] result = new double[2];
        double delta = (b * b ) - ( 4 * a * c);
        double sqrt = Math.sqrt(delta);
        double numerator1 = -b + sqrt;
        double numerator2 = -b - sqrt;
        result[0] = numerator1 / denominator;
        result[1] = numerator2 / denominator;
        return result;
    }
    public static boolean plusOrMinus(char c) {
        if (c == '-' || c == '+') {
            return true;
        }
        return false;
    }
    public static boolean isDigit(char c) {
        if ( (c >= '1' && c <= '9')) {
            return true;
        }
        return false;
    }
}
