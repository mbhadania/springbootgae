package com.springboot.controller;

import com.google.appengine.api.datastore.DatastoreService;
import com.google.appengine.api.datastore.Entity;
import com.google.appengine.api.datastore.FetchOptions;
import com.google.appengine.api.datastore.Query;
import com.google.appengine.api.users.User;
import com.google.appengine.api.users.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.List;

@Controller
public class GuestbookController {
    @Autowired
    DatastoreService datastoreService;
    @Autowired
    UserService userService;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    String list(Model model, HttpServletRequest request) {
       // Query query = new Query("Greeting").addSort("date", Query.SortDirection.DESCENDING);
       // List<Entity> greetings = datastoreService.prepare(query).asList(FetchOptions.Builder.withLimit(30));
       // model.addAttribute("greetings", greetings);

        User user = userService.getCurrentUser();
        if (user != null) {
            String username = user.getEmail();
            model.addAttribute("username", username.contains("@") ? username.split("@")[0] : username);
            model.addAttribute("logoutUrl", userService.createLogoutURL(request.getRequestURI()));
        } else {
            model.addAttribute("loginUrl", userService.createLoginURL(request.getRequestURI()));
        }
        return "list";
    }

    @RequestMapping(value = "/", method = RequestMethod.POST)
    String greet(@RequestParam("number") int number, Model model) {
        
        model.addAttribute("number", number);
        
        
        
        
        return "list";
    }
}
