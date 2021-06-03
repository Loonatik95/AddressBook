package addressbook.tests;

import addressbook.model.ContactDate;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class ContactFullInfoTest extends TestBase {

    @BeforeEach
    public void ensurePreconditions() {
        if (app.contact().all().size() == 0) {
            app.goTo().contactPage();
            app.contact().create(new ContactDate().withFirstname("karapuz").withLastname("sasha")
                    .withAddress("gomel").withPhone("783097").withEmail("karapuz@tut.by"), false);
        }
    }

    @Test
    public void testFullContactInfo() {
        ContactDate contact = app.contact().all().iterator().next();
        String contactInfoFromHomePage = cleaned(contact.getFullName() + contact.getAddress()
                + contact.getAllPhones() + contact.getAllEmails());
        app.contact().showFullInfo(contact);
        String fullContactInfo = cleaned(app.contact().fullContactInfo());
        assertThat(contactInfoFromHomePage, equalTo(fullContactInfo));
    }

    private static String cleaned(String info) {
        return info.replaceAll("H: ", "").replaceAll("M: ", "").replaceAll("W: ", "")
                .replaceAll("\\s", "").replaceAll("[-()]", "");
    }
}
