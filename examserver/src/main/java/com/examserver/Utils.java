package com.examserver;

import org.springframework.stereotype.Component;

@Component
public class Utils {
	public Boolean notEqual(String data1,String data2) {
		 if(data1.equals(data2)) {
			 return false;
		 }else
			 return true;
	}

}
