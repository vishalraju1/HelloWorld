import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class SessionJDK8 {

	public static void main(String[] args) {
		// function as input T and output R
		Function<Integer, String> myFunction = x -> x.toString();
		String returnValue = myFunction.apply(500);
		System.out.println(returnValue);

		// supplier  - supplies T
		Supplier<Double> mySupplier = () -> Double.valueOf(Math.random());
		System.out.println(mySupplier.get());
		
		//consumer
		Consumer<String> myConsumer = x -> System.out.println(x.concat("PMC"));
		myConsumer.accept("I work with ");

		// predicate
		Predicate<String> myPredicate = x -> x!=null;
		System.out.println(myPredicate.test(null));
		System.out.println(myPredicate.test("PMC"));
		
		// variations - consumer which accepts two type and process
		BiConsumer<String, String> myBiConsumer =  (x,y) -> {x = x.concat(y);};
		BiConsumer<String,String> myFinalConsumer = myBiConsumer.andThen((x,y) -> {x = x.toLowerCase(); System.out.println(x);});
		
		myFinalConsumer.accept("I Like ", "PIZZA");
		
	}
}
