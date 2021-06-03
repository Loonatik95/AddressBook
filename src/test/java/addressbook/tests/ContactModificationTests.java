package addressbook.tests;

import addressbook.model.ContactDate;
import addressbook.model.Contacts;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class ContactModificationTests extends TestBase {

    @BeforeEach
    public void ensurePreconditions() {
        if (app.contact().all().size() == 0) {
            app.goTo().contactPage();
            app.contact().create(new ContactDate().withFirstname("karapuz").withLastname("sasha")
                    .withAddress("gomel").withPhone("783097").withEmail("karapuz@tut.by"), false);
        }
    }

    @Test
    public void testContactModification() {
        Contacts before = app.contact().all();
        ContactDate modifiedContact = before.iterator().next();
        ContactDate contact = new ContactDate().withFirstname("karapuz").withLastname("sasha");
        app.contact().modify(contact);
        assertThat(app.group().count(), equalTo(before.size()));
        Contacts after = app.contact().all();
        assertThat(after, equalTo(before.without(modifiedContact).withAdded(contact)));
    }
}
