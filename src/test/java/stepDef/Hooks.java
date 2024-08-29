package stepDef;
//hook penting untuk web untuk menggil selenium
import io.cucumber.java.After;
import io.cucumber.java.AfterAll;
import io.cucumber.java.Before;
import io.cucumber.java.BeforeAll;

import java.beans.IntrospectionException;

import static helper.utility.quitDriver;
import static helper.utility.startDriver;

public class Hooks {
    @BeforeAll
    public static void setUp(){

    }

    @AfterAll
    public static void tearDown(){

    }

    @Before
    public void beforeTest(){
        startDriver();
    }

    @After
    public void afterTest() throws InterruptedException {
        Thread.sleep(3000);
        quitDriver();
    }
}
