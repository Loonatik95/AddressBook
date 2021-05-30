package addressbook.tests;

import addressbook.model.ContactDate;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class ContactCreationTests extends TestBase {

    @Test
    public void testContactCreationTests() {
        List<ContactDate> before = app.contact().list();
        app.goTo().contactPage();
        ContactDate contact = new ContactDate().withFirstname("karapuz").withLastname("sasha")
                .withAddress("gomel").withPhone("783097").withEmail("karapuz@tut.by");
        app.contact().fillContactForm(contact, false);
        app.contact().submitContactCreation();
        app.contact().returnHomePage();
        List<ContactDate> after = app.contact().list();
        Assertions.assertEquals(after.size(), before.size() + 1);

        before.add(contact);
        Assertions.assertEquals(before, after);
    }
}
