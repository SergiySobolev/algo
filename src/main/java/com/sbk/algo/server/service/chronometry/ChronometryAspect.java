package com.sbk.algo.server.service.chronometry;

import com.sbk.algo.shared.result.Chronometr;
import com.sbk.algo.shared.result.SortingResult;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * Created by sobik on 29/11/2014.
 */
@Component
@Aspect
public class ChronometryAspect {


    @Pointcut("execution(* com.sbk.algo.server.service.sorting.SortingServiceImpl.sort(..))")
    public void sortOperation() {
    }

    ;

    @Around("sortOperation()")
    public SortingResult chronoStart(final ProceedingJoinPoint pjp) throws Throwable {
        Chronometr chrono = new Chronometr();
        chrono.start();
        SortingResult result = (SortingResult) pjp.proceed();
        chrono.stop();
        result.setChrono(chrono);
        return result;
    }

}
