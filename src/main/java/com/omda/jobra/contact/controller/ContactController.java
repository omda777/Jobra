package com.omda.jobra.contact.controller;


import com.omda.jobra.contact.service.IContactService;
import com.omda.jobra.dto.ContactRequestDto;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/contacts")
@AllArgsConstructor
public class ContactController {
    private final IContactService contactService;

    @PostMapping(version = "1.0")
    public ResponseEntity<String> saveContactMsg(
            @RequestBody ContactRequestDto contactRequestDto
            ){

        boolean isSaved = contactService.saveContact(contactRequestDto);
        if(isSaved){
            return ResponseEntity.status(HttpStatus.CREATED)
                    .body("Contact saved successfully");
        }
        else {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Contact not saved successfully");
        }
    }
}
