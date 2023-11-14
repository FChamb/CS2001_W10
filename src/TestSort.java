import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;

public class TestSort {
    @Test
    public void testGetMergeArray() {
        int[] array = new int[]{7, 6, 8, 4, 2, 1, 9, 3, 5};
        MergeSort sort = new MergeSort(array);
        assertEquals(array, sort.getArray());
    }

    @Test
    public void testSortMergeArray() {
        int[] array = new int[]{7, 6, 8, 4, 2, 1, 9, 3, 5};
        MergeSort sort = new MergeSort(array);
        sort.sortArray();
        for (int i = 0; i < 9; i++) {
            array[i] = i;
        }
        assertEquals(array, sort.getArray());
    }

    @Test
    public void testGetSelectionArray() {
        int[] array = new int[]{7, 6, 8, 4, 2, 1, 9, 3, 5};
        SelectionSort sort = new SelectionSort(array);
        assertEquals(array, sort.getArray());
    }

    @Test
    public void testSortSelectionArray() {
        int[] array = new int[]{7, 6, 8, 4, 2, 1, 9, 3, 5};
        SelectionSort sort = new SelectionSort(array);
        sort.sortArray();
        for (int i = 0; i < 9; i++) {
            array[i] = i;
        }
        assertEquals(array, sort.getArray());
    }

    @Test
    public void testNullMergeArray() {
        int[] array = null;
        MergeSort sort = new MergeSort(array);
        sort.sortArray();
        assertEquals(array, sort.getArray());
    }

    @Test
    public void testNullSelectionArray() {
        int[] array = null;
        SelectionSort sort = new SelectionSort(array);
        sort.sortArray();
        assertEquals(array, sort.getArray());
    }

    @Test
    public void testEmptyMergeArray() {
        int[] array = new int[10];
        MergeSort sort = new MergeSort(array);
        sort.sortArray();
        assertEquals(array, sort.getArray());
    }

    @Test
    public void testEmptySelectionArray() {
        int[] array = new int[10];
        SelectionSort sort = new SelectionSort(array);
        sort.sortArray();
        assertEquals(array, sort.getArray());
    }

    @Test
    public void testOneMergeArray() {
        int[] array = new int[]{1};
        MergeSort sort = new MergeSort(array);
        sort.sortArray();
        assertEquals(array, sort.getArray());
    }

    @Test
    public void testOneSelectionArray() {
        int[] array = new int[]{1};
        SelectionSort sort = new SelectionSort(array);
        sort.sortArray();
        assertEquals(array, sort.getArray());
    }

}
