package xyz.vopen.passport.service;


import com.pyw.commons.cache.memcached.MemcachedClient;
import xyz.vopen.passport.dao.PassportDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;

/**
 * 持久层支持
 * Created by ive on 03/11/2016.
 */
public class DubboServiceSupport {

    /**
     * 账号持久层接口
     */
    protected PassportDAO passportDAO;

    public PassportDAO getPassportDAO () {
        return passportDAO;
    }

    @Autowired
    public void setPassportDAO (PassportDAO passportDAO) {
        this.passportDAO = passportDAO;
    }


    /**
     * Default MemcachedClient <br/>
     */
    @Deprecated
    protected MemcachedClient memcachedClient;

    /**
     * default redis template client <br/>
     */
    protected RedisTemplate<String, String> redisTemplate;

    @Autowired(required = false)
    @Deprecated
    public void setMemcachedClient (MemcachedClient memcachedClient) {
        this.memcachedClient = memcachedClient;
    }

    @Autowired(required = false)
    public void setRedisTemplate (RedisTemplate<String, String> redisTemplate) {
        this.redisTemplate = redisTemplate;
    }


}
