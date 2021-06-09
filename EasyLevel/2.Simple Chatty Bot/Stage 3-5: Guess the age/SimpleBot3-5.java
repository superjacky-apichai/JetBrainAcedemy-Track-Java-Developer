package bot;
//Stage 3/5: Guess the age
import java.util.Scanner;

public class SimpleBot {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Hello! My name is Aid.");
        System.out.println("I was created in 2018.");
        System.out.println("Please, remind me your name.");

        String name = scanner.nextLine();

        System.out.println("What a great name you have, " + name + "!");
        System.out.println("Let me guess your age.");
        System.out.println("Enter remainders of dividing your age by 3, 5 and 7.");

        int reminder1 = scanner.nextInt();
        int reminder2 = scanner.nextInt();
        int reminder3 = scanner.nextInt();

        reminder1 = (reminder1 % 3) * 70;
        reminder2 = (reminder2 % 5) * 21;
        reminder3 = (reminder3 % 7) * 15;
        int sum = (reminder1 + reminder2 + reminder3) % 105;

        System.out.printf("Your age is %d; that's a good time to start programming!", sum);
    }
}
