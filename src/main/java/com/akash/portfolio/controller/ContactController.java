package com.akash.portfolio.controller;

import com.akash.portfolio.entity.Contact;
import com.akash.portfolio.repository.ContactRepository;
import com.akash.portfolio.service.ContactService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@AllArgsConstructor
public class ContactController {
    private final ContactService contactService;
    private final ContactRepository contactRepository;

    @PostMapping("/contact")
    public String saveContact(Contact contact){
        contactService.save(contact);
        return "redirect:/";
    }
    @GetMapping("/delete-message/{id}")
    public String deleteMessage(@PathVariable Long id){

        contactRepository.deleteById(id);

        return "redirect:/messages";
    }

}
