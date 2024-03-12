package visualizealgorithms.bll.algorithm;

public class SelectionSortAlgo extends GenericAlgorithm {

    public SelectionSortAlgo() {
        super("Selection Sort", "Sorts an array using the selection sort algorithm", AlgorithmType.SORTING);
    }

    @Override
    public void doWork() {
        // Perform selection sort algorithm
        int[] arr = (int[]) getData();
        selectionSort(arr);
    }

    private void selectionSort(int[] arr) {
        if (arr == null) {
            System.out.println("Array is null. Cannot perform sorting.");
            return; // or handle the null case according to your application's requirements
        }

        int n = arr.length;

        // One by one move boundary of unsorted subarray
        for (int i = 0; i < n - 1; i++) {
            // Find the minimum element in the unsorted array
            int min_idx = i;
            for (int j = i + 1; j < n; j++) {
                if (arr[j] < arr[min_idx]) {
                    min_idx = j;
                }
            }

            // Swap the found minimum element with the first element
            int temp = arr[min_idx];
            arr[min_idx] = arr[i];
            arr[i] = temp;
        }
    }
}
