package tn.esprit.ds.ski_nada_namanizitouni.aspects;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;
import org.springframework.util.StopWatch;

@Aspect
@Component
@Slf4j
public class PerformenceAspects {
    @Around("execution(public * tn.esprit.ds.ski_nada_namanizitouni.services.*.add*(..) )")
    public Object executionTime(ProceedingJoinPoint pjp) throws Throwable {
        StopWatch stopWatch = new StopWatch() ;
        stopWatch.start();

        Object o=pjp.proceed();
        stopWatch.stop();
        log.info("execution time of {} is {}",pjp.getSignature().getName() , stopWatch.getTotalTimeMillis());
        return o;
    }
}
