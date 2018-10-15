package utlis;

/**
 * @Author: ky
 * @Date: 2018/10/15 13:07
 */

import java.lang.annotation.Annotation;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.server.ServletServerHttpRequest;
import org.springframework.http.server.ServletServerHttpResponse;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodReturnValueHandler;
import org.springframework.web.method.support.ModelAndViewContainer;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerAdapter;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

import javax.servlet.http.HttpServletResponse;


public class JsonReturnHandle implements HandlerMethodReturnValueHandler{

    public boolean supportsReturnType(MethodParameter methodParameter) {
        // 如果有我们自定义的 JSON 注解 就用我们这个Handler 来处理
        boolean hasJsonAnno= methodParameter.getMethodAnnotation(Json.class) != null;
        return hasJsonAnno;

    }
    public void handleReturnValue(Object o, MethodParameter methodParameter, ModelAndViewContainer modelAndViewContainer, NativeWebRequest nativeWebRequest) throws Exception {
        modelAndViewContainer.setRequestHandled(true);
        System.out.println("hhhhhandler");
        // 获得注解并执行filter方法 最后返回
        HttpServletResponse response = nativeWebRequest.getNativeResponse(HttpServletResponse.class);
        Annotation[] annos = methodParameter.getMethodAnnotations();
        CustomerJsonSerializer jsonSerializer = new CustomerJsonSerializer();
        Arrays.asList(annos).forEach(a -> {
            if (a instanceof Json) {
                Json json = (Json) a;
                jsonSerializer.filter(json.type(), json.include(), json.filter());
            }
        });

        response.setContentType(MediaType.APPLICATION_JSON_UTF8_VALUE);
        String json = jsonSerializer.toJson(o);
        response.getWriter().write(json);
    }
}
