package com.util;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

/**
 * Created by bingchenglin on 2016/8/22.
 */
public class RedisUtil {

    private static JedisPool jedisPool;
    static {
        jedisPool = new JedisPool(new JedisPoolConfig(),"127.0.0.1");
    }

    public synchronized static Jedis getResource(){
        try {
            if (jedisPool != null){
                return jedisPool.getResource();
            }else{
                return null;
            }
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

    public void closeResource(Jedis jedis){
       // jedisPool.returnBrokenResource(jedis);�˷����ѱ��������ٷ��Ѿ���д��close�������ڲ�����գ����Դ�us��
        if(jedis != null){
            jedis.close();
        }
    }




}
