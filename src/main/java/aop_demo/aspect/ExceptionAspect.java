package aop_demo.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(3)
public class ExceptionAspect {

    @AfterThrowing(
            pointcut = "execution(* aop_demo.service.EmployeeService.*(..))",
            throwing = "exception"
    )
    public void handleException(
            JoinPoint joinPoint,
            Throwable exception
    ) {

        System.out.println("\n========== EXCEPTION DETECTED ==========");

        System.out.println(
                "Method: " +
                        joinPoint.getSignature().getName()
        );

        System.out.println(
                "Exception: " + exception.getMessage()
        );

        System.out.println("========================================\n");
    }
}
