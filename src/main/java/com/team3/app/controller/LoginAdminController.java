package com.team3.app.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginAdminController {
  
  @GetMapping("/ok")
  public String index() {
      return "index";
  }

  @GetMapping("/login-admin") 
  public String admin() {
      return "admin";
  }
}
