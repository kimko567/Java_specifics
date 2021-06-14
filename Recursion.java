
import java.util.Scanner;

public class Recursion {

    static Scanner sc = new Scanner(System.in);

    static public void ievade(int i, int A[]) {
        A[A.length - i] = sc.nextInt();
        if (i > 1) {
            ievade(i - 1, A);
        }

    }

    static public void parask(int i, int count, int A[]) {

        if (A[i] % 2 == 0) {
            count++;
        }
        if (i < A.length - 1) {
            parask(i + 1, count, A);
        } else {
            System.out.println(count);
        }

    }

    public static void main(String[] args) {
	
        System.out.println("count:");
        int count = sc.nextInt();
        int A[] = new int[count];
        
        System.out.println("numbers:");
        ievade(count, A);
        
        System.out.println("result:");
        parask(0, 0, A);

    }

}
