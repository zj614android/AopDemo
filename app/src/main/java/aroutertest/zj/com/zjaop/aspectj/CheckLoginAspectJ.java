package aroutertest.zj.com.zjaop.aspectj;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

/**
 * Created by thinkpad on 2018/2/8.
 */

@Aspect public class CheckLoginAspectJ {

    String TAG = "CheckLoginAspectJ___";

    //    aroutertest.zj.com.zjaop.aspectj.CheckLogin
    //    * *(..)) 代表可以处理CheckLogin这个类所有的方法
    @Pointcut("execution(@aroutertest.zj.com.zjaop.aspectj.CheckLogin * *(..))")
    public void handleMethod() {
        System.out.println(TAG + "@handleMethod");
    }

    @Before("handleMethod()")
    public void before(JoinPoint point) {
        System.out.println(TAG + "@Before");
    }

    @Around("handleMethod()")
    public void around(ProceedingJoinPoint joinPoint) throws Throwable {
        System.out.println(TAG + "@Around");
//        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
//        String name = signature.getName(); // 方法名：test
//        Method method = signature.getMethod(); // 方法：public void com.lqr.androidaopdemo.MainActivity.test(android.view.View)
//        Class returnType = signature.getReturnType(); // 返回值类型：void
//        Class declaringType = signature.getDeclaringType(); // 方法所在类名：MainActivity
//        String[] parameterNames = signature.getParameterNames(); // 参数名：view
//        Class[] parameterTypes = signature.getParameterTypes(); // 参数类型：View

//        TestAnnoTrace annotation = method.getAnnotation(TestAnnoTrace.class);
//        String value = annotation.value();
//        int type = annotation.type();

//        long beginTime = SystemClock.currentThreadTimeMillis();
        joinPoint.proceed();
//        long endTime = SystemClock.currentThreadTimeMillis();
//        long dx = endTime - beginTime;
//        System.out.println("耗时：" + dx + "ms");
    }

    @After("handleMethod()")
    public void after(JoinPoint point) {
        System.out.println(TAG + "@After");
    }

    @AfterReturning("handleMethod()")
    public void afterReturning(JoinPoint point, Object returnValue) {
        System.out.println(TAG + "@AfterReturning");
    }

    @AfterThrowing(value = "handleMethod()", throwing = "ex")
    public void afterThrowing(Throwable ex) {
        System.out.println(TAG + "@afterThrowing");
        System.out.println("ex = " + ex.getMessage());
    }

}
