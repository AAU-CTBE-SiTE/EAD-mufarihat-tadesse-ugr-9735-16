package aop_demo.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(2)
public class PerformanceAspect {

    @Around("execution(* aop_demo.service.EmployeeService.*(..))")
    public Object measureExecutionTime(
            ProceedingJoinPoint joinPoint
    ) throws Throwable {

        long startTime = System.nanoTime();

        System.out.println(
                "Starting execution of: " +
                        joinPoint.getSignature().getName()
        );

        try {

            return joinPoint.proceed();

        } finally {

            long endTime = System.nanoTime();

            long executionTime = (endTime - startTime) / 1_000_000;

            System.out.println(
                    "Execution time: " + executionTime + " ms"
            );

        }
    }
}
