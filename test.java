
import java.util.ArrayList;

public class test {
    public static void main(String[] args) {

        // Set start variables
        int modNumber = 1;
        boolean generateNewSets = false;

        // Random generator settings
        int setSize = 6;
        int numOfEach = 1;

        String[] mods = { "Plain", "Duplicate", "Sorted", "Gap", "CountingSort" };
        String mod = mods[modNumber];

        if (generateNewSets)
            RandomGenerator.randomGenerator(mod, setSize, numOfEach);

        ArrayList<Input> inputList = Reader.read(mod);

        System.out.print("Algorithm: CountingSort, Type: " + mods[modNumber] + ": ");
        for (Input input : inputList) {

            long start = System.nanoTime();

            // Sorting operation
            //Algorithms.recursiveQuickSort(input.getArr(), 0, input.getArr().length-1);
            //Algorithms.quickSortMedian(input.getArr());
             // Algorithms.mergeSort(input.getArr(), 0, input.getArr().length - 1);
             //Algorithms.heapSort(input.getArr());
             Algorithms.countingsort(input.getArr(), input.getArr().length);

            long end = System.nanoTime();
            long elapsedTime = end - start;

            System.out.print(elapsedTime + " ");

        }




    }
}
