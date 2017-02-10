/**
 * Copyright (C) 2014 android10.org. All rights reserved.
 * @author Fernando Cejas (the android10 coder)
 */

package com.aspect;

import android.util.Log;
import android.view.View;

import com.jeven.aopdemo4andriod.R;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

import java.util.Calendar;

/**
 * Aspect representing the cross cutting-concern: Method and Constructor Tracing.
 */
@Aspect
public class LoginCheckAspect {

    private static final String POINTCUT_METHOD = "execution(@com.example.aop.LoginChecker * *(..))";

    @Pointcut(POINTCUT_METHOD)
    public void methodAnnotatedWithDebugTrace() {
    }

    @Around("methodAnnotatedWithDebugTrace()")
    public void weaveJoinPoint(ProceedingJoinPoint joinPoint) throws Throwable {

        Log.i("LoginCheckAspect", "LoginCheckAspect is call!");

    }

}
