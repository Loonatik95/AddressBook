package addressbook.tests;

import addressbook.model.ContactDate;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

public class ContactModificationTests extends TestBase {
    @BeforeEach
    public void ensurePreconditions(){
//        app.goTo().contactPage();
        if (app.contact().list().size() == 0) {
            app.goTo().contactPage();
            app.contact().create(new ContactDate().withFirstname("karapuz").withLastname("sasha")
                    .withAddress("gomel").withPhone("783097").withEmail("karapuz@tut.by"), false);
        }
    }

    @Test
    public void testContactModification() {
        List<ContactDate> before = app.contact().list();
        int index = before.size() - 1;
        ContactDate contact = new ContactDate().withFirstname("karapuz").withLastname("sasha7");
//        изменить кнопку update
        app.contact().modify(index, contact);
        app.contact().returnHomePage();
        List<ContactDate> after = app.contact().list();
        Assertions.assertEquals(after.size(), before.size());

//        before.remove(index);
//        before.add(contact);
        Assertions.assertEquals(before, after);
    }
}
