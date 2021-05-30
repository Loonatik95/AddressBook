package addressbook.tests;

import addressbook.model.ContactDate;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

public class ContactDeletionTests extends TestBase {
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
    public void testContactDeletion() {
        List<ContactDate> before = app.contact().list();
        int index = before.size() - 1;
        app.contact().delete(index);
        app.goTo().alert();
//        идти на дом
        List<ContactDate> after = app.contact().list();
        Assertions.assertEquals(after.size(), index);

        before.remove(index);
        Assertions.assertEquals(before, after);
    }
}
