package Stream;

import java.util.Arrays;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;

public class PrimitiveStreams {
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6,7,8,9,10};
        IntStream stream=Arrays.stream(arr);
        //stream is generic IntStream is specific we can range it
        IntStream range=IntStream.range(1,5);
        System.out.println(range.boxed().collect(Collectors.toList()));
        System.out.println(IntStream.rangeClosed(1,5).boxed().collect(Collectors.toList()));
        // we can not use these int like function without boxed it means it convert to wrapper class called stream

        IntStream.of(1,2,3,4);

        DoubleStream doubleStream=new Random().doubles(5);
        System.out.println(doubleStream.sum());
//        System.out.println(doubleStream.boxed().collect(Collectors.toList()));

        IntStream intStream=new Random().ints(5);
        System.out.println(intStream.boxed().collect(Collectors.toList()));

//        doubleStream.mapToInt(x->(int)x+1);
//        System.out.println(doubleStream.sum());
//        System.out.println(doubleStream.min());
//        System.out.println(doubleStream.max());
//        System.out.println(doubleStream.average());
//        System.out.println(doubleStream.average());
//        doubleStream.summaryStatistics();
    }
}
