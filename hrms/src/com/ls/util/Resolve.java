package com.ls.util;

import com.ls.model.Employee;
import com.ls.test.T;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;

/**
 * Created by LS on 2017/10/27 10:36.
 * To Be or Not to Be
 */
public class Resolve {
    public static <T>List<T> par(Object obj) throws ClassNotFoundException, IllegalAccessException, InstantiationException, InvocationTargetException {
        String name = obj.getClass().getName();
        Class aClass = Class.forName(name);
        obj= aClass.newInstance();
        Method[] methods = aClass.getDeclaredMethods();
        for (Method method : methods) {
            String name1 = method.getName();
            if (name1.startsWith("get")){
                Object invoke = method.invoke(obj);
                if (invoke!=null){
                    String s = invoke.toString();
                    System.out.println(s);
                }
            }
        }
        return null;
    }

    public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, InvocationTargetException {
        List<Object> par = par(new Employee());

    }
}
