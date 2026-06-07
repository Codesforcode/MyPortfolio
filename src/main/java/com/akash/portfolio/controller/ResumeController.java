package com.akash.portfolio.controller;

import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.io.IOException;

@Controller
public class ResumeController {

    @GetMapping("/download-resume")
    public ResponseEntity<Resource> downloadResume() throws IOException {

        Resource resource =
                new ClassPathResource("static/resume/resume.pdf");

        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION,
                        "attachment; filename=Akash_Agrawal_Resume.pdf")
                .body(resource);
    }
}