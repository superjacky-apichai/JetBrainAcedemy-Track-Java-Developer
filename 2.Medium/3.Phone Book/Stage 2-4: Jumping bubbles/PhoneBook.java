package phonebook;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class PhoneBook {

    Map<String, String> directoryMap;

    List<String> findList;


     int searching(List<String> find, Map<String, String> directory) {
        int count = 0;

        for (String finds : find) {

            if (directory.containsKey(finds)) {
                count++;
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
        Map<String, String> directoryMap = new HashMap<>();
        while (scannerDirectory.hasNext()) {
            String[] storeValue = scannerDirectory.nextLine().split(" ");
            if (storeValue.length == 3) {
                storeValue[1] += " " + storeValue[2];
            }
            directoryMap.put(storeValue[1], storeValue[0]);

        }

        this.directoryMap = directoryMap;

    }



}
