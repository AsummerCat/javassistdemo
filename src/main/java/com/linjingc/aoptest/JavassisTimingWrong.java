package com.linjingc.aoptest;

import javassist.ClassPool;
import javassist.CtClass;
import javassist.CtMethod;

/**
 * 错误案例
 * aop切入 环绕
 */
public class JavassisTimingWrong {

	public static void main(String[] args) throws Exception {

		//需要修改的已有的类名和方法名

		String className = "com.linjingc.aoptest.Looper";

		String methodName = "loop";

		ClassPool classPool = ClassPool.getDefault();

		CtClass clazz = classPool.get(className);

		CtMethod method = clazz.getDeclaredMethod(methodName);

		method.insertBefore("long start=System.currentTimeMillis();");

		method.insertAfter("System.out.println(\"耗时:\"+(System.currentTimeMillis()-start)+\"ms\");");

		//调用修改的Looper类的loop方法

		Looper looper = (Looper) clazz.toClass().newInstance();

		looper.loop();

	}

}