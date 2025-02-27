package com.develogical;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

import org.hamcrest.core.IsEqual;
import org.junit.Test;

public class QueryProcessorTest {

  QueryProcessor queryProcessor = new QueryProcessor();

  @Test
  public void returnsEmptyStringIfCannotProcessQuery() throws Exception {
    assertThat(queryProcessor.process("test"), is(""));
  }

  @Test
  public void knowsAboutShakespeare() throws Exception {
    assertThat(queryProcessor.process("Shakespeare"), containsString("playwright"));
  }

  @Test 
  public void knowsName() {
    assertThat(queryProcessor.process("What is your name?"), containsString("Nick"));
   
  }
  @Test 
  public void doMinus() {
    assertThat(queryProcessor.process("What is 3 minus 1?"), IsEqual.equalTo("2"));
    assertThat(queryProcessor.process("What is 14 minus 6?"), IsEqual.equalTo("8"));
    
  }

  @Test 
  public void doSums() {
    assertThat(queryProcessor.process("What is 1 plus 1?"), IsEqual.equalTo("2"));
    assertThat(queryProcessor.process("What is 12 plus 13?"), IsEqual.equalTo("25"));
    assertThat(queryProcessor.process("What is 12 plus -5?"), IsEqual.equalTo("7"));
    
  }
   @Test 
  public void doPlus() {
    assertThat(queryProcessor.process("What is 1 plus 1?"), IsEqual.equalTo("2"));
    assertThat(queryProcessor.process("What is 12 plus 13?"), IsEqual.equalTo("25"));
    assertThat(queryProcessor.process("What is 12 plus -5?"), IsEqual.equalTo("7"));
    
  }

  @Test
  public void doPrimes() {
    String q = "Which of the following numbers are primes: 4, 8, 13, 22";
    assertThat(queryProcessor.process(q), IsEqual.equalTo("13"));
    q = "Which of the following numbers are primes: 5, 96, 50, 4, 61?";
    assertThat(queryProcessor.process(q), IsEqual.equalTo("5, 61"));
    

  }

  @Test
  public void doMax() {
    assertThat(queryProcessor.process("Which of the following numbers is the largest: 1, 2, 3?"), IsEqual.equalTo("3"));
    assertThat(queryProcessor.process("Which of the following numbers is the largest: 10, 20, 12?"), IsEqual.equalTo("20"));
    assertThat(queryProcessor.process("Which of the following numbers is the largest: -10, -20, -12?"), IsEqual.equalTo("-10"));
    
      
  }

     @Test 
  public void doPow() {
    assertThat(queryProcessor.process("What is 2 to the power of 3?"), IsEqual.equalTo("8"));
    
  }

    @Test 
  public void doMult() {
    assertThat(queryProcessor.process("What is 1 multiplied by 1?"), IsEqual.equalTo("1"));
    assertThat(queryProcessor.process("What is 2 multiplied by 13?"), IsEqual.equalTo("26"));
    assertThat(queryProcessor.process("What is -1 multiplied by -5?"), IsEqual.equalTo("5"));
    
  }

  @Test
  public void doSC() {
    String q = "Which of the following numbers is both a square and a cube: 921, 3844, 4225, 4843, 3375, 2472, 1?";

    assertThat(queryProcessor.process(q), IsEqual.equalTo("1"));
  }
}
