package xyz.twstak.hellospring;

import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RequesController {
    @RequestMapping("/request")
    public String request(HttpServletRequest request) {
        String name = request.getParameter("name");
        String age = request.getParameter("age");
        String header = request.getHeader("User-Agent");
        String requestURI = request.getRequestURI();
        String requestURL = request.getRequestURL().toString();
        String method = request.getMethod();
        return "Hello, this is a request response!";
    }
}
