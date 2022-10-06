package com.emented.weblab2.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

@WebFilter(value = "/*")
public class HeadersFilter implements Filter {

    private ServletContext context;

    @Override
    public void init(FilterConfig filterConfig) {
        this.context = filterConfig.getServletContext();
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) request;
        Map<String, Long> headers = (HashMap<String, Long>) context.getAttribute("headers");
        if (headers == null) {
            headers = new HashMap<>();
            context.setAttribute("headers", headers);
        }
        Enumeration<String> reqHeaderNames = req.getHeaderNames();
        while (reqHeaderNames.hasMoreElements()) {
            String currentHeader = reqHeaderNames.nextElement();
            headers.put(currentHeader, headers.getOrDefault(currentHeader, 0L) + 1);
        }
        System.out.println(headers);
        context.setAttribute("headers", headers);
        chain.doFilter(request, response);
    }
}
