package br.com.casadocodigo.loja.conf;

import javax.servlet.Filter;
import javax.servlet.MultipartConfigElement;
import javax.servlet.ServletRegistration.Dynamic;

import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class ServletSpringMVC extends AbstractAnnotationConfigDispatcherServletInitializer{

	@Override
	protected Class<?>[] getRootConfigClasses() {
		return null;
	}

	//Identificação que diz ao spring para scanear as classes controlers
	@Override
	protected Class<?>[] getServletConfigClasses() {
	    return new Class[] {AppWebConfiguration.class, JPAConfiguration.class};
	}

	//método que diz para o spring a partir de qual uri ele tem que mapear
	@Override
	protected String[] getServletMappings() {
	    return new String[] {"/"};
	}
	
	@Override
    protected Filter[] getServletFilters() {
        CharacterEncodingFilter encodingFilter = new CharacterEncodingFilter();
        encodingFilter.setEncoding("UTF-8");
        return new Filter[] {encodingFilter};
    }
	
	@Override
    protected void customizeRegistration(Dynamic registration) {
        registration.setMultipartConfig(new MultipartConfigElement(""));
    }

}
