package com.sbk.algo.config;

import org.spring4gwt.server.SpringGwtRemoteServiceServlet;
import org.springframework.web.filter.DelegatingFilterProxy;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import javax.servlet.Filter;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

/**
 * Created by sobik on 27.08.2014.
 */
public class WebAppInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

    public WebAppInitializer() {
        System.err.println("======================> WEB_APP_STARTER");
    }

    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class<?>[]{RootConfig.class};
    }

    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class<?>[]{WebAppConfig.class};
    }

    @Override
    protected String[] getServletMappings() {
        return new String[]{};
    }

    @Override
    protected Filter[] getServletFilters() {
        DelegatingFilterProxy securityDelegatingFilterProxy = new DelegatingFilterProxy("springSecurityFilterChain");
        return new Filter[]{
                securityDelegatingFilterProxy
        };
    }

    @Override
    public void onStartup(ServletContext servletContext) throws ServletException {
        super.onStartup(servletContext);

        ServletRegistration.Dynamic servlet = servletContext.addServlet("springGwtRemoteServiceServlet", new SpringGwtRemoteServiceServlet());
        servlet.addMapping("/algo/algoserv/*");
        servlet.setLoadOnStartup(1);
    }
}