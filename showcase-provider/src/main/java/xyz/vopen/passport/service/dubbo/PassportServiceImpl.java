/**
 * Copyright 2016 VOPEN.XYZ.
 */
package xyz.vopen.passport.service.dubbo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.DataAccessException;
import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.data.redis.core.RedisCallback;
import xyz.vopen.passport.service.DubboServiceSupport;
import xyz.vopen.passport.service.PassportService;

import java.util.Set;

/**
 * @author Elve.xu
 */
public class PassportServiceImpl extends DubboServiceSupport implements PassportService {

    private static final Logger logger = LoggerFactory.getLogger(PassportServiceImpl.class);


    @Override
    public String something () {
        System.out.println("\t dubbo auth");
        System.out.println(redisTemplate);
        if (redisTemplate != null) {
            Set<byte[]> result = redisTemplate.execute(new RedisCallback<Set<byte[]>>() {
                @Override
                public Set<byte[]> doInRedis (RedisConnection redisConnection) throws DataAccessException {
                    return redisConnection.sMembers("something".getBytes());
                }
            });

            System.out.println("redis get: " + result);
        }
        this.passportDAO.something();
        return "something";
    }
}
