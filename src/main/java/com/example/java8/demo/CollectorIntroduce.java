package com.example.java8.demo;

import com.example.java8.entity.Apple;

import java.util.*;
import java.util.function.Consumer;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.groupingBy;

/**
 * @ClassName CollectorIntroduce
 * @Description TODO
 * @Author pwang6
 * @Date 2021/7/16 17:09
 * @Version 1.0
 **/
public class CollectorIntroduce {
    public static void main(String[] args) {
        Consumer consumer = System.out::println;
        List<Apple> apples = Arrays.asList(new Apple(100, "red", "appleA"),
                new Apple(200, "green", "appleB"),
                new Apple(300, "bule", "appleC"),
                new Apple(300, "green", "appleD"),
                new Apple(700, "bule", "appleE"),
                new Apple(800, "green", "appleF"));
        List<Apple> greenApples = apples.stream().filter(a -> a.getColor().equals("green")).collect(Collectors.toList());
        Optional.ofNullable(greenApples).ifPresent(consumer);

        Map<String, List<Apple>> colorApples = getColorApples(apples);
        consumer.accept(colorApples);
        colorApples = getColorApplesByFunction(apples);
        consumer.accept(colorApples);
        consumer.accept("------------------------");
        colorApples = getColorApplesByCollect(apples);
        consumer.accept(colorApples);

    }

    //获取对应颜色分组的apple
    private static Map<String, List<Apple>> getColorApples(List<Apple> apples) {
        Map<String, List<Apple>> result = new HashMap<String, List<Apple>>();
        for (Apple a : apples) {
            String color = a.getColor();
            List<Apple> apples1 = result.get(color);
            if (null == apples1) {
                apples1 = new ArrayList<>();
                result.put(color, apples1);
            }
            apples1.add(a);
        }
        return result;
    }

    //使用函数式编程获取对应颜色的appleList
    private static Map<String, List<Apple>> getColorApplesByFunction(List<Apple> apples) {
        Map<String, List<Apple>> resultMap = new HashMap<String, List<Apple>>();
        apples.stream().forEach(a ->
                {
                    String color = a.getColor();
                    List<Apple> apples1 = Optional.ofNullable(resultMap.get(color)).orElseGet(
                            () -> {
                                List<Apple> colorApples = new ArrayList<Apple>();
                                resultMap.put(color, colorApples);
                                return colorApples;
                            }
                    );
                    apples1.add(a);
                }
        );
        return resultMap;
    }

    private static Map<String, List<Apple>> getColorApplesByCollect(List<Apple> apples) {
        Map<String, List<Apple>> collect = apples.stream().collect(groupingBy(Apple::getColor));
        return collect;
    }
}
