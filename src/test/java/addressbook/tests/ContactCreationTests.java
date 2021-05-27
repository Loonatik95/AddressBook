package addressbook.tests;

import addressbook.model.ContactDate;
import org.junit.jupiter.api.Test;

public class ContactCreationTests extends TestBase {

    @Test
    public void testContactCreationTests() {
        app.getNavigationHelper().gotoContactPage();
        app.getContactHelper().fillContactForm(new ContactDate("Sasha", "Karapuz", "Gomel",
                "783890", "karapuz@tut.by", "test1"), true);
        app.getContactHelper().submitContactCreation();
    }

}
