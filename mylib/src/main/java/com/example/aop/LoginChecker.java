
package com.example.aop;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 登录判断
 **/
@Retention(RetentionPolicy.CLASS)
@Target({ElementType.METHOD})
public @interface LoginChecker {
}
