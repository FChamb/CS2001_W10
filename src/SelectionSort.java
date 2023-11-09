public class SelectionSort {
    private int[] array;

    public SelectionSort(int[] array) {
        this.array = array;
    }

    public int[] getArray() {
        return this.array;
    }

    public void sortArray() {
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
