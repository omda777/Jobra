package com.omda.jobra.contact.service.impl;


import com.omda.jobra.contact.service.IContactService;
import com.omda.jobra.dto.ContactRequestDto;
import com.omda.jobra.entity.Contact;
import com.omda.jobra.repository.ContactRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.time.Instant;

@Service
@RequiredArgsConstructor
public class ContactService implements IContactService {

    private final ContactRepository contactRepository;

    @Override
    public boolean saveContact(ContactRequestDto contactRequestDto) {
        Contact contact = transformContactRequestDto(contactRequestDto);
        Contact contactSaved = contactRepository.save(contact);
        if(contactSaved == null || contactSaved.getId() == null) {
            return false;
        }
        return true;
    }

    private Contact transformContactRequestDto(ContactRequestDto contactRequestDto) {
        Contact contact = new Contact();
        BeanUtils.copyProperties(contactRequestDto, contact);
        contact.setStatus("NEW");
        return contact;
    }
}
