import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Enumeration;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class CollectionsTest {

	public static void main(String[] args) {

		// add arrays to list/collections
		List<String> strings = new ArrayList<String>();
		strings.add("Paul");
		Collections.addAll(strings, "Mason", "Consulting"); // T could be array
		System.out.println(strings);

		//CollectionUtils.addAll(Collection C , Enum / Iter / C[]);
		
		// binary search - needs to be sorted by asc order otherwise results are
		// not predicted
		List<String> binStrings = new ArrayList<String>();
		Set<String> sortedStrings = new TreeSet<String>();
		Collections.addAll(sortedStrings, "Paul", "Mason", "Consulting","India", "Pvt", "Ltd");
		binStrings.addAll(sortedStrings);
		int indexLoc = Collections.binarySearch(binStrings, "Pvt");
		System.out.println("Element your searched for is at index " + indexLoc);

		// Note :Arrays.binarySearch on primitives and also from to to index search
		
		// static and runtime type check of the collections
		List<String> chkStrings = new ArrayList<String>();
		chkStrings.add("Paul");
		chkStrings.add("Mason");
		//chkStrings = Collections.checkedList(chkStrings,String.class);
		ThirdPartyLibrary tpl = new ThirdPartyLibrary();
		tpl.doSomethingOnCollection(chkStrings);
		
		
		// copy list - if dest list is shorter then src list then index out of bound
		List<String> srcList = new ArrayList<String>();
		srcList.add("Paul");
		srcList.add("Mason");
		srcList.add("Consulting");
		List<String> destList = new ArrayList<String>();
		destList.add("PMC");
		destList.add("India");
		destList.add("SubhanPura");
		destList.add("Vadodara");
		Collections.copy(destList,srcList);
		System.out.println(destList);

		// returns true if collections has no common element - based on equals
		boolean hasAnyCommon = Collections.disjoint(srcList,destList);
		System.out.println(hasAnyCommon);
		
		// Couple EMPTY refer List , Map , Iterator - those are immutable
		
		// CollectionUtils.emptyCollection() - 		Returns the immutable EMPTY_COLLECTION with generic type safety.
		// CollectionUtils.emptyIfnull (Coll c) - Returns empty collection if arg is null 
		
		
		// return underlying Enumerations - legacy support
		Enumeration<String> enumms = Collections.enumeration(srcList); 

		List<String> emptyList = Collections.EMPTY_LIST; // this is immutable
		// emptyList.add("default"); // this will throw un supported exception as its immu
		
		List<String> fillList = new ArrayList<String>();
		fillList.add("default1");fillList.add("default2");
		Collections.fill(fillList,"Paul");
		System.out.println(fillList);
	
		List<String> frequencyList = new ArrayList<String>();
		frequencyList.add("PMC");
		frequencyList.add("India");
		frequencyList.add("SubhanPura");
		frequencyList.add("Vadodara");
		int freq = Collections.frequency(frequencyList,"India");
		System.out.println("Frequency is " + freq);
		
		// CollectionsUtils.cardinality 
		
		List<String> mainList = new ArrayList<String>();
		mainList.add("Paul");
		mainList.add("Mason");
		mainList.add("Consulting");
		List<String> subList = new ArrayList<String>();
		subList.add("Mason");
		subList.add("Consulting");
		int find = Collections.indexOfSubList(mainList, subList);
		System.out.println(find);
		int lind = Collections.lastIndexOfSubList(mainList, subList);
		System.out.println(lind);
		
		// class must imple, comparable - natural ordering sort by default
		List<Integer> nums = Arrays.asList(5,20,50,2,11);
		System.out.println("Max = "+ Collections.max(nums));
		System.out.println("Max = "+ Collections.min(nums));
		
		List<String> copyListImu= Collections.nCopies(5,"Paul");
		//copyListImu.add("Mason");
		System.out.println(copyListImu);
		
		// 		Collections.newSetFromMap(map)
		
		List<String> replList = new ArrayList<String>();
		replList.add("Paul");
		replList.add("Mason");
		replList.add("Consulting");
		System.out.println(Collections.replaceAll(replList, "Paul" , "PMC")); // repl is modified
		
		Collections.reverse(replList);
		System.out.println(replList);
		
		Collections.sort(nums, Collections.reverseOrder());
		System.out.println(nums);
		
		//shuffle is pending
		
		
		List<String> single = Collections.singletonList("One");
		//single.add("Two");
		System.out.println(single);
		
		// comparator
		List<String> numbers = new ArrayList<String>();
		numbers.add("PBXU");
		numbers.add("ABC");
		numbers.add("Z");
		numbers.add("ZY");
		Collections.sort(numbers , new StringLengthComparator ());
		System.out.println(numbers);
		
		// swap 0 and 1 index
		Collections.swap(numbers, 0, 1);
		System.out.println(numbers);
		//Collections.sh
		List<String> unmodList = new ArrayList<String>();
		unmodList.add("Paul");
		unmodList.add("Mason");
		unmodList.add("Consulting");
		unmodList = Collections.unmodifiableList(unmodList);
		System.out.println(unmodList.get(0));
//		unmodList.add("Vadodara");
	}
	
	static class StringLengthComparator implements Comparator<String>{
		@Override
		public int compare(String o1, String o2) {
			return o1.toString().length() - o2.toString().length();
		}
	}

	static class ThirdPartyLibrary {
		public void doSomethingOnCollection(List myList) {
			myList.add(12.12);
		}
	}
	
	static class SyncTest{
		public void trySynChronizedList(){
		List<String> syncList = Collections.synchronizedList(new ArrayList<String>());
		Thread t1 = new Thread(new Runnable() {
			@Override
			public void run() {
			try {
				Thread.currentThread().sleep(5000);
				
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			syncList.add("Adding First and going to slip");
			
			}
		});
		
		Thread t2 = new Thread(new Runnable() {
			@Override
			public void run() {
			try {
				Thread.currentThread().sleep(5000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			syncList.add("Adding second and going to slip");
			
			}
		});
		
		t1.start();
		t2.start();
		}
	}
}
