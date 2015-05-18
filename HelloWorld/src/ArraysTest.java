import java.util.Arrays;
import java.util.List;


public class ArraysTest {

	
	public static void main(String[] args) {
		List<String> strings = Arrays.asList("Paul","Mason");
		System.out.println(strings);
		
		int[] myarr = new int[]{1,2,3};
		int[] myanotherarr = Arrays.copyOf(myarr, 4);
		System.out.println(myanotherarr) ;// 4th element padded with zero
		
		// Arrays.copyOfRange(original, from, to)
		
		// Arrays.fill

		// Arrays, parellelPrefix , TBC 
		
		// Arrays.ParallelSort
		
		// Arrays.class Sort (which uses quick sort)
		
		// Pending
		// Arrays.deepHC , deepToString and deepEq and splititerator  
	}
}
