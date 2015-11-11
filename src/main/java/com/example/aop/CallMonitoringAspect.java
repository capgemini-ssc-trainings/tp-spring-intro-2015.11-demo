package com.example.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.StopWatch;

@Aspect
@Component
public class CallMonitoringAspect {
    Logger logger = org.slf4j.LoggerFactory.getLogger(CallMonitoringAspect.class);

    @Autowired
    CallMonitor callMonitor;

    @Pointcut("execution(* com.example..service.BookService.*(..))")
    public void serviceMethods() {

    }

    @Around("serviceMethods()")
    public Object monitor(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {

        if (this.callMonitor.isEnabled()) {

            this.logger.info("Monitoring of " + proceedingJoinPoint.toString() + " started");
            StopWatch sw = new StopWatch(proceedingJoinPoint.toString());

            try {
                sw.start(proceedingJoinPoint.toShortString());
                return proceedingJoinPoint.proceed();

            } finally {

                synchronized (this) {
                    this.callMonitor.registerCall(1);
                }

                sw.stop();
                this.logger.info(sw.prettyPrint());
                this.logger.info("Monitoring of " + proceedingJoinPoint.toString() + " finished after "
                        + sw.getLastTaskTimeMillis() + " ms");
            }
        } else {
            return proceedingJoinPoint.proceed();
        }
    }


    public void setCallMonitor(CallMonitor callMonitor) {
        this.callMonitor = callMonitor;
    }
}
