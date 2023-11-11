import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

public class Test {
    private int runTime;
    private int accuracy;
    public static void main(String[] args) {
        Test test = new Test(500, 20000);
        test.runTest();
    }

    public Test(int runTime, int accuracy) {
        this.runTime = runTime;
        this.accuracy = accuracy;
    }

    public int[] fillRandom(int number, int random) {
        int[] array = new int[number];
        Random generate = new Random();
        for (int i = 0; i < number; i++) {
            array[i] = generate.nextInt(random);
        }
        return array;
    }

    public void runTest() {
        int run = this.runTime;
        int acc = this.accuracy;
        FileWriter write;
        try {
            int array[];
            MergeSort mergeSort;
            SelectionSort selectionSort;
            long time, time2, time3, time4, difference, difference2;
            write = createFile();
            write.write(",MergeSort,SelectionSort\n");
            for (int i = 1; i <= run; i++) {
                long total = 0;
                long total2 = 0;
                for (int j = 0; j < acc; j++) {
                    array = fillRandom(i, i);
                    mergeSort = new MergeSort(array);
                    selectionSort = new SelectionSort(array);
                    time = System.nanoTime();
                    mergeSort.sortArray();
                    time2 = System.nanoTime();
                    difference = time2 - time;
                    total += difference;
                    time3 = System.nanoTime();
                    selectionSort.sortArray();
                    time4 = System.nanoTime();
                    difference2 = time4 - time3;
                    total2 += difference2;
                }
                write.write(i + "," + total / acc + ",");
                write.write(total2 / acc + "\n");
            }
            write.close();
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
        System.out.println("Done with Test.");
    }

    public FileWriter createFile() throws IOException {
        File output = new File("../data/" + this.runTime + "-" + this.accuracy + ".csv");
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
