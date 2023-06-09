/*
 * Copyright (c) 2023.  Yaser Rodriguez
 * yaser.rguez@gmail.com
 * LastUpdate: 6/9/23, 12:35 AM
 *
 */

package com.group.bestvision.yrm.test.controller.cache;

import com.group.bestvision.yrm.test.controller.impl.BaseController;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.cache.Cache;
import javax.cache.CacheManager;

@Slf4j
@RestController
@RequestMapping("/cache")
public class CacheController extends BaseController implements CacheApi
{
    private final CacheManager cacheManager;

    public CacheController(CacheManager cacheManager)
    {
        this.cacheManager = cacheManager;
    }

    @Scheduled(initialDelay = 1000, fixedDelay = 180000)
    @DeleteMapping()
    public ResponseEntity clearAllCaches()
    {
        cacheManager.getCacheNames().forEach(cacheName -> {
            clearCacheFromCacheName(cacheName);
        });
        return noContentResponse();
    }

    @DeleteMapping(value = "/{cacheName}")
    public ResponseEntity clearCache(@PathVariable("cacheName") String cacheName)
    {
        return clearCacheFromCacheName(cacheName) ? noContentResponse() : notFoundResponse();
    }

    private Boolean clearCacheFromCacheName(final String cacheName)
    {
        final Cache cache = cacheManager.getCache(cacheName);
        if (cacheExists(cache))
        {
            cache.clear();
            return true;
        }
        return false;
    }

    private Boolean cacheExists(final Cache cache)
    {
        return cache != null;
    }
}

