package pl.kszafran.sda.algo.exercises.sorting;

public class Quicksort implements IntSortingAlgorithm {

    /*
    for each (unsorted) partition
set first element as pivot
  storeIndex = pivotIndex + 1
  for i = pivotIndex + 1 to rightmostIndex
    if element[i] < element[pivot]
      swap(i, storeIndex); storeIndex++
  swap(pivot, storeIndex - 1)
    */

    @Override
    public void sort(int[] array) {
        int pivot = array[0];
        int index = 1;
        for (int j = 1; j < array.length; j++) {
            if (array[j] < pivot) {
                swapMinus(array, pivot, index);
                swapPlus(array, pivot, index);
            }
        }
    }

    private void swapPlus(int[] array, int pivot, int index) {

        index++;
        int temp = array[pivot];
        array[pivot] = array[index];
        array[index] = temp;
    }

    public void swapMinus(int[] array, int pivot, int index) {
        index--;
        int temp = array[pivot];
        array[pivot] = array[index];
        array[index] = temp;

    }
/*
    public void swap(int[] array, int a, int b) {

    }
*/
}


