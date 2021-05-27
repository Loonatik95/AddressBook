package addressbook.tests;

import addressbook.model.ContactDate;
import org.junit.jupiter.api.Test;

public class ContactModificationTests extends TestBase {

    @Test
    public void testContactModification() {
        app.getNavigationHelper().gotoContactPage();
        if (!app.getContactHelper().isThereAContact()) {
            app.getContactHelper().createContact(new ContactDate("Sasha", "Karapuz", "Gomel",
                    "783890", "karapuz@tut.by", "test1"), true);
        }
        app.getContactHelper().initContactModification();
        app.getContactHelper().fillContactForm(new ContactDate("Sasha", "Karapuz", "Gomel",
                "783890", "karapuz@tut.by", null), false);
        app.getContactHelper().submitContactModification();
    }
}
