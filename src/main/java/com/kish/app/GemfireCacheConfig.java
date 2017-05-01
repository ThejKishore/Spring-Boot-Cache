package com.kish.app;


import com.gemstone.gemfire.cache.Cache;
import com.gemstone.gemfire.cache.GemFireCache;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.data.gemfire.CacheFactoryBean;
import org.springframework.data.gemfire.LocalRegionFactoryBean;
import org.springframework.data.gemfire.support.GemfireCacheManager;

import java.util.Properties;

/**
 * Created by ThejKishore on 4/30/2017.
 */
@Configuration
@Profile("Gemfire")
public class GemfireCacheConfig {

    @Bean
    Properties gemfireProperties() {
        Properties gemfireProperties = new Properties();
        gemfireProperties.setProperty("name", "DataGemFireCachingApplication");
        gemfireProperties.setProperty("mcast-port", "0");
        gemfireProperties.setProperty("log-level", "config");
        return gemfireProperties;
    }

    @Bean
    CacheFactoryBean gemfireCache() {
        CacheFactoryBean gemfireCache = new CacheFactoryBean();
        gemfireCache.setClose(true);
        gemfireCache.setProperties(gemfireProperties());
        return gemfireCache;
    }

    @Bean
    GemfireCacheManager cacheManager(Cache gemfireCache) {
        GemfireCacheManager cacheManager = new GemfireCacheManager();
        cacheManager.setCache(gemfireCache);
        return cacheManager;
    }

    @Bean
    LocalRegionFactoryBean<Integer, Integer> perosnRegion(GemFireCache cache) {
        LocalRegionFactoryBean<Integer, Integer> personRegion = new LocalRegionFactoryBean<>();
        personRegion.setCache(cache);
        personRegion.setClose(false);
        personRegion.setName("person");
        personRegion.setPersistent(false);
        return personRegion;
    }
}
