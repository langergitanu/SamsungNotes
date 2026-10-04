package org.junit.internal.runners.statements;

import java.util.Iterator;
import java.util.List;
import org.junit.runners.model.FrameworkMethod;
import org.junit.runners.model.Statement;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes11.dex */
public class RunBefores extends Statement {
    private final List<FrameworkMethod> befores;
    private final Statement next;
    private final Object target;

    public RunBefores(Statement statement, List<FrameworkMethod> list, Object obj) {
        this.next = statement;
        this.befores = list;
        this.target = obj;
    }

    @Override // org.junit.runners.model.Statement
    public void evaluate() {
        Iterator<FrameworkMethod> it = this.befores.iterator();
        while (it.hasNext()) {
            invokeMethod(it.next());
        }
        this.next.evaluate();
    }

    public void invokeMethod(FrameworkMethod frameworkMethod) {
        frameworkMethod.invokeExplosively(this.target, new Object[0]);
    }
}
