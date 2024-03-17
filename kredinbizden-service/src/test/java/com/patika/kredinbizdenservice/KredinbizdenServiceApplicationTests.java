package com.patika.kredinbizdenservice;

import com.patika.kredinbizdenservice.model.User;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class KredinbizdenServiceApplicationTests {

    public static void main(String[] args) {
        User user1 = new User("Burcu","Kündüm","burcu@gmail.com");
        User user2 = new User("Burcu","hkahd","burcu@gmail.com");
    }


    @Test
    void contextLoads() {
    }

}
