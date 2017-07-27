package ssm.controller;

import org.springframework.web.bind.annotation.ControllerAdvice;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by lixuanyu
 * on 2017/7/27.
 */
@ControllerAdvice
public class ExceptionHandlerTest {
    public String handleMaxUploadSizeExceededException(HttpServletRequest request) {
        request.setAttribute("message",">300kb!");
        return "/work/index.jsp";
    }
}
