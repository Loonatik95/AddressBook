package addressbook.tests;

import org.junit.jupiter.api.Test;

public class ContactDeletionTests extends TestBase {

    @Test
    public void testContactDeletion() {
        app.getNavigationHelper().buttonHome();
        app.getContactHelper().selectContact();
        app.getContactHelper().buttonDeleteContact();
        app.getContactHelper().alert();
    }
}
