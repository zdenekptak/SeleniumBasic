package test;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

/* Zapis aby pocitac vedel ze chceme testy spoustet pomoci suite */
@RunWith(Suite.class)

/* Definice test suite */
/* Seznam testu ktere budeme chtit spoustet */
@Suite.SuiteClasses({
        ClickMeTest.class,
        CssSelectorTest.class,
        MySecondTest.class,
        StroopTest.class,
        KalkulackaTest.class,
        registrace.class,
        ZenaMuzTest.class,
})


public class TestSuite {
}
