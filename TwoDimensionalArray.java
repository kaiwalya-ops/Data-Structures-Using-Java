public class TwoDimensionalArray{
	int arr[][] = null;
	public TwoDimensionalArray(int numOfRows,int numOfColumns){
		this.arr = new int[numOfRows][numOfColumns];
		for(int i=0;i<numOfRows;i++){
			for(int j=0;j<numOfColumns;j++){
				arr[i][j] = Integer.MIN_VALUE;
			}
		}
	}

	// Inserting a value
	public void insertValueInTheArray(int row,int column, int value){
		try{
			if(arr[row][column] == Integer.MIN_VALUE){
				this.arr[row][column] = value;
				System.out.println("Insertion Successful!");
			}
			else{
				System.out.println("Location Pre-occupied!");
			}
		}
		catch(ArrayIndexOutOfBoundsException e){
			System.out.println("Location Invalid!");
		}
	}

	// Accessing Value
	public void accessCell(int row, int column){
		System.out.println("Accessing Row : "+row+"\nAccessing Column : "+column);
		try{
			System.out.println("Value : "+arr[row][column]);
		}
		catch(ArrayIndexOutOfBoundsException e){
			System.out.println("Location Invalid!");
		}
	}

	// Traversing the 2D Array
	public void traverse2DArray(){
		for(int i=0;i<arr.length;i++){
			for(int j=0;j<arr[0].length;j++){
				System.out.print(arr[i][j]+" ");
			}
			System.out.println();
		}
	}

	// Searching for an element in 2D Array
	public void searchingValue(int value){
		for(int i=0;i<arr.length;i++){
			for(int j=0;j<arr[0].length;j++){
				if(arr[i][j] == value){
					System.out.println("Values is found at ("+i+","+j+")");
					return;
				}
			}
		}
		System.out.println("Value is not in the Array");
	}

	// Delete an element from 2D Array
	public void deleteValuefromArray(int row,int column){
		try{
			arr[row][column] = Integer.MIN_VALUE;
			System.out.println("Successfully Deleted!");
		}
		catch(ArrayIndexOutOfBoundsException e){
			System.out.println("Invalid Location!");
		}
	}
}