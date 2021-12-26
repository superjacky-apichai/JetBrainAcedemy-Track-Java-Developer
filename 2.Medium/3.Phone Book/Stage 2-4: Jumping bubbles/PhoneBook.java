package phonebook;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class PhoneBook {

    Map<String, String> directoryMap = new HashMap<>();
    List<String> findList = new ArrayList<>();
    List<String> directoryList = new ArrayList<>();


    int searching() {
        int count = 0;

        for (String value : findList) {

            for (String s : directoryList) {
                if (value.equals(s)) {
                    count++;
                    break;
                }
            }
        }


        return count;
    }

    void find() throws FileNotFoundException {
        File find = new File("C:\\find.txt");
        Scanner scanner = new Scanner(find);
        List<String> findList = new ArrayList<>();

        while (scanner.hasNext()) {
            findList.add(scanner.nextLine());
        }
        this.findList = findList;
    }

    void directory() throws FileNotFoundException {

        File directory = new File("C:\\directory.txt");
        Scanner scannerDirectory = new Scanner(directory);

        while (scannerDirectory.hasNext()) {
            String[] storeValue = scannerDirectory.nextLine().split(" ");
            if (storeValue.length == 3) {
                storeValue[1] += " " + storeValue[2];
            }
            this.directoryMap.put(storeValue[1], storeValue[0]);
            this.directoryList.add(storeValue[1]);

        }


    }

    void bubbleSort() {
        System.out.println("Start searching (bubble sort + jump search)...");
        long start = System.currentTimeMillis();

        try {

            for (int i = 0; i < this.directoryList.size(); i++) {
                for (int j = 0; j < this.directoryList.size() - 1; j++) {
                    if (directoryList.get(j).compareToIgnoreCase(directoryList.get(j + 1)) > 0) {
                        String backup = directoryList.get(j + 1);
                        directoryList.remove(j + 1);
                        directoryList.add(j, backup);
                    }
                    start = Math.abs(System.currentTimeMillis() - start);

                }
            }

        } catch (Exception e) {
            long start1 = System.currentTimeMillis();
            System.out.printf("Found %d / %d entries.Time taken:  %s\n\n", searching(), findList.size(), Main.returnTime(Math.abs(start - System.currentTimeMillis())));
            long end1 = System.currentTimeMillis();
            System.out.println("Sorting time: " + Main.returnTime(start) + " - STOPPED, moved to linear search");
            System.out.printf("Searching time: %s\n", Main.returnTime(end1 - start1));
        }


    }

    int jumpSearch() {
        int count = -1;


        int step = (int) Math.floor(Math.sqrt(directoryList.size()));

        for (String s : findList) {

            for (int j = 0; j < directoryList.size(); j += step) {

                if (s.equalsIgnoreCase(directoryList.get(j))) {
                    count++;

                } else if (s.compareToIgnoreCase(directoryList.get(j)) < 0) {
                    if (j > 0) {
                        for (int g = j - step; g < j; g++) {
                            if (s.equalsIgnoreCase(directoryList.get(g))) {
                                count++;
                                break;

                            }
                        }

                    }

                }


                if (j + step >= directoryList.size()) {
                    for (int b = j+1; b < directoryList.size(); b++) {
                        if (s.equalsIgnoreCase(directoryList.get(b))) {
                            count++;
                            break;
                        }

                    }

                }

            }
        }

        return count;
    }

}