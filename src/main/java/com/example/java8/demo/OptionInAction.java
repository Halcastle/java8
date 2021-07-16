package com.example.java8.demo;

import com.example.java8.entity.Car;
import com.example.java8.entity.Insurance;
import com.example.java8.entity.Person;

import java.util.Optional;
import java.util.function.Consumer;

/**
 * @ClassName OptionInAction
 * @Description TODO
 * @Author pwang6
 * @Date 2021/7/16 11:09
 * @Version 1.0
 **/
public class OptionInAction {
    public static void main(String[] args) {
        Consumer consumer = System.out::println;
        Insurance insurance = new Insurance("生成Name");
        Car car = new Car(insurance,Optional.ofNullable(insurance));
        Person person = new Person(car,Optional.ofNullable(car));
        String insuranceName = getInsuranceName(person);
        consumer.accept(insuranceName);

    }

    //获取person中Insurance的name
    private static String getInsuranceName(Person person){
        Optional<Person> optionalPerson = Optional.ofNullable(person);

//        Optional<Car> car = optionalPerson.flatMap(t -> t.getOptionalCar());
//        Optional<Insurance> optionalInsurance = car.flatMap(t -> t.getOptionalInsurance());
//        Insurance insurance = optionalInsurance.orElseGet(() -> new Insurance("elseName"));

        Insurance insurance = optionalPerson.flatMap(t -> t.getOptionalCar())
                .flatMap(t -> t.getOptionalInsurance())
                .orElseGet(()->new Insurance("elseName"));
        return insurance.getName();
    }
}
