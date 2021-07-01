package recognition;

import java.util.*;

public class Main {
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        //Store value of grid
        System.out.println("Input grid:");
        char[] grid = new char[9];
        String line = "";

        //input 3*3 grid
        for (int i = 0; i < 3; i++) {
            line += scanner.nextLine();

        }
        //Convert String to charArray
        for (int j = 0; j < 9; j++) {
            grid[j] = line.charAt(j);
        }
        //Convert X/O to 0/1 by inputNeuron Method
        int[] neuron = inputNeuron(grid);

        //Output the result
        System.out.println("This number is " + findNumber(neuron));

    }

    //this method calculate the result
    public static int findNumber(int[] grid) {
        int[] weight = {2, 1, 2, 4, -4, 4, 2, -1, 2, -5};
        int sum = 0;
        for (int j = 0; j < 9; j++) {
            sum += grid[j] * weight[j];
        }
        sum += weight[weight.length - 1];
        if (sum > 0) {
            return 0;
        } else {
            return 1;
        }
    }

    // This method Convert X/O to 0/1
    public static int[] inputNeuron(char[] grid) {
        int[] neuron = new int[9];
        for (int i = 0; i < 9; i++) {

            if (grid[i] == 'X') {
                neuron[i] = 1;
            } else if (grid[i] == '_') {
                neuron[i] = 0;
            }

        }
        return neuron;
    }
}
