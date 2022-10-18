package org.example;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import org.springframework.stereotype.Service;

/**
 * 功能描述
 *
 * @auhtor sunlei
 * @since 2022/10/14 15:49
 */
@Service
public class TestService {

    @SentinelResource(value = "sayHello", defaultFallback = "fallback")
    public String sayHello(String name) {
        return "Hello, " + name;
    }

    public String fallback(){
        return "Sentinel fallback";
    }

}
