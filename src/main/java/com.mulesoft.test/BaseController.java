package com.mulesoft.test;

import java.util.Random;

import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

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

    @RequestMapping(value="/strictdelay", method = RequestMethod.GET)
    public String strictDelayLetters(@RequestParam(value = "miliseconds") int maxMiliseconds,
                              @RequestParam(value = "letters", required = false) String letters,  ModelMap model) throws InterruptedException
    {
        Thread.sleep(maxMiliseconds);
        if  (letters != null)
        {
            String repeated = StringUtils.repeat("f",Integer.parseInt(letters));
            model.addAttribute("message", repeated);
        }
        else
        {
            model.addAttribute("message", "Waited for " + maxMiliseconds + " miliseconds");   
        }
        return "index";
    }

    @RequestMapping(value="/randomdelay", method = RequestMethod.GET)
    public String randomDelayLetters(@RequestParam(value = "miliseconds") int maxMiliseconds,
                              @RequestParam(value = "letters", required = false) String letters,  ModelMap model) throws InterruptedException
    {
        Random r = new Random();
        int wait = r.nextInt(maxMiliseconds);
        Thread.sleep(wait);
        if (letters != null)
        {
            String repeated = StringUtils.repeat("f",Integer.parseInt(letters));
            model.addAttribute("message", repeated);
        }
        else
        {
            model.addAttribute("message", "Waited for " + wait + " miliseconds");
        }
        return "index";
    }
}