package addressbook.tests;

import addressbook.model.ContactDate;
import addressbook.model.Contacts;
import org.junit.jupiter.api.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class ContactCreationTests extends TestBase {

    @Test
    public void testContactCreationTests() {
        Contacts before = app.contact().all();
        app.goTo().contactPage();
        ContactDate contact = new ContactDate().withFirstname("karapuz").withLastname("sasha")
                .withAddress("gomel").withPhone("783097").withEmail("karapuz@tut.by");
        app.contact().fillContactForm(contact, false);
        app.contact().submitContactCreation();
        app.contact().returnHomePage();


        Contacts after = app.contact().all();
        assertThat(after.size(), equalTo(before.size()));
    }
}
