package com.cts.personservice.filter;

import com.cts.personservice.config.ServletRequestContext;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

import static com.cts.personservice.constant.Constants.RequestHeader.X_TENANT_ID;

public class TenantIdFilter implements Filter {

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        try {
            HttpServletRequest httpRequest = (HttpServletRequest) request;
            ServletRequestContext.set(X_TENANT_ID, httpRequest.getHeader(X_TENANT_ID));
            chain.doFilter(request, response);
        } finally {
            ServletRequestContext.clear();
        }
    }
}
