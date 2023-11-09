import java.util.Date;
import java.util.Random;

public class Test {
    public static void main(String[] args) {
        Test test = new Test();
        int[] array = test.fillRandom(811, 1000000000);
        MergeSort mergeSort = new MergeSort(array);
        SelectionSort selectionSort = new SelectionSort(array);
        System.out.println("--- MergeSort ---");
        long time = System.currentTimeMillis();
        System.out.println("Start: " + time);
        mergeSort.sortArray();
        long time2 = System.currentTimeMillis();
        System.out.println("End: " + time2);
        System.out.println("Time: " + (time2 - time));
//        System.out.println(mergeSort.getArray());
        System.out.println("-----------------");
        System.out.println("--- SelectionSort ---");
        time = System.currentTimeMillis();
        System.out.println("Start: " + time);
        selectionSort.sortArray();
        time2 = System.currentTimeMillis();
        System.out.println("End: " + time2);
        System.out.println("Time: " + (time2 - time));
//        System.out.println(selectionSort.getArray());
        System.out.println("---------------------");
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
}
