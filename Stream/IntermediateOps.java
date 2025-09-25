package Stream;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class IntermediateOps {
    public static void main(String[] args) {
        // intermediate operations transform a stream into another stream
        // they are lazy, meaning they don't execute until a terminal operations is
        // invoked

        // 1. filter
        List<String> list = Arrays.asList("Ram", "Shyam", "Ghanshyam","Aksath","Ram");
        Stream<String> filteredStream = list.stream().filter(x -> x.startsWith("R"));
        // no filtering at this point
        long res = list.stream().filter(x -> x.startsWith("R")).count();
        System.out.println(res);

        // 2.map
        List<String> list1 = list.stream().map(String::toUpperCase).collect(Collectors.toList());
        System.out.println(list1);

        //3. sorted
        Stream<String> stream=list.stream().sorted();
        Stream<String> stream1=list.stream().sorted((a,b)->a.length()-b.length());

        //distinct
        System.out.println(list.stream().distinct().count());

        //5.limit
        System.out.println(Stream.iterate(1,x->x+1).limit(10));;

        //6.skip
        System.out.println(Stream.iterate(1,x->x+1).skip(10).limit(100).count());

        //7. peek
        // perform action on each element as it is consumed
        System.out.println(Stream.iterate(1,x->x+1).limit(100).peek(System.out::println).count());

        //flatMap
        //handles streams of collections, lists or arrays where each element is itself a collection
        // flatten nested structures (e,g list within list) so that they can be processed as a single sequence of elements
        // transform and flatten elements at the same time

        List<List<String>> listList=Arrays.asList(
                Arrays.asList("banana", "kiwi"),
                Arrays.asList("mango", "apple"),
                Arrays.asList("pear", "grapes")
        );
        System.out.println(listList.get(1).get(1));
        System.out.println(listList.stream().flatMap(Collection::stream)//it will give streams
                .map(String::toUpperCase).toList());

    }
}
