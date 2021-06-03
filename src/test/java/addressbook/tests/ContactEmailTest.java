package addressbook.tests;

import addressbook.model.ContactDate;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class ContactEmailTest extends TestBase {

    @BeforeEach
    public void ensurePreconditions() {
        if (app.contact().all().size() == 0) {
            app.goTo().contactPage();
            app.contact().create(new ContactDate().withFirstname("karapuz").withLastname("sasha")
                    .withAddress("gomel").withPhone("783097").withEmail("karapuz@tut.by"), false);
        }
    }

    @Test
    public void testEmail() {
//        app.goTo().gotoHomePage();
        ContactDate contact = app.contact().all().iterator().next();
        ContactDate contactInfoFromEditForm = app.contact().infoFromEditForm(contact);

        assertThat(contact.getAllEmails(), equalTo(mergeEmails(contactInfoFromEditForm)));
    }

    private String mergeEmails(ContactDate contact) {
        return Stream.of(contact.getEmail(), contact.getEmail2(), contact.getEmail3())
                .filter(s -> !s.equals(""))
                .collect(Collectors.joining("\n"));
    }
}
