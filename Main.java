import java.util.Arrays;
public class Main {
  public static void main(String[] args) {
		SingleDimensionArray sda = new SingleDimensionArray(4);
  	TwoDimensionalArray tda = new TwoDimensionalArray(2,2);
		sda.insert(0,0);
		sda.insert(1,1);
		sda.insert(2,2);
		sda.insert(3,3);
		sda.traverseArray();

		tda.insertValueInTheArray(0,0,0);
		tda.insertValueInTheArray(0,1,1);
		tda.insertValueInTheArray(1,0,2);
		tda.insertValueInTheArray(1,1,3);
		tda.traverse2DArray();
  }
}