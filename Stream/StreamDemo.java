package Stream;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamDemo {
    public static void main(String[] args) {
        // feature introduced in java 8
        // process collections of data in a functional and declarative manner
        // simplify data processing by writing smaller code
        //  embrace functional programming
        // improve readability and maintainability
        // enable easy parallelism

        //what is stream?
        // a sequence of elements supporting functional and declarative programming, it is interface
        // how to use stream?
        // Source, intermediate operations, terminal operation

        List<Integer> list= Arrays.asList(1,2,3,4,5,6,7,8,9);
        System.out.println(list.stream().filter(x->x%2==0).count());


        //creating streams
        // 1. from collections

        List<Integer> list1 = Arrays.asList(1,2,3,4,5,6,7,8,9);
        Stream<Integer> stream = list1.stream();
        //2. from Arrays
        String[] arr={"A","B","C"};
        Stream<String> stream1=Arrays.stream(arr);
        // Stream.of()
        Stream<String> stream2=Stream.of("A","B","C");
        //4. infinite stream
        Stream<Integer> stream3= Stream.generate(()->1).limit(100);
        List<Integer> stream4= Stream.iterate(1,x->x+1).limit(100).collect(Collectors.toList());
        System.out.println(stream4);



    }
}
