package addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class NavigationHelper extends HelperBase {

    public NavigationHelper(WebDriver driver) {
        super(driver);
    }

    public void groupPage() {
        if (isElementPresented(By.tagName("h1"))
                && driver.findElement(By.tagName("h1")).getText().equals("Groups")
                && isElementPresented(By.linkText("groups"))) {
            return;
        }
        click(By.linkText("GROUPS"));
    }

    public void contactPage() {
        click(By.linkText("ADD_NEW"));
    }

    public void gotoHomePage() {
//        if (isElementPresented(By.id("maintable"))) {
//            return;
//        }
        click(By.xpath("//a[text()='HOME']"));
    }

    public void alert() {
        driver.switchTo().alert().accept();
    }


}
