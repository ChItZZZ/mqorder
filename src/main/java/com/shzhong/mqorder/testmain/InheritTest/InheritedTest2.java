package com.shzhong.mqorder.testmain.InheritTest;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * 声明的此注解没有使用Inherited元注解，表示此注解用在类上时，不会被子类所继承
 * @author crazy
 */
@Retention(RetentionPolicy.RUNTIME)
public @interface InheritedTest2 {
 
	String value();
}