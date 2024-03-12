package visualizealgorithms.bll.algorithm;

public class BubbleSortAlgo extends GenericAlgorithm {

    public BubbleSortAlgo() {
        super("Bubble Sort", "Sorts an array using the bubble sort algorithm", AlgorithmType.SORTING);
    }

    @Override
    public void doWork() {
        // Perform bubble sort algorithm
        int[] arr = (int[]) getData();
        bubbleSort(arr);
    }

    private void bubbleSort(int[] arr) {
        if (arr == null) {
            System.out.println("Array is null. Cannot perform sorting.");
            return; // or handle the null case according to your application's requirements
        }

        int n = arr.length;
        boolean swapped;

        // One by one move boundary of unsorted subarray
        for (int i = 0; i < n - 1; i++) {
            swapped = false;
            // Last i elements are already in place, so no need to check them
            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    // Swap arr[j] and arr[j+1]
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    swapped = true;
                }
            }
            // If no two elements were swapped in the inner loop, array is already sorted
            if (!swapped) {
                break;
            }
        }
    }
}
