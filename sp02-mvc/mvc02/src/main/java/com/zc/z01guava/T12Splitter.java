package com.zc.z01guava;

import com.google.common.base.Splitter;

public class T12Splitter {
   public static void main(String args[]){
      T12Splitter tester = new T12Splitter();
      tester.testSplitter();
   }

   private void testSplitter(){
      System.out.println(Splitter.on(',')
         .trimResults()
         .omitEmptyStrings()
         .split("the ,quick, , brown         , fox,              jumps, over, the, lazy, little dog."));
   }
}