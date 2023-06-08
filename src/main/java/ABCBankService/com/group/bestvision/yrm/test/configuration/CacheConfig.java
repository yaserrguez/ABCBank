/*
 * Copyright (c) 2023.  Yaser Rodriguez
 * yaser.rguez@gmail.com
 * LastUpdate: 6/7/23, 9:18 PM
 *
 */

package ABCBankService.com.group.bestvision.yrm.test.configuration;///*

//package cu.datys.srnt.services.common.configuration;
//
//import org.springframework.cache.annotation.EnableCaching;
//import org.springframework.cache.interceptor.KeyGenerator;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
//import java.lang.reflect.Method;
//import java.util.Arrays;
//
//@Configuration
//@EnableCaching
//public class CacheConfig
//{
//    public CacheConfig()
//    {
//        //Para Spring
//    }
//
//    @Bean
//    public KeyGenerator multiplyKeyGenerator() {
//        return (Object target, Method method, Object... params) ->
//                method.getName() + "_" + Arrays.toString(params);
//    }
//
////    @Bean
////    JCacheCacheManager jCacheCacheManager()
////    {
////        return new JCacheCacheManager(cacheManager());
////    }
////
////    @Bean(destroyMethod = 'close')
////    CacheManager cacheManager()
////    {
////        CacheConfiguration cacheConfiguration = CacheConfigurationBuilder.newCacheConfigurationBuilder(
////                Object,
////                Object,
////                ResourcePoolsBuilder.heap(5)).withExpiry(Expirations.timeToLiveExpiration(new Duration(5, TimeUnit.SECONDS))).
////                                                                                 build();
////
////        Map<String, CacheConfiguration> caches = ['person': cacheConfiguration];
////
////        EhcacheCachingProvider provider = (EhcacheCachingProvider) Caching.getCachingProvider();
////        DefaultConfiguration configuration = new DefaultConfiguration(caches, provider.getDefaultClassLoader());
////
////        return provider.getCacheManager(provider.getDefaultURI(), configuration);
////    }
//
////    @Bean
////    JCacheCacheManager jCacheCacheManager()
////    {
////        return new JCacheCacheManager(cacheManager());
////    }
////
////    @Bean(destroyMethod = "close")
////    CacheManager cacheManager()
////    {
////        CachingProvider provider = Caching.getCachingProvider();
////        CacheManager cacheManager = provider.getCacheManager();
////
////        MutableConfiguration cacheConfiguration = new MutableConfiguration()
////                .setTypes(Object.class, Object.class)
////                .setStoreByValue(false)
////                .setExpiryPolicyFactory(CreatedExpiryPolicy.factoryOf(new Duration(TimeUnit.SECONDS, 30)));
////
////        cacheManager.createCache("myCache", cacheConfiguration);
////
////        return cacheManager;
////    }
//
//}
