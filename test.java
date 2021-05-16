import java.time.Duration;
import java.time.Instant;
import java.util.ArrayList;

public class test {
    public static void main(String[] args) {

        // Set start variables
        int modNumber = 0;
        boolean generateNewSets = true;

        // Random generator settings
        int setSize = 6;
        int numOfEach = 1;

        String[] mods = {"Plain", "Duplicate", "Sorted", "Gap", "CountingSort"};
        String mod = mods[modNumber];

        if (generateNewSets)
            RandomGenerator.randomGenerator(mod, setSize, numOfEach);

        ArrayList<Input> inputList = Reader.read(mod);

        System.out.print("Insert algo name here: ");
            for (Input input: inputList) {

                long start = System.nanoTime();

//                int sortedArray[] = sort ( input.getArr() ) ;

                long end = System.nanoTime();
                long elapsedTime = end - start;


                System.out.print(elapsedTime + " ");


// some time passes


                // time passes


            }

//        System.out.println("s");

    }
}
