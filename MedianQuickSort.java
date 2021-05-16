public class MedianQuickSort {


    public static void main(String[] args) {

    }

    // This method sorts an array and internally calls quickSort
    public static void quickSortMedian(int a[]){
        int left = 0;
        int right = a.length-1;

        quickSortM(a, left, right);
    }

    // This method is used to sort the array using quicksort algorithm.
    // It takes the left and the right end of the array as the two cursors.
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

    // This method is used to partition the given array and returns the integer which points to the sorted pivot index
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

    // This method is used to swap the values between the two given index
    public static void swapMedian(int a[], int left, int right){
        int temp = a[left];
        a[left] = a[right];
        a[right] = temp;
    }

}