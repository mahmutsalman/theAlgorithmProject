import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Random {
    public Random() {

    }
    public void randomGenerator() {

        try {
            File myObj = new File("randomNumbers.txt");
            if (myObj.createNewFile()) {
                System.out.println("File created: " + myObj.getName());
            } else {
                System.out.println("File already exists.");
            }
            FileWriter myWriter = new FileWriter("randomNumbers.txt");
            BufferedWriter out = new BufferedWriter(myWriter);
            int i = 1;
            int j = 0;
            int setSize = 12;
            int numOfEach = 3;

            //TODO GENERATE RANDOM SETS, equal number of times of respectively 10, 100, 1000 elements. PLAIN
//            for (i = 0; i < setSize; i++) {
//                myWriter.write("Set " + i + ":");
//
//                for (j = 0; j < (int)(Math.pow(10,(i)/numOfEach+1)); j++) {
//                    String rand = String.valueOf((int)(Math.random() * 10000));
//                    if (j == Math.pow(10,(i)/numOfEach+1) - 1)
//                        myWriter.write(" " + rand + "\n");
//                    else
//                        myWriter.write(" " + rand + ",");
//                }
//            }
            //TODO GENERATE DUPLICATE DENSE SETS, equal number of times of respectively 10, 100, 1000 elements.
            for (i = 0; i < setSize; i++) {
                myWriter.write("Set " + i + ":");
                String[] tempArr = new String[(int)(Math.pow(10,(i)/numOfEach+1))];
                for (j = 0; j < Math.pow(10,(i)/numOfEach+1); j++) {
                    int sizeOfTempArr = 0;
                    while (tempArr[sizeOfTempArr] != null) {
                        sizeOfTempArr++;
                    }
                    int coin = (int)(Math.random()*2);
                    String rand = "";
                    if (coin == 0)
                        rand = String.valueOf((int)(Math.random() * 10000));
                    else if (coin == 1 && j == 0)
                        rand = String.valueOf((int)(Math.random() * 10000));
                    else if ( coin == 1 && j > 0)
                        rand = tempArr[(int)(Math.random() * sizeOfTempArr)];
                    if (j == Math.pow(10,(i)/numOfEach+1) - 1)
                        myWriter.write(" " + rand + "\n");
                    else
                        myWriter.write(" " + rand + ",");
                    boolean found = false;
                    for (int k = 0; k < j; k++) { //check if already exists
                        if (tempArr[k] == null)
                            break;
                        if (tempArr[k].equals(rand)) {
                            found = true;
                            break;
                        }
                    }
                    if (!found)
                        tempArr[sizeOfTempArr] = rand;
                }
            }


            myWriter.close();
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }

    }
}
