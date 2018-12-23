package com.zc.z01guava;

import com.google.common.base.Function;
import com.google.common.collect.Lists;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class Z01Transform {
    @Test
    public void test01() {
        List<Person> persons = new ArrayList<Person>();
        persons.add(new Person("za", 11));
        persons.add(new Person("ab", 12));
        persons.add(new Person("ac", 13));
        List<String> names = Lists.transform(persons, new Function<Person, String>() {
            @Override
            public String apply(Person input) {
                return input.getName();
            }
        });
        System.out.println(names);
    }

    @Test
    public void test02() {
        Assert.assertFalse(false);
        // Assert.assertFalse(true);
    }
}

class Person {
    private String name;
    private int age;

    public Person() {
    }

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}