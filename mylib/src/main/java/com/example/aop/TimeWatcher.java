
package com.example.aop;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 方法计时器
 **/
@Retention(RetentionPolicy.CLASS)
@Target(ElementType.METHOD)
public @interface TimeWatcher {
}
