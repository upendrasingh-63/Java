package Java8Demo;

import java.util.Arrays;
import java.util.List;
import java.util.function.*;
import java.util.stream.Collectors;

public class Java8Demo {
    public static void main(String[] args) {
        // steams

        // java 8-> minimal code (had to write large code early using if else now
        // lambda), functional programing(treating function as variable) initially OOP
        // language but now both
        // java 8-> lambda expression, streams, date time api

        // lambda expression -> is an anonymous function(no name, no return type, no
        // access
        // modifier),---- it is used to implements functional interface -> those
        // interfaces which have only one abstract method(no body) other default
        // function can be allowed

        Thread t1 = new Thread(() -> {
            System.out.println("Hello World");
        });

        // we are using reference of functional interface MathOperation for holding
        // lambda expression
        MathOperation sumOperation = (a, b) -> a + b;
        MathOperation subOperation = (a, b) -> a + b;
        int operate = sumOperation.operate(5, 6);
        System.out.println(operate);

        // Predicate --> functional interface (boolean valued function)
        Predicate<Integer> isEven = x -> x % 2 == 0; // predicate only holds condition it is used to check condition
        System.out.println(isEven.test(6)); // storing condition in variable
        Predicate<String> isWordStartingWithA = x -> x.toLowerCase().startsWith("a");
        Predicate<String> isWordendingWithA = x -> x.toLowerCase().endsWith("t");
        Predicate<String> and = isWordendingWithA.and(isWordStartingWithA);
        System.out.println(and.test("Ankiy"));

        // Function -> it is also functional interface which will work for you give and
        // take output
        Function<Integer, Integer> doubleIt = x -> x * 2;
        Function<Integer, Integer> tripleIt = x -> x * 3;
        System.out.println(doubleIt.andThen(tripleIt).apply(20));
        System.out.println(tripleIt.andThen(doubleIt).apply(20));
        System.out.println(doubleIt.compose(tripleIt).apply(20));
        System.out.println(doubleIt.apply(100));

        Function<Integer, Integer> identity = Function.identity();
        System.out.println(identity.apply(7));// static methods are called using functional interface
        // apply -> apply the function to given argument, returns result of function

        // Consumer -> it will some something can do work but do not return anything
        Consumer<Integer> consumer = x -> System.out.println(x);
        consumer.accept(5);
        List<Integer> list = Arrays.asList(1, 2, 3);
        Consumer<List<Integer>> printList = x -> {
            for (int key : x) {
                System.out.println(key);
            }
        };
        printList.accept(list);

        // Supplier-> not take only return using get
        Supplier<String> give = () -> "hello world";
        System.out.println(give.get());

        // combined example
        Predicate<Integer> predicate = x -> x % 2 == 0;
        Function<Integer, Integer> function = x -> x * x;
        Consumer<Integer> consumer1 = x -> System.out.println(x);
        Supplier<Integer> supplier = () -> 100;

        if (predicate.test(supplier.get())) {
            consumer1.accept(function.apply(supplier.get()));
        }

        // Bipredicate, Biconsumer, BiFunction that take two argument
        BiPredicate<Integer, Integer> biPredicate = (x, y) -> (x + y) % 2 == 0;
        BiConsumer<Integer, Integer> biConsumer = (x, y) -> {
            System.out.println(x);
            System.out.println(y);
        };
        BiFunction<String, String, Integer> biFunction = (x, y) -> (x + y).length();

        System.out.println(biFunction.apply("abc", "def"));
        System.out.println(biPredicate.test(3, 5));
        biConsumer.accept(4, 7);

        Function<Integer, Integer> a = x -> x * 2;
        UnaryOperator<Integer> unaryOperator = x -> x * 2;// it is same as function but take one data type extends
                                                          // function
        System.out.println(unaryOperator.apply(5));

        BinaryOperator<Integer> binaryOperator = (x, y) -> x + y;// it is same as bifunction
        System.out.println(binaryOperator.apply(4, 6));

        // Method reference --> use without invoking and can use in place of lambda
        // expression, giving method as parameter
        List<String> list1 = Arrays.asList("Ram", "Shyam", "Ghanshyam");
        // list1.forEach(x-> System.out.println(x));
        list1.forEach(System.out::println);// use without invoking without bracket, in place of lambda expression

        // contructor reference
        List<String> list2 = Arrays.asList("A", "B", "C");
        // List<MobilePhone> modify= list2.stream().map(x->new
        // MobilePhone(x)).collect(Collectors.toList());
        List<MobilePhone> modify = list2.stream().map(MobilePhone::new).collect(Collectors.toList());
        // MobilePhone::new means referring constructor

    }
}

class MobilePhone {
    String name;

    public MobilePhone(String x) {
        this.name = name;
    }
}

// class SumOperation implements MathOperation{
//
// @Override
// public int operate(int a, int b) {
// return a+b;
// }
// }

// it is a functional interface it can be implemented by lambda expression
@FunctionalInterface // good practice here
interface MathOperation {
    int operate(int a, int b);
}

// the work of this class is to run the method by implementing runnable but this
// can be done by lambda alone
// class Task implements Runnable {
//
// @Override
// public void run() {
// System.out.println("hello World");
// }
// }
