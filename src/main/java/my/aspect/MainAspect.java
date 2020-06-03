package my.aspect;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Slf4j
public class MainAspect {

    @Pointcut("execution(* my.main.controller.*.*(..))")
    public void pointcut() {}

    @Before("pointcut()")
    public void before(JoinPoint joinPoint) {
        log.info("##### [MainAspect] ----------- Before -----------");
    }

    @After("pointcut()")
    public void after(JoinPoint joinPoint) {
        log.info("##### [MainAspect] ----------- After -----------");
    }

    @AfterReturning(pointcut = "pointcut()", returning = "str")
    public void afterReturning(JoinPoint joinPoint, Object str) {
        log.info("##### [MainAspect] ----------- AfterReturning, str: " + str + " -----------");
    }

    @AfterThrowing(pointcut = "pointcut()", throwing = "ex")
    public void afterThrowing(JoinPoint joinPoint, Throwable ex) {
        log.info("##### [MainAspect] ----------- AfterThrowing, ex: " + ex + " -----------");
    }

    /*@Around("pointcut()")
    public void around(ProceedingJoinPoint joinPoint) throws Throwable {
        log.info("##### [MainAspect] ----------- Around, Start ("
                + joinPoint.getSignature().getDeclaringTypeName() + " / "
                + joinPoint.getSignature().getName()
                + ") -----------");
        joinPoint.proceed();
        log.info("##### [MainAspect] ----------- Around, End ("
                + joinPoint.getSignature().getDeclaringTypeName() + " / "
                + joinPoint.getSignature().getName()
                + ") -----------");
    }*/

}
