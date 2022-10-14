package com.emented.weblab2.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.Enumeration;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

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
        Map<String, Long> headers = getHeaders("headers");
        Enumeration<String> reqHeaderNames = req.getHeaderNames();
        while (reqHeaderNames.hasMoreElements()) {
            String currentHeader = reqHeaderNames.nextElement();
            headers.put(currentHeader, headers.getOrDefault(currentHeader, 0L) + 1);
        }
        System.out.println(headers);
        context.setAttribute("headers", headers);
        chain.doFilter(request, response);
    }

    public synchronized Map<String, Long> getHeaders(String attributeName) {
        Object headers = context.getAttribute(attributeName);

        if (headers == null) {
            Map<String, Long> headersMap = new ConcurrentHashMap<>();
            context.setAttribute(attributeName, headersMap);
            return headersMap;
        }
        return (Map<String, Long>) headers;
    }
}
