package com.xino.free;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
public class TimeClass {
	  public static void main(String[] args) {
		
		     LocalDateTime localDateTime = LocalDateTime.now();
		     System.out.println(localDateTime);
		     DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
		     System.err.println(formatter);
		     String strDate2 = formatter.format(localDateTime);

		     System.out.println(strDate2);
	}

}
