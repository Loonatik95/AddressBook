package addressbook.tests;

import addressbook.model.ContactDate;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class ContactAddressTests extends TestBase {

    @BeforeEach
    public void ensurePreconditions() {
        if (app.contact().all().size() == 0) {
            app.goTo().contactPage();
            app.contact().create(new ContactDate().withFirstname("karapuz").withLastname("sasha")
                    .withAddress("gomel").withPhone("783097").withEmail("karapuz@tut.by"), false);
        }
    }

    @Test
    public void testAddress() {
//        app.goTo().gotoHomePage();
        ContactDate contact = app.contact().all().iterator().next();
        ContactDate contactInfoFromEditForm = app.contact().infoFromEditForm(contact);

        assertThat(cleaned(contact.getAddress()), equalTo(cleaned(contactInfoFromEditForm.getAddress())));

    }

    private static String cleaned(String address) {
        return address.replaceAll("\\n", "").replaceAll("\\s", "");
    }
}
