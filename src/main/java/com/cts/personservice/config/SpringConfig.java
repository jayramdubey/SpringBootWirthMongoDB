package com.cts.personservice.config;

import com.cts.personservice.filter.TenantIdFilter;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.Ordered;

import java.text.SimpleDateFormat;

import static java.util.Arrays.asList;

@Configuration
public class SpringConfig {

    @Bean
    public FilterRegistrationBean<TenantIdFilter> tenantIdFilter(){
        FilterRegistrationBean<TenantIdFilter> registration= new FilterRegistrationBean<>();
        registration.setFilter(new TenantIdFilter());
        registration.setUrlPatterns(asList("/v1/*"));
        registration.setOrder(Ordered.LOWEST_PRECEDENCE);
        return registration;
    }

    @Bean
    @Primary
    public ObjectMapper serializingObjectMapper() {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.registerModule(new JavaTimeModule());
        objectMapper.setDateFormat(new SimpleDateFormat("yyyy-MM-dd"));
        return objectMapper;
    }

/*    @Bean
    public WebServerFactoryCustomizer<ConfigurableServletWebServerFactory> webServerFactoryCustomizer() {
        return factory -> factory.setContextPath(APP_NAME);
    }*/
}
