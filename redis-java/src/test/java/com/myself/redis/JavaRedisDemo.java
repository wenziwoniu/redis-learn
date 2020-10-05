package com.myself.redis;

import org.junit.Test;
import redis.clients.jedis.Jedis;

public class JavaRedisDemo {

    @Test
    public void redisTester() {

        Jedis jedis = new Jedis("localhost", 6379, 100000);
        jedis.auth("Abcd1234");
        int i = 0;
        try {
            long start = System.currentTimeMillis();
            while (true) {
                long end = System.currentTimeMillis();
                if (end - start > 1000) {
                    break;
                }
                i++;
                jedis.set("test" + i, i + "");
            }

            System.out.println("输出测试：" + jedis.get("myKey"));
        } finally {
            jedis.close();
        }

        System.out.println("redis每秒操作：" + i + "次");

    }
}
