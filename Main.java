import java.util.Arrays;
public class Main {
  public static void main(String[] args) {
  	TwoDimensionalArray tda = new TwoDimensionalArray(3,3);
		tda.insertValueInTheArray(0,0,10);
		tda.insertValueInTheArray(0,1,1);
		tda.insertValueInTheArray(0,3,1);

		tda.traverse2DArray();
		
		tda.accessCell(0,1);

		tda.deleteValuefromArray(0,0);
  }
}