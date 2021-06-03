package addressbook.appmanager;

import addressbook.model.ContactDate;
import addressbook.model.Contacts;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class ContactHelper extends HelperBase {

    private Contacts contactCache = null;

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
            Assertions.assertFalse(isElementPresented(By.name("new_group")));
        }
    }

    public void selectContact(int id) {
        driver.findElement(By.cssSelector("input[value='" + id + "']")).click();
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

    public void create(ContactDate contact, boolean c) {
        fillContactForm(contact, c);
        submitContactCreation();
        contactCache = null;
        returnHomePage();
    }

    public void delete(ContactDate contact) {
        selectContact(contact.getId());
        buttonDeleteContact();
        contactCache = null;
    }

    public void showFullInfo(ContactDate contact) {
        driver.findElement(By.cssSelector(String.format("a[href='view.php?id=%s'", contact.getId()))).click();
    }

    public void modify(ContactDate contact) {
        initContactModification(contact);
        fillContactForm(contact, false);
        submitContactModification();
        contactCache = null;
        returnToHomePage();
    }

    public void returnToHomePage() {
        click(By.xpath("//a[text()='HOME']"));
    }


    public Contacts all() {
        if (contactCache != null) {
            return new Contacts(contactCache);
        }
        Contacts contacts = new Contacts();
        List<WebElement> elements = driver.findElements(By.name("entry"));
        for (WebElement element : elements) {
            String lastname = element.findElement(By.xpath("./td[2]")).getText();
            String name = element.findElement(By.xpath("./td[3]")).getText();
            String adress = element.findElement(By.xpath("./td[4]")).getText();
            String allEmails = element.findElement(By.xpath("./td[5]")).getText();
            String allPhones = element.findElement(By.xpath("./td[6]")).getText();
            int id = Integer.parseInt(element.findElement(By.tagName("input")).getAttribute("value"));
            contacts.add(new ContactDate().withFirstname(name).withLastname(lastname).withAllEmails(allEmails)
                    .withAddress(adress).withAllPhones(allPhones));
        }
        return contacts;
    }

    public void returnHomePage() {
        click(By.linkText("home page"));
    }

    public int count() {
        return driver.findElements(By.name("selected[]")).size();
    }

    public ContactDate infoFromEditForm(ContactDate contact) {
//        initContactModificationById(contact.getId());
        initContactModification(contact);
        String firstname = driver.findElement(By.name("firstname")).getAttribute("value");
        String lastname = driver.findElement(By.name("lastname")).getAttribute("value");
        String home = driver.findElement(By.name("home")).getAttribute("value");
        String mobile = driver.findElement(By.name("mobile")).getAttribute("value");
        String work = driver.findElement(By.name("work")).getAttribute("value");
        String address = driver.findElement(By.name("address")).getAttribute("value");
        String email1 = driver.findElement(By.name("email")).getAttribute("value");
        String email2 = driver.findElement(By.name("email2")).getAttribute("value");
        String email3 = driver.findElement(By.name("email3")).getAttribute("value");
        driver.navigate().back();
        return new ContactDate().withId(contact.getId()).withFirstname(firstname).withLastname(lastname)
                .withPhone(home).withMobilePhone(mobile).withWorkPhone(work).withAddress(address).withEmail(email1)
                .withEmail2(email2).withEmail3(email3);
    }

    private void initContactModification(ContactDate contact) {
        driver.findElement(By.cssSelector(String.format("a[href='edit.php?id=%s'", contact.getId()))).click();
    }

    public String fullContactInfo() {
        return driver.findElement(By.id("content")).getText();
    }

}
