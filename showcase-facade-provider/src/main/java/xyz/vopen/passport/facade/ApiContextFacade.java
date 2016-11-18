package xyz.vopen.passport.facade;

import com.pyw.commons.cache.memcached.MemcachedClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.redis.core.ListOperations;
import org.springframework.data.redis.core.RedisTemplate;
import xyz.vopen.passport.service.PassportService;

import javax.annotation.Resource;

/**
 * 内部服务提供接口<br/>
 * <li>Api Rest Service Support <br/>
 * <li>Support Service Default implement<br/>
 * <li>Cache Support
 * <p>
 * #Redis Cache Support<br/>
 * #Memcached Cache Support(TODO)
 * </p>
 *
 * @author Elve.xu
 * @see <code>Project #passport-api#'s implements </code>
 */
public class ApiContextFacade {

    /**
     * Default MemcachedClient <br/>
     *
     * @deprecated use redisTemplate instead of
     */
    @Deprecated
    protected static MemcachedClient memcachedClient;
    /**
     * Default Api Service Implements instance. inject on SpringContext
     *
     * @see PassportService
     */
    protected PassportService passportService;
    /**
     * default redis template client <br/>
     */
    protected RedisTemplate<String, String> redisTemplate;
    /**
     * Redis 集合操作
     */
    @Resource(name = "redisTemplate")
    protected ListOperations<String, String> listOps;

    public ApiContextFacade () {
    }

    /**
     * PassportService setter method
     *
     * @param passportService instance
     */
    @Autowired
    @Qualifier("passportServiceImpl")
    public void setPassportService (PassportService passportService) {
        this.passportService = passportService;
    }

    @Autowired(required = false)
    @Deprecated
    public void setMemcachedClient (MemcachedClient memcachedClient) {
        ApiContextFacade.memcachedClient = memcachedClient;
    }

    @Autowired(required = false)
    public void setRedisTemplate (RedisTemplate<String, String> redisTemplate) {
        this.redisTemplate = redisTemplate;
    }


}
