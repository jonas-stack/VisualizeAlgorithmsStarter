package visualizealgorithms.bll.algorithm;

public class TimSortAlgo extends GenericAlgorithm{

    static int MIN_MERGE = 32;

    public TimSortAlgo() {
        super("TimSortAlgo", "Uses Hybrid devide and Conquer", AlgorithmType.SORTING);
    }

    @Override
    public void doWork() {
        int[] arr = (int[]) getData();
        timSort(arr, arr.length);
    }

    public static int minRunLength(int n){
        assert n >= 0;

        int r = 0;
        while (n >= MIN_MERGE){
            r |= (n & 1);
            n >>= 1;
        }
        return n + r;
    }

    public static void insertionSort(int[] arr, int left,
                                     int right)
    {
        for (int i = left + 1; i <= right; i++) {
            int temp = arr[i];
            int j = i - 1;
            while (j >= left && arr[j] > temp) {
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = temp;
        }
    }

    // Merge function merges the sorted runs
    public static void merge(int[] arr, int l, int m, int r)
    {
        // Original array is broken in two parts
        // left and right array
        int len1 = m - l + 1, len2 = r - m;
        int[] left = new int[len1];
        int[] right = new int[len2];
        for (int x = 0; x < len1; x++) {
            left[x] = arr[l + x];
        }
        for (int x = 0; x < len2; x++) {
            right[x] = arr[m + 1 + x];
        }

        int i = 0;
        int j = 0;
        int k = l;

        // After comparing, we merge those two array
        // in larger sub array
        while (i < len1 && j < len2) {
            if (left[i] <= right[j]) {
                arr[k] = left[i];
                i++;
            }
            else {
                arr[k] = right[j];
                j++;
            }
            k++;
        }

        // Copy remaining elements
        // of left, if any
        while (i < len1) {
            arr[k] = left[i];
            k++;
            i++;
        }

        // Copy remaining element
        // of right, if any
        while (j < len2) {
            arr[k] = right[j];
            k++;
            j++;
        }
    }

    private void timSort(int[] arr, int length) {
        {
            int minRun = minRunLength(MIN_MERGE);

            // Sort individual subarrays of size RUN
            for (int i = 0; i < length; i += minRun) {
                insertionSort(
                        arr, i,
                        Math.min((i + MIN_MERGE - 1), (length - 1)));
            }

            // Start merging from size
            // RUN (or 32). It will
            // merge to form size 64,
            // then 128, 256 and so on
            // ....
            for (int size = minRun; size < length; size = 2 * size) {

                // Pick starting point
                // of left sub array. We
                // are going to merge
                // arr[left..left+size-1]
                // and arr[left+size, left+2*size-1]
                // After every merge, we
                // increase left by 2*size
                for (int left = 0; left < length; left += 2 * size) {

                    // Find ending point of left sub array
                    // mid+1 is starting point of right sub
                    // array
                    int mid = left + size - 1;
                    int right = Math.min((left + 2 * size - 1),
                            (length - 1));

                    // Merge sub array arr[left.....mid] &
                    // arr[mid+1....right]
                    if (mid < right)
                        merge(arr, left, mid, right);
                }
            }
        }
    }
}

