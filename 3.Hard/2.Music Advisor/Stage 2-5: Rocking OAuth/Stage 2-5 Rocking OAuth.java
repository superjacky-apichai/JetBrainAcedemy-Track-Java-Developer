package advisor;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        while (true) {
            String choice = scanner.nextLine();
            if (choice.equals("exit")) {
                System.out.println("---GOODBYE!---");
                return;
            } else if (choice.equals("auth")) {
                System.out.println("https://accounts.spotify.com/authorize?client_id=YOURCLIENT&redirect_uri=https://www.example.com&response_type=code");
                System.out.println("---SUCCESS---");
                while (true) {
                    String choice1 = scanner.nextLine();
                    if (choice1.equals("exit")) {
                        System.out.println("---GOODBYE!---");
                        return;
                    } else {
                        interfaceWindows(choice1);
                    }
                }

            } else {
                System.out.println("Please, provide access for application.");
            }
        }
    }


    static void interfaceWindows(String choice) {

        switch (choice) {
            case "new":
                System.out.println("---NEW RELEASES---\n" +
                        "Mountains [Sia, Diplo, Labrinth]\n" +
                        "Runaway [Lil Peep]\n" +
                        "The Greatest Show [Panic! At The Disco]\n" +
                        "All Out Life [Slipknot]");
                break;
            case "featured":
                System.out.println("---FEATURED---\n" +
                        "Mellow Morning\n" +
                        "Wake Up and Smell the Coffee\n" +
                        "Monday Motivation\n" +
                        "Songs to Sing in the Shower");
                break;
            case "categories":
                System.out.println("---CATEGORIES---\n" +
                        "Top Lists\n" +
                        "Pop\n" +
                        "Mood\n" +
                        "Latin");
                break;
            case "playlists Mood":
                System.out.println("---MOOD PLAYLISTS---\n" +
                        "Walk Like A Badass  \n" +
                        "Rage Beats  \n" +
                        "Arab Mood Booster  \n" +
                        "Sunday Stroll");
                break;
        }

    }

}
