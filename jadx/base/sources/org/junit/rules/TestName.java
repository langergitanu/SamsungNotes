package org.junit.rules;

import org.junit.runner.Description;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes11.dex */
public class TestName extends TestWatcher {
    private volatile String name;

    public String getMethodName() {
        return this.name;
    }

    @Override // org.junit.rules.TestWatcher
    public void starting(Description description) {
        this.name = description.getMethodName();
    }
}
