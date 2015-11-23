package com.ls;

import java.util.Random;

/** Generate 10 random integers in the range 0..99. */
public final class RandomInteger {

 public static final int showTicket(){
	 
	 Random randomGenerator = new Random();
	   
     int randomInt = randomGenerator.nextInt(10000);
    
	 return randomInt;
 }
}
