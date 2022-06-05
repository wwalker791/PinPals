package com.pinpals.pinpals.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;

@Controller
@RequestMapping("index")
public class MainController {

    static ArrayList<String> pins = new ArrayList<>();

    @RequestMapping (value = "")
    public String index(Model model) {


        pins.add("death");
        pins.add("theFool");
        pins.add("theLovers");

        model.addAttribute("pins", pins);
        model.addAttribute("title", "PinPals");

        return "index";
    }

    @RequestMapping(value = "create", method = RequestMethod.GET)
    public String displayCreatePin(Model model) {
        model.addAttribute("title", "Create a Pin!");
        return "create";
    }
    @RequestMapping(value= "create", method = RequestMethod.POST)
    public String processCreateForm(@RequestParam String pinName) {
        pins.add(pinName);

        return "redirect:";
    }
}
