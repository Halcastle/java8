package com.example.java8.demo;

import com.example.java8.entity.Trader;
import com.example.java8.entity.Transaction;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;
import java.util.stream.Collectors;

/**
 * @ClassName StreamInAction
 * @Description TODO
 * @Author pwang6
 * @Date 2021/7/15 9:21
 * @Version 1.0
 **/
public class StreamInAction {
    public static void main(String[] args) {
        Trader traderA = new Trader("nameA", "cityA");
        Trader traderB = new Trader("nameB", "cityB");
        Trader traderC = new Trader("nameC", "cityA");
        Trader traderD = new Trader("nameD", "cityD");

        List<Transaction> transactionList = Arrays.asList(
                new Transaction(traderA, 2011, 300),
                new Transaction(traderB, 2012, 600),
                new Transaction(traderC, 2012, 400),
                new Transaction(traderD, 2011, 100)
        );

        Consumer consumer = System.out::println;
        //获取交易年份为2011，且根据值进行升序
        List<Transaction> collect = transactionList.stream().filter(transaction -> transaction.getYear() == 2011).sorted(Comparator.comparing(Transaction::getValue).thenComparing(Transaction::getYear)).collect(Collectors.toList());
        consumer.accept(collect);
        //获取交易年份为2011，且根据值进行降序
        collect = transactionList.stream().filter(transaction -> transaction.getYear() == 2011).sorted(Comparator.comparing(Transaction::getValue).thenComparing(Transaction::getYear).reversed()).collect(Collectors.toList());
        consumer.accept(collect);

        //拿出Trade中不重复的城市
        transactionList.stream().map(transaction -> transaction.getTrader().getCity()).distinct().forEach(System.out::println);

        //拿出来自cityA的所有Trader，并且按照名字降序
        transactionList.stream()
                .map(Transaction::getTrader)
                .filter(trader -> trader.getCity().equals("cityA"))
                .sorted(Comparator.comparing(Trader::getName).reversed())
                .forEach(consumer);

        //拿出所有trade的名称
        String reduce = transactionList.stream()
                .map(Transaction::getTrader)
                .map(Trader::getName)
                .distinct()
                .sorted()
                .reduce("", (name1, name2) -> name1 + name2);
        consumer.accept(reduce);

        //拿出所有在cityA的trader
        transactionList.stream()
                .map(Transaction::getTrader)
                .filter(trader -> trader.getCity().equals("cityA"))
                .forEach(consumer);

        consumer.accept("拿出所有在cityA的trader的transaction的value");
        //拿出所有在cityA的trader的transaction的value
        transactionList.stream()
                .filter(transaction -> transaction.getTrader().getCity().equals("cityA"))
                .map(Transaction::getValue)
                .forEach(consumer);

        //拿到所有transaction中最大value
        consumer.accept("拿到所有transaction中最大value");
        transactionList.stream()
                .map(Transaction::getValue)
                .reduce(Integer::max)
                .ifPresent(consumer);

        //拿到所有transaction中最小value
        consumer.accept("拿到所有transaction中最大value");
        transactionList.stream()
                .map(Transaction::getValue)
                .reduce(Integer::min)
                .ifPresent(consumer);
    }
}
