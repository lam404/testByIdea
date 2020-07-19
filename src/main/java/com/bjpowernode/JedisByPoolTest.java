package com.bjpowernode;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

public class JedisByPoolTest {
    public static void main(String[] args) {
        JedisPoolConfig config = new JedisPoolConfig();
        //设置最大连接数
        config.setMaxTotal(10);
        //设置空闲连接数
        config.setMaxIdle(3);
        config.setTestOnBorrow(true);
        JedisPool jedisPool = new JedisPool(config, "192.168.19.128");
        Jedis jedis = jedisPool.getResource();
        //清除数据
        jedis.flushDB();
        //选择操作的数据库
        jedis.select(0);
        String master = jedis.get("master");
        System.out.println(master);
    }
}
