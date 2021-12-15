package phonebook;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {

        long start = System.currentTimeMillis();
        Map<String, String> directoryMap = directory();

        List<String> findList = find();
        System.out.println("Start searching...");

        long end = System.currentTimeMillis();
        System.out.printf("Found %d / %d entries. %s\n", searching(findList, directoryMap), findList.size(), returnTime(start, end));

    }

    static String returnTime(long start, long end) {
        long timeMs = end - start;
        long timeSec = timeMs / 1000;
        long timeMin = timeSec / 60;
        timeMs %= 100;
        timeSec %= 60;

        return "Time taken: " + timeMin + " min. " + timeSec + " sec. " + timeMs + " ms.";

    }

    static int searching(List<String> find, Map<String, String> directory) {
        int count = 0;

        for (String finds : find) {

            if (directory.containsKey(finds)) {
                count++;
            }
        }


        return count;
    }

    static List<String> find() throws FileNotFoundException {
        File find = new File("C:\\find.txt");
        Scanner scanner = new Scanner(find);
        List<String> findList = new ArrayList<>();

        while (scanner.hasNext()) {
            findList.add(scanner.nextLine());
        }
        return findList;
    }

    static Map<String, String> directory() throws FileNotFoundException {

        File directory = new File("C:\\directory.txt");
        Scanner scannerDirectory = new Scanner(directory);
        Map<String, String> directoryMap = new HashMap<>();
        while (scannerDirectory.hasNext()) {
            String[] storeValue = scannerDirectory.nextLine().split(" ");
            if (storeValue.length == 3) {
                storeValue[1] += " " + storeValue[2];
            }
            directoryMap.put(storeValue[1], storeValue[0]);

        }

        return directoryMap;

    }

}
