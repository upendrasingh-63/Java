package Stream;

import javax.swing.plaf.IconUIResource;
import java.lang.reflect.Array;
import java.util.*;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class CollectorsDemo {
    public static void main(String[] args) {
        //collectors is a utility class
        // provides a set of methods to create common collectors

        //1. collecting to a list
        List<String> names= Arrays.asList("Jack","Jill","Jeff","Jeff","Jeff");
        List<String> res= names.stream()
                .filter(x->x.endsWith("l"))
                .collect(Collectors.toList());
        System.out.println(res);

        //2. collecting to a set
        List<Integer> numbers= Arrays.asList(1,2,4,4,6,6,7,8,9);
//        Set<Integer> set= new HashSet<>(numbers);
        Set<Integer> set=numbers.stream().collect(Collectors.toSet());
        System.out.println(set);

        //3. collecting to specific collection
        ArrayDeque<String> collect=names.stream().collect(Collectors.toCollection(ArrayDeque::new));

        //4. joining strings
        String ans=names.stream().map(String::toUpperCase).collect(Collectors.joining(", "));
        System.out.println(ans);

        //summarizing data
        // generate statistical summary (count, sum, min, average,max)
        IntSummaryStatistics res1=numbers.stream().collect(Collectors.summarizingInt(x->x));
        System.out.println(res1.getMax());

        //6. calculating average
        Double average=numbers.stream().collect(Collectors.averagingInt(x->x));
        System.out.println(average);

        //7. counting elements
        Long count=numbers.stream().collect(Collectors.counting());
        System.out.println(count);

        //8. grouping elements
        List<String> names0=Arrays.asList("ram","shyam","jelly","jak","ghanshyam");
        // function classifier-in which group element goes, collector downstream which take collectores, supplier mapfactory
        System.out.println(names0.stream().collect(Collectors.groupingBy(String::length)));
        System.out.println(names0.stream().collect(Collectors.groupingBy(String::length, Collectors.joining(" "))));
        TreeMap<Integer, String> treeMap= names0.stream().collect(Collectors.groupingBy(String::length,TreeMap::new,Collectors.joining(" ")));
        System.out.println(treeMap);

        //9. partitioning elements
        // partitions elements into two groups( true and false based on a predicate
        System.out.println(names0.stream().collect(Collectors.partitioningBy(x->x.length()>3)));;

        //10. mapping and collecting
        // apply map before collect
        System.out.println(names0.stream().collect(Collectors.mapping(String::toUpperCase,Collectors.joining(" "))));;

        // example1: collecting names by length
        List<String> l1= Arrays.asList("Anna","Bob","Alexander","Brian","Alice");
        System.out.println(l1.stream().collect(Collectors.groupingBy(String::length)));

        // example2: counting word occurrences
        String sentences="hello world hello java world";
        System.out.println(Arrays.stream(sentences.split(" ")).collect(Collectors.groupingBy(x->x,Collectors.counting())));

        //example 3: partitioning even and odd
        List<Integer> l2=Arrays.asList(1,2,3,4,5);
        System.out.println(l2.stream().collect(Collectors.partitioningBy(x->x%2==0)));

        //example4: summing values in a map
        Map<String, Integer> items=new HashMap<>();
        items.put("Apple",10);
        items.put("Orange",20);
        items.put("Pear",30);
        System.out.println(items.values().stream().reduce(Integer::sum).get());
        System.out.println(items.values().stream().collect(Collectors.summarizingInt(x->x)));

        //example5: creating a ap from stream elements
        List<String> fruits=Arrays.asList("apple","banana","cherry");
        System.out.println(fruits.stream().collect(Collectors.toMap(String::toLowerCase, String::length)));

        //example6: use mergeFunction
        List<String> words=Arrays.asList("apple","banana","cherry","apple","banana");
        System.out.println(words.stream().collect(Collectors.toMap(k->k,v->1, Integer::sum)));
    }
}
