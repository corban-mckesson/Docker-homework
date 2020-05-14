package com.corban.upskilling.homework.helloname;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class HelloNameApplicationTests {

    @Test
    void hellonameTest(){
        HelloController mycontroller = new HelloController();
        System.out.println(mycontroller.sayHelloPlusName("someName"));
    }

}
