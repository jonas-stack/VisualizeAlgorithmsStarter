package visualizealgorithms.bll.algorithm;

public class QuickSortAlgo extends GenericAlgorithm {

    public QuickSortAlgo() {
        super("QuickSortAlgo", "Uses divide-and-conquer approach", AlgorithmType.SORTING);
    }

    @Override
    public void doWork() {
        int[] arr = (int[]) getData();
        quickSort(arr, 0, arr.length - 1); // Corrected method call
    }

    private void quickSort(int[] array, int low, int high) {
        if (low < high) {
            int pivotIndex = partition(array, low, high);
            quickSort(array, low, pivotIndex - 1);
            quickSort(array, pivotIndex + 1, high);
        }
    }

    private int partition(int[] array, int low, int high) {
        int pivot = array[high];
        int i = low - 1;
        for (int j = low; j < high; j++) {
            if (array[j] < pivot) {
                i++;
                swap(array, i, j);
            }
        }
        swap(array, i + 1, high);
        return i + 1;
    }

    private void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
}
