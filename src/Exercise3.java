import java.util.Scanner;

public class Exercise3 {
    public static int[] decomposeIntoPrimeNumbers (int num) {
        int numCopy = num;
        int prime = 2;
        int count = 0;
        while (num > 1) {  //determines array length
            if (num % prime == 0) {
                count++;
                num = num / prime;
            } else {
                prime += 1;
            }
        }

        int[] arrOfPrimes = new int[count];
        int primeCopy = 2;

        while (numCopy > 1) {  //stores primes into array
            for (int i = 0; i < count; i++) {
                if (numCopy % primeCopy == 0) {
                    arrOfPrimes[i] = primeCopy;
                    numCopy = numCopy / primeCopy;
                } else {
                    primeCopy = primeCopy + 1;
                    --i;
                }
            }
        } return arrOfPrimes;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Please enter a number: ");
        int num = sc.nextInt();
        int[] arrOfPrimes = decomposeIntoPrimeNumbers(num);
        System.out.print("{");
        for (int i = 0; i < arrOfPrimes.length - 1; i++) {
            System.out.print(arrOfPrimes[i] + ",");
        } System.out.print(arrOfPrimes[arrOfPrimes.length - 1] + "}");
    }
}