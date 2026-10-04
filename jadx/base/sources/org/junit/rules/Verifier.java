package org.junit.rules;

import org.junit.runner.Description;
import org.junit.runners.model.Statement;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes11.dex */
public abstract class Verifier implements TestRule {
    @Override // org.junit.rules.TestRule
    public Statement apply(final Statement statement, Description description) {
        return new Statement() { // from class: org.junit.rules.Verifier.1
            @Override // org.junit.runners.model.Statement
            public void evaluate() {
                statement.evaluate();
                Verifier.this.verify();
            }
        };
    }

    public void verify() {
    }
}
