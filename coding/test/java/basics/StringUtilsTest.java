package test.java.basics;

import org.apache.commons.lang3.StringUtils;

public class StringUtilsTest {

	public static void main(String[] args) {
		String someValue="test";
		String blank="";
		String whiteSpace="  ";
		String nullValue=null;
		
		System.out.println("----------isNotBlank---------");
		
		System.out.println(StringUtils.isNotBlank(someValue));//true
		System.out.println(StringUtils.isNotBlank(blank));// false
		System.out.println(StringUtils.isNotBlank(whiteSpace));//false
		System.out.println(StringUtils.isNotBlank(nullValue));//false
		
		System.out.println("----------isBlank---------");
		
		System.out.println(StringUtils.isBlank(someValue));//false
		System.out.println(StringUtils.isBlank(blank));// true
		System.out.println(StringUtils.isBlank(whiteSpace));//true
		System.out.println(StringUtils.isBlank(nullValue));//true
		
        System.out.println("----------isNotEmpty---------");
	
		System.out.println(StringUtils.isNotEmpty(someValue));//true
		System.out.println(StringUtils.isNotEmpty(blank));// false
		System.out.println(StringUtils.isNotEmpty(whiteSpace));//true
		System.out.println(StringUtils.isNotEmpty(nullValue));//false
		
		System.out.println("----------isEmpty---------");
		
		System.out.println(StringUtils.isEmpty(someValue));//false
		System.out.println(StringUtils.isEmpty(blank));// true
		System.out.println(StringUtils.isEmpty(whiteSpace));//true
		System.out.println(StringUtils.isEmpty(nullValue));//false

	}

}
