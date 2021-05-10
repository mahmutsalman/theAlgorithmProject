import java.util.ArrayList;

public class test {
    public static void main(String[] args) {
        // Set start variables
        int modN = 0;
        boolean generateNewSets = false;


        String[] mods = {"Plain", "Duplicate", "Sorted"};
        String mod = mods[modN];

        if (generateNewSets)
            RandomGenerator.randomGenerator(mod);

        ArrayList<Input> inputList = Reader.read(mod);
    }
}
