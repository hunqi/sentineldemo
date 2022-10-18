package org.example;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * 功能描述
 *
 * @auhtor sunlei
 * @since 2022/10/16 16:50
 */

@Slf4j
@RestController
public class FlowLimitController
{
    @GetMapping("/testA")
    public String testA() {
        log.info(Thread.currentThread().getName()+" testA...");
        return "------testA";
    }

    @GetMapping("/testB")
    public String testB() {
        log.info(Thread.currentThread().getName()+" testB...");
        return "------testB";
    }

    @GetMapping("/testC")
    public String testC() {
        return "------test降级RT";
    }

    @GetMapping("/testHotKey")
    @SentinelResource(value = "testHotKey", blockHandler = "block_testHotKey")
    public String testHotKey(@RequestParam(value = "p1", required = false) String p1,
                             @RequestParam(value = "p2", required = false) String p2){
        return "testHotKey...";
    }

    public String block_testHotKey(String p1, String p2, BlockException exception) {
        return "Huh, testHotKey is limited...";
    }

}
