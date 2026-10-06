package com.omda.jobra.contact.service;

import com.omda.jobra.dto.ContactRequestDto;

public interface IContactService {

    public boolean saveContact(ContactRequestDto contactRequestDto);
}
