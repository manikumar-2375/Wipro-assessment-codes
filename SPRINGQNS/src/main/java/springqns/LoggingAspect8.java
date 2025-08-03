package springqns;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

@Aspect
public class LoggingAspect8 {

    @Before("execution(* springqns.ShoppingService8.purchaseItems(..))")
    public void logBeforePurchase() {
        System.out.println(" Before purchasing, LoggingAspect: purchaseItems");
    }
}
