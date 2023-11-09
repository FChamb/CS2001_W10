import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Date;
import java.util.Random;

public class Test {
    public static void main(String[] args) {
        Test test = new Test();
        test.runTest(5000, 10);
    }

    public Test() {

    }

    public int[] fillRandom(int number, int random) {
        int[] array = new int[number];
        Random generate = new Random();
        for (int i = 0; i < number; i++) {
            array[i] = generate.nextInt(random);
        }
        return array;
    }

    public void runTest(int runTime, int accuracy) {
        FileWriter write;
        try {
            write = createFile();
            for (int i = 1; i <= runTime; i++) {
                long total = 0;
                long total2 = 0;
                for (int j = 0; j < accuracy; j++) {
                    int[] array = fillRandom(i, i);
                    MergeSort mergeSort = new MergeSort(array);
                    SelectionSort selectionSort = new SelectionSort(array);
                    long time = System.nanoTime();
                    mergeSort.sortArray();
                    long time2 = System.nanoTime();
                    long difference = time2 - time;
                    total += difference;
                    long time3 = System.nanoTime();
                    selectionSort.sortArray();
                    long time4 = System.nanoTime();
                    long difference2 = time4 - time3;
                    total2 += difference2;
                }
                write.write(total / 10 + ",");
                write.write(total2 / 10 + "\n");
            }
            write.close();
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
        System.out.println("Done with Test.");
    }

    public FileWriter createFile() throws IOException {
        Date date = new Date();
        File output = new File("../data/" + date.getTime() + ".csv");
        try {
            if (output.createNewFile()) {
                System.out.println("Creating new file: " + output.getName());
            } else {
                System.out.println("Writing to file: " + output.getName());
            }
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
        return new FileWriter(output.getAbsoluteFile());
    }
}
