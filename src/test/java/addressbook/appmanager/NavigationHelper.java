package addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class NavigationHelper extends HelperBase {

    public NavigationHelper(WebDriver driver) {
        super(driver);
    }

    public void gotoGroupPage() {
        click(By.linkText("GROUPS"));
    }

    public void gotoContactPage() {
        click(By.linkText("ADD_NEW"));
    }

    public void buttonHome() {
        click(By.xpath("//a[text()='HOME']"));
    }

    public void alert() {
        driver.switchTo().alert().accept();
    }
}
