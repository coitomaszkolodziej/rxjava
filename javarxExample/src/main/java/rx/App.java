package rx;

import rx.*;
/**
 * Hello world!
 *
 */
public class App 
{

    public static void main( String[] args )
    {
  
        Integer[] numbers = { 0, 1, 2, 3, 4, 5 };

        Observable numberObservable = Observable.from(numbers);

        numberObservable.subscribe(
                (incomingNumber) -> System.out.println("incomingNumber " + incomingNumber),
                (error) -> System.out.println("Something went wrong" + ((Throwable)error).getMessage()),
                () -> System.out.println("This observable is finished")
        );
    }
	

}
