package org.junit.internal.runners.statements;

import org.junit.runners.model.FrameworkMethod;
import org.junit.runners.model.Statement;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes11.dex */
public class InvokeMethod extends Statement {
    private final Object target;
    private final FrameworkMethod testMethod;

    public InvokeMethod(FrameworkMethod frameworkMethod, Object obj) {
        this.testMethod = frameworkMethod;
        this.target = obj;
    }

    @Override // org.junit.runners.model.Statement
    public void evaluate() {
        this.testMethod.invokeExplosively(this.target, new Object[0]);
    }
}
