package com.example.java8.demo;

import com.example.java8.entity.Car;
import com.example.java8.entity.Insurance;
import com.example.java8.entity.Person;

import java.util.function.Consumer;

/**
 * @ClassName NullPointerException
 * @Description TODO
 * @Author Dream
 * @Date 2021-07-15 22:55
 * @Version 1.0
 **/
public class NullPointerException {
    public static void main(String[] args) {
        Consumer consumer = System.out::println;
        String insuranceNameByDeep = getInsuranceNameByDeep(new Person());
        consumer.accept(insuranceNameByDeep);
    }

    private static String getInsuranceNameByDeep(Person person) {
        if (null != person) {
            Car car = person.getCar();
            if (null != car) {
                Insurance insurance = car.getInsurance();
                if (null != insurance) {
                    return insurance.getName();
                }
            }
        }
        return "UNKNOWN";
    }

    private static String getInstranceNameByMultExit(Person person) {
        final String defaultvalue = "UNKNOWN";
        if (null == person) {
            return defaultvalue;
        }
        Car car = person.getCar();
        if (null == car) {
            return defaultvalue;
        }
        Insurance insurance = car.getInsurance();
        if (null == insurance) {
            return defaultvalue;
        }
        return insurance.getName();
    }

    private static String getInsuranceName(Person person) {
        return person.getCar().getInsurance().getName();
    }
}
