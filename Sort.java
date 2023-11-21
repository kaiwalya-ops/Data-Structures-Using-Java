import java.util.ArrayList;
import java.util.Collections;
public class Sort {
    public void print(int[] arr){
        for(int i=0;i<arr.length;i++){
            System.out.print(arr[i]+" ");
        }
        System.out.println();
    }

    public void bubbleSort(int[] arr){
        int n = arr.length;
        for(int i=0;i<n-1;i++){
            for(int j=0;j<n-i-1;j++){
                if(arr[j] > arr[j+1]){
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
        }
        System.out.print("The Array Sorted Using Bubble Sort : ");
        print(arr);
    }

    public void selectionSort(int[] arr){
        int n = arr.length;
        for(int j = 0;j < n; j++){
            int minIndex = j;
            for(int i = j+1;i<n;i++)
                if(arr[i] < arr[minIndex]) 
                    minIndex = i;
            if(minIndex != j){
                int temp = arr[j];
                arr[j] = arr[minIndex];
                arr[minIndex] = temp;
            }
        }
        System.out.print("The Array Sorted Using Selection Sort : ");
        print(arr);
    }
    
    public void insertionSort(int[] arr){
        int n = arr.length;
        for(int i = 0;i < n; i++){
            for(int j = i;j > 0; j--)
            if(arr[j]<arr[j-1]){
                int temp = arr[j];
                arr[j] = arr[j-1];
                arr[j-1] = temp;
            }
        }
        System.out.print("The Array Sorted Using Insertion Sort : ");
        print(arr);
    }
    
    public void bucketSort(int[] arr){
        int numOfBuckets = (int) Math.ceil(Math.sqrt(arr.length));
        
        int max = Integer.MIN_VALUE;
        for(int value : arr) if (max < value) max = value;
        
        ArrayList<Integer>[] buckets = new ArrayList[numOfBuckets];
        for(int i=0;i<numOfBuckets;i++) buckets[i] = new ArrayList<>();

        for(int value:arr){
            int bucketNumber = (int) Math.ceil((float)value * numOfBuckets / (float)max);
            buckets[bucketNumber-1].add(value);
        }
        
        for(ArrayList<Integer> bucket : buckets) Collections.sort(bucket);

        int index = 0;
        for(ArrayList<Integer> bucket : buckets){
            for(int value:bucket){
                arr[index] = value;
                index++;
            }
        }
        System.out.print("The Array Sorted Using Bucket Sort : ");
        print(arr);
    }
    
    public static void merge(int[] A, int left,int middle,int right){
        int[] leftTemp = new int[middle-left+2];
        int[] rightTemp = new int[right-middle+1];
        for (int i=0;i<=middle-left;i++) leftTemp[i] = A[left+i];
        for (int i=0;i<right-middle;i++) rightTemp[i] = A[middle+i+1];

        leftTemp[middle-left+1] = Integer.MAX_VALUE;
        rightTemp[right-middle] = Integer.MAX_VALUE;
        
        int i=0,j=0;
        for(int k=left;k<=right;k++){
            if(leftTemp[i]<rightTemp[j]) {
                A[k] = leftTemp[i];
                i++;
            }
            else{
                A[k] = rightTemp[j];
                j++;
            }
        }
    }
    private void mergeSort(int[] arr,int left,int right){
        if(right > left){
            int m = (left+right)/2;
            mergeSort(arr,left,m);
            mergeSort(arr,m+1,right);
            merge(arr,left,m,right);
        }
    }
    public void mergeSort(int[] arr){
        mergeSort(arr,0,arr.length-1);
        System.out.print("The Array Sorted Using Merge Sort : ");
        print(arr);
    }

    private static int partition(int[] arr, int start, int end){
        int i = start-1;
        for(int j=start;j<=end;j++){
            if(arr[j] <= arr[end]){
                i++;
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        return i;
    }
    private void quickSort(int[] arr,int start,int end){
        if(start < end){
            int pivot = partition(arr,start,end);
            quickSort(arr,start,pivot-1);
            quickSort(arr,pivot+1,end);
        }
    }
    public void quickSort(int[] arr){
        quickSort(arr,0,arr.length-1);
        System.out.print("The Array Sorted Using Quick Sort : ");
        print(arr);
    }
    
    public void heapSort(int[] arr){
        BinaryHeap heap = new BinaryHeap(arr.length,"Min");
        for(int i:arr) heap.insert(i);
        for(int i=0;i<arr.length;i++) arr[i] = heap.extract();
        System.out.print("The Array Sorted Using Heap Sort : ");
        print(arr);
    }
}
