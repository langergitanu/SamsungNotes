package org.junit.internal.builders;

import junit.runner.BaseTestRunner;
import org.junit.internal.runners.SuiteMethod;
import org.junit.runner.Runner;
import org.junit.runners.model.RunnerBuilder;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes11.dex */
public class SuiteMethodBuilder extends RunnerBuilder {
    public boolean hasSuiteMethod(Class<?> cls) {
        try {
            cls.getMethod(BaseTestRunner.SUITE_METHODNAME, null);
            return true;
        } catch (NoSuchMethodException unused) {
            return false;
        }
    }

    @Override // org.junit.runners.model.RunnerBuilder
    public Runner runnerForClass(Class<?> cls) {
        if (hasSuiteMethod(cls)) {
            return new SuiteMethod(cls);
        }
        return null;
    }
}
