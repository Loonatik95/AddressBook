package addressbook.tests;

import addressbook.model.ContactDate;
import org.junit.jupiter.api.Test;

public class ContactDeletionTests extends TestBase {

    @Test
    public void testContactDeletion() {
        app.getNavigationHelper().gotoContactPage();
        if (!app.getContactHelper().isThereAContact()) {
            app.getContactHelper().createContact(new ContactDate("Sasha", "Karapuz", "Gomel",
                    "783890", "karapuz@tut.by", "test1"), true);
        }
        app.getContactHelper().selectContact();
        app.getContactHelper().buttonDeleteContact();
        app.getNavigationHelper().alert();
    }
}
