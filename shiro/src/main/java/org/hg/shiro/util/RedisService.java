package org.hg.shiro.util;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ZSetOperations;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

/**
 * @Author hg
 * @Date 2019/4/8 14:51
 * @Desc
 * @Version 1.0
 **/
@Service
@Slf4j
public class RedisService {
    @Autowired
    RedisTemplate redisTemplate;

    public boolean set(String key, String value) {
        try {
            redisTemplate.opsForValue().set(key, value);
        } catch (Exception e) {
            log.error("set " + key + " " + value, e);
            return false;
        }
        return true;
    }

    /**
     * @param key
     * @param value
     * @param expireTime TimeUnit.SECONDS
     * @return
     */
    public boolean set(String key, String value, long expireTime) {
        try {
            redisTemplate.opsForValue().set(key, value);
            redisTemplate.expire(key, expireTime, TimeUnit.SECONDS);
        } catch (Exception e) {
            log.error("set " + key + " " + value + " " + expireTime, e);
            return false;
        }
        return true;
    }

    public void remove(final String... keys) {
        if (keys == null) {
            return;
        }
        for (String key : keys) {
            redisTemplate.delete(key);
        }
    }

    public void removePattern(final String pattern) {
        Set keys = redisTemplate.keys(pattern);
        if (keys != null && !keys.isEmpty()) {
            redisTemplate.delete(keys);
        }
    }

    public boolean hashKey(final String key) {
        return redisTemplate.hasKey(key);
    }

    public Object getValue(final String key) {
        return redisTemplate.opsForValue().get(key);
    }

    public boolean hmSet(String key, Object hashKey, Object value) {
        try {
            redisTemplate.opsForHash().put(key, hashKey, value);
        } catch (Exception e) {
            log.error("hmSet " + key + " " + hashKey + " " + value, e);
            return false;
        }
        return true;
    }
    public void hmDel(String key, Object hashKey){
        redisTemplate.opsForHash().delete(key, hashKey);
    }
    public Object hmGet(String key, Object hashKey){
        return redisTemplate.opsForHash().get(key, hashKey);
    }
    public Set<Object> hmKeys(String key){
        return redisTemplate.opsForHash().keys(key);
    }
    public List<Object> hmValues(String key){
        return redisTemplate.opsForHash().values(key);
    }
    public void lPush(String k, String v){
        redisTemplate.opsForList().leftPush(k, v);
    }
    public void rPop(String key){
        redisTemplate.opsForList().rightPop(key);
    }
    public List<Object> lRange(String k, long start, long end){
        return redisTemplate.opsForList().range(k, start, end);
    }
    public long listSize(String k){
        return redisTemplate.opsForList().size(k);
    }
    public void removeList(String key, Object v){
        redisTemplate.opsForList().remove(key, 0, v);
    }
    public void addSet(String key, Object value){
        redisTemplate.opsForSet().add(key, value);
    }
    public Set<Object> setMembers(Object key){
        return  redisTemplate.opsForSet().members(key);
    }
    public void zsetAdd(String key, Object value, double score){
        redisTemplate.opsForZSet().add(key, value, score);
    }
    public Set<Object> rangeByScore(String key, double score, double score1){
        return redisTemplate.opsForZSet().rangeByScore(key, score, score1);
    }
    public void zrem(String key, Object obj) {
        ZSetOperations<String, Object> zset = redisTemplate.opsForZSet();
        zset.remove(key, obj);
    }

    public Object zRevRangeByScore(String key) {
        ZSetOperations<String, Object> zset = redisTemplate.opsForZSet();
        Set<Object> obj = zset.reverseRange(key, 0, 0);
        Object o = null;
        for (Object t : obj) {
            o = t;
        }
        if (null != o) {
            return o;
        }
        return null;
    }

    /**
     * 模糊删除
     */
    public void fuzzyRemove(String fuzzyKey) {
        Set<String> keys = redisTemplate.keys(fuzzyKey + "*");
        if (null!=keys&&!keys.isEmpty()) {
            for (String key : keys) {
                redisTemplate.delete(key);
            }
        }
    }

    /**
     * 模糊查询
     */
    public Set<String> fuzzyQuery(String fuzzyKey) {
        return redisTemplate.keys(fuzzyKey + "*");

    }
}
