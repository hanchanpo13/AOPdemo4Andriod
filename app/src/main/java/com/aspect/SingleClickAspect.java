/**
 * Copyright (C) 2014 android10.org. All rights reserved.
 * @author Fernando Cejas (the android10 coder)
 */

package com.aspect;

import android.util.Log;
import android.view.View;

import com.jeven.aopdemo4andriod.R;
import com.utils.StopWatch;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;

import java.util.Calendar;

/**
 * Aspect representing the cross cutting-concern: Method and Constructor Tracing.
 */
@Aspect
public class SingleClickAspect {

    private static final String POINTCUT_METHOD = "execution(@com.example.aop.SingleClick * *(..))";
    static int TIME_TAG = R.id.click_time;
    public static final int MIN_CLICK_DELAY_TIME = 600;

    @Pointcut(POINTCUT_METHOD)
    public void methodAnnotatedWithDebugTrace() {
    }

    @Around("methodAnnotatedWithDebugTrace()")
    public void weaveJoinPoint(ProceedingJoinPoint joinPoint) throws Throwable {

        Log.i("SingleClickAspect", "SingleClickAspect is call!");

        View view = null;
        for (Object arg : joinPoint.getArgs())
            if (arg instanceof View)
                view = (View) arg;
        if (view != null) {
            Object tag = view.getTag(TIME_TAG);
            long lastClickTime = ((tag != null) ? (long) tag : 0);
            Log.i("SingleClickAspect", "lastClickTime:" + lastClickTime);
            long currentTime = Calendar.getInstance().getTimeInMillis();
            if (currentTime - lastClickTime > MIN_CLICK_DELAY_TIME) {// 过滤掉600毫秒内的连续点击
                view.setTag(TIME_TAG, currentTime);
                Log.i("SingleClickAspect", "currentTime:" + currentTime);
                joinPoint.proceed();// 执行原方法
            }
        }

    }

}
