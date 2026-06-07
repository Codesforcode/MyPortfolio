package com.akash.portfolio.controller;

import com.akash.portfolio.repository.ProjectRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@AllArgsConstructor
public class HomeController {
    private final ProjectRepository projectRepository;

    @GetMapping("/")
    public String home(Model model){

        model.addAttribute(
                "projects",
                projectRepository.findAll()
        );

        return "index";
    }

}
