package com.proj2.proj2test;

import java.util.HashMap;
import java.util.Map;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ChatController {

  @CrossOrigin(origins = "http://localhost:5173/")
  @GetMapping("/greet")
  public Map<String, String> greet(@RequestParam String naam, @RequestParam String language) {
    Map<String, String> response = new HashMap<>();

    switch (language.toLowerCase()) {
        case "english":
            if (naam.toLowerCase().contains("niels")) {
                response.put("message", naam + " is awesome!");
            } 
            else if (naam.toLowerCase().contains("ritesh")) {
                response.put("message", "Hello, " + naam + "!");
            }
            break;

        case "dutch":
            if (naam.toLowerCase().contains("niels")) {
                response.put("message", naam + " is geweldig!");
            } 
            else if (naam.toLowerCase().contains("ritesh")) {
                response.put("message", "Hallo, " + naam + "!");
            }
            break;

        default:
            return null;
    }

    return response;
}

}