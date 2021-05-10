import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Reader {
    public ArrayList<Input> read() {

        ArrayList<Input> list = new ArrayList<Input>();
        String fileName = "C:\\Users\\engin\\IdeaProjects\\theAlgorithmProject\\randomNumbers.txt";
        String line;
        try {
            FileReader fileReader = new FileReader(fileName);
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            while ((line = bufferedReader.readLine()) != null) {
                Input input = new Input();
                int index = line.indexOf(':');
                String name = line.substring(0,index);
                line = line.substring(index + 2);
                String[] inputNumbers = line.split(", ");
                int numbers[] = new int[inputNumbers.length];
                System.out.println(inputNumbers.length);
                for (int i = 0; i < inputNumbers.length; i++) {
                    numbers[i] = Integer.parseInt(inputNumbers[i]);
                }
                input.setName(name);
                input.setArr(numbers);
                list.add(input);
            }
            bufferedReader.close();
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();

        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return list;
    }
}

