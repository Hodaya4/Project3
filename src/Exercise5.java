import java.util.Scanner;

public class Exercise5 {
    public static String subString (String str, int start, int end) {
        String str2 = "";
        for (int i = start; i < end; i++) {
            str2 += str.charAt(i);
        } return str2;
    }

    public static String newString() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a sentence: ");
        String str = new String(sc.nextLine());
        int counter = 0;
        char chr1 = 0;
        char chr2 = 0;
        int numChr1 = 0;
        int numChr2 = 0;
        char tempChr = 0;
        int tempNumChar = 0;

        for (int i = 0; i < str.length(); i++) {    // checks two most used chars
            for (int j = 0; j <str.length(); j++) {
                if (str.charAt(i) == str.charAt(j)) {
                    counter++;
                    if (counter > tempNumChar) {
                        tempChr = str.charAt(i);
                        tempNumChar = counter;
                    }
                }
            } if (tempNumChar > numChr1 && tempChr != ' ') {
                numChr1 = tempNumChar;
                chr1 = tempChr;
            } if (tempNumChar > numChr2 && tempNumChar < numChr1 && tempChr != ' ') {
                chr2 = tempChr;
                numChr2 = tempNumChar;
            }
            tempChr = 0;
            tempNumChar = 0;
            counter = 0;
        }

        String str2 = "";
        String str3 = "";

        for (int i = 0; i < str.length(); i++) {   // creates new string with switched chars
            if (str.charAt(i) == chr1) {
                if (i > 0) {
                    str3 = subString(str2, 0, i);
                }
                str2 = str3 + chr2 + subString(str, i+1, str.length());
            }
            else if (str.charAt(i) == chr2) {
                if (i > 0) {
                    str3 = subString(str2, 0, i);
                }
                str2 = str3 + chr1 + subString(str, i+1, str.length());
            }
        }
        return str2;
    }

    public static void main(String[] args) {
        String str = newString();
        System.out.println(str);
    }
}