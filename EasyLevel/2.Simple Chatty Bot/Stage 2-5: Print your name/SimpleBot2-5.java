package bot;
//Stage 2/5: Print your name
import java.util.Scanner;

public class SimpleBot {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Hello! My name is Aid.");
        System.out.println("I was created in 2018.");
        System.out.println("Please, remind me your name.");

        String myName = scanner.next();

        System.out.println("What a great name you have, "+myName+"!");
    }
}