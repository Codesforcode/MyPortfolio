package com.akash.portfolio.controller;

import com.akash.portfolio.repository.ContactRepository;
import com.akash.portfolio.repository.ProjectRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@AllArgsConstructor
public class AdminController {

    private final ProjectRepository projectRepository;
    private final ContactRepository contactRepository;
    @GetMapping("/messages")
    public String getMessages(Model model){
        model.addAttribute("messages",contactRepository.findAll());
        return "messages";
    }
    @GetMapping("/admin")
    public String adminDashboard(Model model){

        model.addAttribute(
                "projectCount",
                projectRepository.count()
        );

        model.addAttribute(
                "messageCount",
                contactRepository.count()
        );

        return "admin";
    }
}
