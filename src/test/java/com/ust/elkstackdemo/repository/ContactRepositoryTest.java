package com.ust.elkstackdemo.repository;

import com.ust.elkstackdemo.model.Contact;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ContactRepositoryTest {
    /**
     * Test cases to be generated
     *
     * 1. addContact_WithValidContact_ShouldAddContact
     * 2. addContact_WithNullName_ShouldThrowException
     * 3. addContact_WithEmptyName_ShouldThrowException
     * 4. addContact_WithNullPhoneNumber_ShouldThrowException
     * 5. addContact_WithEmptyPhoneNumber_ShouldThrowException
     * 6. addContact_WithExistingContact_ShouldThrowException
     * 7. getContacts_WithNoContacts_ShouldReturnEmptyList
     * 8. getContacts_WithContacts_ShouldReturnAllContacts
     * 9. getContactsByPhoneNumber_WithExistingPhoneNumber_ShouldReturnContact
     * 10. getContactsByPhoneNumber_WithNonExistingPhoneNumber_ShouldReturnEmptyList
     * 11. getContactsByName_WithExistingName_ShouldReturnContact
     * 12. getContactsByName_WithNonExistingName_ShouldReturnEmptyList
     * 13. removeContactByPhoneNumber_WithExistingPhoneNumber_ShouldRemoveContact
     * 14. removeContactByPhoneNumber_WithNonExistingPhoneNumber_ShouldThrowException
     * 15. removeContactByPhoneNumber_WithLongerPhoneNumber_ShouldThrowException
     * 16. removeContactByPhoneNumber_WithNullPhoneNumber_ShouldThrowException
     * 17. removeContactByPhoneNumber_WithNonNumericPhoneNumber_ShouldThrowException
     * 18. getContactsByPhoneNumber_WithNonNumericPhoneNumber_ShouldThrowException
     * 19. getContactsByName_WithNullName_ShouldThrowException
     * 20. getContactsByName_WithEmptyName_ShouldThrowException
     *
     * Instructions:
     * 1. While checking for exceptions, ensure the correct exception object is throw
     * and the exception message is correct.
     *
     * 2. Use the DisplayName annotation to give a meaningful name to the test case.
     *
     * 3. Use the @BeforeEach annotation to initialize the ContactRepository object.
     *
     * 4. Ensure code coverage of the ContactRepository class is 100%.
     */

    ContactRepository contactRepository;
    Contact validContact, contactWithNullName
            , contactWithEmptyName, contactWithNullPhoneNumber
            , contactWithEmptyPhoneNumber, existingContact;

    @BeforeEach
    void setUp() {
        contactRepository = new ContactRepository();
        validContact = new Contact("John Doe", "john.doe", "1234567890");
        contactWithNullName = new Contact(null, "john.doe", "1234567890");
        contactWithEmptyName = new Contact("", "john.doe", "1234567890");
        contactWithNullPhoneNumber = new Contact("John Doe", "john.doe", null);
        contactWithEmptyPhoneNumber = new Contact("John Doe", "john.doe", "");
        existingContact = new Contact("John Doe", "john.doe", "1234567890");
    }

    @Test
    @DisplayName("Add contact with valid contact should add contact")
    void addContact_WithValidContact_ShouldAddContact() {
        contactRepository.addContact(validContact);
        assertEquals(1, contactRepository.getContacts().size());
        assertEquals(validContact, contactRepository.getContacts().get(0));
    }

    @Test
    @DisplayName("Add contact with null name should throw exception")
    void addContact_WithNullName_ShouldThrowException() {
        var ex = assertThrows(IllegalArgumentException.class, () -> contactRepository.addContact(contactWithNullName));
        assertEquals("Name is null or empty.", ex.getMessage());
    }

}