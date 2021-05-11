import java.util.ArrayList;

public class test {
    public static void main(String[] args) {

        // Set start variables
        int modNumber = 0;
        boolean generateNewSets = false;

        String[] mods = {"Plain", "Duplicate", "Sorted"};
        String mod = mods[modNumber];

        if (generateNewSets)
            RandomGenerator.randomGenerator(mod);

        ArrayList<Input> inputList = Reader.read(mod);
    }
}
