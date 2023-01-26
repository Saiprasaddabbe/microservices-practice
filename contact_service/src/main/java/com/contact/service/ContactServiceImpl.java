package com.contact.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.contact.entity.Contact;
@Service
public class ContactServiceImpl implements ContactService {

	List<Contact> list = List.of(

			new Contact(11L, "sai@gmail.com", "sai", 1L),
			new Contact(12L, "sai1@gmail.com", "sai", 1L),
			new Contact(13L, "prasad@gmail.com", "prasad", 2L),
			new Contact(14L, "prasad1@gmail.com", "prasad", 2L),
			new Contact(15L, "saiprasad@gmail.com", "saiprasad", 3L),
			new Contact(16L, "saiprasad1@gmail.com", "saiprasad", 3L)

	);

	@Override
	public List<Contact> getContactOfUser(Long userId) {
		return list.stream().filter(contact -> contact.getUserId().equals(userId)).collect(Collectors.toList());

	}

}
