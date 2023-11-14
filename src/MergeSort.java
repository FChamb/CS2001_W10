public class MergeSort {
    private int[] array;
    public MergeSort(int[] array) {
        this.array = array;
    }

    public int[] getArray() {
        return this.array;
    }

    public void sortArray() {
        if (this.array == null) {

        }
        sort(0, this.array.length - 1);
    }

    private void sort(int left, int right) {
        if (left < right) {
            int middle = left + (right - left) / 2;
            sort(left, middle);
            sort(middle + 1, right);
            merge(left, middle, right);
        }
    }

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