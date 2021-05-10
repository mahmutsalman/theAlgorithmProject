import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Reader {
    public ArrayList<Input> read() {

        ArrayList<Input> list = new ArrayList<Input>();
        String fileName = "C:\\Users\\engin\\IdeaProjects\\theAlgorithmProject\\sample";
        String line;
        try {
            FileReader fileReader = new FileReader(fileName);
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            while ((line = bufferedReader.readLine()) != null) {
                Input input = new Input();
                String name = line.substring(0,5);
                line = line.substring(7);
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







//import java.io.File;
//        import java.io.FileNotFoundException;
//        import java.util.ArrayList;
//        import java.util.Scanner;
//
//public class Reader {
//    public ArrayList<Input>() {
//        ArrayList<Input> list = new ArrayList<Input>();
//
//        try {
//            File myObj = new File("filename.txt");
//            Scanner myReader = new Scanner(myObj);
//            while (myReader.hasNextLine()) {
//                Input input = new Input();
//                int size = lineSize;
//                int arr[lineSize];
//                for (int i = 0; i < lineSize; i++) {
//                    arr[i] = myReader.nextInt();
//                }
//                input.size = lineSize;
//                input.setArr(arr);
//            }
//            myReader.close();
//        } catch (FileNotFoundException e) {
//            System.out.println("An error occurred.");
//            e.printStackTrace();
//        }
//
//
//        return list;
//    }
//}
