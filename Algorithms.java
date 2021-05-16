import java.util.Arrays;

public class Algorithms {
    public Algorithms() {

    }

    public static void insertionSort(int array[]) {
        int size = array.length;

        for (int step = 1; step < size; step++) {
            int key = array[step];
            int j = step - 1;

            // Compare key with each element on the left of it until an element smaller than
            // it is found.
            // For descending order, change key<array[j] to key>array[j].
            while (j >= 0 && key < array[j]) {
                array[j + 1] = array[j];
                --j;
            }

            // Place key at after the element just smaller than it.
            array[j + 1] = key;
        }
    }

    public static void binaryInsertionSort(int array[])
    {
        for (int i = 1; i < array.length; i++)
        {
            int x = array[i];

            int j = Math.abs(
                    Arrays.binarySearch(array, 0,
                            i, x) + 1);

            System.arraycopy(array, j,
                    array, j + 1, i - j);

            array[j] = x;
        }
    }




    public static void merge(int arr[], int p, int q, int r) {
        // Create L ← A[p..q] and M ← A[q+1..r]
        int n1 = q - p + 1;
        int n2 = r - q;

        int L[] = new int[n1];
        int M[] = new int[n2];

        for (int i = 0; i < n1; i++)
            L[i] = arr[p + i];
        for (int j = 0; j < n2; j++)
            M[j] = arr[q + 1 + j];

        // Maintain current index of sub-arrays and main array
        int i, j, k;
        i = 0;
        j = 0;
        k = p;

        // Until we reach either end of either L or M, pick larger among
        // elements L and M and place them in the correct position at A[p..r]
        while (i < n1 && j < n2) {
            if (L[i] <= M[j]) {
                arr[k] = L[i];
                i++;
            } else {
                arr[k] = M[j];
                j++;
            }
            k++;
        }

        // When we run out of elements in either L or M,
        // pick up the remaining elements and put in A[p..r]
        while (i < n1) {
            arr[k] = L[i];
            i++;
            k++;
        }

        while (j < n2) {
            arr[k] = M[j];
            j++;
            k++;
        }
    }

    public static void mergeSort(int arr[], int l, int r) {
        if (l < r) {

            // m is the point where the array is divided into two subarrays
            int m = (l + r) / 2;

            mergeSort(arr, l, m);
            mergeSort(arr, m + 1, r);

            // Merge the sorted subarrays
            merge(arr, l, m, r);
        }
    }

    // For quick sort pivoting the mid element
    public static void quickSortMedian(int a[]){
        int left = 0;
        int right = a.length-1;

        quickSortM(a, left, right);
    }

    private static void quickSortM(int a[], int left, int right){

        // If both cursor scanned the complete array quicksort exits
        if(left >= right)
            return;

        // For the simplicity, we took the right most item of the array as a pivot
        int pivot = a[right];
        int partition = partitionMedian(a, left, right, pivot);

        // Recursively, calls the quicksort with the different left and right parameters of the sub-array
        quickSortM(a, 0, partition-1);
        quickSortM(a, partition+1, right);
    }

    private static int partitionMedian(int a[], int left, int right, int pivot){
        int leftCursor = left-1;
        int rightCursor = right;
        while(leftCursor < rightCursor){
            while(a[++leftCursor] < pivot);
            while(rightCursor > 0 && a[--rightCursor] > pivot);
            if(leftCursor >= rightCursor){
                break;
            }else{
                swapMedian(a, leftCursor, rightCursor);
            }
        }
        swapMedian(a, leftCursor, right);
        return leftCursor;
    }

    public static void swapMedian(int a[], int left, int right){
        int temp = a[left];
        a[left] = a[right];
        a[right] = temp;
    }

    // For quick sort pivoting the first element
    public static int partition(int[] a, int left, int right) {
        int pivot = a[left];
        while(left<=right) {
            while(a[left] < pivot)
                left++;
            while(a[right] > pivot)
                right--;
            if(left<=right) {
                int tmp = a[left];
                a[left] = a[right];
                a[right] = tmp;
                left++;
                right--;
            }
        }
        return left;
    }

    public static void recursiveQuickSort(int[] a, int i, int j) {
        int idx = partition(a, i, j);
        if(i < idx-1) {
            recursiveQuickSort(a, i, idx-1);
        }
        if(j > idx) {
            recursiveQuickSort(a, idx, j);
        }
    }
    // For heap sort
    public static void heapify(int arr[], int n, int i) {
        // Find largest among root, left child and right child
        int largest = i;
        int l = 2 * i + 1;
        int r = 2 * i + 2;

        if (l < n && arr[l] > arr[largest])
            largest = l;

        if (r < n && arr[r] > arr[largest])
            largest = r;

        // Swap and continue heapifying if root is not largest
        if (largest != i) {
            int swap = arr[i];
            arr[i] = arr[largest];
            arr[largest] = swap;

            heapify(arr, n, largest);
        }
    }

    public static void heapSort(int arr[]) {
        int n = arr.length;

        // Build max heap
        for (int i = n / 2 - 1; i >= 0; i--) {
            heapify(arr, n, i);
        }

        // Heap sort
        for (int i = n - 1; i >= 0; i--) {
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;

            // Heapify root element
            heapify(arr, i, 0);
        }
    }

    public static void countingsort(int array[], int size) {
        int[] output = new int[size + 1];

        // Find the largest element of the array
        int max = array[0];
        for (int i = 1; i < size; i++) {
            if (array[i] > max)
                max = array[i];
        }
        int[] count = new int[max + 1];

        // Initialize count array with all zeros.
        for (int i = 0; i < max; ++i) {
            count[i] = 0;
        }

        // Store the count of each element
        for (int i = 0; i < size; i++) {
            count[array[i]]++;
        }

        // Store the cummulative count of each array
        for (int i = 1; i <= max; i++) {
            count[i] += count[i - 1];
        }

        // Find the index of each element of the original array in count array, and
        // place the elements in output array
        for (int i = size - 1; i >= 0; i--) {
            output[count[array[i]] - 1] = array[i];
            count[array[i]]--;
        }

        // Copy the sorted elements into original array
        for (int i = 0; i < size; i++) {
            array[i] = output[i];
        }
    }
}
