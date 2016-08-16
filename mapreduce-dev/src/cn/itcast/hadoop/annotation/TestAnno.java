/**
 * Copyright 2014-2015, NetEase, Inc. All Rights Reserved.
 * 
 * Date: 2016年5月17日
 */

package cn.itcast.hadoop.annotation;

import java.lang.annotation.Annotation;

/**
 * TODO
 *
 * @author linjingu<hzlinjingu@corp.netease.com>
 * @since 2016年5月17日
 */

public class TestAnno {
	
	
	public TestAnno(){
		
	}
	
	@Test(age=2)
	public void dump(){
		
	}
	
	public static void main(String[] args) throws Exception {
		Class<?> as = Class.forName("cn.itcast.hadoop.annotation.TestAnno");
		Annotation[] ans = as.getDeclaredAnnotations();
		for(Annotation a : ans){
			System.out.println(a.annotationType());
		}
		boolean isAnnoTest = as.isAnnotationPresent(Test.class);
		System.out.println(isAnnoTest);
		Test an = as.getAnnotation(Test.class);
		if(an != null){
			System.out.println(an.name() + " " + an.age());
		}
		
		
	}
}
