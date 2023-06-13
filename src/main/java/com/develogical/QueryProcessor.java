package com.develogical;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class QueryProcessor {

  Pattern plus = Pattern.compile("What is (\\d+) plus (\\d+)\\?");

  public String process(String query) {

    System.out.println("Received query:" + query);

    Matcher plusMatcher = plus.matcher(query);
    if (plusMatcher.matches()) {
      int i1 = Integer.valueOf(plusMatcher.group(1));
      int i2 = Integer.valueOf(plusMatcher.group(2));
      return String.valueOf(i1+i2);
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
