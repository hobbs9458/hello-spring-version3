package org.launchcode.hellospringversion3.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@ResponseBody
@Controller
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
//    @GetMapping("hello")
//    public String hello(@RequestParam String name, @RequestParam String favoriteColor,
//                        @RequestParam String favoriteMovie, @RequestParam String religion) {
//        return "Hello " + name + "\n" +
//                "We see here your favorite color is " + favoriteColor + "\n" +
//                "Your favorite movie is " + favoriteMovie + "\n" +
//                "Your religion is " + religion;
//    }

    //handles requests of the form hello/launchcode
    @GetMapping("hello/{name}")
    public String helloWithPathParam(@PathVariable String name) {
        return "Hello, " + name;
    }

    @RequestMapping(value="form-handler", method = {RequestMethod.POST})
    public static String formHandler(@RequestParam String language, @RequestParam String name) {
        return language + " " + name;
    }

    @GetMapping("form")
    public String helloForm() {
        return "<html>" +
                "<body>" +
                "<form action='form-handler'>" + //action tells form where to submit
                "<input type='text' name='name' placeholder='name'/>" +
                "<select name='language'>" +
                "<option value='Hello'>English</option>" +
                "<option value='Hola'>Spanish</option>" +
                "<option value='Marhaba'>Aramaic</option>" +
                "<option value='Bonjour'>French</option>" +
                "<option value='Hallo'>German</option>" +
                "</select>" +
                "</form>" +
                "</body>" +
                "</html>";
    }

}
