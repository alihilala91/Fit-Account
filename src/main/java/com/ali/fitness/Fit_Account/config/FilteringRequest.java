package com.ali.fitness.Fit_Account.config;

import com.ali.fitness.Fit_Account.constant.SystemConstant;
import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.FilterConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.UUID;

/**
 * Author Ali Hilal
 * Date 1/24/2023
 */

@Component
@Log4j2
public class FilteringRequest implements Filter {

    public static ThreadLocal<String> requestId = new ThreadLocal<>();

    @Override
    public void init(final FilterConfig filterConfig) {
    }

    @Override
    public void doFilter(final ServletRequest servletRequest,
                         final ServletResponse servletResponse,
                         final FilterChain chain) throws IOException, ServletException {

        final HttpServletRequest request = (HttpServletRequest) servletRequest;
        final HttpServletResponse response = (HttpServletResponse) servletResponse;

        try {
            // check If Request Header contain REQUEST_ID
            if (request.getHeader(SystemConstant.REQUEST_ID) == null) {

                // Generate Request Id
                requestId.set(UUID.randomUUID().toString());

                // Set New Request ID
                request.setAttribute(SystemConstant.REQUEST_ID, requestId.get());
            } else {
                // Continue Use existing Request Id
                requestId.set(request.getHeader(SystemConstant.REQUEST_ID));

            }
            // Log For Start The Process
            log.info("Start processing {}", requestId.get());

            //call next filter in the filter chain
            chain.doFilter(request, response);

            // Log for End the Process
            log.info("End processing {}", requestId.get());
        } finally {
            requestId.remove();
        }

    }

    @Override
    public void destroy() {
    }
}
