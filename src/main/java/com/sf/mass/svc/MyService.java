package com.sf.mass.svc;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.http.HttpHeaders;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/call")
//@Scope()
public class MyService {

    @Autowired
    OtherServiceCaller otherServiceCaller;

    Logger logger = LogManager.getLogger(MyService.class);

    @GetMapping
    public String hello(@RequestHeader HttpHeaders httpHeaders){
        logger.info("MyService hash = " + System.identityHashCode(this));
        List<String> values = httpHeaders.get("no-process");
        String headerValue = "";
        if(values != null && !values.isEmpty()){
            headerValue = values.get(0);
        }
        String fromSfDemo = otherServiceCaller.callSfDemo(headerValue);
        if(fromSfDemo != null){
            return fromSfDemo;
        }
        logger.info("saying hello!!");
        return "Say Hello!";
    }

    @PostMapping
    public String post(){
        logger.info("saying hello from Post method!!");
        return "Say Hello from Post modified!";
    }
}
