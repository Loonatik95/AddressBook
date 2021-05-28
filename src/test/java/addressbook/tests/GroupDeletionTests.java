package addressbook.tests;

import addressbook.model.GroupDate;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class GroupDeletionTests extends TestBase {

    @Test
    public void testGroupDeletion() {
        app.getNavigationHelper().gotoGroupPage();
        if (!app.getGroupHelper().isThereAGroup()) {
            app.getGroupHelper().createGroup(new GroupDate("test1", null, null));
        }
        List<GroupDate> before = app.getGroupHelper().getGroupList();
        app.getGroupHelper().selectGroup(before.size() - 1);
        app.getGroupHelper().deleteSelectedGroups();
        app.getGroupHelper().returnToGroupPage();
        List<GroupDate> after = app.getGroupHelper().getGroupList();
        Assertions.assertEquals(after.size(), before.size() - 1);

        before.remove(before.size() - 1);
        Assertions.assertEquals(before, after);
    }

}
