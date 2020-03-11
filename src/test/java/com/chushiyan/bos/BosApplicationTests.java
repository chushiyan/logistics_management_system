package com.chushiyan.bos;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.RandomStringUtils;
import org.junit.jupiter.api.Test;

import org.springframework.boot.test.context.SpringBootTest;

import java.nio.ByteBuffer;
import java.util.Base64;
import java.util.UUID;

@SpringBootTest
@Slf4j
class BosApplicationTests {

    @Test
    void contextLoads() {
    }

    @Test
    public void test1(){

        for(int i = 0;i <50;i++){
            log.info(RandomStringUtils.randomNumeric(10));
        }
    }

    @Test
    public  void shortUUID() {
        UUID uuid = UUID.randomUUID();
        System.out.println("--------------------------------");
        System.out.println(shortUUID(uuid));
        System.out.println("--------------------------------");

    }

    public  String shortUUID(UUID uuid) {
        ByteBuffer byteBuffer = ByteBuffer.allocate(16);
        byteBuffer.putLong(uuid.getMostSignificantBits());
        byteBuffer.putLong(uuid.getLeastSignificantBits());

        return Base64.getEncoder().withoutPadding().encodeToString(byteBuffer.array());
    }
}
