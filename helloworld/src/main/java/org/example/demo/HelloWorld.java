package org.example.demo;

import com.alibaba.csp.sentinel.Entry;
import com.alibaba.csp.sentinel.SphU;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.alibaba.csp.sentinel.slots.block.RuleConstant;
import com.alibaba.csp.sentinel.slots.block.flow.FlowRule;
import com.alibaba.csp.sentinel.slots.block.flow.FlowRuleManager;

import java.util.ArrayList;
import java.util.List;

/**
 * 功能描述
 *
 * @auhtor sunlei
 * @since 2022/10/14 15:07
 */
public class HelloWorld {

    public static void main(String[] args) {

        System.out.println("hello world");

        initFlowQpsRule();

        for (int i = 0; i < 2; i++) {
            try (Entry entry = SphU.entry("HelloWorld")){
                System.out.println("Do something");
            } catch (BlockException e) {
                e.printStackTrace();
            }
        }

    }

    private static void initFlowQpsRule() {
        List<FlowRule> rules = new ArrayList<>();
        FlowRule rule = new FlowRule();
        rule.setResource("HelloWorld");
        // set limit qps to 20
        rule.setCount(1);
        rule.setGrade(RuleConstant.FLOW_GRADE_QPS);
        rules.add(rule);
        FlowRuleManager.loadRules(rules);
    }

}
