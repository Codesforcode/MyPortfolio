package com.akash.portfolio.controller;

import com.akash.portfolio.entity.Contact;
import com.akash.portfolio.service.ContactService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@AllArgsConstructor
public class ContactController {
    private final ContactService contactService;

    @PostMapping("/contact")
    public String saveContact(Contact contact){
        contactService.save(contact);
        return "redirect:/";
    }

}
