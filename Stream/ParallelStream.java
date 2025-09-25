package Stream;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Stream;

public class ParallelStream {
    public static void main(String[] args) {
        //a type of stream that enables parallel processing of elements
        // allowing multiple threads to process parts of the stream simultaneously
        // this can significantly improve performance for large data sets
        // workload is distributed across multiple threads

        long start=System.currentTimeMillis();
        List<Integer> list= Stream.iterate(1, i->i+1).limit(20000).toList();
        List<Long> factorialList=list.stream().map(ParallelStream::factorial).toList();
        long end=System.currentTimeMillis();
        System.out.println("Time taken with sequential stream: "+(end-start)+"ms");


        start=System.currentTimeMillis();
//        factorialList=list.parallelStream().map(ParallelStream::factorial).sequential().toList();
        factorialList=list.parallelStream().map(ParallelStream::factorial).toList();
        end=System.currentTimeMillis();
        System.out.println("Time taken with parallel stream: "+(end-start)+"ms");

        //Parallel streams are most effective for CPU-intensive or large dataset where tasks are independent
        //they may add overhead for simple tasks or small datasets
        // it should be used there where operations are independent of each other

        // Cumulative sum
        //[1,2,3,4,5]->[1,3,6,10,15]
        List<Integer> list1= Arrays.asList(1,2,3,4,5);
        //Variable used in lambda expression should be final or effectively final
        // in parallel stream we can not use it coz it can create inconsistency, no thread safe
        AtomicInteger sum=new AtomicInteger(0);// for thread safely but answer can be different
        List<Integer> cumulativeSum=list1.parallelStream().map(sum::addAndGet).toList();
        System.out.println(cumulativeSum);

//        List<Integer> cumulativeSum=list1.parallelStream()
//                .map(x->{
//                    int i= x+sum;
//                    sum=i;
//                    return i;
//                }).toList();

    }
    private static long factorial(int n) {
        long res=1;
        if(n==1)return n;
        for(int i=2;i<=n;i++){
            res=res*i;
        }
        return res;
    }
}
