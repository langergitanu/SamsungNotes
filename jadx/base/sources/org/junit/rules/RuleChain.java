package org.junit.rules;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.junit.runner.Description;
import org.junit.runners.model.Statement;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes11.dex */
public class RuleChain implements TestRule {
    private static final RuleChain EMPTY_CHAIN = new RuleChain(Collections.EMPTY_LIST);
    private List<TestRule> rulesStartingWithInnerMost;

    private RuleChain(List<TestRule> list) {
        this.rulesStartingWithInnerMost = list;
    }

    public static RuleChain emptyRuleChain() {
        return EMPTY_CHAIN;
    }

    public static RuleChain outerRule(TestRule testRule) {
        return emptyRuleChain().around(testRule);
    }

    @Override // org.junit.rules.TestRule
    public Statement apply(Statement statement, Description description) {
        return new RunRules(statement, this.rulesStartingWithInnerMost, description);
    }

    public RuleChain around(TestRule testRule) {
        if (testRule == null) {
            throw new NullPointerException("The enclosed rule must not be null");
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add(testRule);
        arrayList.addAll(this.rulesStartingWithInnerMost);
        return new RuleChain(arrayList);
    }
}
