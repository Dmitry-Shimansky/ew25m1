package runner;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import tests.SendOrderBottomFormTest;
import tests.SendOrderTopFormTest;

@RunWith(Suite.class)
@Suite.SuiteClasses({
        SendOrderBottomFormTest.class,
        SendOrderTopFormTest.class
})

public class JUnit4Runner {
}
