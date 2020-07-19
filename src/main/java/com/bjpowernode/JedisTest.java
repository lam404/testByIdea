package com.bjpowernode;

import redis.clients.jedis.Jedis;

public class JedisTest {
    public static void main(String[] args) {
        Jedis jedis = new Jedis("192.168.19.128",6379);
        jedis.auth("123456");
        jedis.select(0);
        jedis.flushAll();


        String append = jedis.set("master", "batman");
        String master = jedis.get("master");
        System.out.println(master);


    }
}
