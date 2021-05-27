package addressbook.tests;

import addressbook.model.GroupDate;
import org.junit.jupiter.api.Test;

public class GroupCreationTests extends TestBase {

    @Test
    public void testGroupCreationTests() {
        app.getNavigationHelper().gotoGroupPage();
        app.getGroupHelper().createGroup(new GroupDate("test1", "test2", "test3"));
    }
}
