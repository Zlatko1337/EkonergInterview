package hr.ekonerg.ekonerginterview.config;

import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.ui.freemarker.FreeMarkerConfigurationFactoryBean;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@EnableWebMvc
public class WebConfig implements BeanPostProcessor, WebMvcConfigurer {
	
	@Bean
    public FreeMarkerConfigurationFactoryBean freeMarkerConfiguration() {
        FreeMarkerConfigurationFactoryBean freeMarkerConfigBean = new FreeMarkerConfigurationFactoryBean();
        freeMarkerConfigBean.setTemplateLoaderPath("/templates/");
        return freeMarkerConfigBean;
    }

	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/**").addResourceLocations("classpath:/META-INF/resources/",
				"classpath:/resources/", "classpath:/static/", "/webjars/");
		
		registry.addResourceHandler("/webjars/**").addResourceLocations("/webjars/").resourceChain(false);
		
	}
	
}
