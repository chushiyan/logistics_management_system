package com.chushiyan.bos;

import org.springframework.util.StringUtils;

import java.nio.ByteBuffer;
import java.util.Base64;
import java.util.UUID;

/**
 * @author chushiyan
 * @email Y2h1c2hpeWFuMDQxNUAxNjMuY29t(base64)
 * @description
 */

public class MyTest {

    public static void main(String[] args) {

        for (int i = 0; i < 50; i++) {
            UUID uuid = UUID.randomUUID();
//            System.out.println("--------------------------------");
            System.out.println(shortUUID(uuid));
//            System.out.println("--------------------------------");
        }

    }


    public static String shortUUID(UUID uuid) {
        ByteBuffer byteBuffer = ByteBuffer.allocate(16);
        byteBuffer.putLong(uuid.getMostSignificantBits());
        byteBuffer.putLong(uuid.getLeastSignificantBits());

        return Base64.getEncoder().withoutPadding().encodeToString(byteBuffer.array())
                .replace("/", "1")
                .replace("+", "2");
    }
}
