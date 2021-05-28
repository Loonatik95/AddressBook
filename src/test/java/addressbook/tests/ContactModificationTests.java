package addressbook.tests;

import addressbook.model.ContactDate;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class ContactModificationTests extends TestBase {

    @Test
    public void testContactModification() {
        app.getNavigationHelper().gotoContactPage();
        if (!app.getContactHelper().isThereAContact()) {
            app.getContactHelper().createContact(new ContactDate("Sasha", "Karapuz", "Gomel",
                    "783890", "karapuz@tut.by", "[NONE]"), true);
        }
        List<ContactDate> before = app.getContactHelper().getContactList();
        app.getContactHelper().selectContact(before.size() - 1);
        app.getContactHelper().initContactModification();
        ContactDate contact = new ContactDate("Sasha", "BigBoss");
        app.getContactHelper().fillContactForm(contact, false);
        app.getContactHelper().submitContactModification();
        app.getContactHelper().returnToGroupPage();
        List<ContactDate> after = app.getContactHelper().getContactList();
        Assertions.assertEquals(after.size(), before.size());

        before.remove(before.size() - 1);
        before.add(contact);
        Assertions.assertEquals(before, after);
    }
}
