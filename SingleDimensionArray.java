public class SingleDimensionArray {
	int arr[] = null;

	public SingleDimensionArray(int sizeOfArray) {
		this.arr = new int[sizeOfArray];
		for (int i = 0; i < sizeOfArray; i++) {
			arr[i] = Integer.MIN_VALUE;
		}
	}

	// For Inserting Elements
	public void insert(int location, int valueToBeInserted) {
		try {
			if (arr[location] == Integer.MIN_VALUE) {
				arr[location] = valueToBeInserted;
				System.out.println("Insertion Successful!");
			} else
				System.out.println("Location Pre-occupied!");
		} catch (ArrayIndexOutOfBoundsException e) {
			System.out.println("Location Invalid!");
		}
	}

	// For Array Traversal
	public void traverseArray() {
		try {
			for (int i = 0; i < arr.length; i++) {
				System.out.print(arr[i] + " ");
			}
			System.out.println();
		} catch (Exception e) {
			System.out.println("Array Inaccessible!");
		}
	}

	// For Searching Element
	public void searchInArray(int valueToSearch) {
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] == valueToSearch) {
				System.out.println("Value is at Index : " + i);
				return;
			}
		}
		System.out.println(valueToSearch + " not in the Array!");
	}

	// Delete Element from the Array
	public void deleteValue(int valueToDeleteIndex) {
		try {
			arr[valueToDeleteIndex] = Integer.MIN_VALUE;
			System.out.println("Successfully Deleted!");
		} catch (ArrayIndexOutOfBoundsException e) {
			System.out.println("Location Invalid!");
		}
	}
}