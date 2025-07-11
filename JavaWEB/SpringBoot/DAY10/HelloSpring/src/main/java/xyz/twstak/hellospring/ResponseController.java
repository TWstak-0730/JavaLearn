package xyz.twstak.hellospring;


import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
public class ResponseController {
    @RequestMapping("/response")
    public void response(HttpServletResponse response) throws IOException {
        response.setStatus(HttpServletResponse.SC_OK);

        response.setHeader("name", "Twstak");
        response.setHeader("age", "18");

        response.getWriter().write("<h1>Hello</h1>");
    }

    @RequestMapping("/response2")
    public ResponseEntity<String> response2(HttpServletResponse response) throws IOException {


        return ResponseEntity
                .status(HttpServletResponse.SC_OK)
                .header("name", "Twstak")
                .header("age", "18")
                .body("<h1>Hello</h1>");
    }

}

