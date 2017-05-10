//package com.io2;
//
//
//import com.io2.utils.DelayedInputFirefoxDriver;
//import org.junit.After;
//import org.junit.Before;
//import org.junit.runner.RunWith;
//import org.springframework.boot.context.embedded.LocalServerPort;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.test.context.junit4.SpringRunner;
//
//import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT;
//
///**
// * Created by Niki on 2017-05-08.
// */
//@RunWith(SpringRunner.class)
//@SpringBootTest(webEnvironment = RANDOM_PORT)
//public class AddSneakersTest {
//
//    private DelayedInputFirefoxDriver webDriver;
//    @LocalServerPort
//    private int port;
//
//    @Before
//    public void setUp() throws Exception {
//        webDriver = new DelayedInputFirefoxDriver();
//        //  webDriver.manage().window().maximize();
//    }
//
//    @After
//    public void tearDown() throws Exception {
//        webDriver.quit();
//    }
//}
