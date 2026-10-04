package org.junit.internal.runners.statements;

import org.junit.internal.AssumptionViolatedException;
import org.junit.runners.model.Statement;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes11.dex */
public class ExpectException extends Statement {
    private final Class<? extends Throwable> expected;
    private final Statement next;

    public ExpectException(Statement statement, Class<? extends Throwable> cls) {
        this.next = statement;
        this.expected = cls;
    }

    @Override // org.junit.runners.model.Statement
    public void evaluate() throws Exception {
        try {
            this.next.evaluate();
            throw new AssertionError("Expected exception: ".concat(this.expected.getName()));
        } catch (AssumptionViolatedException e) {
            if (!this.expected.isAssignableFrom(e.getClass())) {
                throw e;
            }
        } catch (Throwable th) {
            if (this.expected.isAssignableFrom(th.getClass())) {
                return;
            }
            throw new Exception("Unexpected exception, expected<" + this.expected.getName() + "> but was<" + th.getClass().getName() + ">", th);
        }
    }
}
