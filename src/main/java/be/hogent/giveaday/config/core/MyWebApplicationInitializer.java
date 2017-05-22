package be.hogent.giveaday.config.core;

import be.hogent.giveaday.config.WebConfig;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

/**
 * Created by bart on 22/05/2017.
 */
public class MyWebApplicationInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class[]{WebConfig.class};
    }

    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class[]{ServletConfigClass.class};
    }

    @Override
    protected String[] getServletMappings() {
        return new String[]{"/"};
    }

//    @Override
//    public void onStartup(ServletContext container) {
//        ServletRegistration.Dynamic registration = container.addServlet("example", new DispatcherServlet());
//        registration.setLoadOnStartup(1);
//        registration.addMapping("/example/*");
//    }

}
