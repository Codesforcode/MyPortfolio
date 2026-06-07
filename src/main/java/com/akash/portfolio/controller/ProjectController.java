package com.akash.portfolio.controller;

import com.akash.portfolio.entity.Project;
import com.akash.portfolio.repository.ProjectRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@Controller
@AllArgsConstructor
public class ProjectController {
    private final ProjectRepository projectRepository;
    @GetMapping("/add-project")
    public String addProjectPage(Model model){
        model.addAttribute("project",new Project());
        return "add-project";
    }

    @PostMapping("/add-project")
    public String saveProject(
            Project project,
            @RequestParam("image") MultipartFile image
    ) throws IOException {

        if(!image.isEmpty()) {

            String fileName =
                    image.getOriginalFilename();

            Path uploadPath =
                    Paths.get("uploads");

            Files.createDirectories(uploadPath);

            image.transferTo(
                    uploadPath.resolve(fileName)
            );

            project.setImageName(fileName);
        }

        projectRepository.save(project);

        return "redirect:/projects";
    }
    @GetMapping("/delete-project/{id}")
    public String deleteProject(@PathVariable Long id){

        projectRepository.deleteById(id);

        return "redirect:/projects";
    }
    @GetMapping("/projects")
    public String projects(Model model){

        model.addAttribute(
                "projects",
                projectRepository.findAll()
        );

        return "projects";
    }
    @GetMapping("/edit-project/{id}")
    public String editProject(@PathVariable Long id,
                              Model model){

        Project project = projectRepository
                .findById(id)
                .orElse(null);

        if(project == null){
            return "redirect:/projects";
        }

        model.addAttribute(
                "project",
                project
        );

        return "edit-project";
    }
    @PostMapping("/update-project")
    public String updateProject(
            Project project,
            @RequestParam("image") MultipartFile image
    ) throws IOException {

        if(!image.isEmpty()) {

            String fileName =
                    image.getOriginalFilename();

            Path uploadPath =
                    Paths.get("uploads");

            Files.createDirectories(uploadPath);

            image.transferTo(
                    uploadPath.resolve(fileName)
            );

            project.setImageName(fileName);
        }
        else {

            Project existingProject =
                    projectRepository.findById(
                            project.getId()
                    ).orElseThrow();

            project.setImageName(
                    existingProject.getImageName()
            );
        }

        projectRepository.save(project);

        return "redirect:/projects";
    }
    @GetMapping("/project/{id}")
    public String projectDetails(
            @PathVariable Long id,
            Model model){

        Project project =
                projectRepository.findById(id)
                        .orElseThrow();

        model.addAttribute(
                "project",
                project
        );

        return "project-details";
    }

}
