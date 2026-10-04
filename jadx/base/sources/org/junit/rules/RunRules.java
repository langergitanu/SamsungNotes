package org.junit.rules;

import java.util.Iterator;
import org.junit.runner.Description;
import org.junit.runners.model.Statement;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes11.dex */
public class RunRules extends Statement {
    private final Statement statement;

    public RunRules(Statement statement, Iterable<TestRule> iterable, Description description) {
        this.statement = applyAll(statement, iterable, description);
    }

    private static Statement applyAll(Statement statement, Iterable<TestRule> iterable, Description description) {
        Iterator<TestRule> it = iterable.iterator();
        while (it.hasNext()) {
            statement = it.next().apply(statement, description);
        }
        return statement;
    }

    @Override // org.junit.runners.model.Statement
    public void evaluate() {
        this.statement.evaluate();
    }
}
