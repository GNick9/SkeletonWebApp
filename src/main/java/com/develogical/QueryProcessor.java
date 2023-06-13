package com.develogical;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class QueryProcessor {

  Pattern plus = Pattern.compile("What is (-?\\d+) plus (-?\\d+)\\?");

  Pattern max = Pattern.compile("Which of the following numbers is the largest: (-?\\d+), (-?\\d+), (-?\\d+)\\?");

  Pattern mult = Pattern.compile("What is (-?\\d+) multiplied by (-?\\d+)\\?");


  public String process(String query) {

    System.out.println("Received query:" + query);

    if (query.contains("Which of the following numbers is both a square and a cube: ")) {
      String q2 = query.replace("Which of the following numbers is both a square and a cube: ", "").replace("?", "");
      String[] numbers = q2.split(", ");
      for (String n : numbers) {
        int i = Integer.parseInt(n);
        if (Math.sqrt((double)i) == (int) Math.sqrt((double)i)) {
          if (Math.cbrt((double)i) == (int) Math.cbrt((double)i)) {
        
            return String.valueOf(i);
          }
        }
      }
      return "";
    }

    Matcher multMatcher = mult.matcher(query);
    if (multMatcher.matches()) {
      int i1 = Integer.valueOf(multMatcher.group(1));
      int i2 = Integer.valueOf(multMatcher.group(2));
      return String.valueOf(i1*i2);
    
    }

    Matcher plusMatcher = plus.matcher(query);
    if (plusMatcher.matches()) {
      int i1 = Integer.valueOf(plusMatcher.group(1));
      int i2 = Integer.valueOf(plusMatcher.group(2));
      return String.valueOf(i1+i2);
    }

    Matcher maxMatcher = max.matcher(query);
    if (maxMatcher.matches()) {
      int i1 = Integer.valueOf(maxMatcher.group(1));
      int i2 = Integer.valueOf(maxMatcher.group(2));
      int i3 = Integer.valueOf(maxMatcher.group(3));

      int m = Math.max( Math.max(i1, i2), i3);
      return String.valueOf(m);
      
    }

    if (query.toLowerCase().contains("shakespeare")) {
      return "William Shakespeare (26 April 1564 - 23 April 1616) was an "
          + "English poet, playwright, and actor, widely regarded as the greatest "
          + "writer in the English language and the world's pre-eminent dramatist.";
    } 
    
    if (query.toLowerCase().contains("your name")) {
      return "Nick";
    }  
    return "";
  }
}
