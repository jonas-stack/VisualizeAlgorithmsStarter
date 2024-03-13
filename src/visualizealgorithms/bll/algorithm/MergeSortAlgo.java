package visualizealgorithms.bll.algorithm;

public class MergeSortAlgo extends GenericAlgorithm {

    // Constructor to initialize the MergeSortAlgo
    public MergeSortAlgo() {
        // Call the superclass constructor to set the algorithm name, description, and type
        super("MergeSortAlgo", "Uses divide-and-conquer approach (is recursive)", AlgorithmType.SORTING);
    }

    // Method to perform the merge sort algorithm
    @Override
    public void doWork() {
        // Retrieve the data (an array of integers) from the superclass
        int[] arr = (int[]) getData();
        // Call the mergeSort method to sort the array
        mergeSort(arr, arr.length);
    }

    // Recursive method to perform the merge sort algorithm on an array
    public static void mergeSort(int[] a, int n) {
        // Base case: if the array length is less than 2, it is already sorted
        if (n < 2) {
            return;
        }
        // Calculate the midpoint of the array
        int mid = n / 2;
        // Create left and right subarrays
        int[] l = new int[mid];
        int[] r = new int[n - mid];

        // Populate the left subarray
        for (int i = 0; i < mid; i++) {
            l[i] = a[i];
        }
        // Populate the right subarray
        for (int i = mid; i < n; i++) {
            r[i - mid] = a[i];
        }

        // Recursively sort the left and right subarrays
        mergeSort(l, mid);
        mergeSort(r, n - mid);

        // Merge the sorted left and right subarrays
        merge(a, l, r, mid, n - mid);
    }

    // Method to merge two sorted subarrays into a single sorted array
    public static void merge(int[] a, int[] l, int[] r, int left, int right) {
        // Initialize variables for iterating through the left and right subarrays, and the merged array
        int i = 0, j = 0, k = 0;
        // Compare elements from the left and right subarrays and merge them into the main array
        while (i < left && j < right) {
            if (l[i] <= r[j]) {
                a[k++] = l[i++];
            } else {
                a[k++] = r[j++];
            }
        }
        // Copy any remaining elements from the left subarray
        while (i < left) {
            a[k++] = l[i++];
        }
        // Copy any remaining elements from the right subarray
        while (j < right) {
            a[k++] = r[j++];
        }
    }
}
