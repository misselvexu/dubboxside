package xyz.vopen.passport.facade.service;

import com.pyw.commons.core.ws.rs.core.MediaTypes;
import xyz.vopen.passport.service.PassportService;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;

/**
 * 账号中心授权相关服务<br/>
 *
 * @see PassportService
 */
@Produces(MediaTypes.TEXT_PLAIN_UTF8)
@Path("/authorizer")
public interface AuthorizerService {

    @GET
    @Path("/something.pyw")
    public String something (@Context HttpServletRequest request);
}
