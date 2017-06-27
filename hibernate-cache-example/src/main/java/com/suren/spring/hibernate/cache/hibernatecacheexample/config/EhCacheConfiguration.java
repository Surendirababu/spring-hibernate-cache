package com.suren.spring.hibernate.cache.hibernatecacheexample.config;

import com.suren.spring.hibernate.cache.hibernatecacheexample.repository.UsersRespository;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.ehcache.EhCacheCacheManager;
import org.springframework.cache.ehcache.EhCacheManagerFactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

/**
 * Created by Surendirababu Janarthanan on 6/24/2017.
 */

@EnableCaching
@Configuration
@EnableJpaRepositories(basePackageClasses = UsersRespository.class)
public class EhCacheConfiguration {

    @Bean
    public CacheManager cacheManager(){
        return new EhCacheCacheManager(ehCacheManagerFactoryBean().getObject());
    }

    @Bean
    public EhCacheManagerFactoryBean ehCacheManagerFactoryBean()
    {
        EhCacheManagerFactoryBean bean = new EhCacheManagerFactoryBean();
        bean.setConfigLocation(new ClassPathResource("ehcache.xml"));
        bean.setShared(true);
        return bean;

    }
}
