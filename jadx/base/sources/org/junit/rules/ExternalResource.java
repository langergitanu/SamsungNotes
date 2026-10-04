package org.junit.rules;

import java.util.ArrayList;
import org.junit.runner.Description;
import org.junit.runners.model.MultipleFailureException;
import org.junit.runners.model.Statement;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes11.dex */
public abstract class ExternalResource implements TestRule {
    private Statement statement(final Statement statement) {
        return new Statement() { // from class: org.junit.rules.ExternalResource.1
            @Override // org.junit.runners.model.Statement
            public void evaluate() throws Exception {
                ExternalResource externalResource;
                ExternalResource.this.before();
                ArrayList arrayList = new ArrayList();
                try {
                    try {
                        statement.evaluate();
                        externalResource = ExternalResource.this;
                    } catch (Throwable th) {
                        try {
                            arrayList.add(th);
                            externalResource = ExternalResource.this;
                        } catch (Throwable th2) {
                            try {
                                ExternalResource.this.after();
                            } catch (Throwable th3) {
                                arrayList.add(th3);
                            }
                            throw th2;
                        }
                    }
                    externalResource.after();
                } catch (Throwable th4) {
                    arrayList.add(th4);
                }
                MultipleFailureException.assertEmpty(arrayList);
            }
        };
    }

    @Override // org.junit.rules.TestRule
    public Statement apply(Statement statement, Description description) {
        return statement(statement);
    }

    public void after() {
    }

    public void before() {
    }
}
