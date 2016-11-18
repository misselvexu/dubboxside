/**
 * Copyright 2016 VOPEN.XYZ.
 */
package xyz.vopen.passport.facade.filter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;
import javax.ws.rs.container.ContainerResponseContext;
import javax.ws.rs.container.ContainerResponseFilter;
import javax.ws.rs.core.Context;
import java.io.IOException;

/**
 * 访问权限.
 * <p/>
 * 符合API, 发生错误时, 返回错误信息, 如果不符合API, 发生错误时, 直接抛出异常.
 *
 * @author Elve.xu
 */
@SuppressWarnings("unused")
public class AccessPermissionFilter implements ContainerRequestFilter, ContainerResponseFilter {

    private static final Logger logger = LoggerFactory.getLogger(AccessPermissionFilter.class);

    @Context
    private HttpServletRequest request;

    @Override
    public void filter (ContainerRequestContext requestContext) throws IOException {

        // RESTEasy request filter

        // ......

    }

    @Override
    public void filter (ContainerRequestContext requestContext, ContainerResponseContext responseContext)
            throws IOException {

        // RESTEast response filter

        // ......
    }
}
