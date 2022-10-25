package com.spring.cloud.config;

import com.dianping.cat.servlet.CatFilter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.servlet.DispatcherType;

/**
 * 可以定义在通用的starter 或者 公共包中
 * cat-filter 可以拦截请求URL在CAT控制台Transaction
 * @author fenglijian
 * @date 2022-10-25 14:49
 */
@Configuration
public class CatFilterConfig {

    @Bean
    public FilterRegistrationBean catFilter() {
        FilterRegistrationBean registration = new FilterRegistrationBean();
        CatFilter catFilter = new CatFilter();
        registration.setFilter(catFilter);
        registration.addUrlPatterns("/*");
        registration.setName("cat-filter");
        registration.setDispatcherTypes(DispatcherType.REQUEST, DispatcherType.FORWARD);
        registration.setOrder(1);
        return registration;
    }
}
