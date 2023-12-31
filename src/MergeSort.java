public class MergeSort {
    private int[] array;

    /**
     * Constructor method for Merge sort. Takes in an array object to be sorted.
     * @param array to be sorted
     */
    public MergeSort(int[] array) {
        this.array = array;
    }

    /**
     * Simple getter method which returns the array.
     * @return array in merge sort
     */
    public int[] getArray() {
        return this.array;
    }

    /**
     * Sort array checks that the array is not null. If it is, the output is
     * final. Otherwise, the array is passed to the recursive sort method.
     */
    public void sortArray() {
        if (this.array == null) {
            return;
        }
        sort(0, this.array.length - 1);
    }

    /**
     * Sort is a recursive method which handles half of the merge sort functionality.
     * This method acts as the divide half of the conquer and divide portion.
     * This method takes a left and right index spot and splits the array for these
     * values in half until only one object remains. Afterward, merge is called.
     * @param left index for the starting spot in array
     * @param right index for the ending spot in array
     */
    private void sort(int left, int right) {
        if (left < right) {
            int middle = left + (right - left) / 2;
            sort(left, middle);
            sort(middle + 1, right);
            merge(left, middle, right);
        }
    }

    /**
     * Merge acts as conquer half of the conquer and divide portion.
     * This method creates new place-holder arrays for the given
     * indexes. Then each of the values from both arrays are compared
     * and places in the appropriate place depending on where they belong.
     * @param left starting index for the array
     * @param middle middle index for the array
     * @param right end index for the array
     */
    private void merge(int left, int middle, int right) {
        int size1 = middle - left + 1;
        int size2 = right - middle;
        int[] leftSide = new int[size1];
        int[] rightSide = new int[size2];
        for (int i = 0; i < size1; i++) {
            leftSide[i] = this.array[left + i];
        }
        for (int j = 0; j < size2; j++) {
            rightSide[j] = this.array[middle + 1 + j];
        }
        int i = 0;
        int j = 0;
        int k = left;
        while (i < size1 && j < size2) {
            if (leftSide[i] <= rightSide[j]) {
                this.array[k] = leftSide[i];
                i++;
            } else {
                this.array[k] = rightSide[j];
                j++;
            }
            k++;
        }
        while (i < size1) {
            this.array[k] = leftSide[i];
            i++;
            k++;
        }
        while (j < size2) {
            this.array[k] = rightSide[j];
            j++;
            k++;
        }
    }
}