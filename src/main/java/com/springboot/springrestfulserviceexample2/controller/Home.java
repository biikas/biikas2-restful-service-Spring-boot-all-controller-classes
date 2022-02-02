package com.springboot.springrestfulserviceexample2.controller;


import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RequestMapping(value = "home")
@RestController
public class Home {

    @GetMapping
    public ResponseEntity<String> greet(){
        log.info("Greeting method called");
        return new ResponseEntity<>("Good morning", HttpStatus.OK);
    }
    //[base_url]/home/convert?nepalicurrency=100
    @GetMapping(value = "convert")
    public ResponseEntity<String> convert(@RequestParam(name = "nepalicurrency",defaultValue = "1")Integer nc){
        String s ="The equivalent nepali currency is "+nc*119;
        return new ResponseEntity<>(s,HttpStatus.ACCEPTED);
    }

    //exception Example1
    @GetMapping("salary")
    public ResponseEntity<String> getSalary(){
        String name =null;
        name.toUpperCase(); //produces null pointer exception
        return new ResponseEntity<>(String.valueOf(50000),HttpStatus.OK);
    }
    //in the above example we get null pointer exception to
    //handle the error we do

//    @ExceptionHandler(NullPointerException.class)
//    public String handleError(NullPointerException e){
//        return"Null pointer exception called";
//    }

    @ExceptionHandler(NullPointerException.class)
//    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ResponseEntity<ErrorResponse> handleError(NullPointerException e){
        ErrorResponse errorResponse = new ErrorResponse(false,"Internal server error");
        return new ResponseEntity<>(errorResponse,HttpStatus.INTERNAL_SERVER_ERROR);
    }

    //exception example2
    @GetMapping(value = "name")
    public ResponseEntity<String> getName(){
        String a ="Hari";
        a.charAt(5);
        return new ResponseEntity<>(a,HttpStatus.OK);
    }
    @ExceptionHandler(StringIndexOutOfBoundsException.class)
    public ErrorResponse handleError2(StringIndexOutOfBoundsException e){
        ErrorResponse errorResponse = new ErrorResponse(false,"Short index");
        log.error("Error result: {} ",errorResponse);
        return errorResponse;
    }
}
