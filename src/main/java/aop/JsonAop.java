package aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;
import utlis.CustomerJsonSerializer;
import utlis.Json;

import java.io.IOException;
import java.lang.reflect.Method;

/**
 * @Author: ky
 * @Date: 2018/10/15 17:05
 */
/*@Component
@Aspect*/
public class JsonAop {
    /*@AfterReturning(value ="@annotation(utlis.Json)",returning = "o")
    public void afterReturn(JoinPoint joinPoint,Object o) throws IOException {
        MethodSignature m=  (MethodSignature)joinPoint.getSignature();
        Json json=m.getMethod().getAnnotation(Json.class);
        CustomerJsonSerializer jsonSerializer = new CustomerJsonSerializer();
        jsonSerializer.filter(json.type(), json.include(), json.filter());
        Class<?> clazz=o.getClass();
        Object result= jsonSerializer.toObject(o,clazz);
    }*/
}
