package com.proj2.proj2test;

import java.util.HashMap;
import java.util.Map;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ChatController {

  @CrossOrigin(origins = "http://127.0.0.1:5173")
  @GetMapping("/greet")
  public Map<String, String> greet(@RequestParam String naam) {
    Map<String, String> response = new HashMap<>();
    if (naam.toLowerCase().contains("niels")) {
      response.put("message", naam + " is awesome!");
      return response;
    } else if (naam.toLowerCase().contains("ritesh")) {
      response.put("message", "Hello, " + naam + "!");
      return response;
    } else {
      return null;
        
    }
    
  }

}