import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import org.junit.After;
import org.junit.Before;

public class BaseTest {

    @Before
    public void startup(){
        System.setProperty("selenide.browser", "edge");
        Configuration.browserSize = "1920x180";
    }

    @After
    public void teardown() {
        Selenide.closeWindow();
    }
}

