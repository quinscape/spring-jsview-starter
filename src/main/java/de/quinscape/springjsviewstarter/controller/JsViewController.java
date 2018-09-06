package de.quinscape.springjsviewstarter.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class JsViewController
{
    @RequestMapping("/app")
    public String entryPointA(ModelMap modelMap)
    {
        modelMap.addAttribute("value", "for one.js");
        return "one";
    }

    @RequestMapping("/app/two")
    public String entryPointB(ModelMap modelMap)
    {
        modelMap.addAttribute("value", "for two.js");

        return "two";
    }
}
