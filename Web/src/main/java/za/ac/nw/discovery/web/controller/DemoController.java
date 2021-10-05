package za.ac.nw.discovery.web.controller;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import za.ac.nw.discovery.domain.service.GeneralResponse;

@RestController
@RequestMapping("demo")
public class DemoController {

    @GetMapping("/")
    public String index() {
        return "Greetings from Spring Boot!";
    }

}
