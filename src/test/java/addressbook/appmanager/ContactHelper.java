package addressbook.appmanager;

import addressbook.model.ContactDate;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.*;

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
        }
//        else {
//            Assertions.assertTrue(isElementPresented(By.name("new_group")));
//        }
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

    public void create(ContactDate contact, boolean c) {
        fillContactForm(contact, c);
        submitContactCreation();
        returnToGroupPage();
    }

    public void delete(int index) {
        selectContact(index);
        buttonDeleteContact();
    }

    public void modify(int index, ContactDate contact) {
        selectContact(index);
        initContactModification();
        fillContactForm(contact, false);
        submitContactModification();
//        returnToGroupPage();
    }

    public void returnToGroupPage() {
        click(By.linkText("home page"));
    }

    public List<ContactDate> list() {
        List<ContactDate> contacts = new ArrayList<>();
        Comparator<ContactDate> comparator = Comparator.comparing(ContactDate::getFirstname)
                .thenComparing(ContactDate::getLastname);
        List<WebElement> elements = driver.findElements(By.name("entry"));
        for (WebElement element : elements) {
            String lastname = element.findElement(By.xpath("./td[2]")).getText();
            String name = element.findElement(By.xpath("./td[3]")).getText();
            contacts.add(new ContactDate().withFirstname(name).withLastname(lastname));
        }
        Collections.sort(contacts, comparator);
        return contacts;
    }

    public void returnHomePage() {
        click(By.linkText("home page"));
    }

//    public ContactDate infoFromEditForm(ContactDate contact) {
//        initContactModificationById(contact.getId());
//        String firstname = driver.findElement(By.name("firstname")).getAttribute("value");
//        String lastname = driver.findElement(By.name("lastname")).getAttribute("value");
//        String home = driver.findElement(By.name("home")).getAttribute("value");
//        String mobile = driver.findElement(By.name("mobile")).getAttribute("value");
//        String work = driver.findElement(By.name("work")).getAttribute("value");
//        driver.navigate().back();
//        return new ContactDate().withId(contact.getId()).withFirstname(firstname).withLastname(lastname).
//                withHomePhone(home).withMobilePhone(mobile).withWorkPhone(work);
//    }
//
//    private void initContactModificationById(int id){
//        WebElement checkbox= driver.findElement(By.cssSelector(String.format("input[value='%s']", id)));
//        WebElement row = checkbox.findElement(By.xpath("./../.."));
//        List<WebElement> cells = row.findElements(By.tagName("td"));
//        cells.get(7).findElement(By.tagName("a")).click();
//    }
}
