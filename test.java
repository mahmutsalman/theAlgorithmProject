/* Analysis of Algorithms Homework -1
@authors Mahmut Salman 150118506
         Engin Bektaş  150118501
*/
import java.util.ArrayList;

public class test {
    public static void main(String[] args) {

        // Set start variables
        int modNumber = 0;
        boolean generateNewSets = true;

        // Random generator settings
        int setSize = 6;
        int numOfEach = 1;

        // Input types below
        String[] mods = { "Plain", "Duplicate", "Sorted", "Gap", "CountingSort" };
        String mod = mods[modNumber];

        if (generateNewSets)
            RandomGenerator.randomGenerator(mod, setSize, numOfEach);

        ArrayList<Input> inputList = Reader.read(mod);

        System.out.print("Algorithm: CountingSort, Type: " + mods[modNumber] + ": ");
        for (Input input : inputList) {

            long start = System.nanoTime();

            // Test cases are tested by one by like below
            // Sorting operations
            // Algorithms.recursiveQuickSort(input.getArr(), 0, input.getArr().length-1);
            // Algorithms.quickSortMedian(input.getArr());
            // Algorithms.mergeSort(input.getArr(), 0, input.getArr().length - 1);
            // Algorithms.heapSort(input.getArr());
            //Algorithms.countingsort(input.getArr(), input.getArr().length);
            // Algorithms.insertionSort(input.getArr());
            //Algorithms.binaryInsertionSort(input.getArr());
            Algorithms.recQuickSort(input.getArr(),0,input.getArr().length-1);


            long end = System.nanoTime();
            long elapsedTime = end - start;

            System.out.print(elapsedTime + " ");

        }




    }
}
