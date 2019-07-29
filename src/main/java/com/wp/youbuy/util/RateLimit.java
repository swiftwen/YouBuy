package com.wp.youbuy.util;

import org.springframework.stereotype.Service;

import com.google.common.util.concurrent.RateLimiter;
/**
 * ip频率限制
 * @author swiftwen
 * @date 2019年4月2日 下午5:08:24
 */
@Service
public class RateLimit {

	//每秒只发出5个令牌
    RateLimiter rateLimiter = RateLimiter.create(100.0);
 
    /**
     * 尝试获取令牌
     * @return
     */
    public boolean tryAcquire(){
        return rateLimiter.tryAcquire();
    }
}