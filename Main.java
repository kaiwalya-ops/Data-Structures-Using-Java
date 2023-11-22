public class Main {
  public static void main(String[] args) {
    int arr[] = {1,2,3,4,5,6,7,8,9,10};
    Search search = new Search();
    search.linearSearch(arr,5);
    search.linearSearch(arr,11);

    search.binarySearch(arr,5);
    search.binarySearch(arr,11);
  }
}