public class SelectionSort {
    private int[] array;

    /**
     * Constructor method for Selection sort. Takes in an array object to be sorted.
     * @param array to be sorted
     */
    public SelectionSort(int[] array) {
        this.array = array;
    }

    /**
     * Simple getter method which returns the array.
     * @return array in selection sort
     */
    public int[] getArray() {
        return this.array;
    }

    /**
     * Sort array uses a nested for loop to check every element in the array
     * against every other element and switch the places if the first item
     * is smaller than the second one.
     */
    public void sortArray() {
        if (this.array == null) {
            return;
        }
        for (int i = 0; i < this.array.length - 1; i++) {
            int baseCase = i;
            for (int j = i + 1; j < this.array.length; j++) {
                if (this.array[j] < this.array[baseCase]) {
                    baseCase = j;
                }
            }
            int temp = this.array[baseCase];
            this.array[baseCase] = this.array[i];
            this.array[i] = temp;
        }
    }
}
