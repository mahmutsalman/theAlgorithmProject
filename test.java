import java.util.ArrayList;

public class test {
    public static void main(String[] args) {
        String[] mods = {"Plain", "Duplicate", "Sorted"};
        String mod = mods[0];

        RandomGenerator random = new RandomGenerator();
        random.randomGenerator(mod);

        Reader reader = new Reader();
        ArrayList<Input> inputList = reader.read(mod);
    }
}
