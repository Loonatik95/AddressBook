package addressbook.appmanager;

import addressbook.model.ContactDate;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

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
            Assertions.assertTrue(isElementPresented(By.name("new_group")));
        }
    }

    public void selectContact(int idex) {
        driver.findElements(By.name("selected[]")).get(idex).click();
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
        return isElementPresented(By.name("selected[]"));
    }

    public int getContactCount() {
        return driver.findElements(By.name("selected[]")).size();
    }

    public List<ContactDate> getContactList() {
        List<ContactDate> contacts = new ArrayList<>();
        Comparator<ContactDate> comparator = Comparator.comparing(ContactDate::getFirstname)
                .thenComparing(ContactDate::getLastname);
        List<WebElement> elements = driver.findElements(By.name("entry"));
        for (WebElement element : elements) {
            String lastname = element.findElement(By.xpath("./td[2]")).getText();
            String name = element.findElement(By.xpath("./td[3]")).getText();
            contacts.add(new ContactDate(name, lastname));
        }
        Collections.sort(contacts, comparator);
        return contacts;
    }
}
