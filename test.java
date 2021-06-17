import java.io.Reader;
import java.util.Scanner;

public class test {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Guess: ");
        // char c = scan.next(".").charAt(0);
        char c = scan.findInLine(".").charAt(0);

        System.out.println(c);


        scan.close();
    }
    
}
