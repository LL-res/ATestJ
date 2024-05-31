package com.github.llres.springl.webCase;


import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpHeaders;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.Map;

@RestController
public class Controller {
    @GetMapping("/c1")
    public String c1(@RequestHeader HttpHeaders map){
        return map.toString();
    }
    @GetMapping("/c2")
    public String c2(@RequestParam("v1") Integer param1){
        return String.valueOf(param1);
    }
    @GetMapping("/c3/{v1}")
    public String c3(@PathVariable("v1") Integer param1){
        return String.valueOf(param1);
    }
    //此处要用Date，不要使用LocalTimeDate
    @GetMapping("/c4")
    public String c4(@DateTimeFormat(pattern = "yyyy-MM-dd")@RequestParam("v1") Date dateTime){
        return dateTime.toString();
    }

}
