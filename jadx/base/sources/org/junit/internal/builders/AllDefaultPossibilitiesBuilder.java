package org.junit.internal.builders;

import java.util.Arrays;
import java.util.Iterator;
import org.junit.runner.Runner;
import org.junit.runners.model.RunnerBuilder;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes11.dex */
public class AllDefaultPossibilitiesBuilder extends RunnerBuilder {
    private final boolean canUseSuiteMethod;

    public AllDefaultPossibilitiesBuilder() {
        this.canUseSuiteMethod = true;
    }

    public AnnotatedBuilder annotatedBuilder() {
        return new AnnotatedBuilder(this);
    }

    public IgnoredBuilder ignoredBuilder() {
        return new IgnoredBuilder();
    }

    public JUnit3Builder junit3Builder() {
        return new JUnit3Builder();
    }

    public JUnit4Builder junit4Builder() {
        return new JUnit4Builder();
    }

    @Override // org.junit.runners.model.RunnerBuilder
    public Runner runnerForClass(Class<?> cls) {
        Iterator it = Arrays.asList(ignoredBuilder(), annotatedBuilder(), suiteMethodBuilder(), junit3Builder(), junit4Builder()).iterator();
        while (it.hasNext()) {
            Runner runnerSafeRunnerForClass = ((RunnerBuilder) it.next()).safeRunnerForClass(cls);
            if (runnerSafeRunnerForClass != null) {
                return runnerSafeRunnerForClass;
            }
        }
        return null;
    }

    public RunnerBuilder suiteMethodBuilder() {
        return this.canUseSuiteMethod ? new SuiteMethodBuilder() : new NullBuilder();
    }

    @Deprecated
    public AllDefaultPossibilitiesBuilder(boolean z) {
        this.canUseSuiteMethod = z;
    }
}
