package org.example;

import lombok.Getter;

/**
 * 功能描述
 *
 * @auhtor sunlei
 * @since 2022/10/18 10:04
 */
@Getter
public class CommonResult {
    private final int code;
    private final String desc;
    private Payment payment = null;

    public CommonResult(int code, String desc, Payment payment) {
        this.code = code;
        this.desc = desc;
        this.payment = payment;
    }

    public CommonResult(int code, String desc) {
        this.code = code;
        this.desc = desc;
    }

}
