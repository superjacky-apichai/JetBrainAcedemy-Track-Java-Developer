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
        System.out.printf("Found %d / %d entries.Time taken:  %s\n\n", phoneBook.searching(phoneBook.findList, phoneBook.directoryMap), phoneBook.findList.size(), returnTime(start, System.currentTimeMillis()));


        System.out.println("Start searching (bubble sort + jump search)...");
        Collections.sort(phoneBook.findList);
        long end1 = System.currentTimeMillis();

        long start2 = System.currentTimeMillis();
        phoneBook.find();
        long end2 = System.currentTimeMillis();
        System.out.printf("Found %d / %d entries.Time taken: %s\n", phoneBook.searching(phoneBook.findList, phoneBook.directoryMap), phoneBook.findList.size(), returnTime(start1, System.currentTimeMillis()));
        System.out.printf("Sorting time: %s\n", returnTime(start1, end1));
        System.out.printf("Searching time: %s\n", returnTime(start2, end2));

    }


    static String returnTime(long start, long end) {
        long timeMs = end - start;
        long timeSec = timeMs / 1000;
        long timeMin = timeSec / 60;
        timeMs %= 100;
        timeSec %= 60;

        return timeMin + " min. " + timeSec + " sec. " + timeMs + " ms.";

    }


}