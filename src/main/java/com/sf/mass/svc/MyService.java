package com.sf.mass.svc;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/call")
//@Scope()
public class MyService {

    @Autowired
    OtherServiceCaller otherServiceCaller;

    Logger logger = LogManager.getLogger(MyService.class);
    @GetMapping
    public String hello(){
        logger.info("MyService hash = " + System.identityHashCode(this));
        String fromSfDemo = otherServiceCaller.callSfDemo();
        if(fromSfDemo != null){
            return fromSfDemo;
        }
        logger.info("saying hello!!");
        return "Say Hello!";
    }

    @PostMapping
    public String post(){
        return "Say Hello from Post modified!";
    }
}
