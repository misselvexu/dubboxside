package xyz.vopen.passport.facade.service.rest;

import org.springframework.dao.DataAccessException;
import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.data.redis.core.RedisCallback;
import xyz.vopen.passport.facade.ApiContextFacade;
import xyz.vopen.passport.facade.exception.NSIllegalRequestException;
import xyz.vopen.passport.facade.service.AuthorizerService;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.core.Context;

/**
 * 账号中心授权相关服务.
 */
public class AuthorizerServiceRest extends ApiContextFacade implements AuthorizerService {


    @Override
    public String something (@Context HttpServletRequest request) {
        System.out.println("\t rest auth ");
        String error = request.getParameter("error");
        if ("1".equals(error)) {
            throw new NSIllegalRequestException("error 测试错误.");
        }

        if ("2".equals(error)) {
            throw new IllegalArgumentException("error 参数错误.");
        }

        System.out.println(redisTemplate);
        if (redisTemplate != null) {
            redisTemplate.execute(new RedisCallback<Object>() {
                @Override
                public Object doInRedis (RedisConnection redisConnection) throws DataAccessException {
                    return redisConnection.sAdd("something".getBytes(), "something".getBytes());
                }
            });
        }
        return this.passportService.something();
    }
}
