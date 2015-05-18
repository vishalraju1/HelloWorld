import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import java.util.function.Predicate;

import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.collections4.PredicateUtils;


public class CommonsCollectionsTest {
	
	public static void main(String[] args) {
		
		List<String> strings = new ArrayList<String>();
		strings.add("Paul");
		strings.add(null);
		//CollectionUtils.addIgnoreNull(strings, null);
		System.out.println(strings);
		
		// Collate
		Set<String> srcList = new TreeSet<String>();
		srcList.add("Paul");
		srcList.add("Mason");
		srcList.add("Consulting");
		Set<String> destList = new TreeSet<String>();
		destList.add("PMC");
		destList.add("India");
		destList.add("Consulting");
		destList.add("Vadodara");
		System.out.println(CollectionUtils.collate(srcList, destList));
		// collate with custom comparator
		
		System.out.println(CollectionUtils.containsAll(strings, srcList));
		
		System.out.println(CollectionUtils.containsAny(strings, srcList));
		
		// remove the common
		System.out.println(CollectionUtils.disjunction(srcList,destList));
		
		// filter with Predicate , matchesAll with Predicate
		
		// check if empty this is null safe and isNotEmpty - this is also null safe check
		System.out.println(CollectionUtils.isEmpty(srcList));
		// same elements
		System.out.println(CollectionUtils.isEqualCollection(srcList, srcList));
		
		// same elements
		System.out.println(CollectionUtils.intersection(srcList, destList));
				
	
		
		// permutations of input colls
		Collection<List<String>> perms = CollectionUtils.permutations(srcList);
		System.out.println(perms);
		
		// Remove / Substract
		// System.out.println(CollectionUtils.removeAll(srcList, destList));
		
		
		// Consulting
		 System.out.println(CollectionUtils.retainAll(srcList, destList));
		
		// A+B 
		System.out.println(CollectionUtils.union(srcList,destList));
		
		// isFull - TBC 
		// Transformer - TBC
		
		// Predicate testPredicate = PredicateUtils.equalPredicate("d");
	    // Object test = CollectionUtils.find(collectionA, testPredicate);
	}

	
	
}
