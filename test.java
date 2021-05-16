import java.util.ArrayList;

public class test {
    public static void main(String[] args) {

        // Set start variables
        int modNumber = 4;
        boolean generateNewSets = true;

        // Random generator settings
        int setSize = 2;
        int numOfEach = 1;

        String[] mods = {"Plain", "Duplicate", "Sorted", "Gap", "CountingSort"};
        String mod = mods[modNumber];

        if (generateNewSets)
            RandomGenerator.randomGenerator(mod, setSize, numOfEach);

        ArrayList<Input> inputList = Reader.read(mod);
    }
}
