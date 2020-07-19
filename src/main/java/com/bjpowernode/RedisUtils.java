package com.bjpowernode;

import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

public class RedisUtils {
    private  static  String host = "";
    private  static  Integer port = null;
    private  static  Integer auth = null;

    private static JedisPool pool = null;
    public static JedisPool open(){
        if (pool==null){
            JedisPoolConfig jedisPoolConfig = new JedisPoolConfig();
            jedisPoolConfig.setMaxTotal(10);
            jedisPoolConfig.setMaxIdle(3);
            jedisPoolConfig.setTestOnBorrow(true);
            pool = new JedisPool(jedisPoolConfig,host,port,auth);
        }
        return pool;
    }
    public static void close(){
        if (pool!=null){
            pool.close();
        }
    }
}
