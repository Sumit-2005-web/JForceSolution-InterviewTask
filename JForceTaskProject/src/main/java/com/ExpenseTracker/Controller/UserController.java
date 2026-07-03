package com.ExpenseTracker.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.ExpenseTracker.Entity.User;
import com.ExpenseTracker.Impl.userServiceImpl;

import jakarta.servlet.http.HttpSession;

@Controller
public class UserController {
	@Autowired
    private userServiceImpl usimpl;

    @GetMapping("/login")
    public String showLoginPage() {
        return "login"; 
    }

    @PostMapping("/loginUser")
    public String loginUser(@RequestParam String userName, @RequestParam String password, HttpSession session, Model model) {
        return usimpl.loginUser(userName, password)
                .map(user -> {
                    session.setAttribute("loggedInUser", user);
                    return "redirect:/"; 
                })
                .orElseGet(() -> {
                    model.addAttribute("error", "Invalid username or password");
                    return "login";
                });
    }

    @GetMapping("/register")
    public String showRegistrationPage(Model model) {
        model.addAttribute("user", new User());
        return "register";
    }

    @PostMapping("/saveUser")
    public String registerUser(@ModelAttribute User user) {
        usimpl.registerUser(user);
        return "redirect:/login";
    }
}
