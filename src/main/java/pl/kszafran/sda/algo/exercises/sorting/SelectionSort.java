package pl.kszafran.sda.algo.exercises.sorting;

public class SelectionSort implements IntSortingAlgorithm {

    @Override
    public void sort(int[] array) {
        for (int i = 0; i < array.length; i++) {
            int min = i;
            for (int j = 0; j < array.length; j++) {
                if (array[i] < array[j]) {
                    min = i;
                }
            }
        }
    }
}

