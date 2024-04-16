package com.woozi.lms.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexController {

  @GetMapping("/")
  public String showIndexPage(
      Model model
  ) {
    model.addAttribute("welcome", "welcome to the site");
    return "index";
  }

}
