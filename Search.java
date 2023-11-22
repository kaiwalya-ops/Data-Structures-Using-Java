public class Search {
    
    public int linearSearch(int arr[],int value){
        for(int i=0;i<arr.length;i++){
            if(arr[i] == value){
                System.out.println("The element is found at : "+i);
                return i;
            }
        }
        System.out.println("The element '"+value+"' was not found");
        return -1;
    }
    
    public int binarySearch(int arr[],int value){
        int left = 0;
        int right = arr.length-1;
        while(left<=right){
            int middle = (right+left)/2;
            if(arr[middle] == value){
                System.out.println("The element is found at : "+middle);
                return middle;
            }
            if(value < arr[middle])
            right = middle-1;
            else
            left = middle+1;
        }
        System.out.println("The element '"+value+"' was not found");
        return -1;
    }
}
