package org.launchcode.hellospringversion3.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@ResponseBody
@RequestMapping("hello")
public class HelloController {

    //handles request at path /hello
//    @GetMapping("hello")
//    @ResponseBody
//    public String hello() {
//        return "Hello, Spring";
//    }

    //handles request at path /goodbye
    @GetMapping("goodbye")
    public String goodbye() {
        return "Goodbye, Spring";
    }

    //handler for requests from /hello?coder=whateverIsTypedHereWillBePassedAsAnArgumentToThisEndPointMethod
    @RequestMapping(value="hello", method={RequestMethod.GET, RequestMethod.POST})
    public String hello(@RequestParam String name, @RequestParam String favoriteColor,
                        @RequestParam String favoriteMovie, @RequestParam String religion) {
        return "Hello " + name + "\n" +
                "We see here your favorite color is " + favoriteColor + "\n" +
                "Your favorite movie is " + favoriteMovie + "\n" +
                "Your religion is " + religion;
    }

    //handles requests of the form hello/launchcode
    @GetMapping("hello/{name}")
    public String helloWithPathParam(@PathVariable String name) {
        return "Hello, " + name;
    }


    @GetMapping("form")
    public String helloForm() {
        return "<html>" +
                "<body>" +
                "<form action='hello' method='POST'>" + //action tells form where to submit
                "<input type='text' name='name' placeholder='name'/>" +
                "<input type='text' name='favoriteColor' placeholder='favorite color'/>" +
                "<input type='text' name='favoriteMovie' placeholder='favorite movie'/>" +
                "<input type='text' name='religion' placeholder='religion'/>" +
                "<input type='submit' value='Greet me'/>" +
                "</form>" +
                "</body>" +
                "</html>";
    }

}
