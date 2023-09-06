import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
public class Main {
  public static void main(String[] args) {
		ArrayList<String> stringList = new ArrayList<>();
		stringList.add("A");
		stringList.add("B");
		stringList.add("C");
		stringList.add("D");
		stringList.add("E");
		for(int i=0;i<stringList.size();i++){
			System.out.print(stringList.get(i));
		}
		System.out.println();
		for(String letter:stringList){
			System.out.print(letter);
		}
		System.out.println();
		Iterator<String> iterator = stringList.iterator();
		while(iterator.hasNext()){
			System.out.print(iterator.next());
		}
		System.out.println();

		for(String letter: stringList){
			if(letter.equals("D")){
				System.out.println("The Element is Found!!");
				break;
			}
		}

		int index = stringList.indexOf("C");
		System.out.println("The Element : C is at Index : "+index);
		index = stringList.indexOf("F");
		System.out.println("The Element : F is at Index : "+index);

		stringList.remove(2);
		System.out.println(stringList);

		
  }
}