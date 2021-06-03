package addressbook.appmanager;

import addressbook.model.GroupDate;
import addressbook.model.Groups;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class GroupHelper extends HelperBase {

    private Groups groupsCache = null;

    public GroupHelper(WebDriver driver) {
        super(driver);
    }

    public void returnToGroupPage() {
        click(By.linkText("group page"));
    }

    public void fillGroupForm(GroupDate groupDate) {
        type(By.name("group_name"), groupDate.getName());
        type(By.name("group_header"), groupDate.getHeader());
        type(By.name("group_footer"), groupDate.getFooter());
    }

    public void submitGroupCreation() {
        click(By.name("submit"));
    }

    public void initGroupCreation() {
        click(By.name("new"));
    }

    public void selectGroupById(int id) {
        driver.findElement(By.cssSelector("input[value='" + id + "']")).click();
    }

    public void deleteSelectedGroups() {
        click(By.name("delete"));
    }

    public void initGroupModification() {
        click(By.name("edit"));
    }

    public void submitGroupModification() {
        click(By.name("update"));
    }

    public void create(GroupDate group) {
        initGroupCreation();
        fillGroupForm(group);
        submitGroupCreation();
        groupsCache = null;
        returnToGroupPage();
    }

    public Groups all() {
        if (groupsCache != null) {
            return new Groups(groupsCache);
        }
        groupsCache = new Groups();
        List<WebElement> elements = driver.findElements(By.cssSelector("span.group"));
        for (WebElement element : elements) {
            String name = element.getText();
            int id = Integer.parseInt(element.findElement(By.tagName("input")).getAttribute("value"));
            groupsCache.add(new GroupDate().withId(id).withName(name));
        }
        return new Groups(groupsCache);
    }

    public void modify(GroupDate group) {
        selectGroupById(group.getId());
        initGroupModification();
        fillGroupForm(group);
        submitGroupModification();
        groupsCache = null;
        returnToGroupPage();
    }

    public void delete(GroupDate group) {
        selectGroupById(group.getId());
        deleteSelectedGroups();
        groupsCache = null;
        returnToGroupPage();
    }

    public int count() {
        return driver.findElements(By.name("selected[]")).size();
    }
}
