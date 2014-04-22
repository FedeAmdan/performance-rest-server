package com.mulesoft.test;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.apache.commons.lang.StringUtils;

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

}