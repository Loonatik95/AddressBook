package addressbook.tests;

import addressbook.model.ContactDate;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class ContactCreationTests extends TestBase {

    @Test
    public void testContactCreationTests() {
        app.getNavigationHelper().gotoContactPage();
        List<ContactDate> before = app.getContactHelper().getContactList();
        ContactDate contact = new ContactDate("Sasha", "Karapuz", "Gomel",
                "783890", "karapuz@tut.by", "[NONE]");
        app.getContactHelper().fillContactForm(contact, true);
        app.getContactHelper().submitContactCreation();
        List<ContactDate> after = app.getContactHelper().getContactList();
        Assertions.assertEquals(after.size(), before.size());

        Assertions.assertEquals(before, after);
    }
}
