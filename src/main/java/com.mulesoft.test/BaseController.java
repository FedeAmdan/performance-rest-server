package com.mulesoft.test;

import java.util.Random;

import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/")
public class BaseController {

    @RequestMapping(value="/letters", method = RequestMethod.GET)
    public String welcome(ModelMap model) {

        model.addAttribute("message", "Insert a pathparam with the amount of letters");

        //Spring uses InternalResourceViewResolver and return back index.jsp
        return "index";

    }

    @RequestMapping(value="/letters/{letters}", method = RequestMethod.GET)
    public String letters(@PathVariable int letters, ModelMap model) {
        String repeated = StringUtils.repeat("f",letters);
        model.addAttribute("message", repeated);
        return "index";
    }

    @RequestMapping(value="/strictdelay/{miliseconds}", method = RequestMethod.GET)
    public String strictdelay(@PathVariable int miliseconds, ModelMap model) throws InterruptedException
    {
        Thread.sleep(miliseconds);
        model.addAttribute("message", "Waited for " + miliseconds + " miliseconds");
        return "index";
    }

    @RequestMapping(value="/randomdelay/{maxMiliseconds}", method = RequestMethod.GET)
    public String randomdelay(@PathVariable int maxMiliseconds, ModelMap model) throws InterruptedException
    {
        Random r = new Random();
        int wait = r.nextInt(maxMiliseconds);
        Thread.sleep(wait);
        model.addAttribute("message", "Waited for " + wait + " miliseconds");
        return "index";
    }
    //
    //
    //@RequestMapping(value = "/add", method = RequestMethod.POST)
    //public String addUser(@PathVariable("user") String user, ModelMap model) throws InterruptedException {
    //    int delay = 4000;
    //    Thread.sleep(delay);
    //    model.addAttribute("message", "Waited for " + delay + " miliseconds");
    //    return "index";
    //}
}