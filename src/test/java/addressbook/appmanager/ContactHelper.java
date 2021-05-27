package addressbook.appmanager;

import addressbook.model.ContactDate;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class ContactHelper extends HelperBase {

    public ContactHelper(WebDriver driver) {
        super(driver);
    }

    public void submitContactCreation() {
        click(By.xpath("(//input[@name='submit'])[2]"));
    }

    public void fillContactForm(ContactDate contactDate, boolean creation) {
        type(By.name("firstname"), contactDate.getFirstname());
        type(By.name("lastname"), contactDate.getLastname());
        type(By.name("address"), contactDate.getAddress());
        type(By.name("home"), contactDate.getPhone());
        type(By.name("email"), contactDate.getEmail());

        if (creation) {
            new Select(driver.findElement(By.name("new_group"))).selectByVisibleText(contactDate.getGroup());
        } else {
            Assertions.assertTrue(isElement(By.name("new_group")));
        }
    }

    public void selectContact() {
        click(By.name("selected[]"));
    }

    public void buttonDeleteContact() {
        click(By.xpath("//input[@value='DELETE']"));
    }

    public void initContactModification() {
        click(By.xpath("//img[@alt='EDIT']"));
    }

    public void submitContactModification() {
        click(By.xpath("//input[@name='submit'][2]"));
    }

    public void createContact(ContactDate contact, boolean c) {
        fillContactForm(contact, true);
        submitContactCreation();
        returnToGroupPage();
    }

    public void returnToGroupPage() {
        click(By.linkText("home page"));
    }

    public boolean isThereAContact() {
        return isElement(By.name("selected[]"));
    }
}
