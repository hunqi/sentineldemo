package org.example;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * 功能描述
 *
 * @auhtor sunlei
 * @since 2022/10/18 09:51
 */
@RestController
public class RateLimitController {

    @GetMapping("/byResource")
    @SentinelResource(value = "byResource", blockHandler = "handleException")
    @ResponseBody
    public CommonResult byResource() {
        return new CommonResult(200, "按资源名称限流测试ok", new Payment(2022, "0001"));
    }

    @GetMapping("/byUrl")
    @SentinelResource(value = "byUrl")
    public CommonResult byUrl() {
        return new CommonResult(200, "按url限流ok", new Payment(2022, "0002"));
    }

    @GetMapping("/customerBlockHandler")
    @SentinelResource(value = "customerBlockHandler",
                        blockHandlerClass = CustomerBlockHandler.class,
                        blockHandler = "handleException2")
    public CommonResult customerBlockHandler() {
        return new CommonResult(200, "自定义", new Payment(2022, "0003"));
    }

    public CommonResult handleException(BlockException ex) {
        return new CommonResult(408, ex.getClass().getCanonicalName() + "\t 服务不可用");
    }
}
