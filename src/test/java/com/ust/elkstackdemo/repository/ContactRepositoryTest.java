package com.ust.elkstackdemo.repository;

import com.ust.elkstackdemo.model.Contact;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
<<<<<<< HEAD

import java.util.List;

import static org.apache.logging.log4j.util.LambdaUtil.getMessage;
=======
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

>>>>>>> upstream/main
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ContactRepositoryTest {
    /**
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
//1. addContact_WithValidContact_ShouldAddContact
    private ContactRepository contactRepository;
    @BeforeEach
    void setUp() {
        contactRepository = new ContactRepository();
    }
    @Test
    @DisplayName("Add Contact with Valid Contact Should Add Contact")
    void addContact_WithValidContact_ShouldAddContact() {
        Contact contact = new Contact("Vathsav", "vathsav@gmail.com", "9876543210");
        contactRepository.addContact(contact);
        List<Contact> contacts = contactRepository.getContacts();
        assertEquals(1, contacts.size());
        assertTrue(contacts.contains(contact));
    }

<<<<<<< HEAD
//2. addContact_WithNullName_ShouldThrowException

    @Test
    @DisplayName("Add Contact with Null Name Should Throw Exception")
    void addContact_WithNullName_ShouldThrowException() {
        Contact contact = new Contact(null,"nav@gmail.com", "9876543210" );
        IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class, () -> contactRepository.addContact(contact));
        assertEquals("Contact name is empty", thrown.getMessage());
    }
//3. addContact_WithEmptyName_ShouldThrowException

    @Test
    @DisplayName("Add Contact with Empty Name Should Throw Exception")
    void addContact_WithEmptyName_ShouldThrowException() {
        Contact contact = new Contact("", "XXXXXXXXXXXXX", "9876543210");
        IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class, () -> contactRepository.addContact(contact));
        assertEquals("Contact name is empty", thrown.getMessage());
    }
//4. addContact_WithNullPhoneNumber_ShouldThrowException
    @Test
    @DisplayName("Add Contect with Null Phone number Should Throw Exception")
    void addContact_withNullPhoneNumber_ShouldThrowException(){
        Contact contact = new Contact("Vathsav", "XXXXXXXXXXXXXXXXX", null);
        IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class, () -> contactRepository.addContact(contact));
        assertEquals("Contact phone number is empty", thrown.getMessage());
    }
// 5. addContact_WithEmptyPhoneNumber_ShouldThrowException
    @Test
    @DisplayName("Add Contact with Empty Phone number Should Throw Exception")
    void addContect_withEmptyPhoneNumber_ShouldThrowException(){
        Contact contact = new Contact("Vathsav", "XXXXXXXXXXXXXXXXX", "");
        IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class, () -> contactRepository.addContact(contact));
        assertEquals("Contact phone number is empty", thrown.getMessage());
    }
//6. addContact_WithExistingContact_ShouldThrowException
    @Test
    @DisplayName("Add Contact With Existing Contact Should Throw Exception")
    void addContact_withExistingContact_ShouldThrownException(){
        Contact contact = new Contact("Vathsav", "XXXXXXXXXXXXXXXXX", "9876543210");
        contactRepository.addContact(contact);
        IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class,() -> contactRepository.addContact(contact));
        assertEquals("Contact already exists", thrown.getMessage());
    }
// 7. getContacts_WithNoContacts_ShouldReturnEmptyList
    @Test
    @DisplayName("Get Contacts with No Contacts Should Return Empty List")
    void getContacts_WithNoContacts_ShouldReturnEmptyList(){
        List<Contact> contacts = contactRepository.getContacts();
        assertTrue(contacts.isEmpty());
    }
// 8. getContacts_WithContacts_ShouldReturnAllContacts
    @Test
    @DisplayName("Get Contact With Contacts Should Return AllContacts")
    void getContacts_WithContacts_ShouldReturnAllContacts(){
        Contact contact = new Contact("Vathsav", "XXXXXXXXXXXXXXXXX", "9876543210");
        contactRepository.addContact(contact);
        List<Contact> contacts = contactRepository.getContacts();
        assertEquals(1, contacts.size());
        assertTrue(contacts.contains(contact));
    }
//9.getContactsByPhoneNumber_WithExistingPhoneNumber_ShouldReturnContact
    @Test
    @DisplayName("Get Contacts By Phone Number With Existing Phone number Should Return Contact")
    void getContactsByPhoneNumber_withExistingPhoneNumber_ShouldReturnContact(){
        Contact contact = new Contact("Vathsav", "XXXXXXXXXXXXXXXXX", "9876543210");
        contactRepository.addContact(contact);
        List<Contact> contacts = contactRepository.getContactsByPhoneNumber("9876543210");
        assertEquals(1, contacts.size());
        assertTrue(contacts.contains(contact));

    }
// 10. getContactsByPhoneNumber_WithNonExistingPhoneNumber_ShouldReturnEmptyList
    @Test
    @DisplayName("Get Contact By PhoneNumber With Non Existing PhoneNumber Should Return Empty List")
    void getContactsByPhoneNumber_WithNonExistingPhoneNumber_ShouldReturnEmptyList()
    {
        List<Contact> contacts = contactRepository.getContactsByPhoneNumber("9876543210");
        assertTrue(contacts.isEmpty());
    }
// 11. getContactsByName_WithExistingName_ShouldReturnContact
    @Test
    @DisplayName("getContacts By Name With Existing Name Should Return Contact")
    void getContactsByName_WithExistingName_ShouldReturnContact(){
        Contact contact = new Contact("Vathsav", "XXXXXXXXXXXXXXXXX", "9876543210");
        contactRepository.addContact(contact);
        List<Contact> contacts = contactRepository.getContactsByName("Vathsav");
        assertEquals(1, contacts.size());
        assertTrue(contacts.contains(contact));

    }
//12. getContactsByName_WithNonExistingName_ShouldReturnEmptyList
    @Test
    @DisplayName("Get ContactsByName WithNonExistingName ShouldReturnEmptyList")
    void getContactsByName_WithNonExistingName_ShouldReturnEmptyList()
    {
        List<Contact> contacts = contactRepository.getContactsByName("Vathsav");
        assertTrue(contacts.isEmpty());
    }
// 13. removeContactByPhoneNumber_WithExistingPhoneNumber_ShouldRemoveContact
    @Test
    @DisplayName("Remove Contact By PhoneNumber With Existing PhoneNumber Should Remove Contact")
    void removeContactByPhoneNumber_WithExistingPhoneNumber_ShouldRemoveContact() {
        Contact contact = new Contact("Vathsav", "XXXXXXXXXXXXXXXXX", "9876543210");
        contactRepository.addContact(contact);
        contactRepository.removeContactByPhoneNumber("9876543210");
        List<Contact> contacts = contactRepository.getContacts();
        assertTrue(contacts.isEmpty());
    }
// 14. removeContactByPhoneNumber_WithNonExistingPhoneNumber_ShouldThrowException
   @Test
    @DisplayName("Remove Contact By PhoneNumber With NonExisting PhoneNumber Should Throw Exception")
    void removeContactByPhoneNumber_WithNonExistingPhoneNumber_ShouldThrowException() {
        Contact contact = new Contact("Vathsav", "XXXXXXXXXXXXXXXXX", "9876543210");
        contactRepository.addContact(contact);
        IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class, () -> contactRepository.removeContactByPhoneNumber("9876553210"));
        assertEquals("No contact with phone number", thrown.getMessage());
    }
// 15. removeContactByPhoneNumber_WithLongerPhoneNumber_ShouldThrowException
    @Test
    @DisplayName("Remove Contact By PhoneNumber With Longer PhoneNumber Should Throw Exception")
    void removeContactByPhoneNumber_WithLongerPhoneNumber_ShouldThrowException() {
        Contact contact = new Contact("Vathsav", "XXXXXXXXXXXXXXXXX", "9876543210");
        contactRepository.addContact(contact);
        IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class, () -> contactRepository.removeContactByPhoneNumber("98765432100"));
        assertEquals("Invalid phone number", thrown.getMessage());
    }

// 16. removeContactByPhoneNumber_WithNullPhoneNumber_ShouldThrowException
    @Test
    @DisplayName("Remove Contact By phoneNumber with Null PhoneNumber Should Throw Exception")
    void removeContactByPhoneNumber_WithNullPhoneNumber_ShouldThrowException()
    {
        Contact contact = new Contact("Vathsav", "XXXXXXXXXXXXXXXXX", "9876543210");
        contactRepository.addContact(contact);
        IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class, ()-> contactRepository.removeContactByPhoneNumber(null));
        assertEquals("Invalid phone number", thrown.getMessage());
    }
//17. removeContactByPhoneNumber_WithNonNumericPhoneNumber_ShouldThrowException
    @Test
    @DisplayName("Remove Contact By PhoneNumber With NonNumeric PhoneNumber Should Throw Exception")
    void removeContactByPhoneNumber_WithNonNumericPhoneNumber_ShouldThrowException()
    {
        Contact contact = new Contact("Vathsav", "XXXXXXXXXXXXXXXXX", "9876543210");
        contactRepository.addContact(contact);
        IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class, ()-> contactRepository.removeContactByPhoneNumber("987654321a"));
        assertEquals("Phone number is not a number", thrown.getMessage());
    }
//18. getContactsByPhoneNumber_WithNonNumericPhoneNumber_ShouldThrowException
    @Test
    @DisplayName("Get Contacts By PhoneNumber With NonNumeric PhoneNumber Should Throw Exception")
    void getContactsByPhoneNumber_WithNonNumericPhoneNumber_ShouldThrowException()
    {
        Contact contact = new Contact("Vathsav", "XXXXXXXXXXXXXXXXX", "9876543210");
        contactRepository.addContact(contact);
        IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class, ()-> contactRepository.getContactsByPhoneNumber("987654321a"));
        assertEquals("Phone number is not a number", thrown.getMessage());
    }
//19. getContactsByName_WithNullName_ShouldThrowException
    @Test
    @DisplayName("Get Contacts By Name With Null Name Should Throw Exception")
    void getContactsByName_WithNullName_ShouldThrowException()
    {
        Contact contact = new Contact("Vathsav", "XXXXXXXXXXXXXXXXX", "9876543210");
        contactRepository.addContact(contact);
        IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class, ()-> contactRepository.getContactsByName(null));
        assertEquals("Name is null or empty.", thrown.getMessage());
    }
 // 20. getContactsByName_WithEmptyName_ShouldThrowException
    @Test
    @DisplayName("Get Contacts By Name With Empty Name Should Throw Exception")
    void getContactsByName_WithEmptyName_ShouldThrowException()
    {
        Contact contact = new Contact("Vathsav", "XXXXXXXXXXXXXXXXX", "9876543210");
        contactRepository.addContact(contact);
        IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class, ()-> contactRepository.getContactsByName(""));
        assertEquals("Name is null or empty.", thrown.getMessage());
    }
=======
    @Autowired
    ContactRepository contactRepository;
    Contact validContact, contactWithNullName
            , contactWithEmptyName, contactWithNullPhoneNumber
            , contactWithEmptyPhoneNumber, existingContact;

    @BeforeEach
    void setUp() {
//        contactRepository = new ContactRepository(); // not needed because of @Autowired and @SpringBootTest
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

>>>>>>> upstream/main
}