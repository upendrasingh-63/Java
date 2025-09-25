package Stream;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class TerminalOps {
    public static void main(String[] args) {
        List<Integer> list= Arrays.asList(1,2,3,4,5,6,7,8,9);

        //1. collect
        list.stream().skip(1).collect(Collectors.toList());
        list.stream().skip(1).toList();

        //2. forEach
        list.stream().forEach(System.out::println);

        //3. reduce
        Optional<Integer> optionalInteger= list.stream().reduce((a, b)->a+b);//sum of all digits, and will return optional
        //Optional is a type of box that means value can be present or not
        System.out.println(optionalInteger.get());

        //4. count

        //5. anyMatch, allMatch, noneMatch they all give true or false, sort- circuit method- as soon as they find something they stop processing rest the elements

        list.stream().anyMatch(x->x%2==0);
        list.stream().allMatch(y->y>0);
        list.stream().noneMatch(z->z<0);

        //6. findFirst, findAny sort- circuit method- as soon as they find something they stop processing rest the elements
        list.stream().findFirst().get();
        list.stream().findAny().get();// no order

        //7. toArray()
        Object[] array= Stream.of(1,2,3,4,5,6,7,8,9).toArray();

        //8. min,max
        System.out.println("min "+Stream.of(1,44,63).min((c,d)->(c-d)).get());
        System.out.println("max "+Stream.of(1,44,63).max(Comparator.naturalOrder()).get());

        //9. forEachOrdered -> split but order maintain
        List<Integer> numbers0= Arrays.asList(1,2,3,4,5,6,7,8,9);
        System.out.println("using forEachOrder loop using parallel stream");
        numbers0.parallelStream().forEachOrdered(System.out::println);

        // examples-filtering and collecting names
        List<String> names=Arrays.asList("Anna","Bob","Charlie","David");
        System.out.println(names.stream().filter(x->x.length()>3).toList());

        // Example: squaring and sorting numbers
        List<Integer> numbers=Arrays.asList(3,7,2,1,6,9,4,5,3);
        System.out.println(numbers.stream().map(x->x*x).sorted().toList());

        //Examples: summing values
        List<Integer> numbers1=Arrays.asList(3,7,2,1,6,9,4,5,3);
        System.out.println(numbers1.stream().reduce(Integer::sum).get());

        // example: counting occurrences of a character
        String sectence="hello world";//there is not stream which take char input hence there is chars which gives stream
        System.out.println(sectence.chars().filter(x->x=='l').count());


        //example
        // stream cannot be reused after a terminal operation has benn called
        Stream<String> stream=Stream.of("hello","world");
//        stream.forEach(System.out::println);
        List<String> list1=stream.map(String::toUpperCase).toList();




        //statefull and stateless operations
        //stateless - map take one element and square which does not requires info about other element
        // statefull- like sorted, distinct know about all elements
    }
}
