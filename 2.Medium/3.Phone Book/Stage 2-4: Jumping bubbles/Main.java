package phonebook;

import java.io.FileNotFoundException;
import java.util.Collections;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {


        System.out.println("Start searching (linear search)...");
        long start = System.currentTimeMillis();
        PhoneBook phoneBook = new PhoneBook();
        phoneBook.directory();
        phoneBook.find();
        long start1 = System.currentTimeMillis();
        System.out.printf("Found %d / %d entries.Time taken:  %s\n\n", phoneBook.searching(), phoneBook.findList.size(), returnTime(System.currentTimeMillis() - start));

        System.out.println("Start searching (bubble sort + jump search)...");
        Collections.sort(phoneBook.directoryList);
        long end1 = System.currentTimeMillis();
        long start2 = System.currentTimeMillis();
        int count = phoneBook.jumpSearch();
        long end2 = System.currentTimeMillis();
        System.out.printf("Found %d / %d entries.Time taken: %s\n", count, phoneBook.findList.size(), returnTime(end2 - start1));
        System.out.printf("Sorting time: %s\n", returnTime(end1 - start1));
        System.out.printf("Searching time: %s\n", returnTime(end2 - start2));

    }


    static String returnTime(long timeMs) {

        long timeSec = timeMs / 1000;
        long timeMin = timeSec / 60;
        timeMs %= 100;
        timeSec %= 60;

        return timeMin + " min. " + timeSec + " sec. " + timeMs + " ms.";

    }


}

