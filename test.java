
import java.util.ArrayList;

public class test {
    public static void main(String[] args) {

        // Set start variables
        int modNumber = 0;
        boolean generateNewSets = true;

        // Random generator settings
        int setSize = 6;
        int numOfEach = 1;

        String[] mods = { "Plain", "Duplicate", "Sorted", "Gap", "CountingSort" };
        String mod = mods[modNumber];

        if (generateNewSets)
            RandomGenerator.randomGenerator(mod, setSize, numOfEach);

        ArrayList<Input> inputList = Reader.read(mod);

        System.out.print("Insert algo name here: ");
        for (Input input : inputList) {

            long start = System.nanoTime();

            // Sorting operation
            // Algorithms.quickSort(input.getArr(), 0, input.getArr().length-1);
            // Algorithms.mergeSort(input.getArr(), 0, input.getArr().length - 1);
            Algorithms.heapSort(input.getArr());

            long end = System.nanoTime();
            long elapsedTime = end - start;

            System.out.print(elapsedTime + " ");

        }


    }
}
