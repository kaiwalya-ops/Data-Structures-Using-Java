public class Main {
  public static void main(String[] args) {
    Sort sort = new Sort();
    int arr[] = {10,5,30,15,50,6};
    sort.print(arr);
    sort.bubbleSort(arr.clone());
    sort.selectionSort(arr.clone());
    sort.insertionSort(arr.clone());
    sort.bucketSort(arr.clone());
    sort.mergeSort(arr.clone());
    sort.quickSort(arr.clone());
    sort.heapSort(arr.clone());
  }
}