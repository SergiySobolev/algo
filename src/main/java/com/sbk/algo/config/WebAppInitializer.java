package com.sbk.algo.config;

import org.spring4gwt.server.SpringGwtRemoteServiceServlet;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

/**
 * Created by sobik on 27.08.2014.
 */
public class WebAppInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {
    public WebAppInitializer() {
    }

    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class<?>[0];
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
    public void onStartup(ServletContext servletContext) throws ServletException {
        super.onStartup(servletContext);
        AnnotationConfigWebApplicationContext rootCtx = new AnnotationConfigWebApplicationContext();
        rootCtx.register(WebAppConfig.class);

        servletContext.addListener(new ContextLoaderListener(rootCtx));

        ServletRegistration.Dynamic servlet = servletContext.addServlet("springGwtRemoteServiceServlet", new SpringGwtRemoteServiceServlet());
        servlet.addMapping("/springGwtServices/*");
        servlet.setLoadOnStartup(1);
    }
}