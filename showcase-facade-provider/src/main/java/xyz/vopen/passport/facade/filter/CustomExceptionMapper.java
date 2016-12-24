package xyz.vopen.passport.facade.filter;

import com.pyw.commons.core.ws.rs.core.MediaTypes;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;

/**
 * Rest http 自定义异常拦截
 *
 * @author Elve.xu
 */
@SuppressWarnings("rawtypes")
public class CustomExceptionMapper implements ExceptionMapper<Exception> {

    private Logger logger = LoggerFactory.getLogger(CustomExceptionMapper.class);

    public Response toResponse (Exception e) {

        logger.error("Exception mapper successfully got an exception:", e);

        // TODO ....

        // otherwise return 404 or you customer exception code
        return Response.status(Response.Status.NOT_FOUND).entity("404").type(MediaTypes.TEXT_PLAIN_UTF8).build();
    }
}
