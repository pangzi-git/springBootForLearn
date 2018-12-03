package com.springBoot.redisService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;

import javax.annotation.Resource;
import java.util.concurrent.TimeUnit;

public abstract class IRedisService <T> {

        @Autowired
        protected RedisTemplate<String, Object> redisTemplate;
        @Resource
        protected HashOperations<String, String, T> hashOperations;

        /**
         * 存入redis中的key
         *
         * @return
         */
        protected abstract String getRedisKey();

        /**
         * 添加
         *
         * @param key    key
         * @param doamin 对象
         * @param expire 过期时间(单位:秒),传入 -1 时表示不设置过期时间
         */
        public void put(String key, T doamin, long expire) {
            hashOperations.put(getRedisKey(), key, doamin);
            if (expire != -1) {
                redisTemplate.expire(getRedisKey(), expire, TimeUnit.SECONDS);
            }
        }

        /**
         * 删除
         *
         * @param key 传入key的名称
         */
        public void remove(String key) {
            hashOperations.delete(getRedisKey(), key);
        }

        /**
         * 查询
         *
         * @param key 查询的key
         * @return
         */
        public T get(String key) {
            return hashOperations.get(getRedisKey(), key);
        }
}
