package com.company.controller;

import com.company.model.User;
import com.company.servise.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/users")
public class UserController {

    UserService service;

    @Autowired
    public UserController(UserService service) {
        this.service = service;
    }

    @GetMapping()
    public String showAll(Model model) {
        System.out.println(service.getAll());
        model.addAttribute("users", service.getAll());
        return "users/index";
    }

    @GetMapping("/{id}")
    public String showOne(@PathVariable("id") int id, Model model) {
        model.addAttribute("user", service.getById(id));
        System.out.println(service.getById(id));
        return "users/user_info";
    }

    @GetMapping("/new")
    public String newUser(@ModelAttribute("user") User user) {
        return "users/new_user";
    }

    @PostMapping
    public String create(@ModelAttribute("user") User user) {
        service.add(user);
        return "redirect:/users";
    }

    @GetMapping("/{id}/edit")
    public String edit(@PathVariable("id") int id, Model model) {
        model.addAttribute("user", service.getById(id));
        return "users/edit_user";
    }

    @PatchMapping("/{id}")
    public String update(@ModelAttribute("user") User user) {
        service.update(user);
        return "redirect:/users";
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable("id") int id) {
        service.delete(id);
        return "redirect:/users";
    }
}
