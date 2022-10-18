package org.example;

import lombok.Getter;

/**
 * 功能描述
 *
 * @auhtor sunlei
 * @since 2022/10/18 10:05
 */
@Getter
public class Payment {
    private final int category;
    private final String seqNo;

    public Payment(int category, String seqNo) {
        this.category = category;
        this.seqNo = seqNo;
    }
}
