package com.example.demo;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.Locale;

@Controller
@RequestMapping("/start")
//@EnableAutoConfiguration
public class HomeController {

    // controller method to show html form
    @RequestMapping("/inputForm")
    public String showForm() {
        return "input-form";
    }

    // controller method to process the html form
    @RequestMapping("/processForm")
    public String processForm() {
        return "processed-form";
    }

    // new controller method to read form data and add data to the model
    @RequestMapping("/processFormV2")
    public String letsShoutDude(HttpServletRequest request, Model model) {
        // studentName comes from input-form.html
        // read the request param from the hmtl form
        String theName = request.getParameter("studentName");

        // convert data to all caps
        theName = theName.toUpperCase();

        //create the message
        String result = "Yo! " + theName;

        // add message to the model
        model.addAttribute("message", result);

        return "processed-form";
    }


    @RequestMapping("/processFormV3")
    public String processFormVersionThree(@RequestParam("studentName") String theName, Model model) {
        // studentName comes from input-form.html
        // convert data to all caps
        theName = theName.toUpperCase();

        //create the message
        String result = "Hello, this is version 3! " + theName;

        // add message to the model
        model.addAttribute("message", result);

        return "processed-form";
    }


}
