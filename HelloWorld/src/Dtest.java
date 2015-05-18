import java.util.ArrayList;
import java.util.List;



public class Dtest {
public static void main(String[] args) {
	System.out.println(Runtime.getRuntime().freeMemory());
	List<Integer> lsts= new ArrayList<Integer>();
	for(int i = 0 ; i < 1000;i++)
		lsts.add(i);
	System.out.println(Runtime.getRuntime().freeMemory());
	
}
}
