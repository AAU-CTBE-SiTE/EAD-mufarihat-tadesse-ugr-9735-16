package aop_demo.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(1)
public class LoggingAspect {

    @Pointcut("execution(* aop_demo.service.EmployeeService.*(..))")
    public void employeeServiceMethods() {
    }

    // Executes before the target method
    @Before("employeeServiceMethods()")
    public void logBefore(JoinPoint joinPoint) {

        System.out.println("\n========== BEFORE METHOD ==========");

        System.out.println(
                "Executing method: " +
                        joinPoint.getSignature().getName()
        );

    }

    // Executes after the target method, even if it throws an exception
    @After("employeeServiceMethods()")
    public void logAfter(JoinPoint joinPoint) {

        System.out.println(
                "Finished executing: " +
                        joinPoint.getSignature().getName()
        );

        System.out.println("===================================\n");
    }

    // Executes only when the target method succeeds
    @AfterReturning(
            pointcut = "employeeServiceMethods()",
            returning = "result"
    )
    public void logAfterReturning(
            JoinPoint joinPoint,
            Object result
    ) {

        System.out.println("Method executed successfully!");

        if (result != null) {
            System.out.println("Returned value: " + result);
        }

    }
}

