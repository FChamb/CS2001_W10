import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

public class Test {
    /**
     * runTime and accuracy are the default run configuration variables
     * for which the program will test on. These can be changed to any
     * user defined value.
     * runTime is the max size array to be tested (every array size up to this number)
     * accuracy is the average number of iterations to be run for the sort functions
     */
    private int runTime = 500;
    private int accuracy = 20000;

    /**
     * Main method creates a new Test class and runs runTest. This runs
     * the specification required tests to create a data set. The commented
     * line, test.testFunctions() can be uncommented and run to show output and
     * functionality for merge and selection sort. Used in Testing section of report.
     * @param args command line arguments, not used in this method
     */
    public static void main(String[] args) {
        Test test = new Test();
//        test.testFunctions();
        test.runTest();
    }

    /**
     * Default constructor. Does nothing, just enables running other methods.
     */
    public Test() {}

    /**
     * Another constructor used to change the runTime and accuracy
     * values. Not used in this class.
     * @param runTime max size of array
     * @param accuracy average iterations
     */
    public Test(int runTime, int accuracy) {
        this.runTime = runTime;
        this.accuracy = accuracy;
    }

    /**
     * Fill random takes a number value and creates an
     * array for that size. Then it is filled with random number up
     * to the provided number.
     * @param number integer size of array
     * @return array filled with random numbers
     */
    public int[] fillRandom(int number) {
        int[] array = new int[number];
        Random generate = new Random();
        for (int i = 0; i < number; i++) {
            array[i] = generate.nextInt(number);
        }
        return array;
    }

    /**
     * Fill ordered takes a number value and creates an
     * array for that size. Then it is filled with an ordered list
     * of numbers up to the provided number.
     * @param number integer size of array
     * @return array filled with random numbers
     */
    public int[] fillOrdered(int number) {
        int[] array = new int[number];
        for (int i = 0; i < number; i++) {
            array[i] = i;
        }
        return array;
    }

    /**
     * Fill reversed takes a number value and creates an
     * array for that size. Then it is filled with a reverse list
     * of numbers up to the provided number.
     * @param number integer size of array
     * @return array filled with random numbers
     */
    public int[] fillReversed(int number) {
        int[] array = new int[number];
        for (int i = number - 1; i >= 0; i--) {
            array[i] = i;
        }
        return array;
    }

    /**
     * Test function creates random even and odd array with fill random and then
     * tests both merge and selection with these arrays. The output is printed to
     * the terminal to show the correct results.
     */
    public void testFunctions() {
        int[] array = fillRandom(10);
        int[] array2 = fillRandom(9);
        System.out.println("________Merge________");
        MergeSort mergeSort = new MergeSort(array);
        MergeSort mergeSort2 = new MergeSort(array2);
        System.out.println("Here are the arrays...");
        System.out.println("\nEven array:");
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println("\nOdd array:");
        for (int i = 0; i < array2.length; i++) {
            System.out.print(array2[i] + " ");
        }
        System.out.println("\nSorting...");
        mergeSort.sortArray();
        mergeSort2.sortArray();
        System.out.println("Returning result...");
        array = mergeSort.getArray();
        array2 = mergeSort2.getArray();
        System.out.println("\nEven array:");
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println("\nOdd array:");
        for (int i = 0; i < array2.length; i++) {
            System.out.print(array2[i] + " ");
        }
        System.out.println("\n_____________________");
        array = fillRandom(10);
        array2 = fillRandom(9);
        System.out.println("________Selection________");
        SelectionSort selectionSort = new SelectionSort(array);
        SelectionSort selectionSort2 = new SelectionSort(array2);
        System.out.println("Here are the arrays...");
        System.out.println("\nEven array:");
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println("\nOdd array:");
        for (int i = 0; i < array2.length; i++) {
            System.out.print(array2[i] + " ");
        }
        System.out.println("\nSorting...");
        selectionSort.sortArray();
        selectionSort2.sortArray();
        System.out.println("Returning result...");
        array = selectionSort.getArray();
        array2 = selectionSort2.getArray();
        System.out.println("\nEven array:");
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println("\nOdd array:");
        for (int i = 0; i < array2.length; i++) {
            System.out.print(array2[i] + " ");
        }
        System.out.println("\n_________________________");
    }

    /**
     * Run test is where a majority of functionality lies. This class uses a file writer
     * to write the output of the test to a ../data/ file. A nested for loop creates a new
     * random array every iteration and passes it to both sort methods. This is done in a for
     * loop which repeats for the runTime, i.e. each size array. Then another for loop repeats
     * this test up to the accuracy value, i.e. average iterations. Each time, the time is grabbed
     * before and after the sort is called. Then these values are subtracted and added to the total.
     * At the end of the second for loop, the average is calculated by dividing by the total number of
     * iterations and wrote to the correct file. This is repeated until every array size has been tested.
     * Nanoseconds are chosen to give more precision. Each variable is initialized outside the for loops
     * for efficiency.
     */
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
                    array = fillRandom(i);
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

    /**
     * Initializes a file writer for the test method above. A try catch loop checks if the file
     * exists or if it needs to be created.
     * @return FileWriter for the test method
     * @throws IOException as a file writer is created
     */
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
