package addressbook.tests;

import addressbook.model.ContactDate;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class ContactDeletionTests extends TestBase {

    @Test
    public void testContactDeletion() {
        app.getNavigationHelper().gotoContactPage();
        if (!app.getContactHelper().isThereAContact()) {
            app.getContactHelper().createContact(new ContactDate("Sasha", "Karapuz", "Gomel",
                    "783890", "karapuz@tut.by", "[NONE]"), true);
        }
        List<ContactDate> before = app.getContactHelper().getContactList();
        app.getContactHelper().selectContact(before.size() - 1);
        app.getContactHelper().buttonDeleteContact();
        app.getNavigationHelper().alert();
        List<ContactDate> after = app.getContactHelper().getContactList();
        Assertions.assertEquals(after.size(), before.size() - 1);

        before.remove(before.size() - 1);
        Assertions.assertEquals(before, after);
    }
}
