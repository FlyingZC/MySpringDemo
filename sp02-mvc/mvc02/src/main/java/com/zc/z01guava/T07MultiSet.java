package com.zc.z01guava;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import com.google.common.collect.HashMultiset;
import com.google.common.collect.Multiset;
import org.junit.Test;

// Multiset接口扩展设置有重复的元素，并提供了各种实用的方法来处理这样的元素在集合中出现。
// Multiset和Set的区别就是可以保存多个相同的对象
// 允许重复，但是不保证顺序
// 常见使用场景：Multiset有一个有用的功能，就是跟踪每种对象的数量，所以你可以用来进行数字统计。
/**Multiset接口定义的接口主要有：
 　　　　add(E element) :向其中添加单个元素
 　　　　add(E element,int occurrences) : 向其中添加指定个数的元素
 　　　　count(Object element) : 返回给定参数元素的个数
 　　　　remove(E element) : 移除一个元素，其count值 会响应减少
 　　　　remove(E element,int occurrences): 移除相应个数的元素
 　　　　elementSet() : 将不同的元素放入一个Set中
 　　　　entrySet(): 类似与Map.entrySet 返回Set<Multiset.Entry>。包含的Entry支持使用getElement()和getCount()
 　　　　setCount(E element ,int count): 设定某一个元素的重复次数
 　　　　setCount(E element,int oldCount,int newCount): 将符合原有重复个数的元素修改为新的重复次数
 　　　　retainAll(Collection c) : 保留出现在给定集合参数的所有的元素
 　　　　removeAll(Collectionc) : 去除出现给给定集合参数的所有的元素
 */
public class T07MultiSet {

   public static void main(String args[]){
      //create a multiset collection
      Multiset<String> multiset = HashMultiset.create();
      multiset.add("a");
      multiset.add("b");
      multiset.add("c");
      multiset.add("d");
      multiset.add("a");
      multiset.add("b");
      multiset.add("c");
      multiset.add("b");
      multiset.add("b");
      multiset.add("b");
      //print the occurrence of an element
      System.out.println("Occurrence of 'b' : "+multiset.count("b"));// 某个元素出现次数
      //print the total size of the multiset
      System.out.println("Total Size : "+multiset.size());
      //get the distinct elements of the multiset as set
      Set<String> set = multiset.elementSet();
      //display the elements of the set
      System.out.println("Set [");
      for (String s : set) {			
         System.out.println(s);		    
      }
      System.out.println("]");
      //display all the elements of the multiset using iterator
      Iterator<String> iterator  = multiset.iterator();
      System.out.println("MultiSet [");
      while(iterator.hasNext()){
         System.out.println(iterator.next());
      }
      System.out.println("]");		
      //display the distinct elements of the multiset with their occurrence count
      System.out.println("MultiSet [");
      for (Multiset.Entry<String> entry : multiset.entrySet())
      {
         System.out.println("Element: "+entry.getElement() +", Occurrence(s): " + entry.getCount());		    
      }
      System.out.println("]");		

      //remove extra occurrences 
      multiset.remove("b",2);
      //print the occurrence of an element
      System.out.println("Occurence of 'b' : "+multiset.count("b"));
   }

   @Test
   public void testWordCount(){
      String strWorld="wer|dffd|ddsa|dfd|dreg|de|dr|ce|ghrt|cf|gt|ser|tg|ghrt|cf|gt|" +
              "ser|tg|gt|kldf|dfg|vcd|fg|gt|ls|lser|dfr|wer|dffd|ddsa|dfd|dreg|de|dr|" +
              "ce|ghrt|cf|gt|ser|tg|gt|kldf|dfg|vcd|fg|gt|ls|lser|dfr";
      String[] words=strWorld.split("\\|");
      Map<String, Integer> countMap = new HashMap<String, Integer>();
      for (String word : words) {
         Integer count = countMap.get(word);
         if (count == null) {
            countMap.put(word, 1);
         }
         else {
            countMap.put(word, count + 1);
         }
      }
      System.out.println("countMap：");
      for(String key:countMap.keySet()){
         System.out.println(key+" count："+countMap.get(key));
      }
   }
}