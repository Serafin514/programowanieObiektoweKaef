package pl.kszafran.sda.algo.exercises.sorting;

public class SelectionSort implements IntSortingAlgorithm {

    @Override
    public void sort(int[] array) {
        int min =array[0];
        for (int i = 0; i < array.length; i++) {
            if (array[i] < array[i+1]) {
                swap(array,i,i+1);
            }
        }
    }

    private void swap(int[] array, int a, int b) {
        int valA = array[a];
        int valB = array[b];

        array[a] = valB;
        array[b] = valA;
    }

    private void swap2(int[] array, int a, int b) {
        int temp = array[a];
        array[a] = array[b];
        array[b] = temp;
    }
}

