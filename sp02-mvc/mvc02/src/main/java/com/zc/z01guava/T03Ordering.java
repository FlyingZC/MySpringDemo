package com.zc.z01guava;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import com.google.common.collect.Ordering;
// Ordering(排序,用于指定排序规则,具体还是使用Collections.sort进行排序)可以被看作是一个丰富的比较具有增强功能的链接，多个实用方法，多类型排序功能等。
public class T03Ordering {
   public static void main(String args[]){
      List<Integer> numbers = new ArrayList<Integer>();
      numbers.add(new Integer(5));
      numbers.add(new Integer(2));
      numbers.add(new Integer(15));
      numbers.add(new Integer(51));
      numbers.add(new Integer(53));
      numbers.add(new Integer(35));
      numbers.add(new Integer(45));
      numbers.add(new Integer(32));
      numbers.add(new Integer(43));
      numbers.add(new Integer(16));

      System.out.println("Input List: ");
      System.out.println(numbers);// [5, 2, 15, 51, 53, 35, 45, 32, 43, 16]

      // 返回使用值的自然顺序排序序列化。
      Ordering ordering = Ordering.natural();

      Collections.sort(numbers,ordering );
      System.out.println("Sorted List: ");
      System.out.println(numbers);// [2, 5, 15, 16, 32, 35, 43, 45, 51, 53]
         
      System.out.println("======================");
      System.out.println("List is sorted: " + ordering.isOrdered(numbers));// true
      System.out.println("Minimum: " + ordering.min(numbers));// 2
      System.out.println("Maximum: " + ordering.max(numbers));// 53

      Collections.sort(numbers,ordering.reverse());
      System.out.println("Reverse: " + numbers);// Reverse: [53, 51, 45, 43, 35, 32, 16, 15, 5, 2]

      numbers.add(null);
      System.out.println("Null added to Sorted List: ");
      System.out.println(numbers);// [53, 51, 45, 43, 35, 32, 16, 15, 5, 2, null]

      Collections.sort(numbers,ordering.nullsFirst());
      System.out.println("Null first Sorted List: ");
      System.out.println(numbers);// [null, 2, 5, 15, 16, 32, 35, 43, 45, 51, 53]
      System.out.println("======================");

      List<String> names = new ArrayList<String>();
      names.add("Ram");
      names.add("Shyam");
      names.add("Mohan");
      names.add("Sohan");
      names.add("Ramesh");
      names.add("Suresh");
      names.add("Naresh");
      names.add("Mahesh");
      names.add(null);
      names.add("Vikas");
      names.add("Deepak");

      System.out.println("Another List: ");// [Ram, Shyam, Mohan, Sohan, Ramesh, Suresh, Naresh, Mahesh, null, Vikas, Deepak]
      System.out.println(names);

	  Collections.sort(names,ordering.nullsFirst().reverse());
      System.out.println("Null first then reverse sorted list: ");
      System.out.println(names);// [Vikas, Suresh, Sohan, Shyam, Ramesh, Ram, Naresh, Mohan, Mahesh, Deepak, null]
   }
}