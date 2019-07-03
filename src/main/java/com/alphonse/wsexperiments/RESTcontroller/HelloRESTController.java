package com.alphonse.wsexperiments.RESTcontroller;

import com.alphonse.wsexperiments.model.HelloWorldClass;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.atomic.AtomicLong;

@RestController
public class HelloRESTController {

    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();

    @RequestMapping("/hello")
    public ResponseEntity<HelloWorldClass> sayHello(@RequestParam(value="name", defaultValue="World") String name) {
        return new ResponseEntity<>(new HelloWorldClass(counter.incrementAndGet(),
                String.format(template, name)), HttpStatus.OK);
    }
}
