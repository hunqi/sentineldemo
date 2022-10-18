package org.example;

import com.alibaba.csp.sentinel.slots.block.BlockException;

/**
 * 功能描述
 *
 * @auhtor sunlei
 * @since 2022/10/18 10:34
 */
public class CustomerBlockHandler {
    public static CommonResult handleException(BlockException exception) {
        return new CommonResult(444, exception.getClass().getCanonicalName() + "\t 服务不可用"+"handleException---1");
    }
    public static CommonResult handleException2(BlockException exception) {
        return new CommonResult(444, exception.getClass().getCanonicalName() + "\t 服务不可用"+"handleException---2");
    }
}

