//package com.gap.productservice;
//
//import org.springframework.cache.CacheManager;
//import org.springframework.cache.annotation.EnableCaching;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.core.io.ClassPathResource;
//
//import org.springframework.cache.ehcache.EhCacheCacheManager;
//import org.springframework.cache.ehcache.EhCacheManagerFactoryBean;
//
//@Configuration
//@EnableCaching
//public class EhCacheConfig {
//	@Bean
//	public CacheManager cacheManager() {
//		return new EhCacheCacheManager(cacheManagerFactory().getObject());
//	}
//	
//	@Bean
//	public EhCacheManagerFactoryBean cacheManagerFactory() {
//		// TODO Auto-generated method stub
//		EhCacheManagerFactoryBean bean = new EhCacheManagerFactoryBean();
//		bean.setConfigLocation(new ClassPathResource("ehcache.xml"));
//		bean.setShared(true);
//		return bean;
//	}
//}
