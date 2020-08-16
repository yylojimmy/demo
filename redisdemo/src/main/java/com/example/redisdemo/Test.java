package com.example.redisdemo;

import redis.clients.jedis.Jedis;

public class Test {
    public static void main(String[] args) {
        Jedis jedis = new Jedis("127.0.0.1", 6379);
        jedis.set("hello","world");
        String ping = jedis.ping();
        System.out.println(ping);
    }
}
